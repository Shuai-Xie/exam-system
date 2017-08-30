# JavaWeb前端企业级项目实践 - SSH框架

基于SSH的企业级项目，包含题库管理、试卷管理、考试管理 3 个部分。

## 一、题库管理

进入主页，默认加载题库管理页面。

![题库管理](http://upload-images.jianshu.io/upload_images/1877813-990fcb2b7bec4c7f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

题库管理包含功能：
- 查找题目（模糊查找，综合标签查找）
- 添加题目（单选、多选、简答）
- 审核题目（异步加载题目审核后的信息）
- 删除题目（异步加载删除题目后的题目列表）

### 1. 查找题目

输入题干关键字，模糊查找（Like操作）

![题干关键字模糊查找](http://upload-images.jianshu.io/upload_images/1877813-379cce4df09617e7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

选择题目标签，综合查找

![题目标签综合查找](http://upload-images.jianshu.io/upload_images/1877813-efb01d5eea3553d7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2. 添加题目

单选题，type = "radio"

![添加单选题](http://upload-images.jianshu.io/upload_images/1877813-66821e5fab6af1fb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

多选题，type = "checkbox"


![添加多选题](http://upload-images.jianshu.io/upload_images/1877813-061eedb0896c64c3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

简答题，textarea

![添加简答题](http://upload-images.jianshu.io/upload_images/1877813-6358e20f62939e74.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

题目已经添加到数据库，题目列表页按 ID 排序在最后面

![添加的试题](http://upload-images.jianshu.io/upload_images/1877813-afc73a3307748f60.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 3. 审核题目

点击审核后异步加载题目列表页面

![审核题目](http://upload-images.jianshu.io/upload_images/1877813-37b20bc8f04a71c5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 4. 删除题目

![删除题目](http://upload-images.jianshu.io/upload_images/1877813-0fd3c48fcbec7782.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 二、试卷管理

![试卷列表](http://upload-images.jianshu.io/upload_images/1877813-7c731034399ba333.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

题库管理包含功能：
- 添加试卷（手工组卷）
- 试卷预览（模板布局，难易度分布图）

### 1. 手工组卷

![手工组卷](http://upload-images.jianshu.io/upload_images/1877813-e9f66b79b6fc63ce.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

保存后跳转到试卷列表页

![保存跳转](http://upload-images.jianshu.io/upload_images/1877813-de0783dd5ec0dccb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 2. 试卷预览
拿到 Paper 下的题目，并按照题目类型分类显示
再按照难易度分值做出分布图

![试卷预览](http://upload-images.jianshu.io/upload_images/1877813-f5b181dc838712cd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 三、考试管理

![考试管理](http://upload-images.jianshu.io/upload_images/1877813-8afb2ef0888faa0f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

考试管理包含功能：
- 题型管理（外键约束，题型下有题目不可删）
- 难度管理（同上）
- 方向管理（同上）
- 知识管理（外键约束，知识点必须属于某个部门）

### 1. 题型管理

![添加题型](http://upload-images.jianshu.io/upload_images/1877813-5f1c01bbc5b45a1d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2. 知识管理

![添加知识](http://upload-images.jianshu.io/upload_images/1877813-9abe645525c5b829.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![批量修改](http://upload-images.jianshu.io/upload_images/1877813-0575701607d17447.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![批量删除](http://upload-images.jianshu.io/upload_images/1877813-69d9fabfec61e1a5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 四、彩蛋

### 1. 关于

![关于](http://upload-images.jianshu.io/upload_images/1877813-d58d134d20b1ef82.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2. 换肤
修改 body 的背景图，点击换肤可以选择自己喜欢的背景

![图书馆](http://upload-images.jianshu.io/upload_images/1877813-ef622039b382cfab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
