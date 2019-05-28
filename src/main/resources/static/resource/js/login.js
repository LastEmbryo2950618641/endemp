
$(function () {

    $("#login_btn").click(function () {

        var userData = new FormData();
        userData.append("username",$("input[name='username']").val());
        userData.append("password",$("input[name='password']").val());
        $.ajax({
            url:contextPath+"/loginHandle",
            data:userData

        });


    });

});