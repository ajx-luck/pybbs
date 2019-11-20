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
  `use_time` int(13) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



