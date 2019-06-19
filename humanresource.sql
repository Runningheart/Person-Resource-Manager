/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : humanresource

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2019-01-04 23:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `user` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', 'root');

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL auto_increment,
  `activity` varchar(255) default NULL,
  `dateTime` date default NULL,
  `timeLength` float default NULL,
  `staff_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK520j7kwt94v2yn93ptkdus02b` (`staff_id`),
  CONSTRAINT `FK520j7kwt94v2yn93ptkdus02b` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '缺勤', '2019-01-01', '360', '20');
INSERT INTO `attendance` VALUES ('2', '缺勤', '2019-01-01', '360', '12');
INSERT INTO `attendance` VALUES ('3', '缺勤', '2019-01-01', '361', '21');
INSERT INTO `attendance` VALUES ('4', '缺勤', '2019-01-01', '364', '30');
INSERT INTO `attendance` VALUES ('5', '缺勤', '2019-01-01', '364', '10');
INSERT INTO `attendance` VALUES ('6', '缺勤', '2019-01-01', '363', '22');
INSERT INTO `attendance` VALUES ('7', '缺勤', '2019-01-01', '363', '40');
INSERT INTO `attendance` VALUES ('8', '缺勤', '2019-01-01', '363', '50');
INSERT INTO `attendance` VALUES ('9', '缺勤', '2019-01-01', '363', '49');
INSERT INTO `attendance` VALUES ('10', '缺勤', '2019-01-01', '364', '15');

-- ----------------------------
-- Table structure for checklist
-- ----------------------------
DROP TABLE IF EXISTS `checklist`;
CREATE TABLE `checklist` (
  `id` int(11) NOT NULL auto_increment,
  `activity` varchar(255) default NULL,
  `dateTime` date default NULL,
  `comments` varchar(255) default NULL,
  `staff_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKbkb8aga0dqqfcgiarrr9wt9e6` (`staff_id`),
  CONSTRAINT `FKbkb8aga0dqqfcgiarrr9wt9e6` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checklist
-- ----------------------------
INSERT INTO `checklist` VALUES ('1', '-100', '2019-01-04', '迟到', '1');
INSERT INTO `checklist` VALUES ('2', '-100', '2019-01-04', '迟到', '2');
INSERT INTO `checklist` VALUES ('3', '-100', '2019-01-04', '迟到', '10');
INSERT INTO `checklist` VALUES ('4', '-100', '2019-01-04', '迟到', '20');
INSERT INTO `checklist` VALUES ('5', '-100', '2019-01-04', '迟到', '15');
INSERT INTO `checklist` VALUES ('6', '-100', '2019-01-04', '迟到', '16');
INSERT INTO `checklist` VALUES ('7', '-100', '2019-01-04', '迟到', '17');
INSERT INTO `checklist` VALUES ('8', '-100', '2019-01-04', '迟到', '9');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `managerName` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '服务部', '16111205001');
INSERT INTO `department` VALUES ('2', '财务部', '16111205002');
INSERT INTO `department` VALUES ('3', '行政部', '16111205003');
INSERT INTO `department` VALUES ('4', '人事部', '16111205004');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `salary` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '前台', '300');
INSERT INTO `job` VALUES ('2', '助理', '4000');
INSERT INTO `job` VALUES ('3', '员工', '4000');
INSERT INTO `job` VALUES ('4', '经理', '5000');

-- ----------------------------
-- Table structure for personnelchange
-- ----------------------------
DROP TABLE IF EXISTS `personnelchange`;
CREATE TABLE `personnelchange` (
  `id` int(11) NOT NULL auto_increment,
  `activity` varchar(255) default NULL,
  `dateTime` date default NULL,
  `oldJob` int(11) default NULL,
  `nowJob` int(11) default NULL,
  `staff_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKghkcey4gedok7ud093744wnsi` (`oldJob`),
  KEY `FKsehpfnbh65pnsf2xud7ue5g0w` (`nowJob`),
  KEY `FKkhpj0xp4d0o76ibv8xk8j9hfa` (`staff_id`),
  CONSTRAINT `FKghkcey4gedok7ud093744wnsi` FOREIGN KEY (`oldJob`) REFERENCES `job` (`id`),
  CONSTRAINT `FKkhpj0xp4d0o76ibv8xk8j9hfa` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKsehpfnbh65pnsf2xud7ue5g0w` FOREIGN KEY (`nowJob`) REFERENCES `job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personnelchange
-- ----------------------------
INSERT INTO `personnelchange` VALUES ('1', '调度', '2018-05-06', '2', '1', '15');
INSERT INTO `personnelchange` VALUES ('2', '调度', '2018-01-07', '2', '4', '16');
INSERT INTO `personnelchange` VALUES ('3', '调度', '2017-05-07', '4', '2', '21');
INSERT INTO `personnelchange` VALUES ('4', '调度', '2018-05-07', '4', '2', '24');
INSERT INTO `personnelchange` VALUES ('5', '调度', '2018-05-07', '3', '2', '32');
INSERT INTO `personnelchange` VALUES ('6', '调度', '2018-05-07', '2', '1', '17');
INSERT INTO `personnelchange` VALUES ('7', '离职', '3899-02-01', '1', '1', '103');
INSERT INTO `personnelchange` VALUES ('8', '离职', '3899-02-01', '1', null, '103');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `health` varchar(255) default NULL,
  `political` varchar(255) default NULL,
  `birthday` date default NULL,
  `job_id` int(11) default NULL,
  `dep_id` int(11) default NULL,
  `isOnline` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKoxgh41a4q0cudxlp9fr1i941r` (`job_id`),
  KEY `FKf29cey8jmhkgcrl0myiwn4xv4` (`dep_id`),
  CONSTRAINT `FKf29cey8jmhkgcrl0myiwn4xv4` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKoxgh41a4q0cudxlp9fr1i941r` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '赵一', '001', '健康', '团员', '1998-01-01', '1', '1', null);
INSERT INTO `staff` VALUES ('2', '钱二', '002', '健康', '团员', '1998-05-01', '1', '1', null);
INSERT INTO `staff` VALUES ('3', '孙三', '003', '健康', '团员', '1997-05-10', '1', '1', null);
INSERT INTO `staff` VALUES ('4', '李四', '004', '健康', '团员', '1997-05-10', '1', '2', null);
INSERT INTO `staff` VALUES ('5', '周五', '005', '健康', '团员', '1998-06-10', '1', '2', null);
INSERT INTO `staff` VALUES ('6', '吴六', '006', '健康', '团员', '1998-07-05', '1', '2', null);
INSERT INTO `staff` VALUES ('7', '老七', '007', '健康', '团员', '1999-07-05', '1', '3', null);
INSERT INTO `staff` VALUES ('8', '第八', '008', '健康', '团员', '1999-01-02', '1', '3', null);
INSERT INTO `staff` VALUES ('9', '胡九', '009', '健康', '团员', '1998-05-06', '1', '3', null);
INSERT INTO `staff` VALUES ('10', '幺鸡', '010', '健康', '团员', '1997-04-06', '1', '4', null);
INSERT INTO `staff` VALUES ('11', '光棍', '011', '健康', '团员', '1997-01-11', '1', '4', null);
INSERT INTO `staff` VALUES ('12', '京东', '012', '健康', '团员', '1998-12-12', '1', '4', null);
INSERT INTO `staff` VALUES ('13', '淘宝', '013', '健康', '团员', '1996-11-12', '2', '1', null);
INSERT INTO `staff` VALUES ('14', '百度', '014', '健康', '团员', '1996-01-02', '2', '1', null);
INSERT INTO `staff` VALUES ('15', '谷歌', '015', '健康', '团员', '1995-07-02', '2', '2', null);
INSERT INTO `staff` VALUES ('16', '网易', '016', '健康', '团员', '1995-08-09', '2', '2', null);
INSERT INTO `staff` VALUES ('17', '腾讯', '017', '健康', '团员', '1995-09-10', '2', '3', null);
INSERT INTO `staff` VALUES ('18', '凤凰', '018', '健康', '团员', '1995-12-10', '2', '3', null);
INSERT INTO `staff` VALUES ('19', '微信', '019', '健康', '团员', '1995-02-08', '2', '4', null);
INSERT INTO `staff` VALUES ('20', '企鹅', '020', '健康', '团员', '1994-09-08', '2', '4', null);
INSERT INTO `staff` VALUES ('21', '王思聪', '021', '健康', '党员', '1992-01-08', '4', '4', null);
INSERT INTO `staff` VALUES ('22', '刘强东', '022', '健康', '党员', '1992-10-06', '4', '4', null);
INSERT INTO `staff` VALUES ('23', '刘一首', '023', '健康', '党员', '1995-01-07', '3', '4', null);
INSERT INTO `staff` VALUES ('24', '马云', '024', '健康', '党员', '1990-10-06', '4', '3', null);
INSERT INTO `staff` VALUES ('25', '马化腾', '025', '健康', '党员', '1991-11-16', '4', '3', null);
INSERT INTO `staff` VALUES ('26', '马龙腾', '026', '健康', '团员', '1995-11-16', '3', '4', null);
INSERT INTO `staff` VALUES ('27', '刘能', '027', '健康', '团员', '1995-01-16', '3', '4', null);
INSERT INTO `staff` VALUES ('28', '吴能', '028', '健康', '团员', '1996-08-16', '3', '4', null);
INSERT INTO `staff` VALUES ('29', '吴用', '029', '健康', '团员', '1996-08-16', '3', '4', null);
INSERT INTO `staff` VALUES ('30', '上官木', '030', '健康', '团员', '1995-08-26', '3', '1', null);
INSERT INTO `staff` VALUES ('31', '凯皇一', '031', '健康', '团员', '1994-10-26', '3', '1', null);
INSERT INTO `staff` VALUES ('32', '张之良', '032', '健康', '团员', '1994-01-26', '3', '1', null);
INSERT INTO `staff` VALUES ('33', '郑屠', '033', '健康', '团员', '1995-09-26', '3', '1', null);
INSERT INTO `staff` VALUES ('34', '夏侯', '034', '健康', '团员', '1995-11-22', '3', '1', null);
INSERT INTO `staff` VALUES ('35', '春秋', '035', '健康', '团员', '1995-03-12', '3', '1', null);
INSERT INTO `staff` VALUES ('36', '一休', '036', '健康', '团员', '1996-04-29', '3', '1', null);
INSERT INTO `staff` VALUES ('37', '韩叶', '037', '健康', '团员', '1995-02-02', '3', '2', null);
INSERT INTO `staff` VALUES ('38', '苏妲己', '038', '健康', '团员', '1996-01-30', '3', '2', null);
INSERT INTO `staff` VALUES ('39', '妖姬', '039', '健康', '团员', '1995-10-30', '3', '2', null);
INSERT INTO `staff` VALUES ('40', '高云', '040', '健康', '团员', '1995-01-15', '3', '2', null);
INSERT INTO `staff` VALUES ('41', '夏萍', '041', '健康', '团员', '1995-05-15', '3', '2', null);
INSERT INTO `staff` VALUES ('42', '崔岩', '042', '健康', '团员', '1995-09-05', '3', '2', null);
INSERT INTO `staff` VALUES ('43', '林冲', '043', '健康', '团员', '1995-06-05', '3', '2', null);
INSERT INTO `staff` VALUES ('44', '李逵', '044', '健康', '团员', '1995-08-09', '3', '2', null);
INSERT INTO `staff` VALUES ('45', '夏国', '045', '健康', '团员', '1995-10-01', '3', '3', null);
INSERT INTO `staff` VALUES ('46', '屠图', '046', '健康', '团员', '1996-01-09', '3', '3', null);
INSERT INTO `staff` VALUES ('47', '李力', '047', '健康', '团员', '1995-05-19', '3', '3', null);
INSERT INTO `staff` VALUES ('48', '孙隼', '048', '健康', '团员', '1996-06-16', '3', '3', null);
INSERT INTO `staff` VALUES ('49', '苏术', '049', '健康', '团员', '1997-07-06', '3', '3', null);
INSERT INTO `staff` VALUES ('50', '马回', '050', '健康', '团员', '1994-05-06', '3', '3', null);
INSERT INTO `staff` VALUES ('51', '夏至', '051', '健康', '团员', '1996-08-29', '3', '4', null);
INSERT INTO `staff` VALUES ('52', '寒露', '052', '健康', '团员', '1995-08-19', '3', '4', null);
INSERT INTO `staff` VALUES ('53', '快手', '053', '健康', '党员', '1995-05-07', '4', '1', null);
INSERT INTO `staff` VALUES ('54', '火山', '054', '健康', '党员', '1995-05-07', '4', '1', null);
INSERT INTO `staff` VALUES ('55', '卫视', '055', '健康', '党员', '1996-02-20', '4', '2', null);
INSERT INTO `staff` VALUES ('56', '上海', '056', '健康', '党员', '1994-12-20', '4', '2', null);
INSERT INTO `staff` VALUES ('103', '伍方健', '111', '健康', '群众', '3899-02-01', '1', '4', '离职');
INSERT INTO `staff` VALUES ('104', 'wufangjian', '112', '健康', '群众', '2019-01-01', '1', '4', '在职');
INSERT INTO `staff` VALUES ('105', '伍方健', '112', '健康', '群众', '2019-01-10', '1', '4', '在职');
