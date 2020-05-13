function changepic(obj) {
	//console.log(obj.files[0]);//这里可以获取上传文件的name
	var newsrc=getObjectURL(obj.files[0]);
	document.getElementById('fig').src=newsrc;
}
//建立一個可存取到該file的url
function getObjectURL(file) {
	var url = null ;
	// 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}

$(function(){

//	$("#fig").click(function(){
//		
//		alert("hello");
//		console.log("hello")
//	})
	
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
					url:"/Info/getInfo",
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
						this.mstu_num= json[0].password;

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
		var stu_num = $("#stu_num").val();
		var password = $("#modi_pas").val();






		var person ={
			"name": name,
			"age": age,
			"gender": gender,
			"seniority": seniority,
			"region": region,
			"stu_num": stu_num,
			"position": position,
			"password":password,
			"salary": "0"
		};
		$("#image").action = "/image/update/person";
		$("#image").submit();

		$.ajax({
				type: "post",
				url: "/Info/modifyInfo",
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

