-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: accesos
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `USUARIOS_ESTADOS`
--

use accesos;

DROP TABLE IF EXISTS `USUARIOS_ESTADOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USUARIOS_ESTADOS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLEADOS_ID` int(11) NOT NULL,
  `ESTADOS_ID` int(11) NOT NULL,
  `CALENDARIOS_ID` int(11) NOT NULL,
  `JORNADAS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unico` (`EMPLEADOS_ID`,`CALENDARIOS_ID`),
  KEY `fk__estad_idx` (`ESTADOS_ID`),
  KEY `fk_usuario_idx` (`EMPLEADOS_ID`),
  KEY `fk_calendario_idx` (`CALENDARIOS_ID`),
  KEY `FXJORNADAS_idx` (`JORNADAS_ID`),
  CONSTRAINT `FXJORNADAS` FOREIGN KEY (`JORNADAS_ID`) REFERENCES `jornadas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkempleados` FOREIGN KEY (`EMPLEADOS_ID`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkestado` FOREIGN KEY (`ESTADOS_ID`) REFERENCES `estados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `flcalendario` FOREIGN KEY (`CALENDARIOS_ID`) REFERENCES `calendarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIOS_ESTADOS`
--

LOCK TABLES `USUARIOS_ESTADOS` WRITE;
/*!40000 ALTER TABLE `USUARIOS_ESTADOS` DISABLE KEYS */;
/*!40000 ALTER TABLE `USUARIOS_ESTADOS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accesos`
--

DROP TABLE IF EXISTS `accesos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accesos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `empleados_id` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `minuto` int(11) NOT NULL,
  `hora` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `horaReal` int(11) NOT NULL DEFAULT '0',
  `minutoReal` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unico` (`year`,`empleados_id`,`month`,`day`,`minuto`,`hora`),
  KEY `fk_accesos_empleados_idx` (`empleados_id`),
  CONSTRAINT `fk_accesos_empleados` FOREIGN KEY (`empleados_id`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesos`
--

LOCK TABLES `accesos` WRITE;
/*!40000 ALTER TABLE `accesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarios`
--

DROP TABLE IF EXISTS `calendarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `estados_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_calendario_estados_idx` (`estados_id`),
  CONSTRAINT `fk_calendario_estados` FOREIGN KEY (`estados_id`) REFERENCES `estados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarios`
--

LOCK TABLES `calendarios` WRITE;
/*!40000 ALTER TABLE `calendarios` DISABLE KEYS */;
INSERT INTO `calendarios` VALUES (1,'2020-01-01 00:00:00',5),(2,'2020-01-02 00:00:00',5),(3,'2020-01-03 00:00:00',5),(4,'2020-01-04 00:00:00',6),(5,'2020-01-05 00:00:00',6),(6,'2020-01-06 00:00:00',5),(7,'2020-01-07 00:00:00',5),(8,'2020-01-08 00:00:00',5),(9,'2020-01-09 00:00:00',5),(10,'2020-01-10 00:00:00',5),(11,'2020-01-11 00:00:00',6),(12,'2020-01-12 00:00:00',6),(13,'2020-01-13 00:00:00',5),(14,'2020-01-14 00:00:00',5),(15,'2020-01-15 00:00:00',5),(16,'2020-01-16 00:00:00',5),(17,'2020-01-17 00:00:00',5),(18,'2020-01-18 00:00:00',6),(19,'2020-01-19 00:00:00',6),(20,'2020-01-20 00:00:00',5),(21,'2020-01-21 00:00:00',5),(22,'2020-01-22 00:00:00',5),(23,'2020-01-23 00:00:00',5),(24,'2020-01-24 00:00:00',5),(25,'2020-01-25 00:00:00',6),(26,'2020-01-26 00:00:00',6),(27,'2020-01-27 00:00:00',5),(28,'2020-01-28 00:00:00',5),(29,'2020-01-29 00:00:00',5),(30,'2020-01-30 00:00:00',5),(31,'2020-01-31 00:00:00',5),(32,'2020-02-01 00:00:00',6),(33,'2020-02-02 00:00:00',6),(34,'2020-02-03 00:00:00',5),(35,'2020-02-04 00:00:00',5),(36,'2020-02-05 00:00:00',5),(37,'2020-02-06 00:00:00',5),(38,'2020-02-07 00:00:00',5),(39,'2020-02-08 00:00:00',6),(40,'2020-02-09 00:00:00',6),(41,'2020-02-10 00:00:00',5),(42,'2020-02-11 00:00:00',5),(43,'2020-02-12 00:00:00',5),(44,'2020-02-13 00:00:00',5),(45,'2020-02-14 00:00:00',5),(46,'2020-02-15 00:00:00',6),(47,'2020-02-16 00:00:00',6),(48,'2020-02-17 00:00:00',5),(49,'2020-02-18 00:00:00',5),(50,'2020-02-19 00:00:00',5),(51,'2020-02-20 00:00:00',5),(52,'2020-02-21 00:00:00',5),(53,'2020-02-22 00:00:00',6),(54,'2020-02-23 00:00:00',6),(55,'2020-02-24 00:00:00',5),(56,'2020-02-25 00:00:00',5),(57,'2020-02-26 00:00:00',5),(58,'2020-02-27 00:00:00',5),(59,'2020-02-28 00:00:00',5),(60,'2020-02-29 00:00:00',6),(61,'2020-03-01 00:00:00',6),(62,'2020-03-02 00:00:00',5),(63,'2020-03-03 00:00:00',5),(64,'2020-03-04 00:00:00',5),(65,'2020-03-05 00:00:00',5),(66,'2020-03-06 00:00:00',5),(67,'2020-03-07 00:00:00',6),(68,'2020-03-08 00:00:00',6),(69,'2020-03-09 00:00:00',5),(70,'2020-03-10 00:00:00',5),(71,'2020-03-11 00:00:00',5),(72,'2020-03-12 00:00:00',5),(73,'2020-03-13 00:00:00',5),(74,'2020-03-14 00:00:00',6),(75,'2020-03-15 00:00:00',6),(76,'2020-03-16 00:00:00',5),(77,'2020-03-17 00:00:00',5),(78,'2020-03-18 00:00:00',5),(79,'2020-03-19 00:00:00',5),(80,'2020-03-20 00:00:00',5),(81,'2020-03-21 00:00:00',6),(82,'2020-03-22 00:00:00',6),(83,'2020-03-23 00:00:00',5),(84,'2020-03-24 00:00:00',5),(85,'2020-03-25 00:00:00',5),(86,'2020-03-26 00:00:00',5),(87,'2020-03-27 00:00:00',5),(88,'2020-03-28 00:00:00',6),(89,'2020-03-29 00:00:00',6),(90,'2020-03-30 00:00:00',5),(91,'2020-03-31 00:00:00',5),(92,'2020-04-01 00:00:00',5),(93,'2020-04-02 00:00:00',5),(94,'2020-04-03 00:00:00',5),(95,'2020-04-04 00:00:00',6),(96,'2020-04-05 00:00:00',6),(97,'2020-04-06 00:00:00',5),(98,'2020-04-07 00:00:00',5),(99,'2020-04-08 00:00:00',5),(100,'2020-04-09 00:00:00',5),(101,'2020-04-10 00:00:00',5),(102,'2020-04-11 00:00:00',6),(103,'2020-04-12 00:00:00',6),(104,'2020-04-13 00:00:00',5),(105,'2020-04-14 00:00:00',5),(106,'2020-04-15 00:00:00',5),(107,'2020-04-16 00:00:00',5),(108,'2020-04-17 00:00:00',5),(109,'2020-04-18 00:00:00',6),(110,'2020-04-19 00:00:00',6),(111,'2020-04-20 00:00:00',5),(112,'2020-04-21 00:00:00',5),(113,'2020-04-22 00:00:00',5),(114,'2020-04-23 00:00:00',5),(115,'2020-04-24 00:00:00',5),(116,'2020-04-25 00:00:00',6),(117,'2020-04-26 00:00:00',6),(118,'2020-04-27 00:00:00',5),(119,'2020-04-28 00:00:00',5),(120,'2020-04-29 00:00:00',5),(121,'2020-04-30 00:00:00',5),(122,'2020-05-01 00:00:00',5),(123,'2020-05-02 00:00:00',6),(124,'2020-05-03 00:00:00',6),(125,'2020-05-04 00:00:00',5),(126,'2020-05-05 00:00:00',5),(127,'2020-05-06 00:00:00',5),(128,'2020-05-07 00:00:00',5),(129,'2020-05-08 00:00:00',5),(130,'2020-05-09 00:00:00',6),(131,'2020-05-10 00:00:00',6),(132,'2020-05-11 00:00:00',5),(133,'2020-05-12 00:00:00',5),(134,'2020-05-13 00:00:00',5),(135,'2020-05-14 00:00:00',5),(136,'2020-05-15 00:00:00',5),(137,'2020-05-16 00:00:00',6),(138,'2020-05-17 00:00:00',6),(139,'2020-05-18 00:00:00',5),(140,'2020-05-19 00:00:00',5),(141,'2020-05-20 00:00:00',5),(142,'2020-05-21 00:00:00',5),(143,'2020-05-22 00:00:00',5),(144,'2020-05-23 00:00:00',6),(145,'2020-05-24 00:00:00',6),(146,'2020-05-25 00:00:00',5),(147,'2020-05-26 00:00:00',5),(148,'2020-05-27 00:00:00',5),(149,'2020-05-28 00:00:00',5),(150,'2020-05-29 00:00:00',5),(151,'2020-05-30 00:00:00',6),(152,'2020-05-31 00:00:00',6),(153,'2020-06-01 00:00:00',5),(154,'2020-06-02 00:00:00',5),(155,'2020-06-03 00:00:00',5),(156,'2020-06-04 00:00:00',5),(157,'2020-06-05 00:00:00',5),(158,'2020-06-06 00:00:00',6),(159,'2020-06-07 00:00:00',6),(160,'2020-06-08 00:00:00',5),(161,'2020-06-09 00:00:00',5),(162,'2020-06-10 00:00:00',5),(163,'2020-06-11 00:00:00',5),(164,'2020-06-12 00:00:00',5),(165,'2020-06-13 00:00:00',6),(166,'2020-06-14 00:00:00',6),(167,'2020-06-15 00:00:00',5),(168,'2020-06-16 00:00:00',5),(169,'2020-06-17 00:00:00',5),(170,'2020-06-18 00:00:00',5),(171,'2020-06-19 00:00:00',5),(172,'2020-06-20 00:00:00',6),(173,'2020-06-21 00:00:00',6),(174,'2020-06-22 00:00:00',5),(175,'2020-06-23 00:00:00',5),(176,'2020-06-24 00:00:00',5),(177,'2020-06-25 00:00:00',5),(178,'2020-06-26 00:00:00',5),(179,'2020-06-27 00:00:00',6),(180,'2020-06-28 00:00:00',6),(181,'2020-06-29 00:00:00',5),(182,'2020-06-30 00:00:00',5),(183,'2020-07-01 00:00:00',5),(184,'2020-07-02 00:00:00',5),(185,'2020-07-03 00:00:00',5),(186,'2020-07-04 00:00:00',6),(187,'2020-07-05 00:00:00',6),(188,'2020-07-06 00:00:00',5),(189,'2020-07-07 00:00:00',5),(190,'2020-07-08 00:00:00',5),(191,'2020-07-09 00:00:00',5),(192,'2020-07-10 00:00:00',5),(193,'2020-07-11 00:00:00',6),(194,'2020-07-12 00:00:00',6),(195,'2020-07-13 00:00:00',5),(196,'2020-07-14 00:00:00',5),(197,'2020-07-15 00:00:00',5),(198,'2020-07-16 00:00:00',5),(199,'2020-07-17 00:00:00',5),(200,'2020-07-18 00:00:00',6),(201,'2020-07-19 00:00:00',6),(202,'2020-07-20 00:00:00',5),(203,'2020-07-21 00:00:00',5),(204,'2020-07-22 00:00:00',5),(205,'2020-07-23 00:00:00',5),(206,'2020-07-24 00:00:00',5),(207,'2020-07-25 00:00:00',6),(208,'2020-07-26 00:00:00',6),(209,'2020-07-27 00:00:00',5),(210,'2020-07-28 00:00:00',5),(211,'2020-07-29 00:00:00',5),(212,'2020-07-30 00:00:00',5),(213,'2020-07-31 00:00:00',5),(214,'2020-08-01 00:00:00',6),(215,'2020-08-02 00:00:00',6),(216,'2020-08-03 00:00:00',5),(217,'2020-08-04 00:00:00',5),(218,'2020-08-05 00:00:00',5),(219,'2020-08-06 00:00:00',5),(220,'2020-08-07 00:00:00',5),(221,'2020-08-08 00:00:00',6),(222,'2020-08-09 00:00:00',6),(223,'2020-08-10 00:00:00',5),(224,'2020-08-11 00:00:00',5),(225,'2020-08-12 00:00:00',5),(226,'2020-08-13 00:00:00',5),(227,'2020-08-14 00:00:00',5),(228,'2020-08-15 00:00:00',6),(229,'2020-08-16 00:00:00',6),(230,'2020-08-17 00:00:00',5),(231,'2020-08-18 00:00:00',5),(232,'2020-08-19 00:00:00',5),(233,'2020-08-20 00:00:00',5),(234,'2020-08-21 00:00:00',5),(235,'2020-08-22 00:00:00',6),(236,'2020-08-23 00:00:00',6),(237,'2020-08-24 00:00:00',5),(238,'2020-08-25 00:00:00',5),(239,'2020-08-26 00:00:00',5),(240,'2020-08-27 00:00:00',5),(241,'2020-08-28 00:00:00',5),(242,'2020-08-29 00:00:00',6),(243,'2020-08-30 00:00:00',6),(244,'2020-08-31 00:00:00',5),(245,'2020-09-01 00:00:00',5),(246,'2020-09-02 00:00:00',5),(247,'2020-09-03 00:00:00',5),(248,'2020-09-04 00:00:00',5),(249,'2020-09-05 00:00:00',6),(250,'2020-09-06 00:00:00',6),(251,'2020-09-07 00:00:00',5),(252,'2020-09-08 00:00:00',5),(253,'2020-09-09 00:00:00',5),(254,'2020-09-10 00:00:00',5),(255,'2020-09-11 00:00:00',5),(256,'2020-09-12 00:00:00',6),(257,'2020-09-13 00:00:00',6),(258,'2020-09-14 00:00:00',5),(259,'2020-09-15 00:00:00',5),(260,'2020-09-16 00:00:00',5),(261,'2020-09-17 00:00:00',5),(262,'2020-09-18 00:00:00',5),(263,'2020-09-19 00:00:00',6),(264,'2020-09-20 00:00:00',6),(265,'2020-09-21 00:00:00',5),(266,'2020-09-22 00:00:00',5),(267,'2020-09-23 00:00:00',5),(268,'2020-09-24 00:00:00',5),(269,'2020-09-25 00:00:00',5),(270,'2020-09-26 00:00:00',6),(271,'2020-09-27 00:00:00',6),(272,'2020-09-28 00:00:00',5),(273,'2020-09-29 00:00:00',5),(274,'2020-09-30 00:00:00',5),(275,'2020-10-01 00:00:00',5),(276,'2020-10-02 00:00:00',5),(277,'2020-10-03 00:00:00',6),(278,'2020-10-04 00:00:00',6),(279,'2020-10-05 00:00:00',5),(280,'2020-10-06 00:00:00',5),(281,'2020-10-07 00:00:00',5),(282,'2020-10-08 00:00:00',5),(283,'2020-10-09 00:00:00',5),(284,'2020-10-10 00:00:00',6),(285,'2020-10-11 00:00:00',6),(286,'2020-10-12 00:00:00',5),(287,'2020-10-13 00:00:00',5),(288,'2020-10-14 00:00:00',5),(289,'2020-10-15 00:00:00',5),(290,'2020-10-16 00:00:00',5),(291,'2020-10-17 00:00:00',6),(292,'2020-10-18 00:00:00',6),(293,'2020-10-19 00:00:00',5),(294,'2020-10-20 00:00:00',5),(295,'2020-10-21 00:00:00',5),(296,'2020-10-22 00:00:00',5),(297,'2020-10-23 00:00:00',5),(298,'2020-10-24 00:00:00',6),(299,'2020-10-25 00:00:00',6),(300,'2020-10-26 00:00:00',5),(301,'2020-10-27 00:00:00',5),(302,'2020-10-28 00:00:00',5),(303,'2020-10-29 00:00:00',5),(304,'2020-10-30 00:00:00',5),(305,'2020-10-31 00:00:00',6),(306,'2020-11-01 00:00:00',6),(307,'2020-11-02 00:00:00',5),(308,'2020-11-03 00:00:00',5),(309,'2020-11-04 00:00:00',5),(310,'2020-11-05 00:00:00',5),(311,'2020-11-06 00:00:00',5),(312,'2020-11-07 00:00:00',6),(313,'2020-11-08 00:00:00',6),(314,'2020-11-09 00:00:00',5),(315,'2020-11-10 00:00:00',5),(316,'2020-11-11 00:00:00',5),(317,'2020-11-12 00:00:00',5),(318,'2020-11-13 00:00:00',5),(319,'2020-11-14 00:00:00',6),(320,'2020-11-15 00:00:00',6),(321,'2020-11-16 00:00:00',5),(322,'2020-11-17 00:00:00',5),(323,'2020-11-18 00:00:00',5),(324,'2020-11-19 00:00:00',5),(325,'2020-11-20 00:00:00',5),(326,'2020-11-21 00:00:00',6),(327,'2020-11-22 00:00:00',6),(328,'2020-11-23 00:00:00',5),(329,'2020-11-24 00:00:00',5),(330,'2020-11-25 00:00:00',5),(331,'2020-11-26 00:00:00',5),(332,'2020-11-27 00:00:00',5),(333,'2020-11-28 00:00:00',6),(334,'2020-11-29 00:00:00',6),(335,'2020-11-30 00:00:00',5),(336,'2020-12-01 00:00:00',5),(337,'2020-12-02 00:00:00',5),(338,'2020-12-03 00:00:00',5),(339,'2020-12-04 00:00:00',5),(340,'2020-12-05 00:00:00',6),(341,'2020-12-06 00:00:00',6),(342,'2020-12-07 00:00:00',5),(343,'2020-12-08 00:00:00',5),(344,'2020-12-09 00:00:00',5),(345,'2020-12-10 00:00:00',5),(346,'2020-12-11 00:00:00',5),(347,'2020-12-12 00:00:00',6),(348,'2020-12-13 00:00:00',6),(349,'2020-12-14 00:00:00',5),(350,'2020-12-15 00:00:00',5),(351,'2020-12-16 00:00:00',5),(352,'2020-12-17 00:00:00',5),(353,'2020-12-18 00:00:00',5),(354,'2020-12-19 00:00:00',6),(355,'2020-12-20 00:00:00',6),(356,'2020-12-21 00:00:00',5),(357,'2020-12-22 00:00:00',5),(358,'2020-12-23 00:00:00',5),(359,'2020-12-24 00:00:00',5),(360,'2020-12-25 00:00:00',5),(361,'2020-12-26 00:00:00',6),(362,'2020-12-27 00:00:00',6),(363,'2020-12-28 00:00:00',5),(364,'2020-12-29 00:00:00',5),(365,'2020-12-30 00:00:00',5),(366,'2020-12-31 00:00:00',5);
/*!40000 ALTER TABLE `calendarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `identificador` varchar(100) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `fecha_baja` datetime DEFAULT NULL,
  `jornadas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `IDENTIFICADOR` (`identificador`),
  KEY `fk_empleados_jornadas1_idx` (`jornadas_id`),
  CONSTRAINT `fk_empleados_jornadas1` FOREIGN KEY (`jornadas_id`) REFERENCES `jornadas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (4,'javier','fernandez garcia','95643r','12345',NULL,NULL,4),(8,'javier nuevo','fernandez garcia','95646r','12345dd',NULL,NULL,3),(9,'empleado 2','garcia lorca','1122334F','aaa112',NULL,NULL,7);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (5,'LABORABLE',1),(6,'FESTIVO',1),(7,'VACACIONES',2),(8,'LICENCIA',2),(9,'SANCION',2),(10,'BAJA',2),(11,'nevo estado desde javascript',1),(12,'nuevo estado desde javascript',1),(13,'nuevo estado desde javascript',1),(14,'nuevo estado desde javascript',1),(15,'nuevo estado desde javascript',1),(16,'nuevo estado desde javascript',1),(17,'nuevo estado desde javascript',1),(18,'nuevo estado desde javascript',1),(19,'nuevo estado desde javascript',1),(20,'nuevo estado desde javascript',1),(21,'nuevo estado desde javascript',1),(22,'nuevo estado desde javascript',1),(23,'nuevo estado desde javascript',1),(24,'nuevo estado desde javascript',1),(25,'nuevo estado desde javascript',1),(26,'nuevo estado desde javascript',1),(27,'nuevo estado desde javascript',1),(28,'nuevo estado desde javascript',1),(29,'nuevo estado desde javascript',1),(30,'nuevo estado desde javascript',1),(31,'nuevo estado desde javascript',1),(32,'nuevo estado desde javascript',1),(33,'nuevo estado desde javascript',1),(34,'nuevo estado desde javascript',1),(35,'nuevo estado desde javascript',1),(36,'nuevo estado desde javascript',1),(37,'nuevo estado desde javascript',1),(38,'nuevo estado desde javascript',1),(39,'nuevo estado desde javascript',1),(40,'nuevo estado desde javascript',1),(41,'nuevo estado desde javascript',1),(42,'nuevo estado desde javascript',1),(43,'nuevo estado desde javascript',1),(44,'nuevo estado desde javascript',1),(45,'nuevo estado desde javascript',1),(46,'nuevo estado desde javascript',1),(47,'nuevo estado desde javascript',1),(48,'nuevo estado desde javascript',1),(49,'nuevo estado desde javascript',1),(50,'nuevo estado desde javascript',1),(51,'nuevo estado desde javascript',1),(52,'nuevo estado desde javascript',1),(53,'nuevo estado desde javascript',1),(54,'nuevo estado desde javascript',1),(55,'nuevo estado desde javascript',1),(56,'nuevo estado desde javascript',1),(57,'nuevo estado desde javascript',1),(58,'nuevo estado desde javascript',1),(59,'nuevo estado desde javascript',1),(60,'nuevo estado desde javascript',1),(61,'nuevo estado desde javascript',1),(62,'nuevo estado desde javascript',1),(63,'nuevo estado desde javascript',1);
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornadas`
--

DROP TABLE IF EXISTS `jornadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jornadas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lunes` varchar(45) NOT NULL,
  `martes` varchar(45) NOT NULL,
  `miercoles` varchar(45) NOT NULL,
  `jueves` varchar(45) NOT NULL,
  `viernes` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `especial` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornadas`
--

LOCK TABLES `jornadas` WRITE;
/*!40000 ALTER TABLE `jornadas` DISABLE KEYS */;
INSERT INTO `jornadas` VALUES (3,'08:00-14:00','ba','ca','da','aaa','nueva jornada 5',0),(4,'9h-15h','9h-15h','9h-15h','9h-15h','9h-15h','Jornada tarde',0),(5,'08:00-14:00','ba','ca','da','aaa','nueva jornada 5',0),(6,'08:00-14:00','ba','ca','da','aaa','nueva jornada 5',0),(7,'','b','c','e','w','',0);
/*!40000 ALTER TABLE `jornadas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-29 14:33:47
