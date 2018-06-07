/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : tickets

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-05-16 21:35:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hall
-- ----------------------------
DROP TABLE IF EXISTS `hall`;
CREATE TABLE `hall` (
  `hallNo` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hallName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `income` double(10,2) NOT NULL,
  `juniorNum` int(10) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `percent` double(10,2) NOT NULL,
  `seniorNum` int(10) NOT NULL,
  PRIMARY KEY (`hallNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1000004 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hall
-- ----------------------------
INSERT INTO `hall` VALUES ('1000000', '南京市栖霞区仙林大道', '体育馆', '0.00', '160', 'cfeng5656', '0.75', '80');
INSERT INTO `hall` VALUES ('1000001', '苏州观前街', '星德罗', '3368.21', '15', 'cfeng5656', '0.88', '50');
INSERT INTO `hall` VALUES ('1000003', '南京市鼓楼区', '南京大学', '204.00', '50', 'cfeng5656', '0.85', '40');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerNo` int(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `income` double(10,2) NOT NULL,
  PRIMARY KEY (`managerNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1437', 'fortnite', '308.94');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `email` varchar(30) CHARACTER SET utf8 NOT NULL,
  `consumption` double(10,2) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `level` int(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `point` int(10) NOT NULL,
  `sex` int(10) NOT NULL,
  `state` int(10) NOT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `checkCode` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('2196921853@qq.com', '544.00', '0.90', '2', '陈泽珺', 'cfeng565656', '5440', '0', '1', '15850793698', 'b6c694865443e149fd793babf362df4e');
INSERT INTO `member` VALUES ('448185075@qq.com', '0.00', '1.00', '0', 'tzj', 'cfeng5656', '0', '0', '0', '15850793698', null);
INSERT INTO `member` VALUES ('549661085@qq.com', '1701.00', '0.85', '3', 'czj', 'cfeng5656', '16010', '0', '1', '15850793698', 'c9586a47b688e67cef2093432e9e675b');

-- ----------------------------
-- Table structure for payaccount
-- ----------------------------
DROP TABLE IF EXISTS `payaccount`;
CREATE TABLE `payaccount` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `balance` double(10,2) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payaccount
-- ----------------------------
INSERT INTO `payaccount` VALUES ('2196921853@qq.com', 'cfeng5656', '15850793698', '2456.00');
INSERT INTO `payaccount` VALUES ('549661085@qq.com', 'cfeng5656', '15850793698', '1299.00');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `planNo` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hallName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hallNo` int(10) NOT NULL,
  `juniorNum` int(10) NOT NULL,
  `juniorPrice` double(10,2) NOT NULL,
  `seniorNum` int(10) NOT NULL,
  `seniorPrice` double(10,2) NOT NULL,
  `showDate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `showType` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1000018 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1000000', '苏州观前街', '嘻嘻嘻', '星德罗', '1000001', '15', '100.00', '50', '240.00', '2018-04-15 18:00:00', '夜店');
INSERT INTO `plan` VALUES ('1000013', '苏州观前街', '嘻嘻嘻', '星德罗', '1000001', '50', '120.00', '30', '180.00', '2018-03-22 20:00:00', '音乐会');
INSERT INTO `plan` VALUES ('1000015', '苏州观前街', '嘻嘻嘻', '星德罗', '1000001', '30', '40.00', '30', '60.00', '2013-04-12 20:00:00', '音乐会');
INSERT INTO `plan` VALUES ('1000016', '苏州观前街', '嘻嘻嘻', '星德罗', '1000001', '15', '80.00', '30', '160.00', '2018-05-03 20:00:00', '音乐会');
INSERT INTO `plan` VALUES ('1000017', '南京市鼓楼区', '南京大学晚餐', '南京大学', '1000003', '30', '80.00', '30', '100.00', '2018-03-22 20:00:00', '晚餐');

-- ----------------------------
-- Table structure for registry
-- ----------------------------
DROP TABLE IF EXISTS `registry`;
CREATE TABLE `registry` (
  `hallNo` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hallName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `income` double(10,2) NOT NULL,
  `juniorNum` int(10) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `percent` double(10,2) NOT NULL,
  `seniorNum` int(10) NOT NULL,
  `isViewed` int(10) NOT NULL,
  PRIMARY KEY (`hallNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1000006 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of registry
-- ----------------------------
INSERT INTO `registry` VALUES ('1000000', '鲈乡南路46号', '吴江体育馆', '0.00', '160', 'cfeng5656', '0.75', '80', '1');
INSERT INTO `registry` VALUES ('1000001', '苏州观前街', '星德罗', '2948.45', '15', 'cfeng5656', '0.88', '50', '1');
INSERT INTO `registry` VALUES ('1000002', '苏州观前街', '星德罗', '0.00', '15', 'cfeng5656', '0.88', '50', '1');
INSERT INTO `registry` VALUES ('1000003', '南京市鼓楼区', '南京大学', '0.00', '50', 'cfeng5656', '0.85', '40', '1');
INSERT INTO `registry` VALUES ('1000005', '铜锣湾', '美世代', '0.00', '50', 'cfeng5656', '0.75', '40', '1');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `planNo` int(20) NOT NULL,
  `srow` int(20) DEFAULT NULL,
  `scolumn` int(20) DEFAULT NULL,
  `type` int(20) DEFAULT NULL,
  `occupied` int(20) DEFAULT NULL,
  `seatNo` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`seatNo`)
) ENGINE=InnoDB AUTO_INCREMENT=356 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('1000013', '0', '0', '0', '1', '171');
INSERT INTO `seat` VALUES ('1000013', '0', '1', '0', '1', '172');
INSERT INTO `seat` VALUES ('1000013', '0', '2', '0', '0', '173');
INSERT INTO `seat` VALUES ('1000013', '0', '3', '0', '0', '174');
INSERT INTO `seat` VALUES ('1000013', '0', '4', '0', '0', '175');
INSERT INTO `seat` VALUES ('1000013', '0', '5', '0', '0', '176');
INSERT INTO `seat` VALUES ('1000013', '0', '6', '0', '1', '177');
INSERT INTO `seat` VALUES ('1000013', '1', '0', '0', '0', '178');
INSERT INTO `seat` VALUES ('1000013', '1', '1', '0', '0', '179');
INSERT INTO `seat` VALUES ('1000013', '1', '2', '0', '0', '180');
INSERT INTO `seat` VALUES ('1000013', '1', '3', '0', '0', '181');
INSERT INTO `seat` VALUES ('1000013', '1', '4', '0', '0', '182');
INSERT INTO `seat` VALUES ('1000013', '1', '5', '0', '0', '183');
INSERT INTO `seat` VALUES ('1000013', '1', '6', '0', '1', '184');
INSERT INTO `seat` VALUES ('1000013', '2', '0', '0', '1', '185');
INSERT INTO `seat` VALUES ('1000013', '2', '1', '0', '0', '186');
INSERT INTO `seat` VALUES ('1000013', '2', '2', '0', '0', '187');
INSERT INTO `seat` VALUES ('1000013', '2', '3', '0', '1', '188');
INSERT INTO `seat` VALUES ('1000013', '2', '4', '0', '1', '189');
INSERT INTO `seat` VALUES ('1000013', '2', '5', '0', '1', '190');
INSERT INTO `seat` VALUES ('1000013', '2', '6', '0', '0', '191');
INSERT INTO `seat` VALUES ('1000013', '3', '0', '0', '0', '192');
INSERT INTO `seat` VALUES ('1000013', '3', '1', '0', '0', '193');
INSERT INTO `seat` VALUES ('1000013', '3', '2', '0', '0', '194');
INSERT INTO `seat` VALUES ('1000013', '3', '3', '0', '0', '195');
INSERT INTO `seat` VALUES ('1000013', '3', '4', '0', '1', '196');
INSERT INTO `seat` VALUES ('1000013', '3', '5', '0', '0', '197');
INSERT INTO `seat` VALUES ('1000013', '3', '6', '0', '0', '198');
INSERT INTO `seat` VALUES ('1000013', '4', '0', '0', '0', '199');
INSERT INTO `seat` VALUES ('1000013', '4', '1', '0', '1', '200');
INSERT INTO `seat` VALUES ('1000013', '4', '2', '0', '0', '201');
INSERT INTO `seat` VALUES ('1000013', '4', '3', '0', '0', '202');
INSERT INTO `seat` VALUES ('1000013', '4', '4', '0', '1', '203');
INSERT INTO `seat` VALUES ('1000013', '4', '5', '0', '0', '204');
INSERT INTO `seat` VALUES ('1000013', '4', '6', '0', '0', '205');
INSERT INTO `seat` VALUES ('1000013', '5', '0', '0', '0', '206');
INSERT INTO `seat` VALUES ('1000013', '5', '1', '0', '1', '207');
INSERT INTO `seat` VALUES ('1000013', '5', '2', '0', '0', '208');
INSERT INTO `seat` VALUES ('1000013', '5', '3', '0', '1', '209');
INSERT INTO `seat` VALUES ('1000013', '5', '4', '0', '1', '210');
INSERT INTO `seat` VALUES ('1000013', '5', '5', '0', '1', '211');
INSERT INTO `seat` VALUES ('1000013', '5', '6', '0', '0', '212');
INSERT INTO `seat` VALUES ('1000013', '6', '0', '0', '0', '213');
INSERT INTO `seat` VALUES ('1000013', '6', '1', '0', '0', '214');
INSERT INTO `seat` VALUES ('1000013', '6', '2', '0', '0', '215');
INSERT INTO `seat` VALUES ('1000013', '6', '3', '0', '0', '216');
INSERT INTO `seat` VALUES ('1000013', '6', '4', '0', '1', '217');
INSERT INTO `seat` VALUES ('1000013', '6', '5', '0', '0', '218');
INSERT INTO `seat` VALUES ('1000013', '6', '6', '0', '1', '219');
INSERT INTO `seat` VALUES ('1000013', '7', '0', '0', '0', '220');
INSERT INTO `seat` VALUES ('1000013', '0', '0', '1', '0', '221');
INSERT INTO `seat` VALUES ('1000013', '0', '1', '1', '0', '222');
INSERT INTO `seat` VALUES ('1000013', '0', '2', '1', '1', '223');
INSERT INTO `seat` VALUES ('1000013', '0', '3', '1', '0', '224');
INSERT INTO `seat` VALUES ('1000013', '0', '4', '1', '1', '225');
INSERT INTO `seat` VALUES ('1000013', '0', '5', '1', '1', '226');
INSERT INTO `seat` VALUES ('1000013', '0', '6', '1', '1', '227');
INSERT INTO `seat` VALUES ('1000013', '1', '0', '1', '0', '228');
INSERT INTO `seat` VALUES ('1000013', '1', '1', '1', '0', '229');
INSERT INTO `seat` VALUES ('1000013', '1', '2', '1', '1', '230');
INSERT INTO `seat` VALUES ('1000013', '1', '3', '1', '0', '231');
INSERT INTO `seat` VALUES ('1000013', '1', '4', '1', '0', '232');
INSERT INTO `seat` VALUES ('1000013', '1', '5', '1', '0', '233');
INSERT INTO `seat` VALUES ('1000013', '1', '6', '1', '0', '234');
INSERT INTO `seat` VALUES ('1000013', '2', '0', '1', '0', '235');
INSERT INTO `seat` VALUES ('1000013', '2', '1', '1', '0', '236');
INSERT INTO `seat` VALUES ('1000013', '2', '2', '1', '1', '237');
INSERT INTO `seat` VALUES ('1000013', '2', '3', '1', '0', '238');
INSERT INTO `seat` VALUES ('1000013', '2', '4', '1', '0', '239');
INSERT INTO `seat` VALUES ('1000013', '2', '5', '1', '0', '240');
INSERT INTO `seat` VALUES ('1000013', '2', '6', '1', '1', '241');
INSERT INTO `seat` VALUES ('1000013', '3', '0', '1', '1', '242');
INSERT INTO `seat` VALUES ('1000013', '3', '1', '1', '1', '243');
INSERT INTO `seat` VALUES ('1000013', '3', '2', '1', '1', '244');
INSERT INTO `seat` VALUES ('1000013', '3', '3', '1', '1', '245');
INSERT INTO `seat` VALUES ('1000013', '3', '4', '1', '0', '246');
INSERT INTO `seat` VALUES ('1000013', '3', '5', '1', '0', '247');
INSERT INTO `seat` VALUES ('1000013', '3', '6', '1', '0', '248');
INSERT INTO `seat` VALUES ('1000013', '4', '0', '1', '0', '249');
INSERT INTO `seat` VALUES ('1000013', '4', '1', '1', '0', '250');
INSERT INTO `seat` VALUES ('1000016', '0', '0', '0', '0', '251');
INSERT INTO `seat` VALUES ('1000016', '0', '1', '0', '0', '252');
INSERT INTO `seat` VALUES ('1000016', '0', '2', '0', '0', '253');
INSERT INTO `seat` VALUES ('1000016', '0', '3', '0', '0', '254');
INSERT INTO `seat` VALUES ('1000016', '0', '4', '0', '0', '255');
INSERT INTO `seat` VALUES ('1000016', '0', '5', '0', '0', '256');
INSERT INTO `seat` VALUES ('1000016', '0', '6', '0', '0', '257');
INSERT INTO `seat` VALUES ('1000016', '1', '0', '0', '0', '258');
INSERT INTO `seat` VALUES ('1000016', '1', '1', '0', '0', '259');
INSERT INTO `seat` VALUES ('1000016', '1', '2', '0', '0', '260');
INSERT INTO `seat` VALUES ('1000016', '1', '3', '0', '0', '261');
INSERT INTO `seat` VALUES ('1000016', '1', '4', '0', '0', '262');
INSERT INTO `seat` VALUES ('1000016', '1', '5', '0', '0', '263');
INSERT INTO `seat` VALUES ('1000016', '1', '6', '0', '0', '264');
INSERT INTO `seat` VALUES ('1000016', '2', '0', '0', '0', '265');
INSERT INTO `seat` VALUES ('1000016', '0', '0', '1', '0', '266');
INSERT INTO `seat` VALUES ('1000016', '0', '1', '1', '0', '267');
INSERT INTO `seat` VALUES ('1000016', '0', '2', '1', '0', '268');
INSERT INTO `seat` VALUES ('1000016', '0', '3', '1', '0', '269');
INSERT INTO `seat` VALUES ('1000016', '0', '4', '1', '0', '270');
INSERT INTO `seat` VALUES ('1000016', '0', '5', '1', '0', '271');
INSERT INTO `seat` VALUES ('1000016', '0', '6', '1', '0', '272');
INSERT INTO `seat` VALUES ('1000016', '1', '0', '1', '0', '273');
INSERT INTO `seat` VALUES ('1000016', '1', '1', '1', '0', '274');
INSERT INTO `seat` VALUES ('1000016', '1', '2', '1', '0', '275');
INSERT INTO `seat` VALUES ('1000016', '1', '3', '1', '0', '276');
INSERT INTO `seat` VALUES ('1000016', '1', '4', '1', '0', '277');
INSERT INTO `seat` VALUES ('1000016', '1', '5', '1', '0', '278');
INSERT INTO `seat` VALUES ('1000016', '1', '6', '1', '0', '279');
INSERT INTO `seat` VALUES ('1000016', '2', '0', '1', '0', '280');
INSERT INTO `seat` VALUES ('1000016', '2', '1', '1', '0', '281');
INSERT INTO `seat` VALUES ('1000016', '2', '2', '1', '0', '282');
INSERT INTO `seat` VALUES ('1000016', '2', '3', '1', '0', '283');
INSERT INTO `seat` VALUES ('1000016', '2', '4', '1', '0', '284');
INSERT INTO `seat` VALUES ('1000016', '2', '5', '1', '0', '285');
INSERT INTO `seat` VALUES ('1000016', '2', '6', '1', '0', '286');
INSERT INTO `seat` VALUES ('1000016', '3', '0', '1', '0', '287');
INSERT INTO `seat` VALUES ('1000016', '3', '1', '1', '0', '288');
INSERT INTO `seat` VALUES ('1000016', '3', '2', '1', '0', '289');
INSERT INTO `seat` VALUES ('1000016', '3', '3', '1', '0', '290');
INSERT INTO `seat` VALUES ('1000016', '3', '4', '1', '0', '291');
INSERT INTO `seat` VALUES ('1000016', '3', '5', '1', '0', '292');
INSERT INTO `seat` VALUES ('1000016', '3', '6', '1', '0', '293');
INSERT INTO `seat` VALUES ('1000016', '4', '0', '1', '0', '294');
INSERT INTO `seat` VALUES ('1000016', '4', '1', '1', '0', '295');
INSERT INTO `seat` VALUES ('1000017', '0', '0', '0', '0', '296');
INSERT INTO `seat` VALUES ('1000017', '0', '1', '0', '0', '297');
INSERT INTO `seat` VALUES ('1000017', '0', '2', '0', '0', '298');
INSERT INTO `seat` VALUES ('1000017', '0', '3', '0', '1', '299');
INSERT INTO `seat` VALUES ('1000017', '0', '4', '0', '0', '300');
INSERT INTO `seat` VALUES ('1000017', '0', '5', '0', '0', '301');
INSERT INTO `seat` VALUES ('1000017', '0', '6', '0', '0', '302');
INSERT INTO `seat` VALUES ('1000017', '1', '0', '0', '0', '303');
INSERT INTO `seat` VALUES ('1000017', '1', '1', '0', '0', '304');
INSERT INTO `seat` VALUES ('1000017', '1', '2', '0', '1', '305');
INSERT INTO `seat` VALUES ('1000017', '1', '3', '0', '1', '306');
INSERT INTO `seat` VALUES ('1000017', '1', '4', '0', '0', '307');
INSERT INTO `seat` VALUES ('1000017', '1', '5', '0', '0', '308');
INSERT INTO `seat` VALUES ('1000017', '1', '6', '0', '0', '309');
INSERT INTO `seat` VALUES ('1000017', '2', '0', '0', '0', '310');
INSERT INTO `seat` VALUES ('1000017', '2', '1', '0', '0', '311');
INSERT INTO `seat` VALUES ('1000017', '2', '2', '0', '0', '312');
INSERT INTO `seat` VALUES ('1000017', '2', '3', '0', '0', '313');
INSERT INTO `seat` VALUES ('1000017', '2', '4', '0', '0', '314');
INSERT INTO `seat` VALUES ('1000017', '2', '5', '0', '0', '315');
INSERT INTO `seat` VALUES ('1000017', '2', '6', '0', '0', '316');
INSERT INTO `seat` VALUES ('1000017', '3', '0', '0', '0', '317');
INSERT INTO `seat` VALUES ('1000017', '3', '1', '0', '0', '318');
INSERT INTO `seat` VALUES ('1000017', '3', '2', '0', '0', '319');
INSERT INTO `seat` VALUES ('1000017', '3', '3', '0', '0', '320');
INSERT INTO `seat` VALUES ('1000017', '3', '4', '0', '0', '321');
INSERT INTO `seat` VALUES ('1000017', '3', '5', '0', '0', '322');
INSERT INTO `seat` VALUES ('1000017', '3', '6', '0', '0', '323');
INSERT INTO `seat` VALUES ('1000017', '4', '0', '0', '0', '324');
INSERT INTO `seat` VALUES ('1000017', '4', '1', '0', '0', '325');
INSERT INTO `seat` VALUES ('1000017', '0', '0', '1', '0', '326');
INSERT INTO `seat` VALUES ('1000017', '0', '1', '1', '0', '327');
INSERT INTO `seat` VALUES ('1000017', '0', '2', '1', '0', '328');
INSERT INTO `seat` VALUES ('1000017', '0', '3', '1', '0', '329');
INSERT INTO `seat` VALUES ('1000017', '0', '4', '1', '0', '330');
INSERT INTO `seat` VALUES ('1000017', '0', '5', '1', '0', '331');
INSERT INTO `seat` VALUES ('1000017', '0', '6', '1', '0', '332');
INSERT INTO `seat` VALUES ('1000017', '1', '0', '1', '0', '333');
INSERT INTO `seat` VALUES ('1000017', '1', '1', '1', '0', '334');
INSERT INTO `seat` VALUES ('1000017', '1', '2', '1', '0', '335');
INSERT INTO `seat` VALUES ('1000017', '1', '3', '1', '0', '336');
INSERT INTO `seat` VALUES ('1000017', '1', '4', '1', '0', '337');
INSERT INTO `seat` VALUES ('1000017', '1', '5', '1', '0', '338');
INSERT INTO `seat` VALUES ('1000017', '1', '6', '1', '0', '339');
INSERT INTO `seat` VALUES ('1000017', '2', '0', '1', '0', '340');
INSERT INTO `seat` VALUES ('1000017', '2', '1', '1', '0', '341');
INSERT INTO `seat` VALUES ('1000017', '2', '2', '1', '0', '342');
INSERT INTO `seat` VALUES ('1000017', '2', '3', '1', '0', '343');
INSERT INTO `seat` VALUES ('1000017', '2', '4', '1', '0', '344');
INSERT INTO `seat` VALUES ('1000017', '2', '5', '1', '0', '345');
INSERT INTO `seat` VALUES ('1000017', '2', '6', '1', '0', '346');
INSERT INTO `seat` VALUES ('1000017', '3', '0', '1', '0', '347');
INSERT INTO `seat` VALUES ('1000017', '3', '1', '1', '0', '348');
INSERT INTO `seat` VALUES ('1000017', '3', '2', '1', '0', '349');
INSERT INTO `seat` VALUES ('1000017', '3', '3', '1', '0', '350');
INSERT INTO `seat` VALUES ('1000017', '3', '4', '1', '0', '351');
INSERT INTO `seat` VALUES ('1000017', '3', '5', '1', '0', '352');
INSERT INTO `seat` VALUES ('1000017', '3', '6', '1', '0', '353');
INSERT INTO `seat` VALUES ('1000017', '4', '0', '1', '0', '354');
INSERT INTO `seat` VALUES ('1000017', '4', '1', '1', '0', '355');

-- ----------------------------
-- Table structure for torder
-- ----------------------------
DROP TABLE IF EXISTS `torder`;
CREATE TABLE `torder` (
  `orderid` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `orderMethod` tinyint(4) NOT NULL,
  `ticketNum` int(4) NOT NULL,
  `ticketType` int(4) NOT NULL,
  `totalPrice` double(10,2) NOT NULL,
  `orderDate` varchar(50) CHARACTER SET utf8 NOT NULL,
  `showDate` varchar(50) CHARACTER SET utf8 NOT NULL,
  `payState` int(4) NOT NULL,
  `allocState` int(4) NOT NULL,
  `isCancelled` int(4) NOT NULL,
  `isSettled` int(4) NOT NULL,
  `hallNo` int(10) NOT NULL,
  `hallName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `showType` varchar(50) CHARACTER SET utf8 NOT NULL,
  `toption` int(11) NOT NULL,
  `minused` double(10,2) NOT NULL,
  `isChecked` int(4) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=1000049 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of torder
-- ----------------------------
INSERT INTO `torder` VALUES ('1000035', '549661085@qq.com', '0', '3', '1', '424.15', '2018-03-15 20:28:33', '2018-05-12 20:00:00', '1', '1', '1', '1', '1000001', '星德罗', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000036', '549661085@qq.com', '0', '3', '1', '540.00', '2018-03-15 20:33:40', '2018-05-12 20:00:00', '1', '1', '1', '1', '1000001', '星德罗', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000037', '549661085@qq.com', '0', '2', '0', '207.00', '2018-03-16 21:27:33', '2018-05-12 20:00:00', '1', '1', '0', '0', '1000001', '星德罗', '晚餐', '0', '10.00', '0');
INSERT INTO `torder` VALUES ('1000038', '549661085@qq.com', '0', '3', '1', '477.00', '2018-03-17 13:20:15', '2018-03-17 18:00:00', '1', '1', '1', '1', '1000001', '星德罗', '晚餐', '0', '10.00', '0');
INSERT INTO `torder` VALUES ('1000039', '549661085@qq.com', '0', '2', '0', '207.00', '2018-03-17 16:04:03', '2018-03-22 20:00:00', '1', '1', '1', '0', '1000001', '星德罗', '晚餐', '1', '10.00', '0');
INSERT INTO `torder` VALUES ('1000040', '549661085@qq.com', '0', '4', '1', '648.00', '2018-03-18 14:37:02', '2018-03-22 20:00:00', '1', '1', '1', '0', '1000001', '星德罗', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000041', '549661085@qq.com', '1', '1', '1', '153.00', '2018-03-18 14:47:21', '2018-03-22 20:00:00', '1', '1', '1', '1', '1000001', '星德罗', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000042', '549661085@qq.com', '0', '3', '0', '306.00', '2018-03-18 21:16:05', '2018-03-22 20:00:00', '1', '1', '1', '0', '1000001', '星德罗', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000043', '549661085@qq.com', '0', '2', '0', '204.00', '2018-03-19 16:10:08', '2018-03-22 20:00:00', '0', '1', '0', '0', '1000001', '星德罗', '音乐会', '0', '0.00', '2');
INSERT INTO `torder` VALUES ('1000044', '2196921853@qq.com', '0', '3', '0', '240.00', '2018-03-19 17:08:34', '2018-03-18 20:00:00', '1', '1', '1', '1', '1000003', '南京大学', '晚餐', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000045', '2196921853@qq.com', '0', '4', '0', '304.00', '2018-03-19 17:09:47', '2018-03-22 20:00:00', '1', '0', '1', '0', '1000003', '南京大学', '晚餐', '1', '0.00', '0');
INSERT INTO `torder` VALUES ('1000046', '2196921853@qq.com', '0', '2', '0', '216.00', '2018-03-19 17:00:50', '2018-03-22 20:00:00', '0', '1', '0', '0', '1000001', '星德罗', '音乐会', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000047', '2196921853@qq.com', '0', '3', '0', '324.00', '2018-03-19 17:11:09', '2018-03-22 20:00:00', '1', '1', '0', '0', '1000001', '星德罗', '音乐会', '0', '0.00', '0');
INSERT INTO `torder` VALUES ('1000048', '549661085@qq.com', '1', '3', '0', '306.00', '2018-03-19 17:12:55', '2018-03-18 20:00:00', '1', '1', '1', '1', '1000001', '星德罗', '音乐会', '0', '0.00', '1');

-- ----------------------------
-- Table structure for tupdate
-- ----------------------------
DROP TABLE IF EXISTS `tupdate`;
CREATE TABLE `tupdate` (
  `hallNo` int(10) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `hallName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 NOT NULL,
  `juniorNum` int(10) NOT NULL,
  `seniorNum` int(10) NOT NULL,
  `income` double(10,2) NOT NULL,
  `percent` double(10,2) NOT NULL,
  PRIMARY KEY (`hallNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tupdate
-- ----------------------------
