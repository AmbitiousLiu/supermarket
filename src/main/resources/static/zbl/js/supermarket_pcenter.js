$(function(){
	
	var v1 = new Vue({
		el:"#center_of_right",
		data:{

			vname:"",
			mname:"",

			vgender:"",
			mgender:"",

			vposition:"",
			mposition:"",

			vage:"",
			mage:"",

			vstu_num:"",
			mstu_num:"",

			vregion:"",
			mregion:"",

			vsalary:"",

			vseniority:"",
			mseniority:""
			
		},
		mounted(){
			this.getInfo();

		},
		methods:{
			getInfo(){
				ajax({
					method:HTTP_METHOD.POST,
					url:"http://localhost:8080/Info/getInfo",
					async:true,
					type:HTTP_RESPONSE_TYPE.JSON,
					callback:(data)=>{

						var json = eval(data);

						this.vname = json[0].name+"/"+json[0].position;
						this.mname = json[0].name;

						this.vgender =  json[0].gender;
						this.mgender =  json[0].gender;

						this.vposition = json[0].position;
						this.mposition = json[0].position;

						this.vage    = json[0].age;
						this.mage    = json[0].age;

						this.vstu_num= json[0].stu_num;
						this.mstu_num= json[0].stu_num;

						this.vseniority = json[0].seniority;
						this.mseniority = json[0].seniority;

						this.vregion = json[0].region;
						this.mregion = json[0].region;

						this.vsalary = json[0].salary;
					}
				})


			}
		}

			

	})
//	
//	$.post(
//	"http://localhost:8080/Info/getInfo",
//	{},
//	function(data){
//
//		var json = eval(data);
//
//		$("#name_pos").text(json[0].name+"/"+json[0].position)
//		$("#gender").val(json[0].gender);
//		$("#position").val(json[0].position);
//		$("#age").val(json[0].age);
//		$("#stu_num").val(json[0].stu_num);
//		$("#seniority").val(json[0].seniority);
//		$("#region").val(json[0].region);
//		$("#salary").val(json[0].salary);
//	},
//		"json"
//	
//)


	$("#modify").click(function(){


		var name = $("#modi_name").val();
		var gender = $("#modi_gender").val();
		var age = $("#modi_age").val();
		var seniority = $("#modi_senoirity").val();
		var region = $("#modi_region").val();
		var position = $("#modi_pos").val();
		var stu_num = $("#modi_num").val();






		var person ={
			"name": name,
			"age": age,
			"gender": gender,
			"seniority": seniority,
			"region": region,
			"stu_num": stu_num,
			"position": position,
			"salary": "0"
		};

		$.ajax({
				type: "post",
				url: "http://localhost:8080/Info/modifyInfo",
				contentType:'application/json',
				data: JSON.stringify(person) ,

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

