# Dump of table member
# ------------------------------------------------------------

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `pay_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `money` int(11) NOT NULL DEFAULT '0',
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`),
  UNIQUE KEY `type_id` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dump of table pay_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pay_info`;

CREATE TABLE `pay_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `money` int(11) NOT NULL DEFAULT '0',
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `pay_status` int(11) NOT NULL,
  `trade_no` varchar(255) DEFAULT NULL,
  `pay_type` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table member_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `member_type`;

CREATE TABLE `member_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` int(11) NOT NULL DEFAULT '0',
  `current_money` int(11) NOT NULL DEFAULT '0',
  `use_time` bigint(50) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `member_type` (`id`,`name`, `money`, `current_money`,`use_time`)
VALUES
	(1,'季度会员', 29800, 19800,7776000000);

INSERT INTO `member_type` (`id`,`name`, `money`, `current_money`,`use_time`)
VALUES
	(2,'年度会员', 89800, 59800,31536000000);

INSERT INTO `member_type` (`id`,`name`, `money`, `current_money`,`use_time`)
VALUES
	(3,'终身会员', 89800, 59800,3153600000000);


