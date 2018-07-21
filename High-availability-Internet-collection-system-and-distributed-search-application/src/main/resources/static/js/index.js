window.onload = function () {

    var Username = "xd";
    var Password = "";

    var majorInputSchool = $("#major-input-school");
    var majorInputProvince = $("#major-input-province");
    var majorInputMajor = $("#major-input-major");

    var schoolInputSchool = $("#school-input-school");
    var schoolInputProvince = $("#school-input-province");

    var provinceInputProvince = $("#province-input-province");

    var inputMajorSearch = $("#input-major-search");

    var inputUsrinfoCategory = $("#input-usrinfo-category");
    var inputUsrinfoProvince = $("#input-usrinfo-province");
    var inputUsrinfoGrade = $("#input-usrinfo-grade");

    var dataFragment = $("#data-fragment");
    var majorFragment = $("#major-fragment");
    var infoFragment = $("#infoFragment");
    //var dataPanel = $("#data-panel");
    var majorSearchList = $("#major-search-list");

    var majorSearchSubmit = $("#major-search-submit");
    var schoolSearchSubmit = $("#school-search-submit");
    var provinceSearchSubmit = $("#province-search-submit");
    var majorSetSubmit = $("#major-set-submit");
    var usrinfoSetSubmit = $("#usrinfo-set-submit");

    var signin = $("#signin-button");
    var signup = $("#signup-button");
    var inputUsername = $("#input-username");
    var inputPassword = $("#input-password");

    //data-fragment区域清空控制变量
    var lastButton = "xd";

    //var years=['2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'];

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
                    signback(message.msg);
                }
            }
        })
    })

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
                    signback(message.msg);
                }
            }
        })
    })

    function signback(message) {
        alert(message);
        $("#username-field").text(Username);
        $("#username-field").attr("href", "/user");
    }

    majorSearchSubmit.click(function () {

        //清空所有内容
        if (lastButton != "majorSearch") {
            dataFragment.empty();
            lastButton = "majorSearch";
        }

        var school_name = majorInputSchool.val();
        var province = majorInputProvince.val();
        var major = majorInputMajor.val();

        console.log(school_name);
        console.log(province);
        console.log(major);

        $.ajax({
            type: "POST",
            url: "/searchCutoff",
            data: { school_name: school_name, province: province, major: major },
            datatype: "json",
            async: false,
            success: function (list) {

                console.log("success");

                //添加panel
                addMajorPanel(school_name, province, major);

                //在panel下添加绘制表格
                $.each(list, function (i, item) {
                    addMajorAndSchoolItem($("#" + school_name + "-" + province + "-" + major + "-tbody"), item.category, item.year, item.batch, item.maxgrade, item.mingrade, item.avegrade);
                })

                mdui.mutation();
            }
        })
    })

    schoolSearchSubmit.click(function () {

        //clear all the content
        if (lastButton != "schoolSearch") {
            dataFragment.empty();
            lastButton = "schoolSearch";
        }

        var school_name = schoolInputSchool.val();
        var province = schoolInputProvince.val();

        $.ajax({
            type: "POST",
            url: "/searchScutoff",
            data: { schoolName: school_name, province: province },
            datatype: "json",
            async: false,
            success: function (list) {

                console.log("success");

                addSchoolPanel(school_name, province);

                $.each(list, function (i, item) {
                    addMajorAndSchoolItem($("#" + school_name + "-" + province + "-tbody"), item.category, item.year, item.batch, item.maxgrade, item.mingrade, item.avegrade);
                })

                mdui.mutation();
            }
        })
    })

    provinceSearchSubmit.click(function () {

        //clear all the content
        if (lastButton != "provinceSearch") {
            dataFragment.empty();
            lastButton = "provinceSearch";
        }

        var province = provinceInputProvince.val();

        $.ajax({
            type: "POST",
            url: "/searchPcutoff",
            data: { province: province },
            datatype: "json",
            async: false,
            success: function (list) {

                console.log("success");

                addProvincePanel(province);

                $.each(list, function (i, item) {
                    //console.log(i);
                    addProvinceItem($("#" + province + "-tbody"), item.category, item.year, item.batch, item.grade);
                })

                mdui.mutation();
            }
        })
    })

    majorSetSubmit.click(function () {

        if(!loginCheck()){
            return;
        }

        $('input:checkbox:checked').each(function (index, item) {
            var major = $(this).val();
            addExpectMajor(major);
        });
    })

    usrinfoSetSubmit.click(function () {

        if(!loginCheck()){
            return;
        }

        var category = inputUsrinfoCategory.val();
        var province = inputUsrinfoProvince.val();
        var grade = inputUsrinfoGrade.val();

        $.ajas({
            type: "POST",
            url: "/setUserInfo",
            data: { useranme: username, category: category, province: province, grade: grade },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message.flag);
                alert(message.flag);
            }
        })
    })

    function loginCheck(){
        if(Username=="xd"){
            alert("Please signin first!");
            return false;
        }
        return true;
    }

    inputMajorSearch.bind("input propertychange", function () {
        var major = inputMajorSearch.val();
        console.log(major);
        if (major != null && major != "") {
            majorSearchList.empty();
            $.ajax({
                type: "POST",
                url: "/findMajorLike",
                data: { major: major },
                async: false,
                success: function (list) {
                    $.each(list, function (i, item) {
                        addMajorListItem(item);
                    })
                }
            })
        }

        mdui.mutation();
    })

    function addMajorPanel(school_name, province, major) {
        var idlabel = school_name + "-" + province + "-" + major;
        var content = "\
            <div class=\"mdui-panel mdui-panel-popout\" mdui-panel>\
                <div class=\"mdui-panel-item\">\
                    <div class=\"mdui-panel-item-header\">\
                        <div class=\"mdui-panel-item-title\">"+ school_name + "</div>\
                        <div class=\"mdui-panel-item-summary\">"+ province + "</div>\
                        <div class=\"mdui-panel-item-summary\">"+ major + "</div>\
                        <i class=\"mdui-panel-item-arrow mdui-icon material-icons\">keyboard_arrow_down</i>\
                    </div>\
                    <div class=\"mdui-panel-item-body\">\
                        <table class=\"mdui-table mdui-table-selectable\">\
                            <thead>\
                                <tr>\
                                    <th>文理</th>\
                                    <th>年份</th>\
                                    <th>批次</th>\
                                    <th>最高分</th>\
                                    <th>最低分</th>\
                                    <th>平均分</th>\
                                </tr>\
                            </thead>\
                            <tbody id=\""+ idlabel + "-tbody" + "\">\
                            </tbody>\
                        </table>\
                    </div>\
                </div>\
            </div>";
        dataFragment.append(content);
        //mdui.mutation();
    }

    function addSchoolPanel(school_name, province) {
        var idlabel = school_name + "-" + province;
        var content = "\
            <div class=\"mdui-panel mdui-panel-popout\" mdui-panel>\
                <div class=\"mdui-panel-item\">\
                    <div class=\"mdui-panel-item-header\">\
                        <div class=\"mdui-panel-item-title\">"+ school_name + "</div>\
                        <div class=\"mdui-panel-item-summary\">"+ province + "</div>\
                        <i class=\"mdui-panel-item-arrow mdui-icon material-icons\">keyboard_arrow_down</i>\
                    </div>\
                    <div class=\"mdui-panel-item-body\">\
                        <table class=\"mdui-table mdui-table-selectable\">\
                            <thead>\
                                <tr>\
                                    <th>文理</th>\
                                    <th>年份</th>\
                                    <th>批次</th>\
                                    <th>最高分</th>\
                                    <th>最低分</th>\
                                    <th>平均分</th>\
                                </tr>\
                            </thead>\
                            <tbody id=\""+ idlabel + "-tbody" + "\">\
                            </tbody>\
                        </table>\
                    </div>\
                </div>\
            </div>";
        dataFragment.append(content);
        //mdui.mutation();
    }

    function addProvincePanel(province) {
        var idlabel = province;
        var content = "\
            <div class=\"mdui-panel mdui-panel-popout\" mdui-panel>\
                <div class=\"mdui-panel-item\">\
                    <div class=\"mdui-panel-item-header\">\
                        <div class=\"mdui-panel-item-title\">"+ province + "</div>\
                        <i class=\"mdui-panel-item-arrow mdui-icon material-icons\">keyboard_arrow_down</i>\
                    </div>\
                    <div class=\"mdui-panel-item-body\">\
                        <table class=\"mdui-table mdui-table-selectable\">\
                            <thead>\
                                <tr>\
                                    <th>文理</th>\
                                    <th>年份</th>\
                                    <th>批次</th>\
                                    <th>分数线</th>\
                                </tr>\
                            </thead>\
                            <tbody id=\""+ idlabel + "-tbody" + "\">\
                            </tbody>\
                        </table>\
                    </div>\
                </div>\
            </div>";
        dataFragment.append(content);
        //mdui.mutation();
        //console.log(content);
    }

    function addProvinceItem(tbody, category, year, batch, grade) {
        if (grade == "null")
            grade = "---";
        var content = "<tr><td>";
        content += category;
        content += "</td><td>";
        content += year;
        content += "</td><td>"
        content += batch;
        content += "</td><td>";
        content += grade;
        content += "</td></tr>"
        tbody.append(content);
    }

    //majorSearch & schoolSearch
    function addMajorAndSchoolItem(tbody, category, year, batch, maxgrade, mingrade, avegrade) {
        if (maxgrade == "null")
            maxgrade = "---";
        if (mingrade == "null")
            mingrade = "---";
        if (avegrade == "null")
            avegrade = "---";
        var content = "<tr>";
        content += "<td>" + category + "</td>";
        content += "<td>" + year + "</td>";
        content += "<td>" + batch + "</td>";
        content += "<td>" + maxgrade + "</td>";
        content += "<td>" + mingrade + "</td>";
        content += "<td>" + avegrade + "</td>";
        content += "</tr>";
        tbody.append(content);
    }

    function addMajorListItem(major) {
        var content = "\
        <label class=\"mdui-list-item mdui-ripple\">\
            <div class=\"mdui-checkbox\">\
                <input type=\"checkbox\" value=\""+ major + "\"/>\
                <i class=\"mdui-checkbox-icon\"></i>\
            </div>\
            <div class=\"mdui-list-item-content\">"+ major + "</div>\
                <i class=\"mdui-list-item-icon mdui-icon material-icons\">chat</i>\
        </label>";
        majorSearchList.append(content);
    }

    function addExpectMajor(major) {
        if (username == "" || useranme == null)
            alert("Please login first!");
        $.ajax({
            type: "POST",
            url: "/searchCutoff",
            data: { username: username, major: major },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message.flag);
                if (message.flag) {
                    majorSearchList.empty();
                }
            }
        })
    }

}