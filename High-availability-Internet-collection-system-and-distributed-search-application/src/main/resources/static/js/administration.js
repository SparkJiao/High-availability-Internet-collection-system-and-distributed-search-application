window.onload = function () {


    //var mot = new Model("xxx", "xxx", "xxx", "xxx", "xxx", "xxx");
    //console.log(JSON.stringify(mot));

    var startUrl_field = $("#startUrl_field");
    $("#level_field").bind("input propertychange", function () {
        var levels = $("#level_field").val();
        console.log(levels);
        if (levels == "")
            content_field.empty();
        else
            addInput(levels);
    })
    var headers_field = $("#headers_field");
    var level_field = $("#level_field");
    var content_field = $("#dialog-content");
    var target_field = $("#target_field");
    var index_field = $("#index_field");

    var startUrls = new Array();

    var models = new Array();

    var panel = $("#panel");
    var submit = $("#submit");
    var delete_button = $("#delete-button");

    //全局template标识符
    var index = 0;

    attempt();

    function attempt() {
        $.ajax({
            type: "POST",
            url: "/adminAttempt",
            datatype: "json",
            async: false,
            success: function (message) {
                if (message.flag) {
                    Username = message.msg;
                    //signback("欢迎回来！" + Username);
                } else {
                    location.href = "/admin";
                }
            }
        })
    }

    function addInput(levels) {
        var content = "";
        for (i = 0; i < levels; i++) {
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">当前层数</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"currentLevel_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">"+ "第" + i + "层使用的匹配方式标识符()</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"token_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">"+ "第" + i + "层匹配模板</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"pattern_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">"+ "第" + i + "层pagenumber位置</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"wherePagenumber_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">"+ "第" + i + "层size位置</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"whereSize_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
            content += "\
            <div class=\"mdui-row mdui-m-t-2\">\
                <div class=\"mdui-textfield mdui-textfield-floating-label mdui-col-xs-12\">\
                    <label class=\"mdui-textfield-label\">"+ "第" + i + "层参数总数量</label>\
                    <textarea class=\"mdui-textfield-input\" id=\"total_field_"+ i + "\"></textarea>\
                </div>\
            </div>";
        }
        content_field.append(content);
        mdui.mutation();
    }

    function Model(currentLevel, token, pattern, wherePagenumber, whereSize, total) {
        this.currentLevel = currentLevel;
        this.token = token;
        this.pattern = pattern;
        this.wherePagenumber = wherePagenumber;
        this.whereSize = whereSize;
        this.total = total;
    }

    function getDynamicValue() {
        var res = $("input[name='static']:checked").val();
        if (res == "1")
            return true;
        else
            return false;
    };

    function addTemplate(index, startUrl, level, target, headers, dynamic, status, startTime, endTime, models) {
        //status 待使用
        content = "";
        content += "\
            <div class=\"mdui-panel mdui-panel-popout\" mdui-panel id=\"template"+ index + "\">\
                <div class=\"mdui-panel-item\">\
                    <div class=\"mdui-panel-item-header\">\
                        <div class=\"mdui-panel-item-title\">"+ index + ":&nbsp;&nbsp;&nbsp;&nbsp;" + startUrl + "</div>\
                        <i class=\"mdui-panel-item-arrow mdui-icon material-icons\">keyboard_arrow_down</i>\
                    </div>\
                    <div class=\"mdui-panel-item-body\">\
                        <ul class=\"mdui-list\">\
                            <li class=\"mdui-list-item mdui-ripple\">"+ level + "层&nbsp;&nbsp;&nbsp;&nbsp;" + (dynamic ? "动态页面" : "静态页面") + "</li>\
                            <li class=\"mdui-list-item mdui-ripple\">创建于"+ changeTimestamp(startTime) + "&nbsp;&nbsp;&nbsp;&nbsp;于" + changeTimestamp(endTime) + "采集完成</li>\
                            <li class=\"mdui-list-item mdui-ripple\">target："+ target + "</li>\
                            <li class=\"mdui-list-item mdui-ripple\">headers："+ headers + "</li>\
                        </ul>\
                        <div class=\"mdui-table-fluid\">\
                            <table class=\"mdui-table mdui-table-hoverable\">\
                                <thead>\
                                    <tr>\
                                        <th>层数</th>\
                                        <th>匹配方式</th>\
                                        <th>匹配模板</th>\
                                        <th>pagenumber位置</th>\
                                        <th>size位置</th>\
                                        <th>参数总数量</th>\
                                    </tr>\
                                </thead>\
                                <tbody>";
        $.each(models, function (i, item) {
            content += generateTable(item.currentLevel, item.token, item.pattern, item.wherePagenumber, item.whereSize, item.total);
        })
        content += "\
                                </tbody>\
                            </table>\
                        </div>\
                    </div>\
                </div>\
            </div>";
        panel.append(content);
        mdui.mutation();
    }

    function generateTable(currentLevel, token, pattern, wherePagenumber, whereSize, total) {
        var content = "<tr><td>";
        content += currentLevel;
        content += "</td><td>";
        content += token;
        content += "</td><td>";
        content += pattern;
        content += "</td><td>";
        content += wherePagenumber;
        content += "</td><td>";
        content += whereSize;
        content += "</td><td>";
        content += total;
        content += "</td><td>";
        return content;
    }

    submit.click(function () {
        var startUrl = startUrl_field.val();
        var target = target_field.val();
        var headers = headers_field.val();
        var level = level_field.val();
        var dynamic = getDynamicValue();
        console.log("startUrl:" + startUrl);
        console.log("target:" + target);
        console.log("headers:" + headers);
        console.log("level:" + level);
        console.log("isStatic:" + dynamic);
        if (!startUrl || !target || !level) {
            alert("请完成所有项目！");
            return;
        }
        for (i = 0; i < level; i++) {
            var currentLevel = $("#currentLevel_field_" + i).val();
            var token = $("#token_field_" + i).val();
            var pattern = $("#pattern_field_" + i).val();
            var wherePagenumber = $("#wherePagenumber_field_" + i).val();
            var whereSize = $("#whereSize_field_" + i).val();
            var total = $("#total_field_" + i).val();
            models[i] = new Model(currentLevel, token, pattern, wherePagenumber, whereSize, total);
            // console.log(currentLevel);
            // console.log(token);
            // console.log(pattern);
            // console.log(wherePagenumber);
            // console.log(whereSize);
            // console.log(total);
        }
        console.log(JSON.stringify({ "startUrl": startUrl, "level": level, "headers": headers, "dynamic": dynamic, "matchModelList": models }));
        $.ajax({
            type: "POST",
            url: "/addTemplate",
            data: JSON.stringify({ "startUrl": startUrl, "level": level, "target":target, "headers": headers, "dynamic": dynamic, "matchModelList": models }),
            contentType: "application/json",
            datatype: "json",
            async: false,
            success: function (message) {
                alert(message.flag);
                if (message.flag) {
                    //var start_time = message.obj.startTime;
                    var startTime = getNow();
                    var status = "未采集";
                    startUrls[index] = startUrl;
                    addTemplate(index, startUrl, level, target, headers, dynamic, status, startTime, null, models);
                    index++;
                } else {
                    alert(message.msg);
                }
            }
        })
    })

    delete_button.click(function (){
        var ind = index_field.val();
        deleteTemplate(ind);
    })

    function getAllModels() {
        $.ajax({
            type: "POST",
            url: "/getAllTemplates",
            datatype: "json",
            async: false,
            success: function (list) {
                $.each(list, function (i, item) {
                    startUrls[index++] = item.startUrl;
                    addTemplate(i, item.startUrl, item.level, item.target, item.headers, item.dynamic, item.status, item.startTime, item.endTime, item.matchModelList);
                })
            }
        })
    }

    getAllModels();

    function changeTimestamp(timestamp) {
        if (!timestamp) return "------------"
        var d = new Date(timestamp);
        var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
        return times;
    }

    function getNow() {
        var d = new Date();
        var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
        return times;
    }

    function deleteTemplate(ind) {
        $.ajax({
            type: "POST",
            url: "/deleteTemplate",
            data: { startUrl: startUrls[ind] },
            datatype: "json",
            async: false,
            success: function (message) {
                console.log(message);
                if (message.flag) {
                    $("#template" + ind).remove();
                }
            }
        })
    }

    mdui.mutation();
}