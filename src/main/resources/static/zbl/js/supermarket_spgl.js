$(function(){
	
	
	
	
	// $.ajax({
	// 	type:"post",
	// 	url:"",
	// 	// data:"",
	// 	contentType:'application/json',
	// 	success: function (data) {
	// 				if (data == "") {
	// 					$("#stu_num").val("");
	// 				} else {
	// 					$("#stu_num").val(data);
	//
	// 				}
	// 			},
	// 			dataType: 'json'
	// })
	
	$("#submit").click(function(){
		
		var num = $("#num").val();
	var cnum = $("#cnum").val();
	var outdate = $("#outdate").val();
	var sum = $("#sum").val();
	var stu_num = $("#stu_num").val();
	
	var stock_out = {
		"num" :num,
		"cnum" : cnum,
		"outdate" : outdate,
		"sum" : sum,
		// "stu_num" : stu_num
		"stu_num" : "01"
	}
	
		var flag = false;
		alert(JSON.stringify(stock_out));
		
		$.ajax({
			type:"post",
			url:"/stockout/subStock_out",
			data:JSON.stringify(stock_out),
			contentType:'application/json',
			success: function (data) {
					if (data == "0") {
						alert("上传失败！");
					} else {
						alert("上传成功！");
//						window.location.reload();
						flag = true;



					}
				},
				dataType: 'json'
			
		})
		
//		if(flag == true){
//				$("#num").val("");
//				$("#cnum").val("");
//				$("#outdate").val("");
//				$("#sum").val("");
//				$("#stu_num").val("");
//		}
//		
		
		
		
		
		
	})
})