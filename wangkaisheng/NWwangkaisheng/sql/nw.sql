/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - nw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nw`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(20) NOT NULL,
  `activity_content` varchar(200) NOT NULL,
  `activity_date` date NOT NULL,
  `activity_address` varchar(20) NOT NULL,
  `activity_organizer` varchar(20) NOT NULL,
  `activity_person` varchar(20) NOT NULL,
  `activity_phone` varchar(20) NOT NULL,
  `activity_oid` int(11) NOT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `ac_or_fk` (`activity_oid`),
  CONSTRAINT `ac_or_fk` FOREIGN KEY (`activity_oid`) REFERENCES `organizer` (`organizer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`activity_id`,`activity_name`,`activity_content`,`activity_date`,`activity_address`,`activity_organizer`,`activity_person`,`activity_phone`,`activity_oid`) values (1,'11','1111','2020-11-11','111','守夜人','不知名的帅哥靓女','13577766666',1);

/*Table structure for table `activitying` */

DROP TABLE IF EXISTS `activitying`;

CREATE TABLE `activitying` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(20) NOT NULL,
  `activity_content` varchar(200) NOT NULL,
  `activity_date` date NOT NULL,
  `activity_address` varchar(20) NOT NULL,
  `activity_organizer` varchar(20) NOT NULL,
  `activity_person` varchar(20) NOT NULL,
  `activity_phone` varchar(20) NOT NULL,
  `activity_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `acing_or_fk` (`activity_oid`),
  CONSTRAINT `acing_or_fk` FOREIGN KEY (`activity_oid`) REFERENCES `organizer` (`organizer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `activitying` */

insert  into `activitying`(`activity_id`,`activity_name`,`activity_content`,`activity_date`,`activity_address`,`activity_organizer`,`activity_person`,`activity_phone`,`activity_oid`) values (3,'蓝蓝','啊啊啊','2020-11-11','哄','11','11','11',2),(5,'11','312312','2020-11-11','222','守夜人','不知名的帅哥靓女','13577766666',1),(6,'333','1333','2020-11-11','333','守夜人','不知名的帅哥靓女','13577766666',1),(7,'333','1113','2020-11-22','2020','守夜人','不知名的帅哥靓女','13577766666',1),(8,'3123','111','2020-11-11','222','守夜人','不知名的帅哥靓女','13577766666',1),(9,'11','444','2020-11-11','22','守夜人','不知名的帅哥靓女','13577766666',1);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(20) NOT NULL,
  `notice_content` varchar(200) NOT NULL,
  `notice_date` date NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`notice_id`,`notice_title`,`notice_content`,`notice_date`) values (1,'一滴','第一','2021-04-09');

/*Table structure for table `organizer` */

DROP TABLE IF EXISTS `organizer`;

CREATE TABLE `organizer` (
  `organizer_id` int(11) NOT NULL AUTO_INCREMENT,
  `organizername` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `associationname` varchar(20) NOT NULL,
  `personname` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `introduction` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`organizer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `organizer` */

insert  into `organizer`(`organizer_id`,`organizername`,`password`,`associationname`,`personname`,`phone`,`introduction`) values (1,'11','1','守夜人','不知名的帅哥靓女','13577766666','这是一个帅哥靓女云集的地方。'),(2,'12','11','11','11','11','11'),(3,'1','1','1','1','1','123');

/*Table structure for table `organizering` */

DROP TABLE IF EXISTS `organizering`;

CREATE TABLE `organizering` (
  `organizer_id` int(11) NOT NULL AUTO_INCREMENT,
  `organizername` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `associationname` varchar(20) NOT NULL,
  `personname` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `introduction` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`organizer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `organizering` */

insert  into `organizering`(`organizer_id`,`organizername`,`password`,`associationname`,`personname`,`phone`,`introduction`) values (3,'2','2','2','2','2','2');

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) NOT NULL,
  `filename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `picture_activity_fk` (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `picture` */

insert  into `picture`(`picture_id`,`nid`,`filename`) values (5,1,'images\\20210414222002.jfif');

/*Table structure for table `timeactivity` */

DROP TABLE IF EXISTS `timeactivity`;

CREATE TABLE `timeactivity` (
  `u_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`u_c_id`),
  KEY `time_user_fk` (`uid`),
  KEY `time_activity_fk` (`cid`),
  CONSTRAINT `time_activity_fk` FOREIGN KEY (`cid`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `time_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `timeactivity` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `gender` varchar(4) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `alltime` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`gender`,`age`,`phone`,`alltime`) values (1,'1','2','1','女',19,'3',4),(3,'2','3','3','女',2,'2',0);

/*Table structure for table `user_activity` */

DROP TABLE IF EXISTS `user_activity`;

CREATE TABLE `user_activity` (
  `u_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`u_c_id`),
  KEY `u_fk` (`uid`),
  KEY `a_fk` (`cid`),
  CONSTRAINT `a_fk` FOREIGN KEY (`cid`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_activity` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
