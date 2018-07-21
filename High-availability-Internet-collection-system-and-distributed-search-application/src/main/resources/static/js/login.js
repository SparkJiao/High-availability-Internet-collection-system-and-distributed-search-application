window.onload = function () {

    // var url = "localhost:8080";

    var username = $("#username");
    var password = $("#password");
    var login = $("#login");

    login.click(function () {
        $.ajax({
            type: "POST",
            url: "/adminLogin",
            data: { username: username.val(), password: password.val() },
            datatype: "json",
            async: false,
            success: function (message) {
                // alert(message.flag);
                if(message.flag == true)
                    location.href = "/index";
                else
                    alert(message.msg);                   
            }
        })
    })
}