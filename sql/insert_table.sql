-- 部门
INSERT INTO tbl_exam_department VALUES (1, 'WebUI');
INSERT INTO tbl_exam_department VALUES (2, 'JavaEE');
INSERT INTO tbl_exam_department VALUES (3, '大数据');
INSERT INTO tbl_exam_department VALUES (4, 'Android');
INSERT INTO tbl_exam_department VALUES (5, 'PHP');
INSERT INTO tbl_exam_department VALUES (6, 'IOS');

-- 用户
INSERT INTO TBL_EXAM_USER VALUES (1, '谢帅', '1234', '12345', 'male', 21, 1);
INSERT INTO TBL_EXAM_USER VALUES (2, '贞阁', '1234', '12345', 'male', 21, 2);
INSERT INTO TBL_EXAM_USER VALUES (3, '天一', '1234', '12345', 'male', 21, 3);

-- 知识点
INSERT INTO tbl_exam_topic VALUES (1, 'HTML', 1);
INSERT INTO tbl_exam_topic VALUES (2, 'JavaScript', 1);
INSERT INTO tbl_exam_topic VALUES (3, 'CSS', 1);
INSERT INTO tbl_exam_topic VALUES (4, 'jQuery', 1);
INSERT INTO tbl_exam_topic VALUES (5, 'Bootstrap', 1);
INSERT INTO tbl_exam_topic VALUES (6, 'CoreJava', 2);
INSERT INTO tbl_exam_topic VALUES (7, 'XML', 2);
INSERT INTO tbl_exam_topic VALUES (8, 'Servlet/JSP', 2);

-- 题目类型
INSERT INTO tbl_exam_subjecttype VALUES (1, 'radio', '单选题');
INSERT INTO tbl_exam_subjecttype VALUES (2, 'check', '复选题');
INSERT INTO tbl_exam_subjecttype VALUES (3, 'question', '简答题');

-- 题目难度
INSERT INTO tbl_exam_subjectlevel VALUES (1, 'easy', '简单');
INSERT INTO tbl_exam_subjectlevel VALUES (2, 'medium', '中等');
INSERT INTO tbl_exam_subjectlevel VALUES (3, 'difficult', '难');

-- 题目
INSERT INTO tbl_exam_subject VALUES
  (1, 'Java中的基本数据类型有哪些', '', '8种基本数据类型', 'byte,short,int,long,float,double,char,boolean', '未审核', 1, 2, 6, 3,
      1);
INSERT INTO tbl_exam_subject VALUES (2, '下面哪种数据类型占8个字节', '', '长整型', '长整型占8个字节', '未审核', 2, 2, 6, 3, 1);

-- 题目选项
INSERT INTO tbl_exam_choice VALUES (1, 'byte', 0, 2);
INSERT INTO tbl_exam_choice VALUES (2, 'short', 0, 2);
INSERT INTO tbl_exam_choice VALUES (3, 'int', 0, 2);
INSERT INTO tbl_exam_choice VALUES (4, 'long', 1, 2);
