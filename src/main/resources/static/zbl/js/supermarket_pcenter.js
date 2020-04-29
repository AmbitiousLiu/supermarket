$(function(){



	$.post(
	"/Info/getInfo",
	{},
	function(data){
		var json = eval(data);
		$("#name_pos").text(json.name+"/"+"json.position")
		$("#gender").text(json.gender);
		$("#position").text(json.position);
		$("#age").text(json.age);
		$("#stunum").text(json.stu_num);
		$("#seniority").text(json.seniority);
		$("#region").text(json.region);
		$("#salary").text(json.salary);
	}
	
)
	
	$("#modify").click(function(){
		
		var name = $("#modi_name");
		var gender = $("#modi_gender");
		var age = $("#modi_age");
		var seniority = $("#modi_senoirity");
		var region = $("#modi_region");
		var position = $("#modi_pos");
		var stu_num = $("#modi_num");
		
		$.post(
			"/Info/modifyInfo",
			{"person" : {
				"name" : name,
				"age" : age,
				"gender" : gender,
				"seniority" : seniority,
				"region" : region,
				"stu_num" : stu_num,
				"position" : position,
				"salary" : "0"
			}},
			function(data){
				if(data == "0"){
					alert("修改失败！");
				}else{
					alert("修改成功！");
				}
			}
			
		)
		
	})

	
})

