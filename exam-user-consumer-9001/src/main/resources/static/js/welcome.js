$(function () {
    //获取当前用户信息
    $.getJSON("/consumer/user/getSession",function (data) {
        $("#user_name").html(data.real_name);
    });

    //获取welcome页面信息
    $.getJSON("/consumer/user/welcome",function (data) {

    });
})