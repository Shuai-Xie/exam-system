<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>手工组卷</title>
    <script src="frameworks/jquery-2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/paper.js"></script>
</head>
<body>


<div class="editingarea">

    <div class="c_flex">
        <span class="c_flexible"></span>
    </div>

    <div class="Topictitle" style="font-size: 2em;">添加试卷</div>

    <div class="c_editview">
        <div class="information">

            <%--试卷名称--%>
            <div class="informationtop">
                <p style="float: left">试卷名称：</p>
                <input id="paper_title" style="width: 300px;height: 20px"/>
            </div>
            <br>

            <%--试卷说明--%>
            <div class="informationdown">
                <div class="informationdownleft">
                    <p style="float: left">试卷说明：</p>
                    <textarea id="paper_description" style="width: 300px;height: 100px"></textarea>
                </div>
                <div class="clear"></div>
            </div>
            <br>

            <%--所属方向--%>
            <div class="informationtop">
                所属方向：
                <select id="paper_department" onchange="showDepartmentSubject()">
                    <c:forEach items="${paperDepartmentList}" var="department">
                        <option> ${department}</option>
                    </c:forEach>
                </select>
                &nbsp;&nbsp;
                考试时间：
                <input id="paper_time" style="width: 100px;text-align: right;"> 小时
                &nbsp;&nbsp;
                试卷总分：
                <input id="paper_score" style="width: 20px;text-align: right;border-style: hidden" value="0"> 分
            </div>
        </div>

        <br>

        <%--2个按钮--%>
        <%--<div class="c_condition">--%>
        <%--<span class="icon_add" style="float: left">--%>
        <%--<em class="icon_r" style="float: left">添加题目</em>--%>
        <%--</span>--%>
        <%--<span class="icon_add" style="float: left">--%>
        <%--<em class="icon_r" style="float: left">试卷预览</em>--%>
        <%--</span>--%>
        <%--</div>--%>

        <div class="paper_right">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" id="paper_table">
                <tbody>
                <tr>
                    <th class="tc" width="300"><span>试题描述</span></th>
                    <th class="tc"><span>题型</span></th>
                    <th class="tc"><span>考核知识点</span></th>
                    <th class="tc"><span>认知水平</span></th>
                    <th class="tc"><span>分数</span></th>
                    <th class="tc"><span>操作</span></th>
                </tr>

                <c:forEach items="${paperSubjectList}" var="subject" varStatus="i">
                    <tr>
                        <td class="tc">${subject.stem}</td>
                        <td class="tc">${subject.subjectType.realName}</td>
                        <td class="tc">${subject.topic.title}</td>
                        <td class="tc">${subject.subjectLevel.realName}</td>
                        <td class="tc"><input class="score" style="text-align: center;border-style: none"/></td>
                        <td class="tc">
                            <div>
                                <input class="add_subject" value="${subject.id}" name="${subject.stem}"
                                       type="checkbox"/>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

        <%--保存按钮--%>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" id="paper_save" onclick="savePaper()">保存</em></span>
            <%--<span class="btnL"><em class="btnR" id="preview_btn" onclick="previewNewPaper()">试卷预览</em></span>--%>
        </div>

    </div>

    <div class="clear"></div>
</div>
</body>

<script>

    function savePaper() {
        var data = {};
        data['paper.title'] = $("#paper_title").val();
        data['paper.description'] = $("#paper_description").val();
        data['paper.totalPoints'] = parseInt($("#paper_score").val());
        data['paper.answerQuestionTime'] = parseFloat($("#paper_time").val());
        data['paper.department.name'] = $("#paper_department").val();

        var count = 0;
        var table = document.getElementById("paper_table");
        $(".add_subject").each(function (index, domEl) {

            if ($(domEl).prop("checked")) {
                data['paperSubjectList[' + count + '].score'] = table.rows[index + 1].cells[4].getElementsByTagName("input")[0].value;
                data['subjectIDArray[' + count + ']'] = parseInt(table.rows[index + 1].cells[5].getElementsByTagName("input")[0].value);
                count++;
            }
        });

        console.log(data);

        $.post(
            "savePaper.action",
            data,
            function () {
                console.log("发送成功");
                $(".right").load("paperList.action");
            }
        );
    }

    function showDepartmentSubject() {
        var data = {};
        data['departmentName'] = $("#paper_department").val();
        $.post(
            "departmentSubject.action",
            data,
            function () {
                console.log("发送成功");
                $(".paper_right").load("dsDetail.action");
            }
        );
    }

    //    function previewNewPaper() {
    //        $.post(
    //            "paperPreview.action",
    //            null,
    //            function () {
    //                console.log("send successfully...");
    //                $(".editingarea").load("paperDetail.action");
    //            }
    //        );
    //    }

</script>

</html>