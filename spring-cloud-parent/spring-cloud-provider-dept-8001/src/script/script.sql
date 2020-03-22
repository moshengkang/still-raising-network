DROP DATABASE IF EXISTS `cloud_db_one`;
CREATE DATABASE `cloud_db_one` CHARACTER SET utf8 COLLATE utf8_bin;
USE cloud_db_one;
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_no` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(500) DEFAULT NULL,
  `db_source` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', 'IT', DATABASE());
INSERT INTO `dept` VALUES ('2', 'HR', DATABASE());
INSERT INTO `dept` VALUES ('3', 'MIS', DATABASE());
INSERT INTO `dept` VALUES ('4', 'FUN', DATABASE());
INSERT INTO `dept` VALUES ('5', 'WM', DATABASE());
INSERT INTO `dept` VALUES ('6', 'EI', DATABASE());
INSERT INTO `dept` VALUES ('7', 'UU', DATABASE());
