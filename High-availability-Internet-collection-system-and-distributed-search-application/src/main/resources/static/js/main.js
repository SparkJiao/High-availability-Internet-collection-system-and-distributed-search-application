window.onload = function () {

    var username = "nothing"

    function isLogin() {
        return username == "nothing" ? false : true;
    }

    function collectSchool(school) {
        $.ajax({
            type: "POST",
            url: "/addSchool",
            data: { username: username, school: school },
            //contentType: "application/json",
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message);
            }
        })
    }


    // function 
    
}