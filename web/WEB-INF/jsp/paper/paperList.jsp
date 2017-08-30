<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>试卷管理</title>
    <script src="js/paper.js"></script>
</head>
<body>

<div class="editingarea">
    <div class="c_flex">
        <span class="c_flexible"></span>
    </div>
    <div class="c_editview">

        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                   class="tab1" id="table">
                <tbody>
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>试题名称</span></th>
                    <th class="tc" width="300"><span>试题描述</span></th>
                    <th class="tc"><span>所属方向</span></th>
                    <th class="tc"><span>创建时间</span></th>
                    <th class="tc"><span>答题时间</span></th>
                    <th class="tc"><span>总分</span></th>
                </tr>

                <c:forEach items="${paperList}" var="paper">
                    <tr>
                        <td class="tc"><input class="checkboxes" type="checkbox" value="${paper.id}"></td>
                        <td class="tc">${paper.title}</td>
                        <td class="tc">${paper.description}</td>
                        <td class="tc">${paper.department.name}</td>
                        <td class="tc">${paper.createTime}</td>
                        <td class="tc">${paper.answerQuestionTime} 小时</td>
                        <td class="tc">${paper.totalPoints}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <div class="btn_left">
            <span class="btnL"><em id="add" class="btnR" onclick="addPaper()">添加</em></span>
            <span class="btnL"><em id="delete" class="btnR" onclick="deletePaper()">删除</em></span>
            <span class="btnL"><em id="preview" class="btnR" onclick="previewPaper()">预览</em></span>
        </div>
    </div>
</div>
</body>

<script>

    // 添加试卷
    function addPaper() {
        console.log("add paper...");
        $(".editingarea").load("makePaperByHand.action"); // todo 手工组卷页面
    }

    // 删除试卷
    function deletePaper() {
        console.log("delete data...");
        var c = confirm("确认删除试卷吗？"); // todo 确认信息
        if (c === true) {
            var data = {};
            var count = 0;
            $(".checkboxes").each(function (index, domEl) {
                if ($(domEl).prop("checked")) {
                    data['deleteIDArray[' + count + ']'] = parseInt($.trim($(domEl).val())); // todo 转成整型
                    count++;
                }
            });
            console.log(data);
            data = $.param(data);
            $.post(
                "deletePaper.action",
                data,
                function () {
                    console.log("send successfully");
                    $(".right").load("paperList.action");
                }
            );
        }
    }

    // 预览试卷
    function previewPaper() {
        console.log("in preview...");
        $(".checkboxes").each(function (index, domEl) {
            if ($(domEl).prop("checked")) {
                var data = {};
                data['previewID'] = parseInt($.trim($(domEl).val())); // todo 转成整型，方便前面 ID 的 List<Long>
                console.log(data);
                data = $.param(data);
                $.post(
                    "paperPreview.action",
                    data,
                    function () {
                        console.log("send successfully...");
                        $(".editingarea").load("paperDetail.action"); // todo 异步加载试卷信息，大action load 小action
                    }
                );
            }
        });
    }

</script>

</html>