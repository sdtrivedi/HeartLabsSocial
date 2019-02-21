-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer_table`
--

DROP TABLE IF EXISTS `answer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer_table` (
  `answer_id` int(11) NOT NULL,
  `response` varchar(255) DEFAULT NULL,
  `question_question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FKx9l3hwun3a0sihxv4gkur7s` (`question_question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_table`
--

LOCK TABLES `answer_table` WRITE;
/*!40000 ALTER TABLE `answer_table` DISABLE KEYS */;
INSERT INTO `answer_table` VALUES (65,'4/5',50),(66,'New Optiondagas',51),(85,'5/5',50),(86,'New Optiondagas',51),(100,'Upendra Singh',89),(101,'Male',90),(102,'7/10',91),(103,'10/10',92),(107,'Jdasfasf',89),(108,'Female',90),(109,'8/10',91),(110,'7/10',92),(132,'bxcbxcznbcx',89),(133,'Female',90),(134,'6/(10)',91),(135,'7/(10)',92),(139,'hasfdfjasfh',89),(140,'Female',90),(141,'7/(10)',91),(142,'2/(10)',92);
/*!40000 ALTER TABLE `answer_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_table`
--

DROP TABLE IF EXISTS `credit_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_table` (
  `credit_id` int(11) NOT NULL AUTO_INCREMENT,
  `credits` int(11) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`credit_id`),
  KEY `FKlv0xsnsigrhfr57j9frws2afp` (`user_user_id`),
  CONSTRAINT `FKlv0xsnsigrhfr57j9frws2afp` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_table`
--

LOCK TABLES `credit_table` WRITE;
/*!40000 ALTER TABLE `credit_table` DISABLE KEYS */;
INSERT INTO `credit_table` VALUES (1,73,'2018-05-14 01:49:25',4),(2,2,'2018-05-02 02:56:46',5),(3,34,'2018-05-14 01:24:07',10),(4,9,'2018-05-14 01:48:30',9),(5,2,'2018-05-02 02:56:30',8),(6,1,'2018-05-02 02:57:12',16),(7,5,'2018-05-13 15:17:22',19),(115,2,'2018-05-14 00:11:10',11);
/*!40000 ALTER TABLE `credit_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (145),(145),(145),(145),(145);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_receiver`
--

DROP TABLE IF EXISTS `message_receiver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_receiver` (
  `message_id` int(11) NOT NULL,
  `receivers_user_id` int(11) NOT NULL,
  KEY `FKc7hu7xk1owtwfyy910kxh2kox` (`receivers_user_id`),
  KEY `FK53c67gao97yuqv63donrpwhvf` (`message_id`),
  CONSTRAINT `FK53c67gao97yuqv63donrpwhvf` FOREIGN KEY (`message_id`) REFERENCES `message_table` (`message_id`),
  CONSTRAINT `FKc7hu7xk1owtwfyy910kxh2kox` FOREIGN KEY (`receivers_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_receiver`
--

LOCK TABLES `message_receiver` WRITE;
/*!40000 ALTER TABLE `message_receiver` DISABLE KEYS */;
INSERT INTO `message_receiver` VALUES (1,4),(1,5),(1,6),(1,8),(1,10),(1,11),(1,13),(1,15),(1,16),(1,17),(1,19),(1,20),(1,21),(1,22),(2,4),(2,5),(2,6),(2,8),(2,10),(2,11),(2,13),(2,15),(2,16),(2,17),(2,19),(2,20),(2,21),(2,22),(3,7),(4,4),(4,5),(4,6),(4,8),(4,10),(4,11),(4,13),(4,15),(4,16),(4,17),(4,19),(4,20),(4,21),(4,22),(5,4),(5,5),(5,6),(5,8),(5,10),(5,11),(5,13),(5,15),(5,16),(5,17),(5,19),(5,20),(5,21),(5,22),(6,4),(6,5),(6,6),(6,8),(6,10),(6,11),(6,13),(6,15),(6,16),(6,17),(6,19),(6,20),(6,21),(6,22),(7,10),(8,4),(8,5),(8,6),(8,8),(8,10),(8,11),(8,13),(8,15),(8,16),(8,17),(8,19),(8,20),(8,21),(8,22),(9,4),(9,5),(9,6),(9,8),(9,10),(9,11),(9,13),(9,15),(9,16),(9,17),(9,19),(9,20),(9,21),(9,22),(10,4),(10,5),(10,6),(10,8),(10,10),(10,11),(10,13),(10,15),(10,16),(10,17),(10,19),(10,20),(10,21),(10,22),(11,4),(11,5),(11,6),(11,8),(11,10),(11,11),(11,13),(11,15),(11,16),(11,17),(11,19),(11,20),(11,21),(11,22),(12,4),(12,5),(12,6),(12,8),(12,10),(12,11),(12,13),(12,15),(12,16),(12,17),(12,19),(12,20),(12,21),(12,22),(13,4),(13,5),(13,6),(13,8),(13,10),(13,11),(13,13),(13,15),(13,16),(13,17),(13,19),(13,20),(13,21),(13,22),(14,4),(14,5),(14,6),(14,8),(14,10),(14,11),(14,13),(14,15),(14,16),(14,17),(14,19),(14,20),(14,21),(14,22),(15,4),(15,5),(15,6),(15,8),(15,10),(15,11),(15,13),(15,15),(15,16),(15,17),(15,19),(15,20),(15,21),(15,22),(16,4),(16,5),(16,6),(16,8),(16,9),(16,10),(16,11),(16,13),(16,15),(16,16),(16,17),(16,19),(16,20),(16,21),(16,22),(17,9),(119,4),(119,5),(119,6),(119,8),(119,9),(119,10),(119,11),(119,13),(119,15),(119,16),(119,17),(119,19),(119,20),(119,21),(119,22);
/*!40000 ALTER TABLE `message_receiver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_table`
--

DROP TABLE IF EXISTS `message_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_table` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` text,
  `sent_timestamp` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sender_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FKg1d9dq25v179mcu49foe6t55q` (`sender_user_id`),
  CONSTRAINT `FKg1d9dq25v179mcu49foe6t55q` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_table`
--

LOCK TABLES `message_table` WRITE;
/*!40000 ALTER TABLE `message_table` DISABLE KEYS */;
INSERT INTO `message_table` VALUES (1,'fasfsav','2018-04-06 02:38:13',2,1,4),(2,'fasfasfa','2018-04-06 02:38:16',2,1,4),(3,'gdfjtjfgn fd','2018-04-06 02:38:25',1,2,4),(4,'Complete first survey.\r\n\r\nhttps://www.youtube.com/watch?v=hchJmTf4x0Y&list=RDMMmhz4LV9kJQY&index=18','2018-04-06 02:39:10',2,1,4),(5,'Data type	Description\r\nCHAR(size)	Holds a fixed length string (can contain letters, numbers, and special characters). The fixed size is specified in parenthesis. Can store up to 255 characters\r\nVARCHAR(size)	Holds a variable length string (can contain letters, numbers, and special characters). The maximum size is specified in parenthesis. Can store up to 255 characters. Note: If you put a greater value than 255 it will be converted to a TEXT type\r\nTINYTEXT	Holds a string with a maximum length of 255 characters\r\nTEXT	Holds a string with a maximum length of 65,535 characters\r\nBLOB	For BLOBs (Binary Large OBjects). Holds up to 65,535 bytes of data\r\nMEDIUMTEXT	Holds a string with a maximum length of 16,777,215 characters\r\nMEDIUMBLOB	For BLOBs (Binary Large OBjects). Holds up to 16,777,215 bytes of data\r\nLONGTEXT	Holds a string with a maximum length of 4,294,967,295 characters\r\nLONGBLOB	For BLOBs (Binary Large OBjects). Holds up to 4,294,967,295 bytes of data\r\nENUM(x,y,z,etc.)	Let you enter a list of possible values. You can list up to 65535 values in an ENUM list. If a value is inserted that is not in the list, a blank value will be inserted.\r\nNote: The values are sorted in the order you enter them.\r\n\r\nYou enter the possible values in this format: ENUM(\'X\',\'Y\',\'Z\')\r\nSET	Similar to ENUM except that SET may contain up to 64 list items and can store more than one choice\r\nNumber data types:\r\nData type	Description\r\nTINYINT(size)	-128 to 127 normal. 0 to 255 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nSMALLINT(size)	-32768 to 32767 normal. 0 to 65535 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nMEDIUMINT(size)	-8388608 to 8388607 normal. 0 to 16777215 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nINT(size)	-2147483648 to 2147483647 normal. 0 to 4294967295 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nBIGINT(size)	-9223372036854775808 to 9223372036854775807 normal. 0 to 18446744073709551615 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nFLOAT(size,d)	A small number with a floating decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\nDOUBLE(size,d)	A large number with a floating decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\nDECIMAL(size,d)	A DOUBLE stored as a string , allowing for a fixed decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\n','2018-04-06 02:47:29',2,1,4),(6,'To change the data type of a column in a table, use the following syntax:\r\n\r\nSQL Server / MS Access:','2018-04-06 02:55:12',2,1,4),(7,'gbdsndf b  fbeab dfbfdnbdfnd','2018-04-06 03:09:07',2,2,4),(8,'This test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\nHave fun and take your time!\r\nThere is zero tolerance for cheating, plagiarizing, sharing code, etc. ','2018-04-06 03:25:14',2,1,4),(9,'This test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\n\r\n\r\n\r\n Have fun and take your time!\r\n\r\n\r\n\r\n\r\n There is zero tolerance for cheating, plagiarizing, sharing code, etc. ','2018-04-06 03:26:23',2,1,4),(10,'Instructions\r\nThis test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\nHave fun and take your time!\r\nThere is zero tolerance for cheating, plagiarizing, sharing code, etc. \r\nThis is a programming test\r\nTo get familiarized with our coding environment, try our Sample Test\r\nYou are free to choose any language from the list and code\r\nIf the code area contains the function signature, just complete the function alone, we\'ll take care of the main function, headers, etc\r\nIf you\'re expected to write the full code, it\'d be mentioned in the code area. All inputs are from STDIN and output to STDOUT. If you\'re using Java, use the classname as \'Solution\'\r\nTo understand more about the environment, time limits, etc. you can read the FAQ here\r\nYou can print to console to debug your code using the appropriate print command for each language (Eg: cout for C++, printf for C, etc.)\r\nhttps://www.hackerrank.com/tests/a5ccreio2qs/f885f28d6efe34cb05421bdec3176315','2018-04-06 03:28:24',2,1,4),(11,'Hello \\n \\n\r\n\r\nfacebook.com','2018-04-06 03:29:46',2,1,4),(12,'<p>\r\n  Hello\r\n<p>\r\n<p>\r\nWorld\r\n<p>\r\n\r\n','2018-04-06 03:30:33',2,1,4),(13,'<p>Complete Survey</p>\r\n\r\n<a href=\"#\">Complete Survey</a>','2018-04-06 03:32:58',2,1,4),(14,'<p>Annoucement Content goes here...</p><a href=\"www.youtube.come\">Link</a>','2018-04-06 03:36:36',2,1,4),(15,'<p>Complete survey 3 before Saturday afternoon</p>\r\n\r\n<p>Anyone who can design amazing graphics stuff, Anyone who knows the main web technologies, Anyone who can create cool GIFs and vector-based motion graphics, Come join us!</p>\r\n\r\n\r\n<a href=\"https://lnkd.in/eFzJAHWe\">Survey 3</a>','2018-04-06 03:39:53',2,1,4),(16,'<p>Annoucement Content goes here...</p><a href=\"www.youtube.come\">Link</a>','2018-04-07 18:44:21',2,1,4),(17,'Get all messages, please sign up. ','2018-04-09 21:20:42',2,2,4),(119,'<p>Hello to everyone!!!</p>','2018-05-14 00:10:47',2,1,4);
/*!40000 ALTER TABLE `message_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_table`
--

DROP TABLE IF EXISTS `post_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_table` (
  `post_id` int(11) NOT NULL,
  `display_time` varchar(255) DEFAULT NULL,
  `isvideo` int(11) DEFAULT NULL,
  `post_content` text,
  `status` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video_link` varchar(255) DEFAULT NULL,
  `posted_by_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKscig6x773xg36ffk4ae386cxr` (`posted_by_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_table`
--

LOCK TABLES `post_table` WRITE;
/*!40000 ALTER TABLE `post_table` DISABLE KEYS */;
INSERT INTO `post_table` VALUES (41,'1 month ago',1,'Hello World!!',1,'2018-05-13 01:34:20','',4),(117,'1 month ago',2,'Best of Big Bang Theory - Family Part 2 - \"The Coopers\"',1,'2018-05-14 00:09:32','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/_e9t8nJhIhQ\"></iframe>',11);
/*!40000 ALTER TABLE `post_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `published_survey_table`
--

DROP TABLE IF EXISTS `published_survey_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `published_survey_table` (
  `published_survey_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `ends_at` datetime DEFAULT NULL,
  `submission_count` int(11) DEFAULT NULL,
  `survey_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `question_val` int(11) DEFAULT NULL,
  PRIMARY KEY (`published_survey_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `published_survey_table`
--

LOCK TABLES `published_survey_table` WRITE;
/*!40000 ALTER TABLE `published_survey_table` DISABLE KEYS */;
INSERT INTO `published_survey_table` VALUES (97,'2018-05-13 15:41:43','2018-05-13 23:55:00',2,88,'Weekly survey 2',92,4),(127,'2018-05-14 01:02:14','2018-05-15 23:59:00',2,88,'Weekly survey 2',92,4);
/*!40000 ALTER TABLE `published_survey_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_options_table`
--

DROP TABLE IF EXISTS `question_options_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_options_table` (
  `question_id` int(11) NOT NULL,
  `option_content` varchar(255) DEFAULT NULL,
  `option_id` int(11) DEFAULT NULL,
  KEY `FKk5eaqdjtt5mgn8gxcb4m3r8pr` (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_options_table`
--

LOCK TABLES `question_options_table` WRITE;
/*!40000 ALTER TABLE `question_options_table` DISABLE KEYS */;
INSERT INTO `question_options_table` VALUES (20,'Male',0),(20,'Female',1),(21,'F1',1),(21,'US Citizen',2),(19,'First and last name',0),(21,'Green Card',0),(37,'0',0),(37,'10',1),(45,'M',0),(45,'F',1),(46,'Short',0),(47,'Mesa',2),(47,'Tempe',0),(47,'Phoenix',1),(48,'10',1),(48,'0',0),(50,'0',0),(50,'5',1),(51,'New Optiondagasd',1),(51,'New Optiongsdg',0),(89,'',0),(90,'Male',0),(90,'Female',1),(91,'0',0),(91,'10',1),(92,'0',0),(92,'10',1);
/*!40000 ALTER TABLE `question_options_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_table`
--

DROP TABLE IF EXISTS `question_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_table` (
  `question_id` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_table`
--

LOCK TABLES `question_table` WRITE;
/*!40000 ALTER TABLE `question_table` DISABLE KEYS */;
INSERT INTO `question_table` VALUES (50,0,'sgddsga',3),(51,1,'gsdgds',2),(89,0,'Name?',4),(90,1,'Gender?',1),(91,2,'Happy?',3),(92,3,'Sad?',3);
/*!40000 ALTER TABLE `question_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER'),(4,'SuperAdmin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_answer_table`
--

DROP TABLE IF EXISTS `survey_answer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_answer_table` (
  `survey_response_id` int(11) NOT NULL,
  `answer_id` int(11) NOT NULL,
  UNIQUE KEY `UK_7frr5qheokxw5ui09qb68nyvm` (`answer_id`),
  KEY `FKn332fb0taob3sqpnlo7p7xho8` (`survey_response_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_answer_table`
--

LOCK TABLES `survey_answer_table` WRITE;
/*!40000 ALTER TABLE `survey_answer_table` DISABLE KEYS */;
INSERT INTO `survey_answer_table` VALUES (99,100),(99,101),(99,102),(99,103),(106,107),(106,108),(106,109),(106,110),(131,132),(131,133),(131,134),(131,135),(138,139),(138,140),(138,141),(138,142);
/*!40000 ALTER TABLE `survey_answer_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_questions`
--

DROP TABLE IF EXISTS `survey_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_questions` (
  `survey_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  UNIQUE KEY `UK_2dqpxn7bp92w6wskj9k15s4hw` (`question_id`),
  KEY `FKr2j2qj61drqyvw6uq8c5nupev` (`survey_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_questions`
--

LOCK TABLES `survey_questions` WRITE;
/*!40000 ALTER TABLE `survey_questions` DISABLE KEYS */;
INSERT INTO `survey_questions` VALUES (49,50),(49,51),(88,89),(88,90),(88,91),(88,92);
/*!40000 ALTER TABLE `survey_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_response_table`
--

DROP TABLE IF EXISTS `survey_response_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_response_table` (
  `survey_response_id` int(11) NOT NULL,
  `survey_published_id` int(11) DEFAULT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `survey_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`survey_response_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_response_table`
--

LOCK TABLES `survey_response_table` WRITE;
/*!40000 ALTER TABLE `survey_response_table` DISABLE KEYS */;
INSERT INTO `survey_response_table` VALUES (99,97,'2018-05-13 15:42:10',88,10),(106,97,'2018-05-13 16:24:17',88,9),(131,127,'2018-05-14 01:48:05',88,10),(138,127,'2018-05-14 01:48:48',88,9);
/*!40000 ALTER TABLE `survey_response_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_table`
--

DROP TABLE IF EXISTS `survey_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_table` (
  `survey_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`survey_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_table`
--

LOCK TABLES `survey_table` WRITE;
/*!40000 ALTER TABLE `survey_table` DISABLE KEYS */;
INSERT INTO `survey_table` VALUES (49,'2018-05-13 03:05:54',0,'Survey Titledsgsd','2018-05-13 03:06:39'),(88,'2018-05-13 15:12:47',0,'Weekly survey 2','2018-05-13 15:12:47');
/*!40000 ALTER TABLE `survey_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_table_questions`
--

DROP TABLE IF EXISTS `survey_table_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey_table_questions` (
  `survey_survey_id` int(11) NOT NULL,
  `questions_question_id` int(11) NOT NULL,
  UNIQUE KEY `UK_l23vxvjij36exhjm45ygyaikk` (`questions_question_id`),
  KEY `FKqy3v09mhvp9cp2qkt6rsjo6db` (`survey_survey_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_table_questions`
--

LOCK TABLES `survey_table_questions` WRITE;
/*!40000 ALTER TABLE `survey_table_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_table_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,1,'usingh8@asu.edu','Singh','Upendra','$2a$10$XZk1bCUgxzkk6Bnmay1Mau64Bx9SIraILQKL9WIjE0hJHgpFOm1mi',NULL),(5,1,'ajain122@asu.edu','Jain','Akshay','$2a$10$XZk1bCUgxzkk6Bnmay1Mau64Bx9SIraILQKL9WIjE0hJHgpFOm1mi',NULL),(6,1,'manjul.pathak@tcs.com','Pathak','Manjul','$2a$10$ysU06sD/zW.mgXa1PoZ7nuNNr/l3qbalsmIFv.r.5iZPammyEsA5m',NULL),(7,2,'kapil.gupta.1@asu.edu','Gupta','Kapil','$2a$10$/rl7chXQKKvIth9sg3eMzefB8McZ1hinsnKyjEmJEg3VGi5C2TXN2',NULL),(8,1,'abhijith@asu.edu','Kirshnan','Abhijith','$2a$10$nrn2B1BDx.6i5onwNimDvOGfvSmSQqqE0c.MCUOog4yI6JFIbaO6.',NULL),(9,1,'jsutton4@asu.edu','Sutton','Jasmine','$2a$10$zbzqpHzjaHftsDe4l13f7eAp5.q1gNMNNAp283YWxF4C.1Upp15oW',NULL),(10,1,'asr@asu.edu','Saxena','Anjali','$2a$10$dzyk/lQejQMAAVdFl.mvZuVpRYue6SEwas8m2Ioj8L7d0iDXABA/W',NULL),(11,1,'jimmy@asu.edu','Daie','Jimmy','$2a$10$cvlkfOiRBoRBW6xjSn692.awAyPsfRHwrUFJMBXnPgLxo/Rwpcv1i',NULL),(12,2,'test_user@asu.edu','user','test_user','$2a$10$lBLNTpvHEqjm4vsNTvmafOeCzYXKL/YH0FWh9aXkh7S.g5y6KkKfW',NULL),(13,1,'upendra@asu.edu','dda','Shara','$2a$10$qITvTjvNFQJbt7nQRQtJZeeJ1pov3yoXtUemEGY6Kh7gtnOrjAsDC',NULL),(14,2,'ayushr@asu.edu','Ruchandani','Ayush','$2a$10$aOZ5qJkJctxW0i4tJxgsFeCLuI/1XHwU14OR8V5PIZETrJ9J8OFuq',NULL),(15,1,'ayushr1@asu.edu','Ruchandani','Ayush','$2a$10$MaGh0AaNYQf0uVARQ4YY9u2ZBujPs1jDj5Igkhw/iVaQYOFtUGBZy',NULL),(16,1,'asfa@asa.casf','adsda','asdas','$2a$10$dayALwON44I3m/MaBo0iiupYPLZJdlTSlX8B3Ct8labxCMbXGXlQa',NULL),(17,1,'kapil.gua.1@asu.edu','Gupta','Kapil Gupta','$2a$10$dwi/zg0.0qlR7eMw0scZFeW5AUf4yiQ23yf2UTYN7EVePxpAIcM8K',NULL),(18,2,'usingh8@asu.ed','Singh','Upendra Singh','$2a$10$vYRWXAEQoVrJ7FuE9JDAwe7oYUsyL/3CPBN1imwPzPjN0UBeNIjBe',NULL),(19,1,'usingh8@gmail.com','Singh','Upendra Singh','$2a$10$7jDiDkvFZBNdvYZJd78soeMr/2NJsUE.oT/s8YBoFcW2R5RKIy43O',NULL),(20,1,'dasda@3adas.gsds','asdasa','dfasfas','$2a$10$fMEsXnEbz7uQFtUzgOH29.vdd7hePZst0/XyKNH9CQJWWEuDur7PG',NULL),(21,1,'dasdsa2@afsfas','Singh','Upendra Singh','$2a$10$Dw/8/66c0u3mHT7apiTt/ekvvlatSIQtAKOZ627.elRhTvpSV/ul6',NULL),(22,1,'312321@eaefa.hjfg','casvasv','fafsdv','$2a$10$zRd3f8cl/t0hIZ7eYRkrnueRm0dDnOMg.LRI0O/IVfzY5/JdqFB8a',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,1),(5,1),(6,1),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermood`
--

DROP TABLE IF EXISTS `usermood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermood` (
  `id` int(11) NOT NULL,
  `mood_title` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermood`
--

LOCK TABLES `usermood` WRITE;
/*!40000 ALTER TABLE `usermood` DISABLE KEYS */;
INSERT INTO `usermood` VALUES (7,'Annoyed',5,'2018-05-12 16:13:24',4),(8,'Laugh',5,'2018-05-12 16:13:31',4),(12,'Laugh',5,'2018-05-12 16:46:51',10),(13,'Smile',5,'2018-05-12 17:01:59',4),(39,'Laugh',5,'2018-05-13 01:18:39',10),(40,'Smile',5,'2018-05-13 01:33:58',4),(42,'Annoyed',5,'2018-05-13 01:47:28',10),(43,'Annoyed',5,'2018-05-13 02:09:31',4),(53,'Laugh',5,'2018-05-13 03:29:36',10),(54,'Smile',5,'2018-05-13 03:32:25',4),(56,'Annoyed',5,'2018-05-13 03:33:10',10),(57,'Laugh',5,'2018-05-13 03:34:19',4),(60,'Laugh',5,'2018-05-13 03:41:39',4),(61,'Laugh',5,'2018-05-13 03:41:53',10),(63,'Laugh',5,'2018-05-13 03:43:54',10),(67,'Annoyed',5,'2018-05-13 03:47:54',4),(68,'Laugh',7,'2018-05-13 14:00:09',4),(69,'Laugh',5,'2018-05-13 14:00:33',9),(70,'VerySad',5,'2018-05-13 14:02:01',4),(71,'Laugh',5,'2018-05-13 14:02:24',10),(72,'Laugh',5,'2018-05-13 14:05:24',10),(73,'Annoyed',5,'2018-05-13 14:12:16',10),(74,'Laugh',5,'2018-05-13 14:12:44',9),(75,'Laugh',5,'2018-05-13 14:12:57',4),(77,'Laugh',5,'2018-05-13 14:14:10',10),(78,'Laugh',5,'2018-05-13 14:17:04',10),(79,'Annoyed',5,'2018-05-13 14:44:22',10),(80,'VerySad',5,'2018-05-13 14:45:14',4),(81,'Smile',5,'2018-05-13 14:46:43',9),(82,'VerySad',5,'2018-05-13 14:47:33',10),(83,'Laugh',5,'2018-05-13 14:56:19',10),(87,'Laugh',5,'2018-05-13 15:05:41',4),(93,'Annoyed',5,'2018-05-13 15:14:59',9),(94,'Laugh',5,'2018-05-13 15:17:25',19),(95,'Laugh',5,'2018-05-13 15:17:52',4),(98,'Laugh',5,'2018-05-13 15:41:55',10),(104,'VerySad',5,'2018-05-13 15:42:19',4),(105,'Annoyed',5,'2018-05-13 16:23:45',9),(111,'Annoyed',5,'2018-05-13 16:24:35',4),(112,'Laugh',5,'2018-05-13 22:30:12',4),(113,'Smile',5,'2018-05-13 22:34:20',4),(114,'Laugh',5,'2018-05-13 23:52:17',4),(116,'Laugh',5,'2018-05-14 00:09:02',11),(118,'Laugh',5,'2018-05-14 00:10:21',4),(120,'Sunglass',5,'2018-05-14 00:11:13',11),(121,'Smile',5,'2018-05-14 00:12:15',4),(122,'Smile',5,'2018-05-14 00:26:14',4),(124,'Laugh',9,'2018-05-14 00:26:52',10),(125,'Smile',7,'2018-05-14 00:28:16',4),(128,'Smile',5,'2018-05-14 01:03:15',10),(129,'Laugh',5,'2018-05-14 01:12:35',10),(130,'Annoyed',5,'2018-05-14 01:24:10',10),(136,'VerySad',5,'2018-05-14 01:48:14',4),(137,'Blush',7,'2018-05-14 01:48:34',9),(143,'VerySad',5,'2018-05-14 01:49:07',9),(144,'Happy',5,'2018-05-14 01:49:29',4);
/*!40000 ALTER TABLE `usermood` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-15  0:06:00
