
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) NOT NULL,
  `png_url` varchar(255) DEFAULT NULL,
  `QR_url` varchar(255) DEFAULT NULL,
  `vote_count` int(11) NOT NULL,
  `heat_value` int(11) NOT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `main_page`;
CREATE TABLE `main_page` (
  `project_amount` int(12) NOT NULL,
  `vote_amount` int(12) NOT NULL,
  `view_amount` int(12) NOT NULL,
  `png_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `main_page` VALUES
  (123,456,789,'www.baidu.com');