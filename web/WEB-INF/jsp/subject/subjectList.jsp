<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>题目管理 subjectList</title>

    <%-- 必须引入jQuery，因为超链接调用方法 --%>
    <script src="frameworks/jquery-2.1.4/jquery.min.js"></script>

</head>

<body>

<div class="editingarea">

    <div class="c_flex"><span class="c_flexible"></span></div>

    <div class="c_editview">

        <%-- 第1行的3个span --%>
        <div class="c_condition">
            <span>
                <select>
                    <option>题干</option>
                </select>
            </span>
            <span class="pl5 ">
                <input type="text" id="search_stem">
            </span>

            <span class="icon_add">
                <em class="icon_r">
                    <a id="add_subject" onclick="addSubject()">单个添加题目</a>
                </em>
            </span>

            <span class="icon_zdy">
                <em class="icon_r">
                    <a id="search_subject" onclick="searchSubject()">查找</a>
                </em>
            </span>

        </div>

        <%-- 第2行的表格 --%>
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tablea">

                <tr>
                    <td align="center" style="width: 50px;">题型</td>
                    <td align="left">
                        <div class="chose">
                            <a class="search_type active3">全部</a>
                            <c:forEach items="${typeList}" var="type">
                                <a class="search_type"> ${type}</a> &nbsp;
                            </c:forEach>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td align="center">难度</td>
                    <td align="left">
                        <div class="chose">
                            <a class="search_level active3">全部</a>
                            <c:forEach items="${levelList}" var="level">
                                <a class="search_level"> ${level}</a> &nbsp;
                            </c:forEach>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td align="center">方向</td>
                    <td align="left">
                        <div class="chose">
                            <a class="search_department active3">全部</a>
                            <c:forEach items="${departmentList}" var="department">
                                <a class="search_department"> ${department}</a> &nbsp;
                            </c:forEach>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td align="center">知识点</td>
                    <td align="left">
                        <div class="chose">
                            <a class="search_topic active3">全部</a>
                            <c:forEach items="${topicList}" var="topic">
                                <a class="search_topic"> ${topic}</a> &nbsp;
                            </c:forEach>
                        </div>
                    </td>
                </tr>
            </table>

        </div>


        <div class="Catalog">

            <div class="Catalog_right">

            </div>

            <div class="clear"></div>
        </div>

    </div>
</div>

</body>

<script>

    // 添加题目
    function addSubject() {
        console.log("add subject...");
        $(".right").load("addSubject.action");
    }


    // 查询标签
    var search_type = "全部";
    var search_level = "全部";
    var search_department = "全部";
    var search_topic = "全部";

    $(".search_type").click(function () {
        $(".search_type").removeClass("active3"); // 点击的时候，所有都先removeClass
        $(this).addClass("active3");
        search_type = $.trim($(this).text());
        console.log(search_type);
    });

    $(".search_level").click(function () {
        $(".search_level").removeClass("active3");
        $(this).addClass("active3");
        search_level = $.trim($(this).text());
        console.log(search_level);
    });

    $(".search_department").click(function () {
        $(".search_department").removeClass("active3");
        $(this).addClass("active3");
        search_department = $.trim($(this).text());
        console.log(search_department);
    });

    $(".search_topic").click(function () {
        $(".search_topic").removeClass("active3");
        $(this).addClass("active3");
        search_topic = $.trim($(this).text());
        console.log(search_topic);
    });

    // 查询题目
    function searchSubject() {

        console.log($("#search_stem").val());

        // 获得查询标签
        var data = {};
        data['searchType'] = search_type;
        data['searchLevel'] = search_level;
        data['searchDepartment'] = search_department;
        data['searchTopic'] = search_topic;

        if ($("#search_stem").val() != "") {
            data['searchStem'] = $("#search_stem").val();
        }

        $.post(
            "searchSubject.action", // url
            data, // 只能传一个
            function () { // 回调函数
                console.log("查找成功");
                $(".Catalog_right").load("subjectDetail.action");
            }
        );

    }

</script>

</html>
