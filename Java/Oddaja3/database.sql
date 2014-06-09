CREATE DATABASE  IF NOT EXISTS `krsnik_faks_b2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `krsnik_faks_b2`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: mysql.lrk.si    Database: krsnik_faks_b2
-- ------------------------------------------------------
-- Server version	5.1.69

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
-- Table structure for table `Grading`
--

DROP TABLE IF EXISTS `Grading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grading` (
  `id` varchar(4) NOT NULL,
  `asist` varchar(4) NOT NULL,
  `stud` varchar(4) NOT NULL,
  `instructions` varchar(600) NOT NULL,
  `prof` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `prof_UNIQUE` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grading`
--

LOCK TABLES `Grading` WRITE;
/*!40000 ALTER TABLE `Grading` DISABLE KEYS */;
INSERT INTO `Grading` VALUES ('0','0','0','Trenutno še ni navodil!','100');
/*!40000 ALTER TABLE `Grading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects`
--

DROP TABLE IF EXISTS `Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Projects` (
  `title` varchar(30) NOT NULL,
  `platform` varchar(30) NOT NULL,
  `mate1` varchar(30) NOT NULL,
  `mate2` varchar(30) NOT NULL,
  `projectSource` varchar(30) NOT NULL,
  `codeSource` varchar(30) NOT NULL,
  PRIMARY KEY (`title`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES ('project1','Android','Janez Novak','Micka Prešeren','http://www.google.com','http://www.gmail.com');
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `number` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `pass` varchar(30) DEFAULT NULL,
  `pass1` varchar(30) DEFAULT NULL,
  `pass2` varchar(30) DEFAULT NULL,
  `fname` varchar(30) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `id_UNIQUE` (`number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('63110179','Krsnik','blabla','blabla','blabla','Luka','Krsnik','luka.krsnik2@hotmail.com','040914122','1'),('12341234','lolek','123','123','123','Lol','Ek','lolek@lol.ek','123456789','3'),('12345671','pišek','piš','piš','piš','Pišek','Piško','pisek@pis.ek','987654321','2');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-22 22:39:14
