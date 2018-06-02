-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: em17
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addsicurezza`
--

DROP TABLE IF EXISTS `addsicurezza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addsicurezza` (
  `IDSICUREZZA` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `SURNAME` varchar(25) NOT NULL,
  `TAX_CODE` varchar(16) NOT NULL,
  `PHONE` varchar(10) NOT NULL,
  `SALARY` double DEFAULT NULL,
  `BIRTH` date DEFAULT NULL,
  PRIMARY KEY (`IDSICUREZZA`),
  UNIQUE KEY `USER_UNICO` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addsicurezza`
--

LOCK TABLES `addsicurezza` WRITE;
/*!40000 ALTER TABLE `addsicurezza` DISABLE KEYS */;
INSERT INTO `addsicurezza` VALUES (1,'CANON','TOMMI','tommasopirozzi@hotmail.it','TOMMASO','PIROZZI','PRZTMS92P04G309L','3343942027',6000,'2018-01-01'),(2,'MARCE','TOMMI','tom@hhhit','MARCELLO','QUATTROMANI','PRZTMS92P04G309L','3354548484',1500.5,'2018-01-01'),(3,'GIUL','TOMMI','tom@hhh.it','GIULIANO','VANESIO','PRZTMS92P04G308L','3405117062',1500.5,'2018-01-01'),(5,'prova','prova','vinc@hotmail.it','VINCENZO','TORINO','PRZTMS92P04G309S','0810000000',3000.15,'1992-06-19'),(6,'PROVA2','PROVA3','OO@HOTMAIL.IT','PROVA','PROVA','PRZTMS92P04G302P','0000000000',1500.12,'2018-06-04');
/*!40000 ALTER TABLE `addsicurezza` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `addsicurezza_BEFORE_INSERT` BEFORE INSERT ON `addsicurezza` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i'))
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PHONE,'^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `addsicurezza_BEFORE_UPDATE` BEFORE UPDATE ON `addsicurezza` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i'))
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PHONE,'^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `amministratore` (
  `IDAMM` varchar(20) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(30) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(15) NOT NULL,
  `CF` varchar(16) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `TEL` varchar(10) NOT NULL,
  PRIMARY KEY (`IDAMM`),
  UNIQUE KEY `AMM_UNICO` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES ('1','TOMMASO','PIROZZI','CANON21','TOMMI','PRZTMS92P04G309L','XXX','000'),('12345','General','Administrator','ok','ok','GNLDNT90T15E313X','admin@em17.it','3391234567');
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biglietto`
--

DROP TABLE IF EXISTS `biglietto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `biglietto` (
  `IDBIGLIETTO` varchar(20) NOT NULL,
  `BARCODE` varchar(200) DEFAULT NULL,
  `PREZZOINTERO` double DEFAULT NULL,
  `PREZZORID` double DEFAULT NULL,
  `NOMEPOSTO` varchar(10) DEFAULT NULL,
  `REPARTO` varchar(20) DEFAULT NULL,
  `DATAEVENTO` date NOT NULL,
  `EVENTO` int(11) DEFAULT NULL,
  `CLIENTE` int(11) DEFAULT NULL,
  `TITOLOEVENTO` varchar(30) NOT NULL,
  `ADDSICUREZZA` int(11) DEFAULT NULL,
  `bigliettocol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDBIGLIETTO`),
  KEY `EVENTO` (`EVENTO`),
  KEY `FK_POSTO2` (`REPARTO`,`NOMEPOSTO`),
  KEY `biglietto_clientefk_idx` (`CLIENTE`),
  KEY `biglietto_sicurezza_idx` (`ADDSICUREZZA`),
  CONSTRAINT `FK_POSTO2` FOREIGN KEY (`REPARTO`, `NOMEPOSTO`) REFERENCES `posto` (`reparto`, `nomeposto`),
  CONSTRAINT `biglietto_clientefk` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `biglietto_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `biglietto_sicurezza` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`idsicurezza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biglietto`
--

LOCK TABLES `biglietto` WRITE;
/*!40000 ALTER TABLE `biglietto` DISABLE KEYS */;
/*!40000 ALTER TABLE `biglietto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `IDCLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `SURNAME` varchar(20) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `TAX_CODE` varchar(16) NOT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  `BIRTH` date NOT NULL,
  PRIMARY KEY (`IDCLIENTE`),
  UNIQUE KEY `CLIENTE_UNICO` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (4,'TODMSFR','yyy','TOMMASO','PIROZZI','TOM@XXX.ITF','PRZTMS92P04G309L','0000000000','2018-06-21');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cliente_BEFORE_INSERT` BEFORE INSERT ON `cliente` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i'))
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PHONE,'^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    IF(NOT REGEXP_LIKE(NEW.USERNAME,'^(?!.*?[ ''.-]{2})[A-Za-z0-9 ''.-]{1,30}$','i'))
	THEN
		SIGNAL SQLSTATE '45005'
		SET MESSAGE_TEXT = 'Error : Invalid username format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cliente_BEFORE_UPDATE` BEFORE UPDATE ON `cliente` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i'))
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PHONE,'^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    IF(NOT REGEXP_LIKE(NEW.USERNAME,'^(?!.*?[ ''.-]{2})[A-Za-z0-9 ''.-]{1,30}$','i'))
	THEN
		SIGNAL SQLSTATE '45005'
		SET MESSAGE_TEXT = 'Error : Invalid username format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `evento` (
  `IDEVENTO` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(1000) NOT NULL,
  `EVENT_TYPE` varchar(20) DEFAULT NULL,
  `KIND_TYPE` varchar(20) DEFAULT NULL,
  `DATE` date NOT NULL,
  `ZIP_CODE` varchar(5) DEFAULT NULL,
  `PLACE_NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IDEVENTO`),
  KEY `FK_LUOGO` (`ZIP_CODE`),
  KEY `FK_LUOGO1` (`PLACE_NAME`,`ZIP_CODE`),
  CONSTRAINT `FK_LUOGO1` FOREIGN KEY (`PLACE_NAME`, `ZIP_CODE`) REFERENCES `luogo` (`nome`, `cap`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'PROVA1','BELLO E BUONO','SPORT','CALCIO','2017-12-05','80019','StadioQualiano');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `evento_BEFORE_INSERT` BEFORE INSERT ON `evento` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.IDEVENTO,'^[0-9]{6}$'))
	THEN
		SIGNAL SQLSTATE '45006'
		SET MESSAGE_TEXT = 'Error : Invalid ID format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.DESCRIPTION,'^[a-z0-9,.;''"/-_#?! ]+$','i'))
	THEN
		SIGNAL SQLSTATE '45007'
		SET MESSAGE_TEXT = 'Error : Invalid description format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.ZIP_CODE,'^[0-9]{3}[0-9xX]{2}$','i'))
	THEN
		SIGNAL SQLSTATE '45008'
		SET MESSAGE_TEXT = 'Error : Invalid zip code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PLACE_NAME,'^(([a-z]{1}[°]?)|([0-9]+[°]?))(([ '',."/-]{1}(([a-z]{1}[°]?)|([0-9]+[°]?)))*["'']?[,./-]?[a-z 0-9]+)*[.]?$','i'))
	THEN
		SIGNAL SQLSTATE '45009'
		SET MESSAGE_TEXT = 'Error : Invalid place name format ';
	END IF;
	IF(NOT REGEXP_LIKE(NEW.TITLE,'^[a-z0-9,.;''"/-_#?!]+$','i'))
	THEN
		SIGNAL SQLSTATE '45010'
		SET MESSAGE_TEXT = 'Error : Invalid title format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `evento_BEFORE_UPDATE` BEFORE UPDATE ON `evento` FOR EACH ROW BEGIN
	IF(NOT REGEXP_LIKE(NEW.IDEVENTO,'^[0-9]{6}$'))
	THEN
		SIGNAL SQLSTATE '45006'
		SET MESSAGE_TEXT = 'Error : Invalid ID format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.DESCRIPTION,'^[a-z0-9,.;''"/-_#?! ]+$','i'))
	THEN
		SIGNAL SQLSTATE '45007'
		SET MESSAGE_TEXT = 'Error : Invalid description format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.ZIP_CODE,'^[0-9]{3}[0-9xX]{2}$','i'))
	THEN
		SIGNAL SQLSTATE '45008'
		SET MESSAGE_TEXT = 'Error : Invalid zip code format ';
	END IF;

	IF(NOT REGEXP_LIKE(NEW.PLACE_NAME,'^(([a-z]{1}[°]?)|([0-9]+[°]?))(([ '',."/-]{1}(([a-z]{1}[°]?)|([0-9]+[°]?)))*["'']?[,./-]?[a-z 0-9]+)*[.]?$','i'))
	THEN
		SIGNAL SQLSTATE '45009'
		SET MESSAGE_TEXT = 'Error : Invalid place name format ';
	END IF;
	IF(NOT REGEXP_LIKE(NEW.TITLE,'^[a-z0-9,.;''"/-_#?!]+$','i'))
	THEN
		SIGNAL SQLSTATE '45010'
		SET MESSAGE_TEXT = 'Error : Invalid title format ';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `gestione_cliente`
--

DROP TABLE IF EXISTS `gestione_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestione_cliente` (
  `CLIENTE` int(11) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(20) DEFAULT NULL,
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `gestione_cliente_clientefk_idx` (`CLIENTE`),
  CONSTRAINT `gestione_cliente_clientefk` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `gestione_cliente_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`idamm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestione_cliente`
--

LOCK TABLES `gestione_cliente` WRITE;
/*!40000 ALTER TABLE `gestione_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestione_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestione_evento`
--

DROP TABLE IF EXISTS `gestione_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestione_evento` (
  `EVENTO` int(11) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(15) DEFAULT NULL,
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `gestione_evento_eventofk_idx` (`EVENTO`),
  CONSTRAINT `gestione_evento_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `gestione_evento_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`idamm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestione_evento`
--

LOCK TABLES `gestione_evento` WRITE;
/*!40000 ALTER TABLE `gestione_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestione_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestione_turno`
--

DROP TABLE IF EXISTS `gestione_turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestione_turno` (
  `EVENTO` int(11) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `ADDSICUREZZA` int(11) DEFAULT NULL,
  `PRESENZA` tinyint(1) DEFAULT NULL,
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `gestione_turno_sicurezzafk_idx` (`ADDSICUREZZA`),
  KEY `gestione_turno_eventofk_idx` (`EVENTO`),
  CONSTRAINT `gestione_turno_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `gestione_turno_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`idamm`),
  CONSTRAINT `gestione_turno_sicurezzafk` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`idsicurezza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestione_turno`
--

LOCK TABLES `gestione_turno` WRITE;
/*!40000 ALTER TABLE `gestione_turno` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestione_turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luogo`
--

DROP TABLE IF EXISTS `luogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `luogo` (
  `NOME` varchar(30) NOT NULL,
  `CAP` varchar(5) NOT NULL,
  `INDIRIZZO` varchar(50) DEFAULT NULL,
  `PROVINCIA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NOME`,`CAP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luogo`
--

LOCK TABLES `luogo` WRITE;
/*!40000 ALTER TABLE `luogo` DISABLE KEYS */;
INSERT INTO `luogo` VALUES ('StadioQualiano','80019','via',NULL);
/*!40000 ALTER TABLE `luogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `new_table` (
  `PROVa` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posto`
--

DROP TABLE IF EXISTS `posto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `posto` (
  `POSTOTYPE` varchar(20) DEFAULT NULL,
  `REPARTO` varchar(20) NOT NULL,
  `NOMEPOSTO` varchar(10) NOT NULL,
  PRIMARY KEY (`REPARTO`,`NOMEPOSTO`),
  CONSTRAINT `FK_REPARTO` FOREIGN KEY (`REPARTO`) REFERENCES `reparto` (`idreparto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posto`
--

LOCK TABLES `posto` WRITE;
/*!40000 ALTER TABLE `posto` DISABLE KEYS */;
/*!40000 ALTER TABLE `posto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparto`
--

DROP TABLE IF EXISTS `reparto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reparto` (
  `NOME` varchar(30) NOT NULL,
  `IDREPARTO` varchar(20) NOT NULL,
  `NOMELUOGO` varchar(50) NOT NULL,
  `CAP` varchar(5) NOT NULL,
  PRIMARY KEY (`IDREPARTO`),
  KEY `FK_LUOGO2` (`NOMELUOGO`,`CAP`),
  CONSTRAINT `FK_LUOGO2` FOREIGN KEY (`NOMELUOGO`, `CAP`) REFERENCES `luogo` (`nome`, `cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparto`
--

LOCK TABLES `reparto` WRITE;
/*!40000 ALTER TABLE `reparto` DISABLE KEYS */;
/*!40000 ALTER TABLE `reparto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariffa`
--

DROP TABLE IF EXISTS `tariffa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tariffa` (
  `EVENTO` int(11) DEFAULT NULL,
  `REPARTO` varchar(20) DEFAULT NULL,
  `PREZZO` double DEFAULT NULL,
  KEY `REPARTO` (`REPARTO`),
  KEY `tariffa_eventofk_idx` (`EVENTO`),
  CONSTRAINT `tariffa_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `tariffa_ibfk_2` FOREIGN KEY (`REPARTO`) REFERENCES `reparto` (`idreparto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariffa`
--

LOCK TABLES `tariffa` WRITE;
/*!40000 ALTER TABLE `tariffa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tariffa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'em17'
--

--
-- Dumping routines for database 'em17'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-02 19:54:12
