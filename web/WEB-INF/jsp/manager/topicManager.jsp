<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>知识点管理</title>
    <script src="js/topic.js"></script>
</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>知识点管理</h3>
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1" id="table">
                <tbody>
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>知识点</span></th>
                    <th class="tc" width="300"><span>所属方向</span></th>
                </tr>
                <c:forEach items="${topicList}" var="topic">
                    <tr>
                        <td class="tc"><input class="checkboxes" type="checkbox" value="${topic.id}"></td>
                        <td class="tc">${topic.title}</td>
                        <td class="tc">${topic.department.name }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="btn_left">
            <span class="btnL"><em id="new" class="btnR">添加</em></span>
            <span class="btnL"><em id="change" class="btnR">修改</em></span>
            <span class="btnL"><em id="delete" class="btnR">删除</em></span>
            <span class="btnL"><em id="save" class="btnR">保存</em></span>
        </div>

        <a id="my_dept" name="${departmentList}"></a>
    </div>
</div>
</body>
</html>