$(function(){



	$.post(
	"http://localhost:8080/Info/getInfo",
	{},
	function(data){

		var json = eval(data);

		$("#name_pos").text(json[0].name+"/"+json[0].position)
		$("#gender").val(json[0].gender);
		$("#position").val(json[0].position);
		$("#age").val(json[0].age);
		$("#stu_num").val(json[0].stu_num);
		$("#seniority").val(json[0].seniority);
		$("#region").val(json[0].region);
		$("#salary").val(json[0].salary);
	},
		"json"
	
)
	
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
		alert(JSON.stringify(person));
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
					}
				},
				dataType: 'json'
			}
		)
		
	})

	
})

