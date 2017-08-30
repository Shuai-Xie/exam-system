<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>试卷预览</title>

    <script src="js/d3.js"></script>

    <style type="text/css">

        #paper-right {
            right: 0;
            position: fixed;
        }

        .score-right {
            position: absolute;
            right: 0;
        }

        .body-middle {
            width: 400px;
            left: 50%;
            margin-left: -200px;
            position: relative;
            float: left;
        }

        .subject-head {
            margin-top: 20px;
        }

        .subject .subject-title {
            line-height: 40px;
            font-size: 15px;
        }

        .choice-content {
            margin-top: -20px;
            margin-left: 18px;
        }

    </style>
</head>
<body>
<div class="editingarea">

    <div class="c_flex"><span class="c_flexible"></span></div>

    <div class="c_editview">

        <%--height: 100px = 69+31 --%>
        <div class="PaperPreview">
            <div class="PaperPreviewtop">
                <div style="text-align: center;font-weight: bold;font-size: 40px;line-height: inherit;">
                    ${paper.title} <%--line-height: inherit 继承父div的高度--%>
                </div>
            </div>
            <div class="PaperPreviewtitle">
                <a>考试说明：${paper.description}</a>&nbsp;&nbsp;
                <a>所属方向：${paper.department.name}</a>&nbsp;&nbsp;
                <a>考试时间：${paper.answerQuestionTime} 小时</a>&nbsp;&nbsp;
                <a>总分：${paper.totalPoints}</a>
            </div>
        </div>

        <%--题目列表--%>
        <div class="body-middle">
            <h2 class="subject-head">一、单选题 <span class="">(${radioPoints})</span></h2>

            <c:forEach items="${radioPSList}" var="ps" varStatus="s">
                <div class="subject">
                    <p class="subject-title">${s.count}. ${ps.subject.stem}
                        <span class="score-right">(${ps.score})</span>
                    </p><br>
                    <ul class="choice-content">

                        <c:set var="choiceArray" value="A,B,C,D,E,F,G"/>
                        <c:set var="separator" value=","/>
                        <c:set var="choiceLogo" value="${fn:split(choiceArray,separator)}"/>

                        <c:forEach items="${ps.subject.choices}" var="choice" varStatus="s">
                            <li>
                                    ${choiceLogo[s.index]}、${choice.content}  <!--题目选项-->
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>


            <h2 class="subject-head">二、复选题 <span class="">(${checkPoints})</span></h2>
            <c:forEach items="${checkPSList}" var="ps" varStatus="s">
                <div class="subject">
                    <p class="subject-title">${s.count}. ${ps.subject.stem}
                        <span class="score-right">(${ps.score})</span>
                    </p><br>
                    <ul class="choice-content">
                        <c:set var="choiceArray" value="A,B,C,D,E,F,G"/>
                        <c:set var="separator" value=","/>
                        <c:set var="choiceLogo" value="${fn:split(choiceArray,separator)}"/>

                        <c:forEach items="${ps.subject.choices}" var="choice" varStatus="s">
                            <li>
                                    ${choiceLogo[s.index]}、${choice.content}  <!--题目选项-->
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>


            <h2 class="subject-head">三、简答题 <span class="">(${questionPoints})</span></h2>
            <c:forEach items="${questionPSList}" var="ps" varStatus="s">
                <div class="subject">
                    <p class="subject-title">${s.count}. ${ps.subject.stem}
                        <span class="score-right">(${ps.score})</span>
                    </p><br>
                </div>
            </c:forEach>
        </div>

        <div id="paper-right">
            <a id="easy-points" style="visibility: hidden" name="${easyPoints}"></a>
            <a id="middle-points" style="visibility: hidden" name="${middlePoints}"></a>
            <a id="hard-points" style="visibility: hidden" name="${hardPoints}"></a>
        </div>

    </div>

</div>
</body>

<script>

    // 拿到分值设置数据集数组
    var easy = parseInt($("#easy-points").attr("name"));
    var middle = parseInt($("#middle-points").attr("name"));
    var hard = parseInt($("#hard-points").attr("name"));

    //    var totalPoints = parseFloat(easy + middle + hard);

    var charset = []; // 设置文字数组
    var dataset = []; // 数据集
    if (easy !== 0) {
        dataset.push(easy);
        charset.push("简单 " + easy + "%");
    }
    if (middle !== 0) {
        dataset.push(middle);
        charset.push("中等 " + middle + "%");
    }
    if (hard !== 0) {
        dataset.push(hard);
        charset.push("困难 " + hard + "%");
    }

    console.log(dataset);

    var baseLen = $(window).width(); // 浏览器宽度

    var width = 0.2 * baseLen;

    var radius = width / 2 - 10;

    //    var data = d3.range(10).map(Math.random).sort(d3.descending);//降序

    var color = d3.scale.category20();

    var arc = d3.svg.arc().outerRadius(radius);//定义了一个弧生辰器，外半径设置为radius

    var pie = d3.layout.pie();                //定义一个饼图布局

    var svg = d3.select('#paper-right').append('svg')
        .attr('width', width)
        .attr('height', width)
        .append('g')
        .attr('transform', "translate(" + width / 2 + "," + width / 2 + ")");//添加一个svg,设置宽高，在偏移到中心。

    var arcs = svg.selectAll('g.arc')
        .data(pie(dataset))            //绑定数据
        .enter().append('g')        //添加g
        .attr('class', "arc");       //定义一个arc类

    arcs.append('path')                 //添加路径
        .attr('fill', function (d, i) {     //根据i的下标给每一个元素添加不同的颜色。
            return color(i);
        })
        .transition()                   //设置动画
        .ease('elastic')                 //动画效果
        .duration(2000)                 //持续时间
        .attrTween('d', tweenPie)        //两个属性之间平滑的过渡。
        .transition()
        .ease("elastic")
        .delay(function (d, i) {
            return 1000 + i * 50
        }) // 设置了一个延迟时间，让每一个内半径不在同一个时间缩小。
        .duration(500)
        .attrTween('d', tweenDonut);


    var arc1 = d3.svg.arc().outerRadius(radius).innerRadius(0.5 * radius);

    arcs.append("text")
        .attr("transform", function (d) {
            return "translate(" + arc1.centroid(d) + ")";
        })
        .attr("text-anchor", "middle")
        .data(charset)
        .text(function (d) {
            return d
        });

    arcs.append("text")
        .attr("visibility", "hidden")
        .attr("transform", function (d) {
            return "translate(" + arc.centroid(d) + ")";
        })
        .attr("text-anchor", "middle")
        .text("难度分布图")
        .transition()
        .delay(1500)
        .attr("visibility", "visible")
        .duration(300);


    function tweenPie(b) {
        // 这里将每一个的弧的开始角度和结束角度都设置成了0
        // 然后向他们原始的角度(b)开始过渡，完成动画。
        b.innerRadius = 0;
        var i = d3.interpolate({startAngle: 0, endAngle: 0}, b);
        //下面的函数就是过渡函数，他是执行多次最终达到想要的状态。
        return function (t) {
            return arc(i(t));
        };
    }

    function tweenDonut(b) {
        //设置内半径不为0
        b.innerRadius = radius * .5;
        //然后内半径由0开始过渡
        var i = d3.interpolate({innerRadius: 0}, b);
        return function (t) {
            return arc(i(t));
        };
    }

    // todo 监听浏览器窗口宽度变化
    $(window).resize(function () {
        baseLen = $(window).width();
        console.log($(window).width());
    });

</script>

</html>