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
            dfsignin: '是',
            // employee_num:['928001','928002','928003','928004','928005'],
            employee_num: [],
            // employee_name:['张三','李四','王五','小六','小七'],
            employee_name:[],
            // employee_job:['称量','理货','加工','打酱油','吆喝'],
            employee_job: [],
            // employee_signin:['是','否','是','否','是'],
            employee_signin: [],
            curname:'',
            curjob:''
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
                    // $.each(JSON.stringify(alljson),function (i,element) {

                    // })
                    // alert(this.employee_num);
                    }
                })
                // $.ajax({
                //     method:HTTP_METHOD.POST,
                //     type:"post",
                //     url:"http://localhost:8080/Info_employee/getAllInfo",
                //     contentType:'application/json',
                //     data:  "region =" + reg,
                //
                //     callback: function(data){
                //
                //     },
                //     // callback: (data)=>{
                //     //
                //     //
                //     // },
                //    dataType: "json"
                // })
            },

            addEmployee:function(name,job){
                this.employee_name.push(name);
                this.employee_job.push(job);
                this.employee_signin.push(this.dfsignin);
            },

            removeEmployee:function(index){
                this.employee_num.splice(index,1);
                this.employee_name.splice(index,1);
                this.employee_job.splice(index,1);
                this.employee_signin.splice(index,1);
            }

        }
    })

    $("#remove").click(function () {
        var region = $("#choice").val();
        var stu_num = $("#stu_num").val();
        var name = $("#name").val();
        var work = $("#work").val();
        var sign = $("#sign").val();

        var employee = {
            "region": region,
            "stu_num": stu_num,
            "name": name,
            "work": work,
            "sign": sign
        };

        $.ajax({
                type: "post",
                url: "http://localhost:8080/Info_employee/modifyInfo",
                contentType:'application/json',
                data: JSON.stringify(employee) ,
                success: function (data) {
                    if (data == "0") {
                        alert("修改失败！");
                    } else {
                        alert("修改成功！");
                        window.location.reload();
                    }
                },
                dataType: 'json'
            }
        )
    })
})