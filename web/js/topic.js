$(function () {

    $("#delete").click(function () {
        var c = confirm("确认删除吗？");
        if (c === true) {
            console.log("delete data...");
            var data = {};
            var count = 0;
            $(".checkboxes").each(function (index, domEl) {
                if ($(domEl).prop("checked")) {
                    data['list[' + count + ']'] = $(domEl).val();
                    count++;
                }
            });
            console.log(data);
            data = $.param(data);
            $.post(
                "deleteTopic.action",
                data,
                function () {
                    console.log("send successfully");
                    $(".right").load("topicManage.action");
                });
        }
    });

    $("#change").click(function () {
        console.log("change data...");
        var table = document.getElementById("table");
        $(".checkboxes").each(function (index, domEl) {
            if ($(domEl).prop("checked")) {
                var row = table.rows[index + 1];
                var id = row.getElementsByTagName("input")[0].value;
                var title = row.cells[1].innerHTML;

                row.innerHTML = row_html;
                row.getElementsByTagName("input")[0].value = id;
                row.getElementsByTagName("input")[1].value = title;

            }
        });
    });

    var my_dept_str = $("#my_dept").attr("name"); // 数组字符串对象
    my_dept_str = my_dept_str.substring(1, my_dept_str.length - 1); // 去掉 [ ]
    console.log(my_dept_str);

    var my_dept = my_dept_str.split(","); // 字符串转数组
    console.log(my_dept);

    var left =
        "<td class='tc'><input class='checkboxes' type='checkbox'></td>" +
        "<td class='tc'><input value='插入知识点'></td>" +
        "<td class='tc'>" +
        "<select class=\"s_dept\">";

    var middle = "";
    for (var i = 0; i < my_dept.length; i++) {
        middle += ("<option>" + my_dept[i] + "</option>");
    }

    var right = "</select></td>";

    var row_html = left + middle + right;

    $("#new").click(function () {
        console.log("new data...");
        var table = document.getElementById("table");
        var rownum = table.rows.length;
        console.log(rownum);
        var row = table.insertRow();


        row.innerHTML = row_html;

        row.getElementsByTagName("input")[0].value = rownum;

    });

    $("#save").click(function () {
        console.log("save data...");
        var Data = {};
        var tab = document.getElementById("table");
        $(".checkboxes").each(function (index, domEl) {
            var cell1 = tab.rows[index + 1].cells[0]; // id
            var cell2 = tab.rows[index + 1].cells[1]; // title
            var cell3 = tab.rows[index + 1].cells[2]; // department

            Data['topicList[' + index + '].id'] = cell1.getElementsByTagName("input")[0].value;
            if (cell2.getElementsByTagName("input")[0] != null) Data['topicList[' + index + '].title'] = cell2.getElementsByTagName("input")[0].value;
            else Data['topicList[' + index + '].title'] = cell2.innerHTML;
            if (cell3.getElementsByTagName("select").length != 0) Data['topicList[' + index + '].department.name'] = cell3.getElementsByTagName("select")[0].value;
            else Data['topicList[' + index + '].department.name'] = cell3.innerHTML; // department

        });
        console.log(Data);
        Data = $.param(Data);
        $.post(
            "saveTopic.action",
            Data,
            function () {
                console.log("send successfully");
                $(".right").load("topicManage.action");
            });
    })
});