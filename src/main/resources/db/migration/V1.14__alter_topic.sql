ALTER TABLE `topic` ADD `check_status` INTEGER (11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `back_content` VARCHAR(255) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `score` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `paid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `aid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `topic` ADD `cid` INTEGER(11) NULL  DEFAULT NULL  AFTER `good`;
ALTER TABLE `comment` ADD `check_status` INTEGER (11) NULL  DEFAULT NULL  AFTER `content`;
ALTER TABLE `comment` ADD `back_content` VARCHAR(255) NULL  DEFAULT NULL  AFTER `content`;

# Dump of table area
# ------------------------------------------------------------

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `aid` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


