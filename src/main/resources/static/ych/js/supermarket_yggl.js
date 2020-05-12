function goPage(pno, psize) {
    var itable = document.getElementById("table_result");//通过ID找到表格
     var num = itable.rows.length;//表格所有行数(所有记录数)
    var totalPage = 0;//总页数
    var pageSize = psize;//每页显示行数
    //总共分几页
    if (num / pageSize > parseInt(num / pageSize)) {
        totalPage = parseInt(num / pageSize) + 1;
    } else {
        totalPage = parseInt(num / pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize + 1; //开始显示的行
    var endRow = currentPage * pageSize; //结束显示的行
    endRow = (endRow > num) ? num : endRow;
    //遍历显示数据实现分页
    for (var i = 1; i < (num + 1); i++) {
        var irow = itable.rows[i - 1];
        if (i >= startRow && i <= endRow) {
            irow.style.display = "block";
        } else {
            irow.style.display = "none";
        }
    }
    var tempStr = "";
    if (currentPage > 1) {
        tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage - 1) + "," + psize + ")\"><上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>"
        for (var j = 1; j <= totalPage; j++) {
            tempStr += "<a href=\"#\" onClick=\"goPage(" + j + "," + psize + ")\">" + j + "&nbsp;&nbsp;&nbsp;</a>"
        }
    } else {
        tempStr += "<上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        for (var j = 1; j <= totalPage; j++) {
            tempStr += "<a href=\"#\" onClick=\"goPage(" + j + "," + psize + ")\">" + j + "&nbsp;&nbsp;&nbsp;</a>"
        }
    }
    if (currentPage < totalPage) {
        tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage + 1) + "," + psize + ")\">下一页>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>";
        for (var j = 1; j <= totalPage; j++) {
        }
    } else {
        tempStr += "  下一页>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        for (var j = 1; j <= totalPage; j++) {
        }
    }
    document.getElementById("barcon").innerHTML = tempStr;
}

$(function(){
    var app = new Vue({
        el:"#right",
        data:{
            num:0,
            name:"",
            elbranch:"",

            // select distinct region from employee;
            // add into branch;

            // branch:['奶制品','蔬果','水产']
            branch:"",

            number:[],
            dfsignin: '1',
            // employee_num:['928001','928002','928003','928004','928005'],
            employee_num: [],
            // employee_name:['张三','李四','王五','小六','小七'],
            employee_name:[],
            // employee_job:['称量','理货','加工','打酱油','吆喝'],
            employee_job: [],
            // employee_signin:['是','否','是','否','是'],
            employee_signin: [],
            // curname:'',
            // curjob:''
        },
        mounted(){
            this.getLogger();
            this.getRegion();
        },
        methods:{


    getLogger() {
                ajax({
                    method:HTTP_METHOD.POST,
                    url:"http://localhost:8080/Info/getInfo",
                    async:true,
                    type:HTTP_RESPONSE_TYPE.JSON,
                    callback:(data)=>{
                        var json = eval(data);
                        this.name = json[0].name;
                    }
                })
            },

            getRegion() {
                ajax({
                    method:HTTP_METHOD.GET,
                    url:"http://localhost:8080/Info_employee/getAllRegion",
                    async:true,
                    type:HTTP_RESPONSE_TYPE.JSON,

                    callback:(data)=>{
                        // session
                        var alljson = eval(data);
                        var json = [];
                        // for(int i = 0; i < alljson.size; i++) {
                        //     json += alljson[i];
                        // }
                        $.each(alljson,function (i,element) {
                            var  a = element.region;
                            json.push(a);
                        })
                        this.branch = json;
                    }
                })
            },

            changeBranch:function(elbranch){
                this.elbranch=elbranch;
            },

            getEpInfo:function() {
                let region = $("#choice").text().split(":")[1].replace(/(^\s*)/g,"");
                ajax({
                    method: HTTP_METHOD.POST,
                    url: "http://localhost:8080/Info_employee/getAllInfo",
                    // contentType:'application/json',
                    async: true,
                    params:  "region="+region,
                    type: HTTP_RESPONSE_TYPE.JSON,
                    callback: (data)=> {
                    var alljson = eval(data);
                        // alert(alljson[0].name);
                        // window.location.reload();
                        // 清空employee列表
                        this.employee_num.length = 0;
                        this.employee_name.length = 0;
                        this.employee_job.length = 0;
                        this.employee_signin.length = 0;
                        this.num = alljson.length;

                        for (var  i = 0 ; i < alljson.length; i++){

                           if(i == 2) { goPage(1, 3); }
                           //  if(i == 2) { goPage(1, 3); }

                            var start = (new Date().getTime());
                            while(new Date().getTime() - start < 100) { $("#category").click(); console.log(1); }

                            this.employee_name.push(alljson[i].name);
                            if (alljson[i].sign == true){
                                this.employee_signin.push("已打卡");
                            }else{
                                this.employee_signin.push("未打卡");
                            }
                            this.employee_num.push(alljson[i].stu_num);
                            this.employee_job.push(alljson[i].work);
                        }

                         // goPage(1, 3,alljson.length);

                    // alert(this.employee_num);
                    }
                })
                // goPage(1,3,this.num);
            },

            addEmployee:function(){
                // 记当前的区域
                let region = $("#choice").text().split(":")[1].replace(/(^\s*)/g,"");
                const stu_num = $("#istu_num").val();
                const ename = $("#iname").val();
                const work = $("#iwork").val();
                var filler =  1;
                if(stu_num=="") { alert("员工工号必填"); filler = 0; return; }
                else if(ename=="") { alert("员工姓名必填"); filler = 0; return;}
                else if(work=="") { alert("员工工作必填"); filler = 0; return; }
                var employee = {
                    "region": region,
                    "stu_num": stu_num,
                    "name": ename,
                    "work": work,
                    "sign": true,
                };
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/Info_employee/insertInfo",
                    contentType:'application/json',
                    data: JSON.stringify(employee),
                    success: function (data) {
                        if (data == "0" || filler == 0) {
                            alert("操作失败，请重试填充表格");
                        } else {
                            alert("操作成功");
                            this.employee_num.push(stu_num);
                            this.employee_name.push(ename);
                            this.employee_job.push(work);
                            // this.employee_signin.push(this.dfsignin);
                            if (this.dfsignin){
                                this.employee_signin.push("已打卡");
                            }else{
                                this.employee_signin.push("未打卡");
                            }
                        }
                    },
                    dataType: 'json'
                })
                // this.employee_num.push(stu_num);
                // this.employee_name.push(ename);
                // this.employee_job.push(work);
                // // this.employee_signin.push(this.dfsignin);
                // if (this.dfsignin){
                //     this.employee_signin.push("已打卡");
                // }else{
                //     this.employee_signin.push("未打卡");
                // }
            },

            removeEmployee:function() {
                let stu_num = $("#dstu_num").val();
                var filler = 1;
                if(stu_num=="") { alert("员工工号必填！"); filler = 0; }
                $.ajax({
                        type: "post",
                        url: "http://localhost:8080/Info_employee/deleteInfo?stu_num="+stu_num,
                        async: true,
                        // params:  "stu_num="+stu_num,
                        contentType:'application/json',
                        data: JSON.stringify(stu_num),
                        success: function (data) {
                            if (data == "0" || filler == 0) {
                                alert("操作失败，请检查工号是否输入正确！");
                            } else {
                                alert("操作成功，请重新选择区域！");
                                // window.location.reload();
                                this.getEpInfo();
                            }
                        },
                        dataType: 'json'
                    }
                )
            }
        }
    })
})
