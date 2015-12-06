/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : expresssystem

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-12-06 15:47:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for geter
-- ----------------------------
DROP TABLE IF EXISTS `geter`;
CREATE TABLE `geter` (
  `gid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `gname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gcity` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gcityadd` varchar(64) CHARACTER SET utf8 NOT NULL,
  `gphone` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsid` int(10) unsigned NOT NULL,
  `number` int(10) unsigned NOT NULL,
  `weight` float(10,3) unsigned NOT NULL,
  `volume` float(10,6) unsigned NOT NULL,
  `goodsname` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `lid` int(10) NOT NULL,
  `sid` int(10) unsigned zerofill NOT NULL,
  `gid` int(10) unsigned zerofill NOT NULL,
  `goodsid` int(10) unsigned NOT NULL,
  `type` varchar(64) CHARACTER SET utf8 NOT NULL,
  `wrap` varchar(64) CHARACTER SET utf8 NOT NULL,
  `price` float(10,2) unsigned NOT NULL,
  PRIMARY KEY (`lid`),
  KEY `sid` (`sid`),
  KEY `gid` (`gid`),
  KEY `goodsid` (`goodsid`),
  CONSTRAINT `gid` FOREIGN KEY (`gid`) REFERENCES `geter` (`gid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goodsid` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`goodsid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `sender` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for sender
-- ----------------------------
DROP TABLE IF EXISTS `sender`;
CREATE TABLE `sender` (
  `sid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `sname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `scity` varchar(64) CHARACTER SET utf8 NOT NULL,
  `scityadd` varchar(64) CHARACTER SET utf8 NOT NULL,
  `sphone` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `uname` varchar(64) CHARACTER SET utf8 NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 NOT NULL,
  `identity` varchar(64) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
