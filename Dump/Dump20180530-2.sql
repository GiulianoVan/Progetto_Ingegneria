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
  `IDSICUREZZA` varchar(20) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addsicurezza`
--

LOCK TABLES `addsicurezza` WRITE;
/*!40000 ALTER TABLE `addsicurezza` DISABLE KEYS */;
INSERT INTO `addsicurezza` VALUES ('1','CANON','TOMMI','tommasopirozzi@hotmail.it','TOMMASO1','PIROZZI','PRZTMS92P04G309L','3343942027',3000,'2018-01-01'),('2','MARCE','TOMMI','tom@hhh','MARCELLO','QUATTROMANI','PRZTMS92P04G309L','4548484',1500.5,'2018-01-01'),('3','GIUL','TOMMI','tom@hhh','GIULIANO','VANESIO','PRZTMS92P04G309L','3405117062',1500.5,'2018-01-01'),('4','VIN','TOMMI','tom@hhh','VINCENZO','TORINO','PRZTMS92P04G308L','77777',1000,'2018-01-01');
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
/*!50003 CREATE*/ /*!50017 DEFINER=CURRENT_USER*/ /*!50003 TRIGGER `addsicurezza_BEFORE_INSERT` BEFORE INSERT ON `addsicurezza` FOR EACH ROW BEGIN

IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
THEN
	 
	SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Error : Invalid Name format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
THEN
	SIGNAL SQLSTATE '45001'
    SET MESSAGE_TEXT = 'Error : Invalid Surname format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
THEN
	SIGNAL SQLSTATE '45002'
    SET MESSAGE_TEXT = 'Error : Invalid Tax_code format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9_]+@[a-z0-9\-]+\.[a-z0-9\-\.]+$]','i'))
THEN
	SIGNAL SQLSTATE '45003'
    SET MESSAGE_TEXT = 'Error : Invalid Email format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.PHONE,'^(\+[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
THEN
	SIGNAL SQLSTATE '45003'
    SET MESSAGE_TEXT = 'Error : Invalid Email format ';
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
/*!50003 CREATE*/ /*!50017 DEFINER=CURRENT_USER*/ /*!50003 TRIGGER `addsicurezza_BEFORE_UPDATE` BEFORE UPDATE ON `addsicurezza` FOR EACH ROW BEGIN

IF(NOT REGEXP_LIKE(NEW.NAME,'^[a-z]+(['']?[a-z ]+)*$','i'))
THEN
	 
	SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Error : Invalid Name format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.SURNAME,'^[a-z]+(['' -]?[a-z ]+)*$','i'))
THEN
	SIGNAL SQLSTATE '45001'
    SET MESSAGE_TEXT = 'Error : Invalid Surname format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.TAX_CODE,'[a-z]{6}[0-9]{2}[a-z][0-9]{2}[a-z][0-9]{3}[a-z]$','i'))
THEN
	SIGNAL SQLSTATE '45002'
    SET MESSAGE_TEXT = 'Error : Invalid Tax_code format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.EMAIL,'^[a-z0-9_]+@[a-z0-9\-]+\.[a-z0-9\-\.]+$]','i'))
THEN
	SIGNAL SQLSTATE '45003'
    SET MESSAGE_TEXT = 'Error : Invalid Email format ';
END IF;

IF(NOT REGEXP_LIKE(NEW.PHONE,'^(\+[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$','i'))
THEN
	SIGNAL SQLSTATE '45003'
    SET MESSAGE_TEXT = 'Error : Invalid Email format ';
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
INSERT INTO `amministratore` VALUES ('1','TOMMASO','PIROZZI','CANON21','TOMMI','PRZTMS92P04G309L','XXX','000');
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
  `EVENTO` varchar(20) DEFAULT NULL,
  `CLIENTE` varchar(20) DEFAULT NULL,
  `TITOLOEVENTO` varchar(30) NOT NULL,
  `ADDSICUREZZA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDBIGLIETTO`),
  KEY `EVENTO` (`EVENTO`),
  KEY `CLIENTE` (`CLIENTE`),
  KEY `ADDSICUREZZA` (`ADDSICUREZZA`),
  KEY `FK_POSTO2` (`REPARTO`,`NOMEPOSTO`),
  CONSTRAINT `FK_POSTO2` FOREIGN KEY (`REPARTO`, `NOMEPOSTO`) REFERENCES `posto` (`reparto`, `nomeposto`),
  CONSTRAINT `biglietto_ibfk_1` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `biglietto_ibfk_2` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `biglietto_ibfk_3` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`IDSICUREZZA`)
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
  `IDCLIENTE` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASS` varchar(20) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `CF` varchar(16) NOT NULL,
  `TEL` varchar(10) DEFAULT NULL,
  `DNASCITA` date NOT NULL,
  PRIMARY KEY (`IDCLIENTE`),
  UNIQUE KEY `CLIENTE_UNICO` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('1','PROVA','prova1','TOMMASO','PIROZZI','kmkdmf','556','55','2015-05-05');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `evento` (
  `IDEVENTO` varchar(50) NOT NULL,
  `TITOLO` varchar(50) NOT NULL,
  `DESCRIZIONE` varchar(1000) NOT NULL,
  `EVENTOTYPE` varchar(20) DEFAULT NULL,
  `GENERETYPE` varchar(20) DEFAULT NULL,
  `DATA` date NOT NULL,
  `CAP` varchar(5) DEFAULT NULL,
  `NOMELUOGO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`IDEVENTO`),
  KEY `FK_LUOGO` (`CAP`),
  KEY `FK_LUOGO1` (`NOMELUOGO`,`CAP`),
  CONSTRAINT `FK_LUOGO1` FOREIGN KEY (`NOMELUOGO`, `CAP`) REFERENCES `luogo` (`nome`, `cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES ('1','PROVA1','XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX','SPORT','CALCIO','2017-12-05','80019','StadioQualiano');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestione_cliente`
--

DROP TABLE IF EXISTS `gestione_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestione_cliente` (
  `CLIENTE` varchar(20) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(20) DEFAULT NULL,
  KEY `CLIENTE` (`CLIENTE`),
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  CONSTRAINT `gestione_cliente_ibfk_1` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`idcliente`),
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
  `EVENTO` varchar(20) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(15) DEFAULT NULL,
  KEY `EVENTO` (`EVENTO`),
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  CONSTRAINT `gestione_evento_ibfk_1` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
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
  `EVENTO` varchar(20) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `ADDSICUREZZA` varchar(20) DEFAULT NULL,
  `PRESENZA` tinyint(1) DEFAULT NULL,
  KEY `EVENTO` (`EVENTO`),
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `ADDSICUREZZA` (`ADDSICUREZZA`),
  CONSTRAINT `gestione_turno_ibfk_1` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
  CONSTRAINT `gestione_turno_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`idamm`),
  CONSTRAINT `gestione_turno_ibfk_3` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`IDSICUREZZA`)
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
  PRIMARY KEY (`NOME`,`CAP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luogo`
--

LOCK TABLES `luogo` WRITE;
/*!40000 ALTER TABLE `luogo` DISABLE KEYS */;
INSERT INTO `luogo` VALUES ('StadioQualiano','80019','via');
/*!40000 ALTER TABLE `luogo` ENABLE KEYS */;
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
  `EVENTO` varchar(20) DEFAULT NULL,
  `REPARTO` varchar(20) DEFAULT NULL,
  `PREZZO` double DEFAULT NULL,
  KEY `EVENTO` (`EVENTO`),
  KEY `REPARTO` (`REPARTO`),
  CONSTRAINT `tariffa_ibfk_1` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`idevento`),
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

-- Dump completed on 2018-05-30 20:04:10
