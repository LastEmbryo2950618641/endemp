
$(function () {

    $("#login_btn").click(function () {

        var name=$("input[name='username']").val();
        var pass=$("input[name='password']").val();

        var data={
            username:name,
            password:pass
        };
        alert(name);

        $.ajax({
            type:"POST",
            url:contextPath+"/User/SysUser/login",
            data:data,
            //credentials: 'include',
            success:function(data){
                window.location.href=contextPath+"/libbox"+data;
            },
            error:function (data) {
                window.location.href=contextPath+data;
            }
        });

    });

});