-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: em17
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
  UNIQUE KEY `USER_UNICO` (`USERNAME`),
  UNIQUE KEY `TAX_CODE_UNIQUE` (`TAX_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addsicurezza`
--

LOCK TABLES `addsicurezza` WRITE;
/*!40000 ALTER TABLE `addsicurezza` DISABLE KEYS */;
INSERT INTO `addsicurezza` VALUES (1,'CANON','TOMMI','tommasopirozzi@hotmail.it','TOMMASO','PIROZZI','PRZTMS92P04G309L','3343942027',6000,'2018-01-01'),(2,'MARCE','TOMMI','tom@hhhit','MARCELLO','QUATTROMANI','PRZTMS92P04G306L','3354548484',1500.5,'2018-01-01'),(3,'GIUL','TOMMI','prova@hhh.it','GIULIANO','VANESIO','PRZTMS92P04G305L','3405117062',1600,'2018-01-01'),(5,'prova','prova','vinc@hotmail.it','VINCENZO','TORINO','PRZTMS92P04G301P','0810000000',3000.15,'1992-06-19');
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
  `PREZZO` double DEFAULT NULL,
  `NOMEPOSTO` varchar(10) DEFAULT NULL,
  `REPARTO` varchar(20) DEFAULT NULL,
  `DATAEVENTO` date NOT NULL,
  `EVENTO` int(11) DEFAULT NULL,
  `CLIENTE` int(11) DEFAULT NULL,
  `TITOLOEVENTO` varchar(30) NOT NULL,
  `ADDSICUREZZA` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDBIGLIETTO`),
  KEY `EVENTO` (`EVENTO`),
  KEY `biglietto_clientefk_idx` (`CLIENTE`),
  KEY `biglietto_sicurezza_idx` (`ADDSICUREZZA`),
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `biglietto_AFTER_INSERT` AFTER INSERT ON `biglietto` FOR EACH ROW BEGIN

SELECT COUNT(*) FROM BIGLIETTO WHERE CLIENTE= NEW.CLIENTE INTO @BIGLIETTI;
 
UPDATE CLIENTE SET ACQUISTI = @BIGLIETTI WHERE IDCLIENTE = NEW.CLIENTE;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  `ACQUISTI` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCLIENTE`),
  UNIQUE KEY `CLIENTE_UNICO` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (4,'PROVA123','yyy','TOMMASO','PIROZZI','TOM@XXX.ITF','PRZTMS92P04G309L','0810000000','1992-06-21',2),(5,'KEFMEKM','MEMKFK','GIULIANO','VANESIO','GIU@GG.IT','GRNVNS93D02F839M','0810000000','1993-04-17',0);
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
    SELECT COUNT(*) FROM BIGLIETTO WHERE CLIENTE= NEW.IDCLIENTE INTO @BIGLIETTI;
    IF(@BIGLIETTI != NEW.ACQUISTI)
    THEN
       SIGNAL SQLSTATE '45006'
	   SET MESSAGE_TEXT = @BIGLIETTI; -- 'Error : That column is automatically calculated, you cant update it '
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
  `EVENT_TYPE` enum('SPORT','CONCERT','THEATER','CINEMA','OTHER') NOT NULL,
  `KIND_TYPE` enum('FOOTBALL','TENNIS','BASKET','VOLLEYBALL','SWIMMING','POP AND ROCK','METAL','MUSICAL','CABARET','COMEDY','DRAMATIC','HORROR','OTHER') NOT NULL,
  `DATE` date NOT NULL,
  `ZIP_CODE` varchar(5) DEFAULT NULL,
  `PLACE_NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IDEVENTO`),
  KEY `FK_LUOGO` (`ZIP_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'DA PAURA','BELLO E BUONO','CINEMA','HORROR','2017-12-05','80019','StadioQualiano'),(5,'PROVA1','SUPER EVENTO','CINEMA','COMEDY','2018-06-18','80019','StadioQualiano'),(9,'PROVA2','SUPER EVENTO','SPORT','FOOTBALL','2018-06-18','80019','StadioQualiano'),(11,'A CASA 1','OK','CINEMA','COMEDY','2018-07-11',NULL,'asd'),(14,'sf','\naf','CINEMA','COMEDY','2018-07-06',NULL,'aef');
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
	IF(NOT REGEXP_LIKE(NEW.DESCRIPTION,'^[a-z0-9 \n,.;''"/_#?!-]+$','i'))
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
	IF(NOT REGEXP_LIKE(NEW.TITLE,'^[a-z0-9 ,.;''"/_#?!-]+$','i'))
	THEN
		SIGNAL SQLSTATE '45010'
		SET MESSAGE_TEXT = 'Error : Invalid title format ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'FOOTBALL' AND NEW.KIND_TYPE != 'TENNIS' AND NEW.KIND_TYPE != 'BASKET' AND NEW.KIND_TYPE != 'VOLLEYBALL' AND NEW.KIND_TYPE != 'SWIMMING' AND NEW.EVENT_TYPE = 'SPORT')
    THEN
		SIGNAL SQLSTATE '45011'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Sport ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL' AND NEW.EVENT_TYPE = 'CONCERT')
    THEN
		SIGNAL SQLSTATE '45012'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Concert ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'MUSICAL' AND NEW.KIND_TYPE != 'CABARET' AND NEW.EVENT_TYPE = 'THEATER')
    THEN
		SIGNAL SQLSTATE '45013'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Theater ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'COMEDY' AND NEW.KIND_TYPE != 'DRAMATIC' AND NEW.KIND_TYPE != 'HORROR' AND NEW.EVENT_TYPE = 'CINEMA')
    THEN
		SIGNAL SQLSTATE '45014'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Cinema ';
	END IF;
    IF(NEW.DATE <= DATE(NOW())) THEN
		SIGNAL SQLSTATE '45015'
		SET MESSAGE_TEXT = 'Error : the entered date has already passed ';
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
	IF(NOT REGEXP_LIKE(NEW.TITLE,'^[a-z0-9,.;''"/-_#?! ]+$','i'))
	THEN
		SIGNAL SQLSTATE '45010'
		SET MESSAGE_TEXT = 'Error : Invalid title format ';
	END IF;
    IF(NEW.EVENT_TYPE != OLD.EVENT_TYPE)
    THEN
        SET NEW.KIND_TYPE = 'OTHER';
        
    END IF;
	IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'FOOTBALL' AND NEW.KIND_TYPE != 'TENNIS' AND NEW.KIND_TYPE != 'BASKET' AND NEW.KIND_TYPE != 'VOLLEYBALL' AND NEW.KIND_TYPE != 'SWIMMING' AND NEW.EVENT_TYPE = 'SPORT')
    THEN
		SIGNAL SQLSTATE '45011'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Sport ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'POP AND ROCK' AND NEW.KIND_TYPE != 'METAL' AND NEW.EVENT_TYPE = 'CONCERT')
    THEN
		SIGNAL SQLSTATE '45012'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Concert ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'MUSICAL' AND NEW.KIND_TYPE != 'CABARET' AND NEW.EVENT_TYPE = 'THEATER')
    THEN
		SIGNAL SQLSTATE '45013'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Theater ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'COMEDY' AND NEW.KIND_TYPE != 'DRAMATIC' AND NEW.KIND_TYPE != 'HORROR' AND NEW.EVENT_TYPE = 'CINEMA')
    THEN
		SIGNAL SQLSTATE '45014'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Cinema ';
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
  `ADDSICUREZZA` int(11) DEFAULT NULL,
  `START` time NOT NULL,
  `END` time NOT NULL,
  `TURN_NUMBER` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`TURN_NUMBER`),
  KEY `gestione_turno_sicurezzafk_idx` (`ADDSICUREZZA`),
  KEY `gestione_turno_eventofk_idx` (`EVENTO`),
  CONSTRAINT `gestione_turno_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `gestione_turno_sicurezzafk` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`idsicurezza`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestione_turno`
--

LOCK TABLES `gestione_turno` WRITE;
/*!40000 ALTER TABLE `gestione_turno` DISABLE KEYS */;
INSERT INTO `gestione_turno` VALUES (1,2,'00:00:00','00:00:00',6),(5,1,'17:00:00','18:00:00',11),(5,1,'17:00:00','18:00:00',12),(5,1,'17:00:00','18:00:00',13),(9,1,'17:00:00','18:00:00',14);
/*!40000 ALTER TABLE `gestione_turno` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `gestione_turno_BEFORE_INSERT` BEFORE INSERT ON `gestione_turno` FOR EACH ROW BEGIN
	/*IF(NEW.END < NEW.START) THEN
		IF((NEW.START - NEW.END) > TO_TIME(12:00:00) THEN
			SIGNAL SQLSTATE '45016'
			SET MESSAGE_TEXT = 'Error : It isn''t possible to work for more than 12 hours';
		END IF;
	ELSEIF(NEW.END > NEW.START) THEN
		IF((NEW.END - NEW.START) > 12:00:00) THEN
			SIGNAL SQLSTATE '45016'
			SET MESSAGE_TEXT = 'Error : It isn''t possible to work for more than 12 hours';
		END IF;
    END IF;*/
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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

-- Dump completed on 2018-07-08 19:48:12
