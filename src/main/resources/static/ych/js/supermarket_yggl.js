$(function(){
    var app = new Vue({
        el:"#right",
        data:{
            name:"张三",
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
            this.getRegion();
        },
        methods:{
            getRegion() {
                ajax({
                    method:HTTP_METHOD.GET,
                    url:"http://localhost:8080/Info_employee/getAllRegion",
                    async:true,
                    type:HTTP_RESPONSE_TYPE.JSON,

                    callback:(data)=>{
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

            getInfo:function() {
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

                        for (var  i = 0 ; i < alljson.length; i++){
                            this.employee_name.push(alljson[i].name);
                            if (alljson[i].sign == true){
                                this.employee_signin.push("已打卡");
                            }else{
                                this.employee_signin.push("未打卡");
                            }
                            this.employee_num.push(alljson[i].stu_num);
                            this.employee_job.push(alljson[i].work);
                        }
                    // alert(this.employee_num);
                    }
                })
            },

            addEmployee:function(){
                // 记当前的区域
                let region = $("#choice").text().split(":")[1].replace(/(^\s*)/g,"");
                const stu_num = $("#istu_num").val();
                const ename = $("#iname").val();
                const work = $("#iwork").val();
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
                        if (data == "0") {
                            alert("操作成功！");
                        }
                    },
                    dataType: 'json'
                })
                this.employee_num.push(stu_num);
                this.employee_name.push(ename);
                this.employee_job.push(work);
                // this.employee_signin.push(this.dfsignin);
                if (this.dfsignin){
                    this.employee_signin.push("已打卡");
                }else{
                    this.employee_signin.push("未打卡");
                }
            },

            removeEmployee:function(index) {
                var stu_num = $("#remove").val();
                $.ajax({
                        type: "post",
                        url: "http://localhost:8080/Info_employee/deleteInfo",
                        contentType:'application/json',
                        data: JSON.stringify(num) ,
                        success: function (data) {
                            if (data == "0") {
                                alert("修改失败！");
                            } else {
                                alert("修改成功！");
                                // window.location.reload();
                            }
                        },
                        dataType: 'json'
                    }
                )
                this.employee_num.splice(index,1);
                this.employee_name.splice(index,1);
                this.employee_job.splice(index,1);
                this.employee_signin.splice(index,1);
            }
        }
    })
})