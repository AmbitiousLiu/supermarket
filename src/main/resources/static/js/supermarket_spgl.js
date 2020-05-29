$(function(){
	
	
	

	//提交出库单
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
		"stu_num" : "01"
	}
	
		var flag = false;
		
		$.ajax({
			type:"post",
			url:"/stockout/subStock_out",
			data:JSON.stringify(stock_out),
			contentType:'application/json',
			success: function (data) {

					if (data == "-1") {
						alert("上传失败！");
					} else if (data == "-2"){
						alert("上传成功！");
						window.location.reload();

					}else if (data == "-3"){
						alert("出库单重复，请重新输入！");
					}else if(data == "-4"){
						alert("该商品号不存在，请重新填写！")
					}
					else {
						alert("该商品仅存"+data+"件，出库失败！");
					}
				},
				dataType: 'json'
			
		})
		
		if(flag == true){
				$("#num").val("");
				$("#cnum").val("");
				$("#outdate").val("");
				$("#sum").val("");
				$("#stu_num").val("");
		}
		
		
		
		
		
		
	})
})