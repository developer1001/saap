$(function () {
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#loginBtn').click();
        }
    });

    getCookie();
})

/**
 * 用户登录,校验
 */
function login() {
    var name = $("#loginName").val();
    var pwd = $("#loginPwd").val();
    var remember = $("input[type='checkbox']").is(':checked');
    $.ajax({
        url:"../login.do",
        method:"post",
        dataType:"json",
        data:{
            loginName:name,
            password:pwd,
            remember:remember?'yes':'no'
        },
        success:function (data) {
            if (data.success){
                var loginUser = {};
                loginUser.Id = data.data.id;
                loginUser.loginName = data.data.loginName;
                loginUser.userName = data.data.userName;
                localStorage.setItem("loginUser",JSON.stringify(loginUser));
                window.location.href="../index.do";
            }
            else
                alert(data.msg);
    }
    })
}

function getCookie() {
    var cookies = document.cookie.split(';');
    var loginName = '',password = '';
    for(var i = 0;i < cookies.length;i++){
        if(cookies[i].indexOf('loginName') != -1 ){
            loginName = cookies[i].substring('loginName'.length+1);
        }
        if(cookies[i].indexOf('password') != -1 ){
            password = cookies[i].substring('password'.length+2);
        }
    }
     $("#loginName").val(loginName);
     $("#loginPwd").val(password);

}
