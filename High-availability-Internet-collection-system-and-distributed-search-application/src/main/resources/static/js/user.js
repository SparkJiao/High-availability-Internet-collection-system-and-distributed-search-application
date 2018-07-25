window.onload = function () {

    var Username = "";
    var schoollist = $("#collected-school-list");
    var schooldisplay = $("#school-display");
    var addMoreSchool = $("#add-more-school");
    var schoolinput = $("#school-input");
    var schoolsearch = $("#school-search");
    var schoolconfirm = $("#school-confirm");

    var expectMajors;

    var signin = $("#signin-button");
    var signup = $("#signup-button");
    var inputUsername = $("#input-username");
    var inputPassword = $("#input-password");
    var exit = $("#exit-button");
    var account = $("#account");

    var schoolExist = new Set();
    var schoolExpectMajorsList = new Map();

    attempt();

    hideSearch();

    findCollectedSchools();

    function attempt() {
        $.ajax({
            type: "POST",
            url: "/attempt",
            datatype: "json",
            async: false,
            success: function (message) {
                if (message.flag) {
                    Username = message.msg;
                    signback();
                }
            }
        })
        console.log(Username);
    }

    //登录
    signin.click(function () {
        var username = inputUsername.val();
        var password = inputPassword.val();
        console.log(username);
        console.log(password);
        $.ajax({
            type: "POST",
            url: "/login",
            data: { username: username, password: password },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message.flag);
                if (!message.flag) {
                    alert(message.msg);
                    return;
                } else {
                    Username = username;
                    signback();
                }
            }
        })
        findCollectedSchools();
    })

    //注册
    signup.click(function () {
        var username = inputUsername.val();
        var password = inputPassword.val();
        $.ajax({
            type: "POST",
            url: "/register",
            data: { username: username, password: password },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message.flag);
                if (!message.flag) {
                    alert(message.msg);
                    return;
                } else {
                    Username = username;
                    signback();
                }
            }
        })
    })

    //注销
    exit.click(function () {
        Username = "";
        exitback();
        schoollist.empty();
        schooldisplay.empty();
        hideSearch();
    })

    //登录成功回调函数
    function signback() {
        //alert(message);
        $("#username-field").text(Username);
        //$("#username-field").attr("href", "/user");
        account.attr("mdui-dialog", "{target: '#exitDialog'}");
    }

    //注销成功回调函数
    function exitback() {
        alert("退出成功");
        $("#username-field").text("←请登录");
        account.attr("mdui-dialog", "{target: '#loginDialog'}");
        clearCookie("username");
        clearCookie("password");
    }

    //添加更多学校按钮单击事件
    addMoreSchool.click(function () {

        if (!loginCheck())
            return;

        schoolinput.show();
        schoolconfirm.show();
        schoolsearch.show();

        //取消所有左侧收藏学校选项卡的激活状态
        schoolExist.forEach(function (value, value2, set) {
            var school = $("#" + value);
            if (school.hasClass("mdui-list-item-active")) {
                school.removeClass("mdui-list-item-active");
            }
        })

        //添加搜索输入框
        // var content = "\
        //     <div class=\"mdui-textfield mdui-textfield-floating-label\">\
        //         <label class=\"mdui-textfield-label\">学校名称</label>\
        //         <input class=\"mdui-textfield-input\" id=\"schoolinput\" type=\"text\"/>\
        //     </div>";
        // schoolinput.append(content);

        //添加添加按钮
        // content = "\
        //     <button class=\"mdui-btn mdui-btn-icon mdui-theme-accent mdui-ripple\">\
        //         <i class=\"mdui-icon material-icons\" id=\"s-confirm\">add</i>\
        //     </button>";
        // schoolconfirm.append(content);

    })

    //搜索输入框绑定输入检测事件
    $("#schoolinput").bind("input propertychange", function () {
        var schoolname = $("#schoolinput").val();
        console.log(schoolname);
        if (schoolname != null && schoolname != "") {
            schoolsearch.empty();
            $.ajax({
                type: "POST",
                url: "/findSchoolsLike",
                data: { school: schoolname },
                async: false,
                success: function (list) {
                    $.each(list, function (i, item) {
                        addSchoolItem(item);
                    })
                }
            })
        }
    })

    //添加收藏学校按钮并添加单击事件
    $("#s-confirm").click(function () {
        $('input:checkbox:checked').each(function (index, item) {
            var school = $(this).val();
            addListItem(school);
            collectSchool(school);
        });

        //添加新的收藏学校后清空该区域
        rightclear();
    })

    //清空右侧展示区域
    function rightclear() {

        schoolExist.forEach(function (value, value2, set) {
            $("#" + value + "Chart").hide();
        })

        hideSearch();
    }

    //隐藏搜索界面
    function hideSearch() {
        schoolinput.hide();
        schoolsearch.hide();
        schoolconfirm.hide();
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

    //获取所有收藏的学校
    function findCollectedSchools() {
        if (!loginCheck())
            return;
        $.ajax({
            type: "POST",
            url: "/findUsersSchool",
            data: { username: Username },
            datatype: "json",
            async: false,
            success: function (list) {
                $.each(list, function (i, item) {
                    addListItem(item);
                })
            }
        })
    }

    //添加一个学校到收藏列表
    function addListItem(schoolname) {

        //添加标记
        schoolExist.add(schoolname);

        //列表增加
        var content =
            "<label class=\"mdui-list-item mdui-ripple\" id=\"" + schoolname + "\">\
                    <div class=\"mdui-list-item-avatar mdui-icon material-icons\">assignment</div>\
                    <div class=\"mdui-list-item-content\">"+ schoolname + "</div>\
                </label>";
        schoollist.append(content);
        var school = $("#" + schoolname);

        mdui.mutation();

        //开辟绘制区域 包括tab和chart区域
        //总区域id=schoolname+Chart
        //tab区域id=schoolname-grade-tab
        //最高分chart区域是schoolname-max-grade-chart 选项卡是 schoolname-tab-max
        var chartlabel = schoolname + "Chart";
        content = "\
            <div id=\""+ chartlabel + "\" >\
                <div class=\"mdui-tab mdui-tab-centered\" mdui-tab id=\""+ schoolname + "-grade-tab\">\
                    <a href=\"#"+ schoolname + "-max-grade-chart\" class=\"mdui-ripple mdui-ripple-white\" id=\"" + schoolname + "-tab-max\">最高分</a>\
                    <a href=\"#"+ schoolname + "-min-grade-chart\" class=\"mdui-ripple mdui-ripple-white\" id=\"" + schoolname + "-tab-min\">最低分</a>\
                    <a href=\"#"+ schoolname + "-ave-grade-chart\" class=\"mdui-ripple mdui-ripple-white\" id=\"" + schoolname + "-tab-ave\">平均分</a>\
                </div>\
                <div id=\"" + schoolname + "-max-grade-chart\"></div>\
                <div id=\"" + schoolname + "-min-grade-chart\"></div>\
                <div id=\"" + schoolname + "-ave-grade-chart\"></div>\
            </div>";
        
        schooldisplay.append(content);

        mdui.mutation();

        //获取对应学校期望专业的所有分数线信息
        //var flag = 
        getSchoolExpectMajors(schoolname);

        // console.log("flag="+flag);

        // if (!flag) {
        //     return;
        // }

        console.log("stop here 0");

        //先把所有图表绘制一遍
        addChart(schoolname, schoolExpectMajorsList.get(schoolname));

        console.log("stop here 1");

        //给tab标签绑定单击事件
        $("#" + schoolname + "-tab-max").click(function () {
            document.getElementById(schoolname + "-max-grade-chart").__chartist__.update();
        })
        $("#" + schoolname + "-tab-min").click(function () {
            document.getElementById(schoolname + "-min-grade-chart").__chartist__.update();
        })
        $("#" + schoolname + "-tab-ave").click(function () {
            document.getElementById(schoolname + "-ave-grade-chart").__chartist__.update();
        })

        console.log("stop here 2");

        //把所有内容隐藏
        $("#" + schoolname + "Chart").hide();

        //给标签列表绑定单击事件
        school.click(function () {
            console.log("click");
            schoolinput.hide();
            schoolsearch.hide();
            schoolconfirm.hide();
            if (school.hasClass("mdui-list-item-active")) {
                //学校标签处于激活状态
                school.removeClass("mdui-list-item-active");
                //隐藏对应图表
                $("#" + schoolname + "Chart").hide();
            } else {
                school.addClass("mdui-list-item-active");
                //显示对应图表
                showSchool(schoolname);
            }
        })

        console.log("stop here 3");

        mdui.mutation();

    }

    //显示某一学校时 展示学校的操作
    function showSchool(schoolname) {
        $("#" + schoolname + "Chart").show();

        document.getElementById(schoolname + "-max-grade-chart").__chartist__.update();
        document.getElementById(schoolname + "-min-grade-chart").__chartist__.update();
        document.getElementById(schoolname + "-ave-grade-chart").__chartist__.update();
    }

    //绘制某个学校期望专业分数线的图标
    function addChart(schoolname, list) {
        var maxCutoffView = new CutoffView();
        var minCutoffView = new CutoffView();
        var aveCutoffView = new CutoffView();

        $.each(list, function (i, item) {

            var label = item.schoolName + " " + item.province + " " + item.category + " " + item.major;

            maxCutoffView.addCutoff(item.year, label, item.maxgrade);
            minCutoffView.addCutoff(item.year, label, item.mingrade);
            aveCutoffView.addCutoff(item.year, label, item.avegrade);
        })

        maxCutoffView.generate();
        minCutoffView.generate();
        aveCutoffView.generate();

        $("#" + schoolname + "-max-grade-chart").empty();
        $("#" + schoolname + "-min-grade-chart").empty();
        $("#" + schoolname + "-ave-grade-chart").empty();

        newChart(maxCutoffView.x, maxCutoffView.y, maxCutoffView.taken, "line", schoolname + "-max-grade-chart");
        newChart(minCutoffView.x, minCutoffView.y, minCutoffView.taken, "line", schoolname + "-min-grade-chart");
        newChart(aveCutoffView.x, aveCutoffView.y, aveCutoffView.taken, "line", schoolname + "-ave-grade-chart");
    }

    //获取某个学校所有期望专业分数线
    function getSchoolExpectMajors(school) {
        // if (!schoolExist.has(school))
        //     alert("您还没有收藏该学校！");
        $.ajax({
            type: "POST",
            url: "/getSchoolExpectMajors",
            data: { username: Username, school: school },
            datatype: "json",
            async: false,
            success: function (message) {
                if (!message.flag) {
                    alert(message.msg);
                    return false;
                } else {
                    var list = message.obj;
                    schoolExpectMajorsList.set(school, list);
                    console.log(school + " success");
                    return true;
                }
            }
        })
    }

    //添加选择学校列表
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

    //向后台发送收藏学校信息
    function collectSchool(school) {
        $.ajax({
            type: "POST",
            url: "/addSchool",
            data: { username: Username, school: school },
            //contentType: "application/json",
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message);
            }
        })
    }

    //登录检测
    function loginCheck() {
        if (Username == "") {
            alert("Please signin first!");
            //location.href = "/index";
            return false;
        }
        return true;
    }
}