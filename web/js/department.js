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
                "deleteDepartment.action",
                data,
                function () {
                    console.log("send successfully");
                    $(".right").load("departmentManage.action");
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
                row.innerHTML = "<td class='tc'><input class='checkboxes' type='checkbox'></td><td class='tc'><input type='text'></td>";
                row.getElementsByTagName("input")[0].value = id;
            }
        });
    });

    $("#new").click(function () {
        console.log("new data...");
        var table = document.getElementById("table");
        var rownum = table.rows.length;
        console.log(rownum);
        var row = table.insertRow();
        row.innerHTML = "<td class='tc'><input class='checkboxes' type='checkbox'></td><td class='tc'><input type='text' value='插入名称'></td>"
        row.getElementsByTagName("input")[0].value = rownum;
        /*var cell1 = row.insertCell();
        cell1.innerHTML = "<td class='tc'><input type='checkbox' class='checkboxes' value=rownum></td>";
        var cell2 = row.insertCell();
        cell2.innerHTML = "<td class='tc'><input type='text' value='插入英文名称'></td>";
        var cell3 = row.insertCell();
        cell3.innerHTML = "<input type='text' value='插入中文名称'>";*/
    });

    $("#save").click(function () {
        console.log("save data...");
        var Data = {};
        var tab = document.getElementById("table");
        $(".checkboxes").each(function (index, domEl) {
            var cell1 = tab.rows[index + 1].cells[0];
            var cell2 = tab.rows[index + 1].cells[1];
            Data['departmentList[' + index + '].id'] = cell1.getElementsByTagName("input")[0].value;
            if (cell2.getElementsByTagName("input")[0] != null) Data['departmentList[' + index + '].name'] = cell2.getElementsByTagName("input")[0].value;
            else Data['departmentList[' + index + '].name'] = cell2.innerHTML;
        });
        console.log(Data);
        Data = $.param(Data);
        $.post(
            "saveDepartment.action",
            Data,
            function () {
                console.log("send successfully");
                $(".right").load("departmentManage.action");
            });
    })
});