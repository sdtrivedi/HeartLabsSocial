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
INSERT INTO `message_receiver` VALUES (1,4),(1,5),(1,6),(1,8),(1,10),(1,11),(1,13),(1,15),(1,16),(1,17),(1,19),(1,20),(1,21),(1,22),(2,4),(2,5),(2,6),(2,8),(2,10),(2,11),(2,13),(2,15),(2,16),(2,17),(2,19),(2,20),(2,21),(2,22),(3,7),(4,4),(4,5),(4,6),(4,8),(4,10),(4,11),(4,13),(4,15),(4,16),(4,17),(4,19),(4,20),(4,21),(4,22),(5,4),(5,5),(5,6),(5,8),(5,10),(5,11),(5,13),(5,15),(5,16),(5,17),(5,19),(5,20),(5,21),(5,22),(6,4),(6,5),(6,6),(6,8),(6,10),(6,11),(6,13),(6,15),(6,16),(6,17),(6,19),(6,20),(6,21),(6,22),(7,10),(8,4),(8,5),(8,6),(8,8),(8,10),(8,11),(8,13),(8,15),(8,16),(8,17),(8,19),(8,20),(8,21),(8,22),(9,4),(9,5),(9,6),(9,8),(9,10),(9,11),(9,13),(9,15),(9,16),(9,17),(9,19),(9,20),(9,21),(9,22),(10,4),(10,5),(10,6),(10,8),(10,10),(10,11),(10,13),(10,15),(10,16),(10,17),(10,19),(10,20),(10,21),(10,22),(11,4),(11,5),(11,6),(11,8),(11,10),(11,11),(11,13),(11,15),(11,16),(11,17),(11,19),(11,20),(11,21),(11,22),(12,4),(12,5),(12,6),(12,8),(12,10),(12,11),(12,13),(12,15),(12,16),(12,17),(12,19),(12,20),(12,21),(12,22),(13,4),(13,5),(13,6),(13,8),(13,10),(13,11),(13,13),(13,15),(13,16),(13,17),(13,19),(13,20),(13,21),(13,22),(14,4),(14,5),(14,6),(14,8),(14,10),(14,11),(14,13),(14,15),(14,16),(14,17),(14,19),(14,20),(14,21),(14,22),(15,4),(15,5),(15,6),(15,8),(15,10),(15,11),(15,13),(15,15),(15,16),(15,17),(15,19),(15,20),(15,21),(15,22);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_table`
--

LOCK TABLES `message_table` WRITE;
/*!40000 ALTER TABLE `message_table` DISABLE KEYS */;
INSERT INTO `message_table` VALUES (1,'fasfsav','2018-04-06 02:38:13',2,1,4),(2,'fasfasfa','2018-04-06 02:38:16',2,1,4),(3,'gdfjtjfgn fd','2018-04-06 02:38:25',1,2,4),(4,'Complete first survey.\r\n\r\nhttps://www.youtube.com/watch?v=hchJmTf4x0Y&list=RDMMmhz4LV9kJQY&index=18','2018-04-06 02:39:10',2,1,4),(5,'Data type	Description\r\nCHAR(size)	Holds a fixed length string (can contain letters, numbers, and special characters). The fixed size is specified in parenthesis. Can store up to 255 characters\r\nVARCHAR(size)	Holds a variable length string (can contain letters, numbers, and special characters). The maximum size is specified in parenthesis. Can store up to 255 characters. Note: If you put a greater value than 255 it will be converted to a TEXT type\r\nTINYTEXT	Holds a string with a maximum length of 255 characters\r\nTEXT	Holds a string with a maximum length of 65,535 characters\r\nBLOB	For BLOBs (Binary Large OBjects). Holds up to 65,535 bytes of data\r\nMEDIUMTEXT	Holds a string with a maximum length of 16,777,215 characters\r\nMEDIUMBLOB	For BLOBs (Binary Large OBjects). Holds up to 16,777,215 bytes of data\r\nLONGTEXT	Holds a string with a maximum length of 4,294,967,295 characters\r\nLONGBLOB	For BLOBs (Binary Large OBjects). Holds up to 4,294,967,295 bytes of data\r\nENUM(x,y,z,etc.)	Let you enter a list of possible values. You can list up to 65535 values in an ENUM list. If a value is inserted that is not in the list, a blank value will be inserted.\r\nNote: The values are sorted in the order you enter them.\r\n\r\nYou enter the possible values in this format: ENUM(\'X\',\'Y\',\'Z\')\r\nSET	Similar to ENUM except that SET may contain up to 64 list items and can store more than one choice\r\nNumber data types:\r\nData type	Description\r\nTINYINT(size)	-128 to 127 normal. 0 to 255 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nSMALLINT(size)	-32768 to 32767 normal. 0 to 65535 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nMEDIUMINT(size)	-8388608 to 8388607 normal. 0 to 16777215 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nINT(size)	-2147483648 to 2147483647 normal. 0 to 4294967295 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nBIGINT(size)	-9223372036854775808 to 9223372036854775807 normal. 0 to 18446744073709551615 UNSIGNED*. The maximum number of digits may be specified in parenthesis\r\nFLOAT(size,d)	A small number with a floating decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\nDOUBLE(size,d)	A large number with a floating decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\nDECIMAL(size,d)	A DOUBLE stored as a string , allowing for a fixed decimal point. The maximum number of digits may be specified in the size parameter. The maximum number of digits to the right of the decimal point is specified in the d parameter\r\n','2018-04-06 02:47:29',2,1,4),(6,'To change the data type of a column in a table, use the following syntax:\r\n\r\nSQL Server / MS Access:','2018-04-06 02:55:12',2,1,4),(7,'gbdsndf b  fbeab dfbfdnbdfnd','2018-04-06 03:09:07',2,2,4),(8,'This test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\nHave fun and take your time!\r\nThere is zero tolerance for cheating, plagiarizing, sharing code, etc. ','2018-04-06 03:25:14',2,1,4),(9,'This test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\n\r\n\r\n\r\n Have fun and take your time!\r\n\r\n\r\n\r\n\r\n There is zero tolerance for cheating, plagiarizing, sharing code, etc. ','2018-04-06 03:26:23',2,1,4),(10,'Instructions\r\nThis test is designed to be difficult to complete in the time frame. Do not be discouraged. \r\nHave fun and take your time!\r\nThere is zero tolerance for cheating, plagiarizing, sharing code, etc. \r\nThis is a programming test\r\nTo get familiarized with our coding environment, try our Sample Test\r\nYou are free to choose any language from the list and code\r\nIf the code area contains the function signature, just complete the function alone, we\'ll take care of the main function, headers, etc\r\nIf you\'re expected to write the full code, it\'d be mentioned in the code area. All inputs are from STDIN and output to STDOUT. If you\'re using Java, use the classname as \'Solution\'\r\nTo understand more about the environment, time limits, etc. you can read the FAQ here\r\nYou can print to console to debug your code using the appropriate print command for each language (Eg: cout for C++, printf for C, etc.)\r\nhttps://www.hackerrank.com/tests/a5ccreio2qs/f885f28d6efe34cb05421bdec3176315','2018-04-06 03:28:24',2,1,4),(11,'Hello \\n \\n\r\n\r\nfacebook.com','2018-04-06 03:29:46',2,1,4),(12,'<p>\r\n  Hello\r\n<p>\r\n<p>\r\nWorld\r\n<p>\r\n\r\n','2018-04-06 03:30:33',2,1,4),(13,'<p>Complete Survey</p>\r\n\r\n<a href=\"#\">Complete Survey</a>','2018-04-06 03:32:58',2,1,4),(14,'<p>Annoucement Content goes here...</p><a href=\"www.youtube.come\">Link</a>','2018-04-06 03:36:36',2,1,4),(15,'<p>Complete survey 3 before Saturday afternoon</p>\r\n\r\n<p>Anyone who can design amazing graphics stuff, Anyone who knows the main web technologies, Anyone who can create cool GIFs and vector-based motion graphics, Come join us!</p>\r\n\r\n\r\n<a href=\"https://lnkd.in/eFzJAHWe\">Survey 3</a>','2018-04-06 03:39:53',2,1,4);
/*!40000 ALTER TABLE `message_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_table`
--

DROP TABLE IF EXISTS `post_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_table` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `isvideo` int(11) DEFAULT NULL,
  `post_content` text,
  `status` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `video_link` varchar(255) DEFAULT NULL,
  `posted_by_user_id` int(11) DEFAULT NULL,
  `display_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKscig6x773xg36ffk4ae386cxr` (`posted_by_user_id`),
  CONSTRAINT `FKscig6x773xg36ffk4ae386cxr` FOREIGN KEY (`posted_by_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_table`
--

LOCK TABLES `post_table` WRITE;
/*!40000 ALTER TABLE `post_table` DISABLE KEYS */;
INSERT INTO `post_table` VALUES (1,2,'Video',1,'2018-03-27 21:27:31','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/_Jnu_jHfQbM&list\"></iframe>',4,NULL),(2,2,'Video',2,'2018-03-27 21:31:22','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/_Jnu_jHfQbM&list\"></iframe>',4,NULL),(3,2,'Video',1,'2018-03-27 21:32:08','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/_Jnu_jHfQbM&list\"></iframe>',4,NULL),(4,2,'Reality of Ramjas college row',1,'2018-03-27 21:50:14','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/A9tZqs-yRLI\"></iframe>',10,NULL),(5,1,'vadbgsbvsd ',2,'2018-04-05 03:56:41','',4,NULL),(6,2,'Friends - Chandler and Nina ( Just a few scenes )',1,'2018-04-07 16:40:00','<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/G2TnY-ngsaU\"></iframe>',10,'1 month ago');
/*!40000 ALTER TABLE `post_table` ENABLE KEYS */;
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
INSERT INTO `user` VALUES (4,1,'usingh8@asu.edu','Singh','Upendraa ','$2a$10$XZk1bCUgxzkk6Bnmay1Mau64Bx9SIraILQKL9WIjE0hJHgpFOm1mi',NULL),(5,1,'ajain122@asu.edu','Jain','Akshay','$2a$10$XZk1bCUgxzkk6Bnmay1Mau64Bx9SIraILQKL9WIjE0hJHgpFOm1mi',NULL),(6,1,'manjul.pathak@tcs.com','Pathak','Manjul','$2a$10$ysU06sD/zW.mgXa1PoZ7nuNNr/l3qbalsmIFv.r.5iZPammyEsA5m',NULL),(7,2,'kapil.gupta.1@asu.edu','Gupta','Kapil','$2a$10$/rl7chXQKKvIth9sg3eMzefB8McZ1hinsnKyjEmJEg3VGi5C2TXN2',NULL),(8,1,'abhijith@asu.edu','Kirshnan','Abhijith','$2a$10$nrn2B1BDx.6i5onwNimDvOGfvSmSQqqE0c.MCUOog4yI6JFIbaO6.',NULL),(9,2,'jsutton4@asu.edu','Sutton','Jasmine','$2a$10$zbzqpHzjaHftsDe4l13f7eAp5.q1gNMNNAp283YWxF4C.1Upp15oW',NULL),(10,1,'asr@asu.edu','Saxena','Anjali','$2a$10$dzyk/lQejQMAAVdFl.mvZuVpRYue6SEwas8m2Ioj8L7d0iDXABA/W',NULL),(11,1,'jimmy@asu.edu','Dai','Jimmy','$2a$10$cvlkfOiRBoRBW6xjSn692.awAyPsfRHwrUFJMBXnPgLxo/Rwpcv1i',NULL),(12,2,'test_user@asu.edu','user','test_user','$2a$10$lBLNTpvHEqjm4vsNTvmafOeCzYXKL/YH0FWh9aXkh7S.g5y6KkKfW',NULL),(13,1,'upendra@asu.edu','dda','Shara','$2a$10$qITvTjvNFQJbt7nQRQtJZeeJ1pov3yoXtUemEGY6Kh7gtnOrjAsDC',NULL),(14,2,'ayushr@asu.edu','Ruchandani','Ayush','$2a$10$aOZ5qJkJctxW0i4tJxgsFeCLuI/1XHwU14OR8V5PIZETrJ9J8OFuq',NULL),(15,1,'ayushr1@asu.edu','Ruchandani','Ayush','$2a$10$MaGh0AaNYQf0uVARQ4YY9u2ZBujPs1jDj5Igkhw/iVaQYOFtUGBZy',NULL),(16,1,'asfa@asa.casf','adsda','asdas','$2a$10$dayALwON44I3m/MaBo0iiupYPLZJdlTSlX8B3Ct8labxCMbXGXlQa',NULL),(17,1,'kapil.gua.1@asu.edu','Gupta','Kapil Gupta','$2a$10$dwi/zg0.0qlR7eMw0scZFeW5AUf4yiQ23yf2UTYN7EVePxpAIcM8K',NULL),(18,2,'usingh8@asu.ed','Singh','Upendra Singh','$2a$10$vYRWXAEQoVrJ7FuE9JDAwe7oYUsyL/3CPBN1imwPzPjN0UBeNIjBe',NULL),(19,1,'usingh8@gmail.com','Singh','Upendra Singh','$2a$10$7jDiDkvFZBNdvYZJd78soeMr/2NJsUE.oT/s8YBoFcW2R5RKIy43O',NULL),(20,1,'dasda@3adas.gsds','asdasa','dfasfas','$2a$10$fMEsXnEbz7uQFtUzgOH29.vdd7hePZst0/XyKNH9CQJWWEuDur7PG',NULL),(21,1,'dasdsa2@afsfas','Singh','Upendra Singh','$2a$10$Dw/8/66c0u3mHT7apiTt/ekvvlatSIQtAKOZ627.elRhTvpSV/ul6',NULL),(22,1,'312321@eaefa.hjfg','casvasv','fafsdv','$2a$10$zRd3f8cl/t0hIZ7eYRkrnueRm0dDnOMg.LRI0O/IVfzY5/JdqFB8a',NULL);
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mood_title` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermood`
--

LOCK TABLES `usermood` WRITE;
/*!40000 ALTER TABLE `usermood` DISABLE KEYS */;
INSERT INTO `usermood` VALUES (1,'Laugh',7,'2018-03-22 19:42:49',4),(2,'Sad',7,'2018-03-22 19:49:49',4),(3,'Annoyed',3,'2018-03-22 19:51:09',5),(4,'Happy',10,'2018-03-22 19:56:40',5),(5,'Laugh',4,'2018-03-22 20:00:10',5),(6,'Annoyed',5,'2018-03-22 20:02:46',5),(7,'Laugh',5,'2018-03-22 20:04:09',4),(8,'Blush',7,'2018-03-22 20:04:23',5),(9,'Laugh',8,'2018-03-22 20:14:00',4),(10,'Annoyed',5,'2018-03-22 20:14:14',5),(11,'Annoyed',5,'2018-03-22 20:14:42',5),(12,'Annoyed',5,'2018-03-22 20:25:30',4),(13,'Annoyed',5,'2018-03-22 20:27:45',4),(14,'Annoyed',7,'2018-03-22 20:51:51',4),(15,'Smile',9,'2018-03-22 20:56:42',4),(16,'VerySad',6,'2018-03-22 20:57:12',6),(17,'Annoyed',5,'2018-03-22 20:57:26',4),(18,'Blush',8,'2018-03-22 22:00:02',4),(19,'Annoyed',5,'2018-03-22 22:00:51',10),(20,'Laugh',5,'2018-03-22 22:23:37',10),(21,'Laugh',5,'2018-03-22 22:36:33',4),(22,'Laugh',5,'2018-03-22 22:37:28',4),(23,'Happy',6,'2018-03-22 22:44:29',4),(24,'Happy',5,'2018-03-22 23:28:46',4),(25,'Smile',9,'2018-03-22 23:30:49',4),(26,'Sunglass',5,'2018-03-22 23:32:05',4),(27,'Blush',10,'2018-03-22 23:32:51',5),(28,'Annoyed',8,'2018-03-22 23:33:19',10),(29,'Happy',5,'2018-03-22 23:55:44',4),(30,'Happy',8,'2018-03-23 00:21:33',4),(31,'Blush',5,'2018-03-23 00:25:24',4),(32,'Blush',5,'2018-03-23 00:26:32',4),(33,'VerySad',5,'2018-03-23 00:27:31',4),(34,'VerySad',10,'2018-03-23 00:35:50',4),(35,'Smile',9,'2018-03-23 00:54:58',4),(36,'Smile',9,'2018-03-23 01:00:09',10),(37,'Blush',9,'2018-03-23 01:02:00',4),(38,'Happy',8,'2018-03-23 01:02:12',4),(39,'Smile',5,'2018-03-23 01:31:45',4),(40,'Happy',5,'2018-03-23 01:56:52',4),(41,'Laugh',5,'2018-03-23 02:15:20',4),(42,'Annoyed',5,'2018-03-23 02:24:46',4),(43,'Sunglass',5,'2018-03-23 02:46:03',10),(44,'Smile',9,'2018-03-23 02:58:20',4),(45,'Sad',9,'2018-03-23 03:06:28',4),(46,'Laugh',5,'2018-03-23 03:12:53',10),(47,'Smile',5,'2018-03-23 03:19:44',4),(48,'Sad',5,'2018-03-23 03:20:47',4),(49,'Smile',5,'2018-03-23 03:27:14',5),(50,'Blush',5,'2018-03-23 03:33:27',4),(51,'Smile',5,'2018-03-23 10:11:20',4),(52,'Laugh',9,'2018-03-23 10:11:40',10),(53,'Sad',9,'2018-03-23 10:14:26',4),(54,'Blush',9,'2018-03-23 11:47:11',4),(55,'Smile',2,'2018-03-23 11:51:14',4),(56,'Annoyed',8,'2018-03-23 11:52:50',10),(57,'Smile',6,'2018-03-23 11:54:06',4),(58,'Smile',8,'2018-03-23 11:59:48',4),(59,'Laugh',5,'2018-03-23 12:00:19',10),(60,'Laugh',5,'2018-03-23 12:02:01',4),(61,'Laugh',8,'2018-03-23 12:10:47',4),(62,'Laugh',5,'2018-03-23 12:11:17',10),(63,'Laugh',5,'2018-03-23 12:18:23',10),(64,'Laugh',7,'2018-03-23 12:19:58',4),(65,'Laugh',8,'2018-03-23 12:23:50',4),(66,'Laugh',9,'2018-03-23 12:36:52',4),(67,'Laugh',8,'2018-03-23 12:38:20',9),(68,'Laugh',5,'2018-03-23 12:47:36',4),(69,'Laugh',5,'2018-03-23 14:08:30',10),(70,'Laugh',5,'2018-03-23 14:09:31',4),(71,'Smile',5,'2018-03-23 15:09:32',4),(72,'Smile',5,'2018-03-23 20:08:13',4),(73,'Smile',5,'2018-03-23 20:49:52',10),(74,'Laugh',5,'2018-03-23 20:50:38',4),(75,'Blush',5,'2018-03-23 20:53:48',4),(76,'Laugh',5,'2018-03-23 20:53:59',4),(77,'Smile',5,'2018-03-23 20:54:15',9),(78,'Laugh',5,'2018-03-23 20:56:03',4),(79,'Laugh',5,'2018-03-23 20:57:38',10),(80,'Annoyed',5,'2018-03-23 21:16:06',4),(81,'Laugh',5,'2018-03-23 21:48:35',4),(82,'Laugh',5,'2018-03-23 21:55:32',4),(83,'Laugh',5,'2018-03-23 21:56:51',4),(84,'Smile',5,'2018-03-23 22:05:32',4),(85,'Laugh',5,'2018-03-23 22:07:44',4),(86,'Laugh',5,'2018-03-27 20:57:07',4),(87,'Laugh',5,'2018-03-27 20:58:30',10),(88,'Laugh',5,'2018-03-27 21:13:44',4),(89,'Annoyed',5,'2018-03-27 21:16:35',9),(90,'Annoyed',5,'2018-03-27 21:20:31',4),(91,'Laugh',5,'2018-03-27 21:32:56',4),(92,'Annoyed',5,'2018-03-27 21:49:25',10),(93,'Laugh',5,'2018-03-27 21:50:31',4),(94,'Laugh',5,'2018-03-27 22:20:24',4),(95,'Sad',5,'2018-03-27 23:20:08',10),(96,'Annoyed',5,'2018-03-27 23:34:41',10),(97,'Laugh',5,'2018-03-27 23:36:07',10),(98,'Annoyed',5,'2018-03-27 23:36:20',4),(99,'Annoyed',5,'2018-03-27 23:36:34',10),(100,'Laugh',5,'2018-03-27 23:38:12',5),(101,'Laugh',5,'2018-03-27 23:38:37',10),(102,'Laugh',5,'2018-04-05 00:38:36',4),(103,'Annoyed',5,'2018-04-05 02:00:53',4),(104,'Laugh',7,'2018-04-05 02:19:55',10),(105,'Blush',9,'2018-04-05 02:38:29',4),(106,'Laugh',5,'2018-04-05 16:42:55',4),(107,'Annoyed',9,'2018-04-05 17:15:18',4),(108,'Laugh',5,'2018-04-05 17:36:27',4),(109,'Smile',5,'2018-04-05 17:37:23',4),(110,'Sad',5,'2018-04-05 17:37:38',4),(111,'Sunglass',8,'2018-04-05 17:50:29',4),(112,'Laugh',10,'2018-04-05 17:51:34',4),(113,'Blush',5,'2018-04-05 17:52:21',4),(114,'Annoyed',5,'2018-04-05 17:57:12',4),(115,'Sunglass',5,'2018-04-05 18:02:12',4),(116,'Smile',5,'2018-04-05 18:02:42',5),(117,'Annoyed',5,'2018-04-05 18:03:02',10),(118,'Sunglass',5,'2018-04-05 18:04:48',4),(119,'Sunglass',8,'2018-04-05 18:14:51',4),(120,'Laugh',5,'2018-04-06 00:03:15',4),(121,'Laugh',5,'2018-04-06 02:58:54',10),(122,'Laugh',5,'2018-04-06 03:08:52',4),(123,'Sunglass',5,'2018-04-06 03:09:20',10),(124,'Blush',5,'2018-04-06 03:20:22',4),(125,'Sunglass',5,'2018-04-06 03:42:56',10),(126,'Sunglass',5,'2018-04-06 03:45:34',5),(127,'Sunglass',5,'2018-04-06 03:45:57',8),(128,'Sunglass',5,'2018-04-06 04:09:15',10),(129,'Sunglass',7,'2018-04-07 16:37:46',10);
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

-- Dump completed on 2018-04-07 16:54:51
