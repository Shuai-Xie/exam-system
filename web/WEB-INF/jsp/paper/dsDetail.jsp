<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>部门题目</title>
</head>
<body>
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
                    <input class="add_subject" value="${subject.id}" name="${subject.stem}" type="checkbox"/>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
