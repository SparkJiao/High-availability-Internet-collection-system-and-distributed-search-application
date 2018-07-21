window.onload = function () {

    var username = "kknotalone";
    var schoollist = $("#collected-school-list");
    var schooldisplay = $("school-display");
    var addMoreSchool = $("#add-more-school");
    var schoolinput = $("#school-input");
    var schoolsearch = $("#school-search");
    var schoolconfirm = $("#school-confirm");

    var schools = new Array();
    var readyschools = new Array();
    var expectMajors;

    addMoreSchool.click(function () {

        rightclear();

        //取消所有左侧收藏学校选项卡的激活状态
        for (var i = 0; i < schools.length; i++) {
            var school = $("#" + schools[i]);
            if (school.hasClass("mdui-list-item-active")) {
                school.removeClass("mdui-list-item-active");
            }
        }

        //添加搜索输入框
        var content = "\
            <div class=\"mdui-textfield mdui-textfield-floating-label\">\
                <label class=\"mdui-textfield-label\">学校名称</label>\
                <input class=\"mdui-textfield-input\" id=\"schoolinput\" type=\"text\"/>\
            </div>";
        schoolinput.append(content);

        //搜索输入框绑定输入检测事件
        $("#schoolinput").bind("input propertychange", function () {
            var schoolname = $("#schoolinput").val();
            console.log(schoolname);
            if (schoolname != null && schoolname != "") {
                schoolsearch.empty();
                $.ajax({
                    type: "POST",
                    url: "/findSchoolLike",
                    data: { schoolName: schoolname },
                    async: false,
                    success: function (list) {
                        $.each(list, function (i, item) {
                            readyschools[i] = item;
                            addSchoolItem(item);
                        })
                    }
                })
            }
        })

        //添加收藏学校按钮并添加单击事件
        content = "\
            <button class=\"mdui-btn mdui-btn-icon mdui-theme-accent mdui-ripple\">\
                <i class=\"mdui-icon material-icons\" id=\"s-confirm\">add</i>\
            </button>";
        schoolconfirm.append(content);
        $("#s-confirm").click(function () {
            $('input:checkbox:checked').each(function (index, item) {
                var school = $(this).val();
                addListItem(school);
                collectSchool(school);
            });

            //添加新的收藏学校后清空该区域
            rightclear();
        })
    })

    function rightclear() {
        schooldisplay.empty();
        schoolinput.empty();
        schoolsearch.empty();
        schoolconfirm.empty();
    }

    function getUserInfo() {

    }

    function setUserInfo(username, category, province, grade) {

        $.ajax({
            type: "POST",
            url: "/findUsersSchool",
            data: { username: username, category: category, province: province, grade: grade },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message);
            }
        })
    }

    function changePassword(username, pre_password, password) {


        $.ajax({
            type: "POST",
            url: "/changePassword",
            data: { username: username, pre_password: pre_password, password: password },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message);
            }
        })
    }

    function findUsersExpectMajor(username) {
        $.ajax({
            type: "POST",
            url: "/findUsersExpectMajor",
            data: { username: username },
            datatype: "json",
            async: false,
            success: function (list) {
                expectMajors = list;
            }
        })
    }

    findCollectedSchools();

    function findCollectedSchools() {
        $.ajax({
            type: "POST",
            url: "/findUsersSchool",
            data: { username: username },
            datatype: "json",
            async: false,
            success: function (list) {
                $.each(list, function (i, item) {
                    schools[i] = item;
                    addListItem(item);
                })
            }
        })
    }

    function addListItem(schoolname) {
        var content =
            "<label class=\"mdui-list-item mdui-ripple\" id=\"" + schoolname + "\">\
                    <div class=\"mdui-list-item-avatar mdui-icon material-icons\">assignment</div>\
                    <div class=\"mdui-list-item-content\">"+ schoolname + "</div>\
                </label>";
        schoollist.append(content);
        var school = $("#" + schoolname);
        school.click(function () {
            if (school.hasClass("mdui-list-item-active")) {
                //学校标签处于激活状态
                school.removeClass("mdui-list-item-active");
                //todo:删除对应图表

            } else {
                school.addClass("mdui-list-item-active");
                //todo:添加对应图表

            }
        })
    }

    function addSchoolItem(schoolname) {
        var content = "\
            <label class=\"mdui-list-item mdui-ripple\">\
                <div class=\"mdui-checkbox\">\
                    <input type=\"checkbox\" value=\""+ schoolname + "\"/>\
                    <i class=\"mdui-checkbox-icon\"></i>\
                </div>\
                <div class=\"mdui-list-item-content\">"+ schoolname + "</div>\
                    <i class=\"mdui-list-item-icon mdui-icon material-icons\">chat</i>\
            </label>";
        schoolsearch.append(content);
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
}