/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.171
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2019-01-07 18:32:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pub_user
-- ----------------------------
DROP TABLE IF EXISTS `pub_user`;
CREATE TABLE `pub_user` (
  `code` varchar(255) NOT NULL COMMENT '主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


