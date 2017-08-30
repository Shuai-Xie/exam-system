<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>3-1题库-全部题库</title>
    <link rel="stylesheet" type="text/css" href="theme/1/css/common.css">
    <link rel="stylesheet" type="text/css" href="theme/1/css/style.css">
    <link rel="stylesheet" type="text/css" href="theme/1/css/EditingArea.css">
    <link rel="stylesheet" type="text/css" href="theme/1/css/table.css">
    <link rel="stylesheet" type="text/css" href="theme/1/css/icon.css">
    <link rel="stylesheet" type="text/css" href="theme/1/css/zy.css">

    <script src="frameworks/jquery-2.1.4/jquery.min.js"></script>
    <script src="frameworks/angular-1.4.0/angular.min.js"></script>
    <script src="frameworks/angular-1.4.0/angular-route.min.js"></script>

    <!--自定义js-->
    <script src="js/index.js"></script>
    <script src="js/subject.js"></script>
    <script src="js/paper.js"></script>
    <script src="js/subjectType.js"></script>
    <script src="js/subjectLevel.js"></script>
    <script src="js/department.js"></script>
    <script src="js/topic.js"></script>
</head>

<body>
<div class="main">
    <div id="top">
        <div class="top">
            <div class="tk_logo"></div>
            <%--<div class="t_sign">--%>
            <%--<span>你好，管理员</span><a href="#" class="t_exit">退出</a>--%>
            <%--</div>--%>
            <div class="t_icon">
                <ul>
                    <li><a class="t1" onclick="toHome()"><span>桌面</span></a></li>
                    <li><a class="t2" onclick="changeBg()"><span>换肤</span></a></li>
                    <li><a class="t3" onclick="toAbout()"><span>关于</span></a></li>
                </ul>
            </div>
        </div>
    </div>

    <div id="cont">
        <div class="centent">

            <div class="left c_view" id="my_left">
                <ul class="baseUI">

                    <%-- 项目管理 --%>
                    <li>
                        <a href="javascript:void(0);">
                            <em class="base_basicset"></em>
                            <span>题库</span></a>
                        <ul>
                            <li class="current">
                                <a id="subject_manage" onclick="subjectManage()">题目管理</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);">
                            <em class="base_userset"></em>
                            <span>试卷管理</span>
                        </a>
                        <ul>
                            <li><a id="paper_list" onclick="paperList()">试卷列表</a></li>
                            <li><a id="paper_add" onclick="makePaperByHand()">手工组卷</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);">
                            <em class="base_teachergroup"></em>
                            <span>考试管理</span>
                        </a>
                        <ul>
                            <li><a id="type_manage" onclick="subjectTypeManage()">题型管理</a></li>
                            <li><a id="level_manage" onclick="subjectLevelManage()">难度管理</a></li>
                            <li><a id="department_manage" onclick="departmentManage()">方向管理</a></li>
                            <li><a id="topic_manage" onclick="topicManage()">知识管理</a></li>
                        </ul>
                    </li>

                </ul>
            </div>

            <!--右侧页面区-->

            <div class="right"></div>

            <div class="clear"></div>
        </div>
    </div>
    <div id="foot"><a href="#">上海五五开 - 长沙五五开</a></div>
</div>

</body>

<script>

    function toHome() {
        console.log("to home...");
        $("#my_left").css("display", "block");
        $("#foot").css("display", "block");
        $(".right").load("subjectList.action");
    }

    function toAbout() {
        console.log("to about...");
        $("#my_left").css("display", "none");
        $("#foot").css("display", "none");
        $(".right").load("toAbout.action");
    }

    function subjectManage() {
        console.log("subject manage...");
        $(".right").load("subjectList.action");
    }

    function paperList() {
        console.log("paper list...");
        $(".right").load("paperList.action");
    }

    function makePaperByHand() {
        console.log("make paper by hand...");
        $(".right").load("makePaperByHand.action");
    }

    function subjectTypeManage() {
        console.log("subject type manage...");
        $(".right").load("subjectTypeManage.action");
    }

    function subjectLevelManage() {
        console.log("subject level manage...");
        $(".right").load("subjectLevelManage.action");
    }

    function departmentManage() {
        console.log("department manage...");
        $(".right").load("departmentManage.action");
    }

    function topicManage() {
        console.log("topic manage...");
        $(".right").load("topicManage.action");
    }

    var index = 0;

    function changeBg() {
        var imgArr = ["alipay.jpeg", "你的名字.jpg", "图书馆.jpeg", "魅族.jpeg"];
        var currentImage = imgArr[index % 4];
        document.getElementsByTagName("body")[0].style.backgroundImage = "url(theme/1/images/theme/" + currentImage + ")";
        index++;
    }

</script>

</html>

