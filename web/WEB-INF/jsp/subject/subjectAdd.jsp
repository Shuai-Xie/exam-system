<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>subjectAdd</title>

    <%-- 必须引入jQuery，因为超链接调用方法 --%>
    <script src="frameworks/jquery-2.1.4/jquery.min.js"></script>

</head>
<body>
<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="Topictitle">添加题目</div>


    <div class="c_editview">
        <%--4个选项--%>
        <%--typeList, levelList, departmentList, topicList 都是项目启动时由listener加载到的--%>
        <div class="Problem">
            <div class="Attributetit">题目属性</div>
            题目类型
            <select id="subject_type" onchange="chooseSubjectType()">
                <c:forEach items="${typeList}" var="type">
                    <option>${type}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            难度级别
            <select id="subject_level">
                <c:forEach items="${levelList}" var="level">
                    <option>${level}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            所属方向
            <select id="subject_department">
                <c:forEach items="${departmentList}" var="department">
                    <option>${department}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
            所属知识点
            <select id="subject_topic">
                <c:forEach items="${topicList}" var="topic">
                    <option>${topic}</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;
        </div>

        <%-- 题目题干 --%>
        <div class="Problem">
            <div class="Attributetit">题目题干</div>
            <div class="Problemcontent">
                <%-- name 必须是 类名.属性 --%>
                <%-- id 或 class 可以是任意值，但是不能与 name 重复 --%>
                <textarea id="subject_stem" cols="200" rows="4" name="subject.stem"></textarea>
            </div>
        </div>

        <!--单选题视图-->
        <div class="Answeroptions" id="radio_subject">
            <div class="Attributetit">单选题答案选项</div>
            <%-- 添加选项图标 --%>
            <div class="c_condition">
                <span class="icon_add"><em class="icon_r" style="float: left">添加选项</em></span>
            </div>

            <%-- 选项内容 --%>
            <div class="Answercontent">
                <%-- 选项A --%>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>A</p>
                        <span>
                        <input class="radio_correct" name="correct" value="0" type="radio"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="radio_content" name="content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <%-- 选项B --%>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>B</p><span>
                        <input class="radio_correct" name="correct" value="1" type="radio"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="radio_content" name="content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <%-- 选项C --%>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>C</p><span>
                        <input class="radio_correct" name="correct" value="2" type="radio"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="radio_content" name="content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <%-- 选项D --%>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>D</p><span>
                        <input class="radio_correct" name="correct" value="3" type="radio"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="radio_content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="clear"></div>
            </div>
        </div>

        <!--多选题视图-->
        <%--刚进入页面只有单选题选项框显示--%>
        <div class="Answeroptions" id="check_subject" style="display: none">
            <div class="Attributetit">复选题答案选项</div>
            <div class="c_condition"><span class="icon_add"><em class="icon_r" style="float: left">添加选项</em></span>
            </div>
            <div class="Answercontent">
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>A</p><span>
                        <input class="checkbox_correct" type="checkbox"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="checkbox_content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>B</p><span>
                        <input class="checkbox_correct" type="checkbox"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="checkbox_content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>C</p><span>
                        <input class="checkbox_correct" type="checkbox"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="checkbox_content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="Answerpart">
                    <div class="Answerpart_left">
                        <p>D</p><span>
                        <input class="checkbox_correct" type="checkbox"/></span>
                    </div>
                    <div class="Answerpart_right">
                        <textarea class="checkbox_content" cols="40" rows="4"></textarea>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <%--简答题视图--%>
        <%--刚进入页面只有单选题选项框显示--%>
        <div class="Problem" id="question_subject" style="display: none">
            <div class="Attributetit">简答题标准答案</div>
            <div class="Problemcontent">
                <textarea id="subject_answer" cols="60" rows="4"></textarea>
            </div>
        </div>


        <div class="Problem">
            <div class="Attributetit">答案解析</div>
            <div class="Problemcontent">
                <textarea id="subject_analysis" cols="60" rows="4"></textarea>
            </div>
        </div>

        <div class="btn_left">
            <span class="btnL">
                <a id="save_continue" class="btnR" onclick="saveSubjectAndContinue()">保存并继续</a>
            </span>
            <span class="btnL">
                <a id="save_close" class="btnR" onclick="saveSubjectAndClose()">保存并关闭</a>
            </span>
        </div>

    </div>
</div>
</body>

<script>

    // 选择题目类型div
    function chooseSubjectType() {
        switch ($("#subject_type").val()) { // 根据选中的题目类型加载相应 div
            case "单选题":
                $("#radio_subject").css("display", "block"); // jQuery语法，区别与js原生语法
                $("#check_subject").css("display", "none");
                $("#question_subject").css("display", "none");
                break;
            case "复选题":
                $("#radio_subject").css("display", "none");
                $("#check_subject").css("display", "block"); // 看清id只有一个下划线!
                $("#question_subject").css("display", "none");
                break;
            case "简答题":
                $("#radio_subject").css("display", "none");
                $("#check_subject").css("display", "none");
                $("#question_subject").css("display", "block");
                break;
        }
    }

    // 保存并继续
    function saveSubjectAndContinue() {
        console.log("save and continue...");
        saveSubject();
        $(".right").load("addSubject.action");
    }

    // 保存并关闭
    function saveSubjectAndClose() {
        console.log("save and close...");
        saveSubject();
        $("body").load("toIndex.action"); // 回主页
    }


    function saveSubject() {
        var data = {};

        // 获取选项内容
        switch ($("#subject_type").val()) {
            case "单选题":
                // 数组类型的数据，要这样拼接
                $(".radio_correct").each(function (index, domEl) {
                    data['choiceCorrectArray[' + index + ']'] = $(domEl).prop("checked"); // boolean类型
                });
                $(".radio_content").each(function (index, domEl) {
                    data['choiceContentArray[' + index + ']'] = $.trim($(domEl).val());
                });
                break;
            case "复选题":
                $(".checkbox_correct").each(function (index, domEl) {
                    data['choiceCorrectArray[' + index + ']'] = $(domEl).prop("checked"); // boolean类型
                });
                $(".checkbox_content").each(function (index, domEl) {
                    data['choiceContentArray[' + index + ']'] = $.trim($(domEl).val());
                });
                break;
        }

        // 4个外键id，少个user
        data['subject.subjectType.realName'] = $("#subject_type").val();    // 类型
        data['subject.subjectLevel.realName'] = $("#subject_level").val();  // 难度
        data['subject.department.name'] = $("#subject_department").val();   // 部门
        data['subject.topic.title'] = $("#subject_topic").val();            // 知识点

        data['subject.stem'] = $("#subject_stem").val();            // 题干
        data['subject.answer'] = $("#subject_answer").val();        // 标准答案
        data['subject.analysis'] = $("#subject_analysis").val();    // 答案解析

        console.log(data);

        data = $.param(data);

        $.post(
            "saveSubject.action", // url
            data, // 只能传一个
            function () { // 回调函数
                console.log("发送成功");
            }
        );
    }
</script>
</html>
