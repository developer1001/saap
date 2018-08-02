function del() {
    $.ajax({
        url:"user/deleteUserById.do",
        method:"post",
        dataType:"json",
        data:{
            id:$("#delId").val()
        },
        success:function (data) {
            $("#deleteResult").html(JSON.stringify(data));
        }
    })
}

function find() {
    $.ajax({
        type:"post",
        url:"user/getUserById.do",
        data:{
            id:$("#userid").val(),
        },
        dataType:"json",
        success:function (data) {
            $("#result").html(JSON.stringify(data));
            if(data.success){
                $("#up_userid").val(data.data.id);
                $("#up_username").val(data.data.user_name);
                $("#up_pwd").val(data.data.password);
                $("#up_age").val(data.data.age);
            }
        },
        complete:function (data) {
            //console.log(data);
        }
    });
}

function add() {
    if ($("#add_username").val()!="" && $("#add_pwd").val()!= "" && $("#add_age").val()!=""){
        $.ajax({
            type:"post",
            url:"user/addUser.do",
            data:{
                user_name:$("#add_username").val(),
                password:$("#add_pwd").val(),
                age:$("#add_age").val()
            },
            dataType:"json",
            success:function (data) {
                $("#addResult").html(JSON.stringify(data));
                $("#add_username").val(""),
                    $("#add_pwd").val(""),
                    $("#add_age").val("")
            }
        });
    }
}

function  update() {
    if ($("#up_username").val()!="" && $("#up_pwd").val()!= "" && $("#up_age").val()!="") {
        $.ajax({
            type: "post",
            url: "user/updateUser.do",
            data: {
                id: $("#up_userid").val(),
                user_name: $("#up_username").val(),
                password: $("#up_pwd").val(),
                age: $("#up_age").val()
            },
            dataType: "json",
            success: function (data) {
                $("#updateResult").html(JSON.stringify(data));
                $("#up_username").val("");
                $("#up_pwd").val("");
                $("#up_age").val("");
            }
        });
    }
}