window.onload = function () {

    var Username = "";

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

    var dataFragment = $("#dataFragment");
    var majorFragment = $("#major-fragment");
    var infoFragment = $("#infoFragment");
    //var dataPanel = $("#data-panel");
    var majorSearchList = $("#major-search-list");

    var majorSearchSubmit = $("#major-search-submit");
    var schoolSearchSubmit = $("#school-search-submit");
    var provinceSearchSubmit = $("#province-search-submit");
    var majorSetSubmit = $("#major-set-submit");
    var usrinfoSetSubmit = $("#usrinfo-set-submit");

    var addChart = $("#add-chart");
    var maxGradeChart = $("#max-grade-chart");
    var minGradeChart = $("#min-grade-chart");
    var aveGradeChart = $("#ave-grade-chart");
    var provinceGradeChart = $("#province-grade-chart")

    var gradeTab = $("#grade-tab");
    gradeTab.hide();
    var tabMax = $("#tab-max");
    var tabMin = $("#tab-min");
    var tabAve = $("#tab-ave");

    var signin = $("#signin-button");
    var signup = $("#signup-button");
    var inputUsername = $("#input-username");
    var inputPassword = $("#input-password");
    var account = $("#account");
    var exit = $("#exit-button");

    //data-fragment区域清空控制变量
    var lastButton = "xd";

    //var cutoffView = new CutoffView();

    //var years=['2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'];

    attempt();

    function attempt() {
        $.ajax({
            type: "POST",
            url: "/attempt",
            datatype: "json",
            async: false,
            success: function (message) {
                if (message.flag) {
                    Username = message.msg;
                    signback("欢迎回来！" + Username);
                }
            }
        })
    }

    addChart.click(function () {

        if (lastButton == "provinceSearch") {

            var cutoffView = new CutoffView();

            var num = $(".mdui-table-row-selected").length;

            for (var i = 0; i < num; i++) {

                console.log($(".mdui-table-row-selected:eq(" + i + ")").attr("id"));

                var item = JSON.parse($(".mdui-table-row-selected:eq(" + i + ")").attr("id"));

                var label = item.province + " " + item.category + " " + item.batch;

                cutoffView.addCutoff(item.year, label, item.grade);
            }

            gradeTab.hide();

            cutoffView.generate();
            provinceGradeChart.empty();
            newChart(cutoffView.x, cutoffView.y, cutoffView.taken, "line", "province-grade-chart");

        } else {

            var maxCutoffView = new CutoffView();
            var minCutoffView = new CutoffView();
            var aveCutoffView = new CutoffView();

            var num = $(".mdui-table-row-selected").length;

            for (var i = 0; i < num; i++) {

                console.log($(".mdui-table-row-selected:eq(" + i + ")").attr("id"));

                var item = JSON.parse($(".mdui-table-row-selected:eq(" + i + ")").attr("id"));
                //console.log(item);

                var label;

                if (lastButton == "majorSearch") {
                    label = item.schoolName + " " + item.province + " " + item.category + " " + item.major;
                } else if (lastButton == "schoolSearch") {
                    label = item.school + " " + item.province + " " + item.category + " " + item.batch;
                }

                maxCutoffView.addCutoff(item.year, label, item.maxgrade);
                minCutoffView.addCutoff(item.year, label, item.mingrade);
                aveCutoffView.addCutoff(item.year, label, item.avegrade);

            }

            gradeTab.show();

            maxCutoffView.generate();
            minCutoffView.generate();
            aveCutoffView.generate();

            maxGradeChart.empty();
            minGradeChart.empty();
            aveGradeChart.empty();

            // maxGradeChart.show();
            // minGradeChart.show();
            // aveGradeChart.show();

            newChart(maxCutoffView.x, maxCutoffView.y, maxCutoffView.taken, "line", "max-grade-chart");
            newChart(minCutoffView.x, minCutoffView.y, minCutoffView.taken, "line", "min-grade-chart");
            newChart(aveCutoffView.x, aveCutoffView.y, aveCutoffView.taken, "line", "ave-grade-chart");

            // maxGradeChart.hide();
            // minGradeChart.hide();
            // aveGradeChart.hide();
            // $(".mdui-tab-active:eq(0)").show();

        }
    })

    tabMax.click(function () {
        document.getElementById("max-grade-chart").__chartist__.update();
    })

    tabMin.click(function () {
        document.getElementById("min-grade-chart").__chartist__.update();
    })

    tabAve.click(function () {
        document.getElementById("ave-grade-chart").__chartist__.update();
    })

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
        account.attr("mdui-dialog", "{target: '#exitDialog'}");
    }

    //注销
    exit.click(function () {
        Username = "";
        exitback();
    })

    //注销成功回调函数
    function exitback() {
        alert("退出成功");
        $("#username-field").text("←请登录");
        account.attr("mdui-dialog", "{target: '#loginDialog'}");
        clearCookie("username");
        clearCookie("password");
    }

    majorSearchSubmit.click(function () {

        //清空所有内容
        if (lastButton != "majorSearch") {
            dataFragment.empty();
            maxGradeChart.empty();
            minGradeChart.empty();
            aveGradeChart.empty();
            provinceGradeChart.empty();
            gradeTab.hide();
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
            success: function (map) {

                console.log("success");

                $.each(map.map, function (key, values) {
                    major = key;

                    console.log(key);

                    //添加panel
                    addMajorPanel(school_name, province, major);

                    $(values).each(function (i, item) {
                        addMajorAndSchoolItem($("#" + school_name + "-" + province + "-" + major + "-tbody"), JSON.stringify(item), item.category, item.year, item.batch, item.maxgrade, item.mingrade, item.avegrade);
                    })
                })

                mdui.mutation();

                // //添加panel
                // addMajorPanel(school_name, province, major);

                // //在panel下添加绘制表格
                // $.each(list, function (i, item) {
                //     addMajorAndSchoolItem($("#" + school_name + "-" + province + "-" + major + "-tbody"), item.category, item.year, item.batch, item.maxgrade, item.mingrade, item.avegrade);
                // })

                // mdui.mutation();
            }
        })
    })

    schoolSearchSubmit.click(function () {

        //clear all the content
        if (lastButton != "schoolSearch") {
            dataFragment.empty();
            maxGradeChart.empty();
            minGradeChart.empty();
            aveGradeChart.empty();
            provinceGradeChart.empty();
            gradeTab.hide();
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
                    addMajorAndSchoolItem($("#" + school_name + "-" + province + "-tbody"), JSON.stringify(item), item.category, item.year, item.batch, item.maxgrade, item.mingrade, item.avegrade);
                })

                mdui.mutation();
            }
        })
    })

    provinceSearchSubmit.click(function () {

        //clear all the content
        if (lastButton != "provinceSearch") {
            dataFragment.empty();
            maxGradeChart.empty();
            minGradeChart.empty();
            aveGradeChart.empty();
            provinceGradeChart.empty();
            gradeTab.hide();
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
                    addProvinceItem($("#" + province + "-tbody"), JSON.stringify(item), item.category, item.year, item.batch, item.grade);
                })

                mdui.mutation();
            }
        })
    })

    majorSetSubmit.click(function () {

        if (!loginCheck()) {
            return;
        }

        $('input:checkbox:checked').each(function (index, item) {
            var major = $(this).val();
            addExpectMajor(major);
        });
    })

    usrinfoSetSubmit.click(function () {

        if (!loginCheck()) {
            return;
        }

        var category = inputUsrinfoCategory.val();
        var province = inputUsrinfoProvince.val();
        var grade = inputUsrinfoGrade.val();

        $.ajax({
            type: "POST",
            url: "/setUserInfo",
            data: { username: Username, category: category, province: province, grade: grade },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message.flag);
                alert(message.flag);
            }
        })
    })

    function loginCheck() {
        if (Username == "") {
            alert("Please signin first!");
            //location.href = "/index";
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
                url: "/findMajorContains",
                data: { major: major },
                async: false,
                success: function (list) {
                    list.sort();
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

    function addProvinceItem(tbody, json, category, year, batch, grade) {
        if (grade == null)
            grade = "---";
        var content = "<tr id=" + json + "><td>";
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
    function addMajorAndSchoolItem(tbody, json, category, year, batch, maxgrade, mingrade, avegrade) {
        if (maxgrade == null)
            maxgrade = "---";
        if (mingrade == null)
            mingrade = "---";
        if (avegrade == null)
            avegrade = "---";
        var content = "<tr id=" + json + ">";
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
        if (Username == "" || Username == null)
            alert("Please login first!");
        $.ajax({
            type: "POST",
            url: "/addExpectMajor",
            data: { username: Username, major: major },
            datatype: "json",
            async: false,
            success: function (message) {
                alert(message.flag);
                console.log(message.flag);
                if (message.flag) {
                    majorSearchList.empty();
                }
            }
        })
    }

}