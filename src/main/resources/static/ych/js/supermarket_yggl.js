$(function(){
    $("#remove").onclick(function () {
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