/*
Navicat MySQL Data Transfer

Source Server         : cms
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : cmsystem

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-06 16:11:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_file
-- ----------------------------
DROP TABLE IF EXISTS `course_file`;
CREATE TABLE `course_file` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `cid` varchar(100) NOT NULL COMMENT '课程id，外键',
  `cname` varchar(100) NOT NULL COMMENT '课程名称',
  `status` varchar(100) NOT NULL COMMENT '课件状态，是否有课件存储',
  `cfile_url` varchar(255) DEFAULT NULL COMMENT '课件存储路径',
  `tid` varchar(100) NOT NULL COMMENT '教师id',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `course_file_UN` (`cfile_url`),
  KEY `course_file_teach_course_relsp_FK` (`tid`,`cid`),
  CONSTRAINT `course_file_teach_course_relsp_FK` FOREIGN KEY (`tid`, `cid`) REFERENCES `teach_course_relsp` (`tid`, `cid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='课件存储';

-- ----------------------------
-- Records of course_file
-- ----------------------------
INSERT INTO `course_file` VALUES ('1', '040401', '高等数学', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('2', '040402', '大学英语', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('3', '040403', '线性代数', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('4', '040404', '计算机科学导论', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('5', '040405', '面向过程程序设计', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('6', '040407', '概率论与数理统计', '缺失', null, 't131000');
INSERT INTO `course_file` VALUES ('7', '040405', '面向过程程序设计', '缺失', null, 't131001');
INSERT INTO `course_file` VALUES ('8', '040406', '离散数学', '缺失', null, 't131001');
INSERT INTO `course_file` VALUES ('9', '040407', '概率论与数理统计', '缺失', null, 't131001');
INSERT INTO `course_file` VALUES ('10', '040408', '中国近代史', '缺失', null, 't131001');
INSERT INTO `course_file` VALUES ('11', '040402', '大学英语', '缺失', null, 't131002');
INSERT INTO `course_file` VALUES ('12', '040411', '软件工程', '缺失', null, 't131002');
INSERT INTO `course_file` VALUES ('13', '040412', '计算机网络', '缺失', null, 't131003');
INSERT INTO `course_file` VALUES ('14', '040413', '数字媒体技术及实践', '缺失', null, 't131003');
INSERT INTO `course_file` VALUES ('15', '040405', '面向过程程序设计', '缺失', null, 't131004');
INSERT INTO `course_file` VALUES ('16', '040408', '中国近代史', '缺失', null, 't131004');
INSERT INTO `course_file` VALUES ('17', '040407', '概率论与数理统计', '缺失', null, 't131005');
INSERT INTO `course_file` VALUES ('18', '040404', '计算机科学导论', '缺失', null, 't131005');
INSERT INTO `course_file` VALUES ('19', '040403', '线性代数', '缺失', null, 't131005');
INSERT INTO `course_file` VALUES ('20', '040401', '高等数学', '缺失', null, 't131006');
INSERT INTO `course_file` VALUES ('21', '040404', '计算机科学导论', '缺失', null, 't131006');
INSERT INTO `course_file` VALUES ('22', '040405', '面向过程程序设计', '缺失', null, 't131006');
INSERT INTO `course_file` VALUES ('23', '040406', '离散数学', '缺失', null, 't131007');
INSERT INTO `course_file` VALUES ('24', '040407', '概率论与数理统计', '缺失', null, 't131007');
INSERT INTO `course_file` VALUES ('25', '040413', '数字媒体技术及实践', '缺失', null, 't131008');
INSERT INTO `course_file` VALUES ('26', '040412', '计算机网络', '缺失', null, 't131008');
INSERT INTO `course_file` VALUES ('27', '040409', '数据与算法基础', '缺失', null, 't131008');
INSERT INTO `course_file` VALUES ('28', '040410', '操作系统', '缺失', null, 't131008');
INSERT INTO `course_file` VALUES ('29', '040410', '操作系统', '缺失', null, 't131009');
INSERT INTO `course_file` VALUES ('30', '040406', '离散数学', '缺失', null, 't131009');
INSERT INTO `course_file` VALUES ('31', '040412', '计算机网络', '缺失', null, 't131009');

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程序号',
  `id` varchar(100) NOT NULL COMMENT '课程号',
  `name` varchar(100) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `course_UN` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='每一门课程信息';

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('1', '040401', '高等数学');
INSERT INTO `course_info` VALUES ('2', '040402', '大学英语');
INSERT INTO `course_info` VALUES ('3', '040403', '线性代数');
INSERT INTO `course_info` VALUES ('4', '040404', '计算机科学导论');
INSERT INTO `course_info` VALUES ('5', '040405', '面向过程程序设计');
INSERT INTO `course_info` VALUES ('6', '040406', '离散数学');
INSERT INTO `course_info` VALUES ('7', '040407', '概率论与数理统计');
INSERT INTO `course_info` VALUES ('8', '040408', '中国近代史');
INSERT INTO `course_info` VALUES ('9', '040409', '数据与算法基础');
INSERT INTO `course_info` VALUES ('10', '040410', '操作系统');
INSERT INTO `course_info` VALUES ('11', '040411', '软件工程');
INSERT INTO `course_info` VALUES ('12', '040412', '计算机网络');
INSERT INTO `course_info` VALUES ('13', '040413', '数字媒体技术及实践');

-- ----------------------------
-- Table structure for exam_info
-- ----------------------------
DROP TABLE IF EXISTS `exam_info`;
CREATE TABLE `exam_info` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '试卷名称',
  `status` varchar(100) NOT NULL COMMENT '批改状态',
  `time` date DEFAULT NULL COMMENT '考试时间',
  `cid` varchar(100) NOT NULL COMMENT '课程编号外键',
  `tid` varchar(100) NOT NULL COMMENT '教师编号外键',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `exam_info_UN` (`exam_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='考试卷子信息，由单选题和简答题组成';

-- ----------------------------
-- Records of exam_info
-- ----------------------------
INSERT INTO `exam_info` VALUES ('1', '第一次考试', '已批改', '2018-12-13', '040401', 't131000');
INSERT INTO `exam_info` VALUES ('2', '第二次考试', '已批改', '2018-12-13', '040404', 't131006');
INSERT INTO `exam_info` VALUES ('10', '第三次考试', '已批改', '2019-01-06', '040402', 't131000');
INSERT INTO `exam_info` VALUES ('11', '第四次', '未批改', '2019-01-09', '040402', 't131000');

-- ----------------------------
-- Table structure for exam_record
-- ----------------------------
DROP TABLE IF EXISTS `exam_record`;
CREATE TABLE `exam_record` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '考试名称',
  `goal` int(11) DEFAULT NULL COMMENT '得分',
  `time` date DEFAULT NULL COMMENT '考试日期',
  `sid` varchar(100) NOT NULL COMMENT '学生学号，外键',
  `cid` varchar(100) NOT NULL COMMENT '课程id，外键',
  `cname` varchar(100) NOT NULL COMMENT '课程名称，外键',
  `tid` varchar(100) NOT NULL COMMENT '教师id，外键',
  `tname` varchar(100) NOT NULL COMMENT '教师名字，外键',
  PRIMARY KEY (`seq_number`),
  KEY `exam_record_stu_course_relsp_FK` (`sid`,`cid`),
  KEY `exam_record_teacher_FK` (`tid`),
  CONSTRAINT `exam_record_stu_course_relsp_FK` FOREIGN KEY (`sid`, `cid`) REFERENCES `stu_course_relsp` (`sid`, `cid`),
  CONSTRAINT `exam_record_teacher_FK` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用于记录学生考试记录及成绩的表单';

-- ----------------------------
-- Records of exam_record
-- ----------------------------
INSERT INTO `exam_record` VALUES ('1', '第一次考试', '70', '2018-12-13', '2015214000', '040401', '高等数学', 't131000', '张三');
INSERT INTO `exam_record` VALUES ('2', '第二次考试', '70', '2018-12-13', '2015214000', '040404', '计算机科学导论', 't131006', '谢鹰');
INSERT INTO `exam_record` VALUES ('9', '第三次考试', '103', '2019-01-06', '2015214000', '040402', '大学英语', 't131000', '张三');
INSERT INTO `exam_record` VALUES ('10', '第三次考试', '130', '2019-01-09', '2015214003', '040402', '大学英语', 't131000', '张三');
INSERT INTO `exam_record` VALUES ('11', '第四次', null, '2019-01-09', '2015214000', '040402', '大学英语', 't131000', '张三');
INSERT INTO `exam_record` VALUES ('12', '第四次', null, null, '2015214003', '040402', '大学英语', 't131000', '张三');

-- ----------------------------
-- Table structure for exam_short_answer
-- ----------------------------
DROP TABLE IF EXISTS `exam_short_answer`;
CREATE TABLE `exam_short_answer` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '试卷名称',
  `title` varchar(255) NOT NULL COMMENT '简答题题目',
  `answer` varchar(255) NOT NULL COMMENT '简答题答案',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `exam_short_answer_UN` (`exam_name`,`title`),
  KEY `exam_short_answer_short_answer_FK` (`title`),
  CONSTRAINT `exam_short_answer_exam_info_FK` FOREIGN KEY (`exam_name`) REFERENCES `exam_info` (`exam_name`),
  CONSTRAINT `exam_short_answer_short_answer_FK` FOREIGN KEY (`title`) REFERENCES `short_answer` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='考试卷子简答题';

-- ----------------------------
-- Records of exam_short_answer
-- ----------------------------
INSERT INTO `exam_short_answer` VALUES ('1', '第一次考试', '构造方法和普通的成员方法有什么区别？', '构造方法是类的一个特殊成员，它会在类实例化对象时被自动调用。而普通方法只有在使用的时候才会被调用。在定义构造方法时要求方法名与类名相同、在方法名的前面没有返回值类型的声明、在方法中不能使用return语句返回一个值\n\n');
INSERT INTO `exam_short_answer` VALUES ('2', '第一次考试', '单例设计模式具备哪些特点？', '单例模式可以保证在整个程序运行期间针对该类只存在一个实例对象。');
INSERT INTO `exam_short_answer` VALUES ('4', '第二次考试', '构造方法和普通的成员方法有什么区别？', '构造方法是类的一个特殊成员，它会在类实例化对象时被自动调用。而普通方法只有在使用的时候才会被调用。在定义构造方法时要求方法名与类名相同、在方法名的前面没有返回值类型的声明、在方法中不能使用return语句返回一个值\n\n');
INSERT INTO `exam_short_answer` VALUES ('5', '第二次考试', '单例设计模式具备哪些特点？', '单例模式可以保证在整个程序运行期间针对该类只存在一个实例对象。');
INSERT INTO `exam_short_answer` VALUES ('13', '第一次考试', '什么是方法重载？', '方法重载指的是在一个类中可以声明多个同名的方法，而方法中参数的个数或者数据类型不一致。调用这些同名的方法时，JVM会根据实际参数的不同绑定到不同的方法。');
INSERT INTO `exam_short_answer` VALUES ('14', '第二次考试', '什么是方法重载？', '方法重载指的是在一个类中可以声明多个同名的方法，而方法中参数的个数或者数据类型不一致。调用这些同名的方法时，JVM会根据实际参数的不同绑定到不同的方法。');
INSERT INTO `exam_short_answer` VALUES ('15', '第三次考试', '构造方法和普通的成员方法有什么区别？', '构造方法是类的一个特殊成员，它会在类实例化对象时被自动调用。而普通方法只有在使用的时候才会被调用。在定义构造方法时要求方法名与类名相同、在方法名的前面没有返回值类型的声明、在方法中不能使用return语句返回一个值\n\n');
INSERT INTO `exam_short_answer` VALUES ('16', '第三次考试', '单例设计模式具备哪些特点？', '单例模式可以保证在整个程序运行期间针对该类只存在一个实例对象。');
INSERT INTO `exam_short_answer` VALUES ('17', '第三次考试', '简述Java的特点。', '面向对象、跨平台性、健壮性、安全性、可移植性、多线程性、动态性等。');
INSERT INTO `exam_short_answer` VALUES ('18', '第四次', '构造方法和普通的成员方法有什么区别？', '构造方法是类的一个特殊成员，它会在类实例化对象时被自动调用。而普通方法只有在使用的时候才会被调用。在定义构造方法时要求方法名与类名相同、在方法名的前面没有返回值类型的声明、在方法中不能使用return语句返回一个值\n\n');
INSERT INTO `exam_short_answer` VALUES ('19', '第四次', '单例设计模式具备哪些特点？', '单例模式可以保证在整个程序运行期间针对该类只存在一个实例对象。');
INSERT INTO `exam_short_answer` VALUES ('20', '第四次', '简述Java的特点。', '面向对象、跨平台性、健壮性、安全性、可移植性、多线程性、动态性等。');

-- ----------------------------
-- Table structure for exam_single_choice
-- ----------------------------
DROP TABLE IF EXISTS `exam_single_choice`;
CREATE TABLE `exam_single_choice` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '试卷名称',
  `title` varchar(255) NOT NULL COMMENT '单选题题目',
  `a_option` varchar(255) NOT NULL COMMENT 'A选项',
  `b_option` varchar(255) NOT NULL COMMENT 'B选项',
  `c_option` varchar(255) NOT NULL COMMENT 'C选项',
  `d_option` varchar(255) NOT NULL COMMENT 'D选项',
  `right_choice` char(1) NOT NULL COMMENT '正确答案',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `exam_single_choice_UN` (`exam_name`,`title`),
  KEY `exam_single_choice_single_choice_FK` (`title`),
  CONSTRAINT `exam_single_choice_exam_info_FK` FOREIGN KEY (`exam_name`) REFERENCES `exam_info` (`exam_name`),
  CONSTRAINT `exam_single_choice_single_choice_FK` FOREIGN KEY (`title`) REFERENCES `single_choice` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='用于存储挑选出来进行考试的单选题';

-- ----------------------------
-- Records of exam_single_choice
-- ----------------------------
INSERT INTO `exam_single_choice` VALUES ('1', '第一次考试', '下列哪种说法是正确的', '实例方法可直接调用超类的实例方法', '实例方法可直接调用超类的类方法', ' 实例方法可直接调用其他类的实例方法', '实例方法可直接调用本类的类方法', 'D');
INSERT INTO `exam_single_choice` VALUES ('2', '第一次考试', '用于调用存储过程的对象是？', 'ResultSet', ' DriverManager', ' CallableStatemet', ' PreparedStatement', 'C');
INSERT INTO `exam_single_choice` VALUES ('3', '第一次考试', ' 在Servlet处理请求的方式为？', '以进程的方式', '以程序的方式', '以线程的方式', '以响应的方式', 'C');
INSERT INTO `exam_single_choice` VALUES ('4', '第一次考试', '在Servlet的生命周期中，容器只调用一次的方法是?', 'service', ' getServletConfig', 'init', 'destroy', 'C');
INSERT INTO `exam_single_choice` VALUES ('5', '第一次考试', ' 下面关于垃圾收集的说法正确的是？', '一旦一个对象成为垃圾，就立刻被收集掉', ' 对象空间被收集掉之后，会执行该对象的finalize方法', 'finalize方法和C++的析构函数是完全一回事情', '一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此', 'D');
INSERT INTO `exam_single_choice` VALUES ('6', '第一次考试', 'Which method is used by a Servlet to place its session ID in a URL that is written to the servlet’s response output stream?', 'The encodeURL method of the HttpServletRequest interface', 'The encodeURL method of the HttpServletResponse interface.', 'The rewriteURL method of the HttpServletRequest interface', 'The rewriteURL method of the HttpServletResponse interface', 'B');
INSERT INTO `exam_single_choice` VALUES ('7', '第一次考试', '在JavaScript中如何验证一个数据是否是数字？', '如果用Integer.parseInt(value)有误就不是数字', ' int I = value 若报错就不是数字', '没有方法验证', '利用isNaN(value) 返回的boolean进行判断', 'D');
INSERT INTO `exam_single_choice` VALUES ('8', '第一次考试', 'JavaScript中判断服务器已经响应的标志是？', 'xmlHttp.readyState = =4', 'xmlHttp.readyState = =3', 'xmlHttp.readyState = =2', 'xmlHttp.readyState = =1', 'A');
INSERT INTO `exam_single_choice` VALUES ('9', '第一次考试', '下面哪项不属于SQL语句的子类', '数据定义语言(DDL)', '数据查询语言(DQL)', '事务控制语言(TCL)', ' 数据插入语言 (DIL)', 'D');
INSERT INTO `exam_single_choice` VALUES ('10', '第二次考试', '下列哪种说法是正确的', '实例方法可直接调用超类的实例方法', '实例方法可直接调用超类的类方法', ' 实例方法可直接调用其他类的实例方法', '实例方法可直接调用本类的类方法', 'D');
INSERT INTO `exam_single_choice` VALUES ('11', '第二次考试', '用于调用存储过程的对象是？', 'ResultSet', ' DriverManager', ' CallableStatemet', ' PreparedStatement', 'C');
INSERT INTO `exam_single_choice` VALUES ('12', '第二次考试', ' 在Servlet处理请求的方式为？', '以进程的方式', '以程序的方式', '以线程的方式', '以响应的方式', 'C');
INSERT INTO `exam_single_choice` VALUES ('13', '第二次考试', '在Servlet的生命周期中，容器只调用一次的方法是?', 'service', ' getServletConfig', 'init', 'destroy', 'C');
INSERT INTO `exam_single_choice` VALUES ('14', '第二次考试', ' 下面关于垃圾收集的说法正确的是？', '一旦一个对象成为垃圾，就立刻被收集掉', ' 对象空间被收集掉之后，会执行该对象的finalize方法', 'finalize方法和C++的析构函数是完全一回事情', '一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此', 'D');
INSERT INTO `exam_single_choice` VALUES ('15', '第二次考试', 'Which method is used by a Servlet to place its session ID in a URL that is written to the servlet’s response output stream?', 'The encodeURL method of the HttpServletRequest interface', 'The encodeURL method of the HttpServletResponse interface.', 'The rewriteURL method of the HttpServletRequest interface', 'The rewriteURL method of the HttpServletResponse interface', 'B');
INSERT INTO `exam_single_choice` VALUES ('16', '第二次考试', '在JavaScript中如何验证一个数据是否是数字？', '如果用Integer.parseInt(value)有误就不是数字', ' int I = value 若报错就不是数字', '没有方法验证', '利用isNaN(value) 返回的boolean进行判断', 'D');
INSERT INTO `exam_single_choice` VALUES ('17', '第二次考试', 'JavaScript中判断服务器已经响应的标志是？', 'xmlHttp.readyState = =4', 'xmlHttp.readyState = =3', 'xmlHttp.readyState = =2', 'xmlHttp.readyState = =1', 'A');
INSERT INTO `exam_single_choice` VALUES ('18', '第二次考试', '下面哪项不属于SQL语句的子类', '数据定义语言(DDL)', '数据查询语言(DQL)', '事务控制语言(TCL)', ' 数据插入语言 (DIL)', 'D');
INSERT INTO `exam_single_choice` VALUES ('46', '第三次考试', '下列哪种说法是正确的', '实例方法可直接调用超类的实例方法', '实例方法可直接调用超类的类方法', ' 实例方法可直接调用其他类的实例方法', '实例方法可直接调用本类的类方法', 'D');
INSERT INTO `exam_single_choice` VALUES ('47', '第三次考试', '用于调用存储过程的对象是？', 'ResultSet', ' DriverManager', ' CallableStatemet', ' PreparedStatement', 'C');
INSERT INTO `exam_single_choice` VALUES ('48', '第三次考试', ' 在Servlet处理请求的方式为？', '以进程的方式', '以程序的方式', '以线程的方式', '以响应的方式', 'C');
INSERT INTO `exam_single_choice` VALUES ('49', '第三次考试', '在Servlet的生命周期中，容器只调用一次的方法是?', 'service', ' getServletConfig', 'init', 'destroy', 'C');
INSERT INTO `exam_single_choice` VALUES ('50', '第三次考试', ' 下面关于垃圾收集的说法正确的是？', '一旦一个对象成为垃圾，就立刻被收集掉', ' 对象空间被收集掉之后，会执行该对象的finalize方法', 'finalize方法和C++的析构函数是完全一回事情', '一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此', 'D');
INSERT INTO `exam_single_choice` VALUES ('51', '第三次考试', 'Which method is used by a Servlet to place its session ID in a URL that is written to the servlet’s response output stream?', 'The encodeURL method of the HttpServletRequest interface', 'The encodeURL method of the HttpServletResponse interface.', 'The rewriteURL method of the HttpServletRequest interface', 'The rewriteURL method of the HttpServletResponse interface', 'B');
INSERT INTO `exam_single_choice` VALUES ('52', '第三次考试', '在JavaScript中如何验证一个数据是否是数字？', '如果用Integer.parseInt(value)有误就不是数字', ' int I = value 若报错就不是数字', '没有方法验证', '利用isNaN(value) 返回的boolean进行判断', 'D');
INSERT INTO `exam_single_choice` VALUES ('53', '第三次考试', 'JavaScript中判断服务器已经响应的标志是？', 'xmlHttp.readyState = =4', 'xmlHttp.readyState = =3', 'xmlHttp.readyState = =2', 'xmlHttp.readyState = =1', 'A');
INSERT INTO `exam_single_choice` VALUES ('54', '第三次考试', '下面哪项不属于SQL语句的子类', '数据定义语言(DDL)', '数据查询语言(DQL)', '事务控制语言(TCL)', ' 数据插入语言 (DIL)', 'D');
INSERT INTO `exam_single_choice` VALUES ('55', '第四次', '下列哪种说法是正确的', '实例方法可直接调用超类的实例方法', '实例方法可直接调用超类的类方法', ' 实例方法可直接调用其他类的实例方法', '实例方法可直接调用本类的类方法', 'D');
INSERT INTO `exam_single_choice` VALUES ('56', '第四次', '用于调用存储过程的对象是？', 'ResultSet', ' DriverManager', ' CallableStatemet', ' PreparedStatement', 'C');
INSERT INTO `exam_single_choice` VALUES ('57', '第四次', ' 在Servlet处理请求的方式为？', '以进程的方式', '以程序的方式', '以线程的方式', '以响应的方式', 'C');
INSERT INTO `exam_single_choice` VALUES ('58', '第四次', '在Servlet的生命周期中，容器只调用一次的方法是?', 'service', ' getServletConfig', 'init', 'destroy', 'C');
INSERT INTO `exam_single_choice` VALUES ('59', '第四次', ' 下面关于垃圾收集的说法正确的是？', '一旦一个对象成为垃圾，就立刻被收集掉', ' 对象空间被收集掉之后，会执行该对象的finalize方法', 'finalize方法和C++的析构函数是完全一回事情', '一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此', 'D');
INSERT INTO `exam_single_choice` VALUES ('60', '第四次', 'Which method is used by a Servlet to place its session ID in a URL that is written to the servlet’s response output stream?', 'The encodeURL method of the HttpServletRequest interface', 'The encodeURL method of the HttpServletResponse interface.', 'The rewriteURL method of the HttpServletRequest interface', 'The rewriteURL method of the HttpServletResponse interface', 'B');
INSERT INTO `exam_single_choice` VALUES ('61', '第四次', '在JavaScript中如何验证一个数据是否是数字？', '如果用Integer.parseInt(value)有误就不是数字', ' int I = value 若报错就不是数字', '没有方法验证', '利用isNaN(value) 返回的boolean进行判断', 'D');
INSERT INTO `exam_single_choice` VALUES ('62', '第四次', 'JavaScript中判断服务器已经响应的标志是？', 'xmlHttp.readyState = =4', 'xmlHttp.readyState = =3', 'xmlHttp.readyState = =2', 'xmlHttp.readyState = =1', 'A');
INSERT INTO `exam_single_choice` VALUES ('63', '第四次', '关于正则表达式声明6位数字的邮编，以下代码正确的是？', ' var  reg = /\\d6/', ' var  reg = \\d{6}\\', ' var  reg = /\\d{6}/', ' var  reg = new RegExp(\"\\d{6}\")', 'C');

-- ----------------------------
-- Table structure for short_answer
-- ----------------------------
DROP TABLE IF EXISTS `short_answer`;
CREATE TABLE `short_answer` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `title` varchar(255) NOT NULL COMMENT '简答题题目',
  `answer` varchar(255) NOT NULL COMMENT '简答题答案',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `short_answer_UN` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='简答题题库表单';

-- ----------------------------
-- Records of short_answer
-- ----------------------------
INSERT INTO `short_answer` VALUES ('1', '构造方法和普通的成员方法有什么区别？', '构造方法是类的一个特殊成员，它会在类实例化对象时被自动调用。而普通方法只有在使用的时候才会被调用。在定义构造方法时要求方法名与类名相同、在方法名的前面没有返回值类型的声明、在方法中不能使用return语句返回一个值\n\n');
INSERT INTO `short_answer` VALUES ('2', '单例设计模式具备哪些特点？', '单例模式可以保证在整个程序运行期间针对该类只存在一个实例对象。');
INSERT INTO `short_answer` VALUES ('3', '简述Java的特点。', '面向对象、跨平台性、健壮性、安全性、可移植性、多线程性、动态性等。');
INSERT INTO `short_answer` VALUES ('4', '什么是方法重载？', '方法重载指的是在一个类中可以声明多个同名的方法，而方法中参数的个数或者数据类型不一致。调用这些同名的方法时，JVM会根据实际参数的不同绑定到不同的方法。');
INSERT INTO `short_answer` VALUES ('5', '什么是多态？', '多态意味着一个对象有着多种形态，可以在特定的情况下，表现不同的状态，从而对应着不同的属性和方法。简单的说，多态就是使用父类类型的变量引用子类对象，根据被引用子类对象的特性，程序会得到不同的运行效果。');
INSERT INTO `short_answer` VALUES ('6', '抽象类和接口的区别？', '在Java中，使用abstract关键字修饰的类称之为抽象类。抽象类是不能被实例化的，通常需要写一个子类来继承抽象类，同时实例化子类来获得该类的对象。抽象类通常用于表示一种抽象的概念。接口可以说是一种特殊的抽象类，接口中只能定义常量和抽象方法。由于接口的特殊性，在定义时需要使用interface关键字。');
INSERT INTO `short_answer` VALUES ('7', 'String和StringBuffer有什么区别？', 'String类是不可变类，即字符串值一旦初始化后就不可能改变。StringBuffer是可变字符串类，类似String的缓冲区，可以修改字符串的值。\n\n');
INSERT INTO `short_answer` VALUES ('8', '什么是集合，请列举集合中常用的类和接口？', '为了使程序能方便的存储和操作数目不固定的一组数据，JDK提供了一套类库，这些类都位于java.util包中，统称为集合。集合框架中包含3个接口，分别是List、Set、Map。');
INSERT INTO `short_answer` VALUES ('9', '集合中的List、Set、Map有什么区别？', 'List的特点是元素有序、元素可重复。List接口的主要实现类有ArrayList和LinkedList。Set的特点是元素无序、元素不可重复。Set接口的主要实现类有HashSet和TreeSet。Map的特点是存储的元素是键(Key)、值(Value)映射关系，元素都是成对出现的。Map接口的主要实现类有HashMap和TreeMap。');
INSERT INTO `short_answer` VALUES ('10', '请说说Collection和Collections的有什么区别？', 'Collection是一个单例集合接口。它提供了对集合对象进行基本操作的通用方法。Collections是一个工具类。它包含各种有关集合操作的方法。');
INSERT INTO `short_answer` VALUES ('11', '简述流的概念。', 'Java程序通过流来完成输入和输出，流是输入或输出信息的抽象。流通过Java的输入/输出系统与外设连接进行数据通信。流是抽象的对象，具体实现代码在java.io包中。');
INSERT INTO `short_answer` VALUES ('12', 'Java流被分为字节流、字符流两大流类，两者有什么区别？', '字节流的两个基类是InputStream和OutputStream，字符流的两个基类是Reader和Writer，它们都是Object类的直接子类，字节流是处理以8位字节为基本单位的字节流类；Reader和Writer类是专门处理16位字节的字符流类。\n\n');
INSERT INTO `short_answer` VALUES ('13', '网络通信协议是什么？', '在Internet中传输数据都需要遵守一定的规则，这种规则通常被称作网络通信协议。网络通信协议对数据传输格式、传输速率、传输步骤等作了统一规定，通信双方必须共同遵守这个规定才能完成数据的交互。到目前为止，网络通信协议已经有很多种，其中TCP/UDP协议在世界范围内应用最为广泛。');
INSERT INTO `short_answer` VALUES ('14', '什么是面向对象编程', '面向对象编程就是把具有共性的事务抽象成属性和方法来进行代码编程');

-- ----------------------------
-- Table structure for single_choice
-- ----------------------------
DROP TABLE IF EXISTS `single_choice`;
CREATE TABLE `single_choice` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `title` varchar(255) NOT NULL COMMENT '单选题目',
  `a_option` varchar(255) NOT NULL COMMENT 'A选项',
  `b_option` varchar(255) NOT NULL COMMENT 'B选项',
  `c_option` varchar(255) NOT NULL COMMENT 'C选项',
  `d_option` varchar(255) NOT NULL COMMENT 'D选项',
  `right_choice` char(1) NOT NULL COMMENT '正确答案',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `single_choice_UN` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='单选题题库';

-- ----------------------------
-- Records of single_choice
-- ----------------------------
INSERT INTO `single_choice` VALUES ('1', '下列哪种说法是正确的', '实例方法可直接调用超类的实例方法', '实例方法可直接调用超类的类方法', ' 实例方法可直接调用其他类的实例方法', '实例方法可直接调用本类的类方法', 'D');
INSERT INTO `single_choice` VALUES ('2', '用于调用存储过程的对象是？', 'ResultSet', ' DriverManager', ' CallableStatemet', ' PreparedStatement', 'C');
INSERT INTO `single_choice` VALUES ('3', ' 在Servlet处理请求的方式为？', '以进程的方式', '以程序的方式', '以线程的方式', '以响应的方式', 'C');
INSERT INTO `single_choice` VALUES ('4', '在Servlet的生命周期中，容器只调用一次的方法是?', 'service', ' getServletConfig', 'init', 'destroy', 'C');
INSERT INTO `single_choice` VALUES ('5', ' 下面关于垃圾收集的说法正确的是？', '一旦一个对象成为垃圾，就立刻被收集掉', ' 对象空间被收集掉之后，会执行该对象的finalize方法', 'finalize方法和C++的析构函数是完全一回事情', '一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此', 'D');
INSERT INTO `single_choice` VALUES ('6', 'Which method is used by a Servlet to place its session ID in a URL that is written to the servlet’s response output stream?', 'The encodeURL method of the HttpServletRequest interface', 'The encodeURL method of the HttpServletResponse interface.', 'The rewriteURL method of the HttpServletRequest interface', 'The rewriteURL method of the HttpServletResponse interface', 'B');
INSERT INTO `single_choice` VALUES ('7', '在JavaScript中如何验证一个数据是否是数字？', '如果用Integer.parseInt(value)有误就不是数字', ' int I = value 若报错就不是数字', '没有方法验证', '利用isNaN(value) 返回的boolean进行判断', 'D');
INSERT INTO `single_choice` VALUES ('8', 'JavaScript中判断服务器已经响应的标志是？', 'xmlHttp.readyState = =4', 'xmlHttp.readyState = =3', 'xmlHttp.readyState = =2', 'xmlHttp.readyState = =1', 'A');
INSERT INTO `single_choice` VALUES ('9', '下面哪项不属于SQL语句的子类', '数据定义语言(DDL)', '数据查询语言(DQL)', '事务控制语言(TCL)', ' 数据插入语言 (DIL)', 'D');
INSERT INTO `single_choice` VALUES ('10', 'GRANT update ON inventory TO joe WITH GRANT OPTION;此语句有什么作用', '一个系统权限被授予用户JOE', ' 一个对象权限被授予用户JOE', '用户JOE被授予在这个对象上的所有权限', '一个系统权限和一个对象权限被授予用户JOE', 'B');
INSERT INTO `single_choice` VALUES ('11', '关于正则表达式声明6位数字的邮编，以下代码正确的是？', ' var  reg = /\\d6/', ' var  reg = \\d{6}\\', ' var  reg = /\\d{6}/', ' var  reg = new RegExp(\"\\d{6}\")', 'C');
INSERT INTO `single_choice` VALUES ('12', '在数据库系统中，提供数据与应用程序间物理独立性的是？', '外模式/模式映像', '模式/内模式映像', '外模式/内模式映像', '子模式/模式映像', 'B');
INSERT INTO `single_choice` VALUES ('13', '下列关于视图的说法中错误的是', '视图是从一个或多个基本表导出的表，它是虚表', '视图可以被用来对无权用户屏蔽数据', '视图一经定义就可以和基本表一样被查询和更新', '视图可以用来定义新的视图', 'C');
INSERT INTO `single_choice` VALUES ('14', ' 如果一个事务在故障发生之前完成，但是它并没有到达检查点，则系统恢复时应对该事务执行', 'REDO操作', ' UNDO操作', ' RESTART操作', 'NULL操作', 'A');
INSERT INTO `single_choice` VALUES ('15', '下列关于栈的叙述正确的是？', '栈是非线性结构', ' 栈是一种树状结构', '栈具有先进先出的特征', '栈具有后进先出的特征', 'D');
INSERT INTO `single_choice` VALUES ('16', '下面数据结构中，属于非线性的是？', '线性表', '树', '队列', '堆栈', 'B');
INSERT INTO `single_choice` VALUES ('17', '软件设计中划分模块的一个准则是', '低内聚低耦合', '低内聚高耦合', '高内聚低耦合', '高内聚高耦合', 'C');
INSERT INTO `single_choice` VALUES ('18', '()设备既是输入设备又是输出设备？', '键盘', '打印机', '硬盘', '显示器', 'C');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录学生序号',
  `id` varchar(100) NOT NULL COMMENT '学号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `major` varchar(100) NOT NULL COMMENT '专业',
  `phone_number` varchar(100) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `student_UN` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='学生个人信息';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2015214000', '王大', '软件工程', '13452842222');
INSERT INTO `student` VALUES ('2', '2015214001', '向前看', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('3', '2015214002', '元山', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('4', '2015214003', '莫山山', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('5', '2015214004', '叶鱼', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('6', '2015214005', '周天', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('7', '2015214006', '慕容小小', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('8', '2015214007', '姜枫', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('9', '2015214008', '周丽', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('10', '2015214009', '林琳', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('11', '2015214010', '洪天', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('12', '2015214011', '谢颖', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('13', '2015214012', '李白', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('14', '2015214013', '帝天', '软件工程', '18889880000');
INSERT INTO `student` VALUES ('15', '2015214014', '莫然', '软件工程', '18889880000');

-- ----------------------------
-- Table structure for stu_course_relsp
-- ----------------------------
DROP TABLE IF EXISTS `stu_course_relsp`;
CREATE TABLE `stu_course_relsp` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `sid` varchar(100) NOT NULL COMMENT '学生id',
  `cid` varchar(100) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `stu_course_relsp_UN` (`sid`,`cid`),
  KEY `stu_course_relsp_course_FK` (`cid`),
  CONSTRAINT `stu_course_relsp_course_FK` FOREIGN KEY (`cid`) REFERENCES `course_info` (`id`),
  CONSTRAINT `stu_course_relsp_student_FK` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='学生、课程 关系表';

-- ----------------------------
-- Records of stu_course_relsp
-- ----------------------------
INSERT INTO `stu_course_relsp` VALUES ('1', '2015214000', '040401');
INSERT INTO `stu_course_relsp` VALUES ('2', '2015214000', '040402');
INSERT INTO `stu_course_relsp` VALUES ('3', '2015214000', '040403');
INSERT INTO `stu_course_relsp` VALUES ('4', '2015214000', '040404');
INSERT INTO `stu_course_relsp` VALUES ('6', '2015214001', '040403');
INSERT INTO `stu_course_relsp` VALUES ('5', '2015214001', '040404');
INSERT INTO `stu_course_relsp` VALUES ('7', '2015214001', '040406');
INSERT INTO `stu_course_relsp` VALUES ('8', '2015214002', '040405');
INSERT INTO `stu_course_relsp` VALUES ('9', '2015214002', '040408');
INSERT INTO `stu_course_relsp` VALUES ('10', '2015214002', '040410');
INSERT INTO `stu_course_relsp` VALUES ('11', '2015214003', '040401');
INSERT INTO `stu_course_relsp` VALUES ('12', '2015214003', '040402');
INSERT INTO `stu_course_relsp` VALUES ('14', '2015214003', '040410');
INSERT INTO `stu_course_relsp` VALUES ('13', '2015214003', '040411');
INSERT INTO `stu_course_relsp` VALUES ('17', '2015214004', '040403');
INSERT INTO `stu_course_relsp` VALUES ('15', '2015214004', '040412');
INSERT INTO `stu_course_relsp` VALUES ('16', '2015214004', '040413');
INSERT INTO `stu_course_relsp` VALUES ('19', '2015214005', '040401');
INSERT INTO `stu_course_relsp` VALUES ('20', '2015214005', '040402');
INSERT INTO `stu_course_relsp` VALUES ('18', '2015214005', '040403');
INSERT INTO `stu_course_relsp` VALUES ('21', '2015214005', '040405');
INSERT INTO `stu_course_relsp` VALUES ('22', '2015214005', '040411');
INSERT INTO `stu_course_relsp` VALUES ('24', '2015214006', '040406');
INSERT INTO `stu_course_relsp` VALUES ('23', '2015214006', '040413');
INSERT INTO `stu_course_relsp` VALUES ('25', '2015214007', '040405');
INSERT INTO `stu_course_relsp` VALUES ('26', '2015214007', '040406');
INSERT INTO `stu_course_relsp` VALUES ('27', '2015214008', '040401');
INSERT INTO `stu_course_relsp` VALUES ('28', '2015214008', '040411');
INSERT INTO `stu_course_relsp` VALUES ('31', '2015214009', '040405');
INSERT INTO `stu_course_relsp` VALUES ('29', '2015214009', '040410');
INSERT INTO `stu_course_relsp` VALUES ('30', '2015214009', '040413');
INSERT INTO `stu_course_relsp` VALUES ('32', '2015214010', '040408');
INSERT INTO `stu_course_relsp` VALUES ('33', '2015214011', '040409');
INSERT INTO `stu_course_relsp` VALUES ('34', '2015214012', '040408');
INSERT INTO `stu_course_relsp` VALUES ('35', '2015214013', '040405');
INSERT INTO `stu_course_relsp` VALUES ('36', '2015214014', '040404');

-- ----------------------------
-- Table structure for stu_exam_short_answer
-- ----------------------------
DROP TABLE IF EXISTS `stu_exam_short_answer`;
CREATE TABLE `stu_exam_short_answer` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '试卷名称',
  `sid` varchar(100) NOT NULL COMMENT '学号，外键',
  `a1` varchar(255) DEFAULT NULL COMMENT '简答题1',
  `a2` varchar(255) DEFAULT NULL COMMENT '简答题2',
  `a3` varchar(100) DEFAULT NULL COMMENT '简答题3',
  `short_answer_goal` int(11) DEFAULT NULL COMMENT '试卷简答题得分',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `stu_exam_short_answer_UN` (`exam_name`,`sid`),
  KEY `stu_exam_short_answer_student_FK` (`sid`),
  CONSTRAINT `stu_exam_short_answer_exam_info_FK` FOREIGN KEY (`exam_name`) REFERENCES `exam_info` (`exam_name`),
  CONSTRAINT `stu_exam_short_answer_student_FK` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='学生考试简答题答案表';

-- ----------------------------
-- Records of stu_exam_short_answer
-- ----------------------------
INSERT INTO `stu_exam_short_answer` VALUES ('5', '第三次考试', '2015214000', '单利', 'java', '构造', '23');
INSERT INTO `stu_exam_short_answer` VALUES ('6', '第三次考试', '2015214003', 'dl', 'jsjava', 'gz', '40');
INSERT INTO `stu_exam_short_answer` VALUES ('7', '第四次', '2015214000', 'hhh', 'jjjj', 'ffff', null);

-- ----------------------------
-- Table structure for stu_exam_single_choice
-- ----------------------------
DROP TABLE IF EXISTS `stu_exam_single_choice`;
CREATE TABLE `stu_exam_single_choice` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `exam_name` varchar(100) NOT NULL COMMENT '试卷名称',
  `sid` varchar(100) NOT NULL COMMENT '学生学号，外键',
  `single_choice_goal` int(11) NOT NULL COMMENT '单选题得分',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `stu_exam_single_choice_UN` (`exam_name`,`sid`),
  KEY `stu_exam_single_choice_student_FK` (`sid`),
  CONSTRAINT `stu_exam_single_choice_exam_info_FK` FOREIGN KEY (`exam_name`) REFERENCES `exam_info` (`exam_name`),
  CONSTRAINT `stu_exam_single_choice_student_FK` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='学生单选题得分';

-- ----------------------------
-- Records of stu_exam_single_choice
-- ----------------------------
INSERT INTO `stu_exam_single_choice` VALUES ('5', '第三次考试', '2015214000', '80');
INSERT INTO `stu_exam_single_choice` VALUES ('6', '第三次考试', '2015214003', '90');
INSERT INTO `stu_exam_single_choice` VALUES ('7', '第四次', '2015214000', '20');

-- ----------------------------
-- Table structure for stu_user
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `id` varchar(100) NOT NULL COMMENT '登录id，学号',
  `password` varchar(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `stu_user_UN` (`id`),
  CONSTRAINT `stu_user_student_FK` FOREIGN KEY (`id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='学生用户登录';

-- ----------------------------
-- Records of stu_user
-- ----------------------------
INSERT INTO `stu_user` VALUES ('1', '2015214000', '123456');
INSERT INTO `stu_user` VALUES ('2', '2015214001', '214001');
INSERT INTO `stu_user` VALUES ('3', '2015214002', '214002');
INSERT INTO `stu_user` VALUES ('4', '2015214003', '214003');
INSERT INTO `stu_user` VALUES ('5', '2015214004', '214004');
INSERT INTO `stu_user` VALUES ('6', '2015214005', '214005');
INSERT INTO `stu_user` VALUES ('7', '2015214006', '214006');
INSERT INTO `stu_user` VALUES ('8', '2015214007', '214007');
INSERT INTO `stu_user` VALUES ('9', '2015214008', '214008');
INSERT INTO `stu_user` VALUES ('10', '2015214009', '214009');
INSERT INTO `stu_user` VALUES ('11', '2015214010', '214010');
INSERT INTO `stu_user` VALUES ('12', '2015214011', '214011');
INSERT INTO `stu_user` VALUES ('13', '2015214012', '214012');
INSERT INTO `stu_user` VALUES ('14', '2015214013', '214013');
INSERT INTO `stu_user` VALUES ('15', '2015214014', '214014');

-- ----------------------------
-- Table structure for tcs_relsp
-- ----------------------------
DROP TABLE IF EXISTS `tcs_relsp`;
CREATE TABLE `tcs_relsp` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `sid` varchar(100) NOT NULL COMMENT '学生学号，外键',
  `cid` varchar(100) NOT NULL COMMENT '课程号，外键',
  `tid` varchar(100) NOT NULL COMMENT '教师编号，外键',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `tcs_resp_UN` (`sid`,`cid`),
  KEY `tcs_resp_teach_course_relsp_FK` (`tid`,`cid`),
  CONSTRAINT `tcs_resp_stu_course_relsp_FK` FOREIGN KEY (`sid`, `cid`) REFERENCES `stu_course_relsp` (`sid`, `cid`),
  CONSTRAINT `tcs_resp_teach_course_relsp_FK` FOREIGN KEY (`tid`, `cid`) REFERENCES `teach_course_relsp` (`tid`, `cid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='教师、学生、课程对应关系表';

-- ----------------------------
-- Records of tcs_relsp
-- ----------------------------
INSERT INTO `tcs_relsp` VALUES ('1', '2015214000', '040401', 't131000');
INSERT INTO `tcs_relsp` VALUES ('2', '2015214000', '040404', 't131006');
INSERT INTO `tcs_relsp` VALUES ('8', '2015214000', '040402', 't131000');
INSERT INTO `tcs_relsp` VALUES ('11', '2015214003', '040402', 't131000');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `id` varchar(100) NOT NULL COMMENT '教师编号',
  `name` varchar(100) NOT NULL COMMENT '教师姓名',
  `email` varchar(100) NOT NULL COMMENT '电子邮箱',
  `phone_number` varchar(100) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `teacher_UN` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='教师个人信息表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 't131000', '张三', '15331496xx@qq.com', '18889880000');
INSERT INTO `teacher` VALUES ('2', 't131001', '李四', 'fengwuj@foxmail.com', '18889880001');
INSERT INTO `teacher` VALUES ('3', 't131002', '王五', 'fengwuj@foxmail.com', '18889880002');
INSERT INTO `teacher` VALUES ('4', 't131003', '刘开心', 'fengwuj@foxmail.com', '18889880003');
INSERT INTO `teacher` VALUES ('5', 't131004', '卢亚', 'fengwuj@foxmail.com', '18889880004');
INSERT INTO `teacher` VALUES ('6', 't131005', '袁弘山', 'fengwuj@foxmail.com', '18889880005');
INSERT INTO `teacher` VALUES ('7', 't131006', '谢鹰', 'fengwuj@foxmail.com', '18889880006');
INSERT INTO `teacher` VALUES ('8', 't131007', '陈平安', 'fengwuj@foxmail.com', '18889880007');
INSERT INTO `teacher` VALUES ('9', 't131008', '王林', 'fengwuj@foxmail.com', '18889880008');
INSERT INTO `teacher` VALUES ('10', 't131009', '周自成', 'fengwuj@foxmail.com', '18889880009');

-- ----------------------------
-- Table structure for teach_course_relsp
-- ----------------------------
DROP TABLE IF EXISTS `teach_course_relsp`;
CREATE TABLE `teach_course_relsp` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `tid` varchar(100) NOT NULL COMMENT '教师id',
  `cid` varchar(100) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `teach_course_relsp_UN` (`tid`,`cid`),
  KEY `teach_course_relsp_course_FK` (`cid`),
  CONSTRAINT `teach_course_relsp_course_FK` FOREIGN KEY (`cid`) REFERENCES `course_info` (`id`),
  CONSTRAINT `teach_course_relsp_teacher_FK` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='教师、课程 关系表';

-- ----------------------------
-- Records of teach_course_relsp
-- ----------------------------
INSERT INTO `teach_course_relsp` VALUES ('1', 't131000', '040401');
INSERT INTO `teach_course_relsp` VALUES ('2', 't131000', '040402');
INSERT INTO `teach_course_relsp` VALUES ('3', 't131000', '040403');
INSERT INTO `teach_course_relsp` VALUES ('4', 't131000', '040404');
INSERT INTO `teach_course_relsp` VALUES ('5', 't131000', '040405');
INSERT INTO `teach_course_relsp` VALUES ('6', 't131000', '040407');
INSERT INTO `teach_course_relsp` VALUES ('7', 't131001', '040405');
INSERT INTO `teach_course_relsp` VALUES ('8', 't131001', '040406');
INSERT INTO `teach_course_relsp` VALUES ('9', 't131001', '040407');
INSERT INTO `teach_course_relsp` VALUES ('10', 't131001', '040408');
INSERT INTO `teach_course_relsp` VALUES ('11', 't131002', '040402');
INSERT INTO `teach_course_relsp` VALUES ('12', 't131002', '040411');
INSERT INTO `teach_course_relsp` VALUES ('13', 't131003', '040412');
INSERT INTO `teach_course_relsp` VALUES ('14', 't131003', '040413');
INSERT INTO `teach_course_relsp` VALUES ('15', 't131004', '040405');
INSERT INTO `teach_course_relsp` VALUES ('16', 't131004', '040408');
INSERT INTO `teach_course_relsp` VALUES ('19', 't131005', '040403');
INSERT INTO `teach_course_relsp` VALUES ('18', 't131005', '040404');
INSERT INTO `teach_course_relsp` VALUES ('17', 't131005', '040407');
INSERT INTO `teach_course_relsp` VALUES ('20', 't131006', '040401');
INSERT INTO `teach_course_relsp` VALUES ('21', 't131006', '040404');
INSERT INTO `teach_course_relsp` VALUES ('22', 't131006', '040405');
INSERT INTO `teach_course_relsp` VALUES ('23', 't131007', '040406');
INSERT INTO `teach_course_relsp` VALUES ('24', 't131007', '040407');
INSERT INTO `teach_course_relsp` VALUES ('27', 't131008', '040409');
INSERT INTO `teach_course_relsp` VALUES ('28', 't131008', '040410');
INSERT INTO `teach_course_relsp` VALUES ('26', 't131008', '040412');
INSERT INTO `teach_course_relsp` VALUES ('25', 't131008', '040413');
INSERT INTO `teach_course_relsp` VALUES ('30', 't131009', '040406');
INSERT INTO `teach_course_relsp` VALUES ('29', 't131009', '040410');
INSERT INTO `teach_course_relsp` VALUES ('31', 't131009', '040412');

-- ----------------------------
-- Table structure for teach_user
-- ----------------------------
DROP TABLE IF EXISTS `teach_user`;
CREATE TABLE `teach_user` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `id` varchar(100) NOT NULL COMMENT '用于登录的教师编号,即id',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`seq_number`),
  UNIQUE KEY `teach_user_UN` (`id`),
  CONSTRAINT `teach_user_teacher_FK` FOREIGN KEY (`id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='教师登录表';

-- ----------------------------
-- Records of teach_user
-- ----------------------------
INSERT INTO `teach_user` VALUES ('1', 't131000', '123456');
INSERT INTO `teach_user` VALUES ('2', 't131001', '131001');
INSERT INTO `teach_user` VALUES ('3', 't131002', '131002');
INSERT INTO `teach_user` VALUES ('4', 't131003', '131003');
INSERT INTO `teach_user` VALUES ('5', 't131004', '131004');
INSERT INTO `teach_user` VALUES ('6', 't131005', '131005');
INSERT INTO `teach_user` VALUES ('7', 't131006', '131006');
INSERT INTO `teach_user` VALUES ('8', 't131007', '131007');
INSERT INTO `teach_user` VALUES ('9', 't131008', '131008');
INSERT INTO `teach_user` VALUES ('10', 't131009', '131009');

-- ----------------------------
-- Table structure for work_file
-- ----------------------------
DROP TABLE IF EXISTS `work_file`;
CREATE TABLE `work_file` (
  `seq_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `file_url` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `submit_time` date DEFAULT NULL COMMENT '提交时间',
  `correct_time` date DEFAULT NULL COMMENT '批改时间',
  `sid` varchar(100) NOT NULL COMMENT '学号外键',
  `cid` varchar(100) NOT NULL COMMENT '课程号外键',
  `tid` varchar(100) NOT NULL COMMENT '教师编号外键',
  `status` varchar(100) DEFAULT NULL COMMENT '审批状态',
  `work_name` varchar(100) NOT NULL COMMENT '作业名字',
  PRIMARY KEY (`seq_number`),
  KEY `work_info_stu_course_relsp_FK` (`sid`,`cid`),
  KEY `work_info_teach_course_relsp_FK` (`tid`,`cid`),
  KEY `work_file_work_info_FK` (`work_name`,`cid`,`tid`),
  CONSTRAINT `work_file_work_info_FK` FOREIGN KEY (`work_name`, `cid`, `tid`) REFERENCES `work_info` (`work_name`, `cid`, `tid`),
  CONSTRAINT `work_info_stu_course_relsp_FK` FOREIGN KEY (`sid`, `cid`) REFERENCES `stu_course_relsp` (`sid`, `cid`),
  CONSTRAINT `work_info_teach_course_relsp_FK` FOREIGN KEY (`tid`, `cid`) REFERENCES `teach_course_relsp` (`tid`, `cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='作业信息表单';

-- ----------------------------
-- Records of work_file
-- ----------------------------
INSERT INTO `work_file` VALUES ('1', null, null, null, '2015214000', '040401', 't131000', '未提交', '二维数组中的查找');
INSERT INTO `work_file` VALUES ('3', null, null, null, '2015214000', '040404', 't131006', '未提交', '替换空格');
INSERT INTO `work_file` VALUES ('5', 'E:\\workspace\\Course%20Manage%20System\\cms-web%20Maven%20Webapp\\target\\classes\\static\\wfile\\040402\\2015214000\\时长.pdf', '2019-01-23', '2019-01-24', '2015214000', '040402', 't131000', '已提交', '替换空格');
INSERT INTO `work_file` VALUES ('6', null, null, null, '2015214000', '040402', 't131000', '未提交', '斐波那契数列');
INSERT INTO `work_file` VALUES ('7', null, null, null, '2015214000', '040402', 't131000', '未提交', '作业标题');
INSERT INTO `work_file` VALUES ('8', null, null, null, '2015214003', '040402', 't131000', '未提交', '作业标题');

-- ----------------------------
-- Table structure for work_info
-- ----------------------------
DROP TABLE IF EXISTS `work_info`;
CREATE TABLE `work_info` (
  `seq_numner` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号记录',
  `work_name` varchar(100) NOT NULL COMMENT '作业标题',
  `content` varchar(255) NOT NULL COMMENT '作业内容',
  `cid` varchar(100) NOT NULL COMMENT '课程编号，外键',
  `tid` varchar(100) NOT NULL COMMENT '教师编号，外键',
  PRIMARY KEY (`seq_numner`),
  UNIQUE KEY `work_info_UN` (`work_name`,`cid`,`tid`),
  KEY `work_info_course_info_FK` (`cid`),
  KEY `work_info_teacher_FK` (`tid`),
  CONSTRAINT `work_info_course_info_FK` FOREIGN KEY (`cid`) REFERENCES `course_info` (`id`),
  CONSTRAINT `work_info_teacher_FK` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='作业信息记录';

-- ----------------------------
-- Records of work_info
-- ----------------------------
INSERT INTO `work_info` VALUES ('1', '二维数组中的查找', '在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。', '040401', 't131000');
INSERT INTO `work_info` VALUES ('2', '替换空格', '请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。', '040404', 't131006');
INSERT INTO `work_info` VALUES ('3', '斐波那契数列', '大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）', '040402', 't131002');
INSERT INTO `work_info` VALUES ('4', '斐波那契数列', '大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）', '040402', 't131000');
INSERT INTO `work_info` VALUES ('5', '替换空格', '请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。', '040402', 't131000');
INSERT INTO `work_info` VALUES ('13', '作业标题', '\n				    作业内容\n				  ', '040402', 't131000');
