// 核心 js
$(function () {

    // Chrome不能加载，要清理cookies
    //实现左侧导航动画效果
    $(".baseUI>li>a").off("click");
    $(".baseUI>li>a").on("click", function () {
        $(".baseUI>li>ul").slideUp();
        $(this).next().slideDown(300);
    });

    //默认收起全部，展示第一个
    $(".baseUI>li>ul").slideUp();
    $(".baseUI>li>a").eq(0).trigger("click");

    $(".baseUI>li>ul>li").off();
    $(".baseUI>li>ul>li").on("click", function () {
        if (!$(this).hasClass("current")) {
            $(".baseUI>li>ul>li").removeClass("current");
            $(this).addClass("current");
        }
    });

    //模拟点击
    $(".baseUI>li>ul>li>a").eq(0).trigger("click");


    //换肤功能的实现
    $(".t2").click(function () {

    });

});

// 实现左侧导航动画效果
// li中的 题库 a超链接 点击展开下面ul
// 题库，试卷列表，考试管理 采用同样的类型
// $(".baseUI>li>a").off("click"); // 点击关闭
// $(".baseUI>li>a").on("click", function () { // 点击打开
//     $(".baseUI>li>ul").slideUp();
//     $(this).next().slideDown(300);
// });
//
// // 默认收起全部，展示第一个
// $(".baseUI>li>ul").slideUp(); // 所有li的ul列表都收上去 slideUp
// $(".baseUI>li>a").eq(0).trigger("click"); // eq(0) 触发 click 打开首个
// //
// // // li 二级菜单 设置跳转
// $(".baseUI>li>ul>li").off();
// $(".baseUI>li>ul>li").on("click", function () {
//     if (!$(this).hasClass("current")) {
//         $(".baseUI>li>ul>li").removeClass("current");
//         $(this).addClass("current");
//     }
// });
//
// // 模拟点击
// $(".baseUI>li>ul>li>a").eq(0).trigger("click"); // 默认点击第一个 a