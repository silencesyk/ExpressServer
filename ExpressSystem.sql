/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : expresssystem

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-12-20 14:44:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `lid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `type` varchar(64) CHARACTER SET utf8 NOT NULL,
  `wrap` varchar(64) CHARACTER SET utf8 NOT NULL,
  `price` varchar(10) CHARACTER SET utf8 NOT NULL,
  `sname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `scity` varchar(64) CHARACTER SET utf8 NOT NULL,
  `scityadd` varchar(64) CHARACTER SET utf8 NOT NULL,
  `sphone` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gcity` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gcityadd` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gphone` varchar(64) CHARACTER SET utf8 NOT NULL,
  `number` varchar(10) CHARACTER SET utf8 NOT NULL,
  `weight` varchar(10) CHARACTER SET utf8 NOT NULL,
  `volume` varchar(10) CHARACTER SET utf8 NOT NULL,
  `goodsname` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `statusid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `lid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `status` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`statusid`),
  KEY `lid` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 NOT NULL,
  `identity` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
