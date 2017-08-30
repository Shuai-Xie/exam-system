<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>subjectDetail</title>
    <script src="frameworks/jquery-2.1.4/jquery.min.js"></script>
</head>
<body>

<div class="Catalogtitle">
    总计 <em>${subjectNumber}</em> 道题&nbsp;&nbsp;
    提示：单击体面可显示答案和解析&nbsp;&nbsp;
    <input type="checkbox" id="show_answer"/><b>显示答案和解析</b>&nbsp;&nbsp;
    <div><i>1</i><a href="#" class="pageone">前</a><a href="#" class="pagetwo">后</a></div>
</div>

<div class="Catalog_rightnei">

    <c:forEach items="${subjectList}" var="subject">

    <div class="Catalogtitwo">
        <b>题号：</b>${subject.id}&nbsp;&nbsp;
        <b>题型：</b>${subject.subjectType.realName}&nbsp;&nbsp;
        <b>难度：</b>${subject.subjectLevel.realName}&nbsp;&nbsp;
        <b>审核状态：</b><span style="color:red">${subject.checkState}</span>&nbsp;&nbsp;
        <b>上传人：</b>${subject.user.name}&nbsp;&nbsp;
        <b>上传时间: </b>${subject.uploadTime}&nbsp;&nbsp;
    </div>

    <div class="Catalogcontent">
        <div class="Catalogcontentup">
            <br>
            <h2>${subject.stem}</h2> <!--题干-->

            <c:if test="${subject.subjectType.realName != '简答题'}"> <%--一定要用单引号比较--%>
                <ul>
                    <c:forEach items="${subject.choices}" var="choice">
                        <li>
                                ${choice.content}  <!--题目选项-->
                        </li>
                    </c:forEach>
                </ul>
            </c:if>

            <div class="subject_answer" style="display: none;margin-top: 30px">
                <b>正确答案：</b>
                    ${subject.answer}
                <br>
                <b>答案解析：</b>
                    ${subject.analysis}
            </div>

        </div>

        <div class="Catalogcontentdown">
            <a class="check_yes" name="${subject.id}">审核通过</a>
            <a class="check_no" name="${subject.id}">审核不通过</a>
            <a class="delete_subject" name="${subject.id}">删除题目</a>
        </div>
    </div>

    </c:forEach>

</body>

<script>

    $("#show_answer").click(function () {
        if ($("#show_answer").prop("checked")) { // prop 拿 true or false
            $(".subject_answer").css("display", "block");
        } else {
            $(".subject_answer").css("display", "none");
        }
    });

    // 审核通过
    $(".check_yes").each(function () {
        $(this).click(function () {
            var yes_subject = {};
            yes_subject['checkYesID'] = $(this).attr("name");
            $.post(
                "checkSubject.action",
                yes_subject,
                function () {
//                    alert("题目" + yes_subject['checkYesID'] + "审核通过！");
                    $(".Catalog_right").load("subjectDetail.action");
                }
            );
        });
    });

    // 审核不通过
    $(".check_no").each(function () {
        $(this).click(function () {
            var no_subject = {};
            no_subject['checkNoID'] = $(this).attr("name");
            $.post(
                "checkSubject.action",
                no_subject,
                function () {
//                    alert("题目" + no_subject['checkNoID'] + "审核不通过！");
                    $(".Catalog_right").load("subjectDetail.action");
                }
            );
        });
    });

    // 删除题目
    $(".delete_subject").each(function () {
        $(this).click(function () {
            var c = confirm("确定删除题目" + $(this).attr("name") + "?");
            if (c === true) {
                var d_subject = {};
                d_subject['deleteID'] = $(this).attr("name");
                $.post(
                    "deleteSubject.action",
                    d_subject,
                    function () {
                        $(".Catalog_right").load("subjectDetail.action");
                    }
                );
            }
        });
    });

</script>
</html>
