-- phpMyAdmin SQL Dump
-- version 3.3.7deb6
-- http://www.phpmyadmin.net
--
-- Host: hostingmysql331
-- Generato il: 21 lug, 2018 at 10:34 AM
-- Versione MySQL: 5.5.52
-- Versione PHP: 5.2.6-1+lenny16



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `registeringws`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `addsicurezza`
--

CREATE TABLE IF NOT EXISTS `addsicurezza` (
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
) TYPE=InnoDB  AUTO_INCREMENT=17 ;

--
-- Dump dei dati per la tabella `addsicurezza`
--

INSERT INTO `addsicurezza` (`IDSICUREZZA`, `USERNAME`, `PASSWORD`, `EMAIL`, `NAME`, `SURNAME`, `TAX_CODE`, `PHONE`, `SALARY`, `BIRTH`) VALUES
(1, 'CANON', 'd79c3decef6fda3fd204', 'tommasopirozzi@hotmail.it', 'TOMMASO', 'PIROZZI', 'PRZTMS92P04G309L', '3343942027', 6000, '1992-05-25'),
(2, 'MARC', '2a4cadf346eb7db51a13', 'marcello@gmail.com', 'MARCELLO', 'QUATTROMANI', 'MRCQTT95Q00T606L', '3354548484', 25000, '1995-12-10'),
(3, 'GIU', '4a165184e6848049287d', 'vanesio@live.com', 'GIULIANO', 'VANESIO', 'VNSGLN93D02F839M', '3405117062', 30000, '1993-04-02'),
(5, 'VINTOR', '9db0d7a507a37ba86c43', 'vinc@hotmail.it', 'VINCENZO', 'TORINO', 'VINTOR92P04G301P', '0810000000', 3000, '1992-06-19'),
(6, 'ROSS', '43d4876d40eff0ff3b5f', 'marior@gmail.com', 'MARIO', 'ROSSI', 'MAROSS92P04G301P', '3335696025', 5000, '1993-05-20'),
(7, 'D10S', 'dc52834d4e5983df7a1b', 'diego@hotmail.it', 'DIEGO', 'MARADONA', 'DIGMAR92P04G301P', '3391010010', 2000, '1980-06-05'),
(8, 'GREEN', 'ec061fafb777f2943027', 'verdi@live.it', 'CIRO', 'VERDI', 'VERCIR92P04G301P', '3405252633', 3500, '1985-10-12'),
(9, 'OOOO', '07f5937c9760f50867a7', 'ajs@fkf.it', 'WOW', 'SNIX', 'TURNFH12H34G374Y', '0815059922', 1500, '1992-07-15'),
(10, 'HANRY', '3212ef04a5c8e8078dd2', 'hanry@ok.it', 'HANRY', 'RADRIZ', 'RYEIWO12I34U567H', '3323344887', 1250, '1993-07-02'),
(11, 'SIGTOMPSON', '467b1b85a0ee941df09a', 'toms@live.com', 'ALBERT', 'TOMPSON', 'TMSLBT88R38I283B', '3323285943', 2600, '1988-06-28'),
(13, 'PINTO', '8cf372d1c5c152c5518e', 'angelo.pintus@gmail.com', 'ANGELO', 'PINTUS', 'PNTNGL79E05U381A', '3285485119', 3000, '1979-05-05'),
(14, 'ISTINCT', '425ed264c86619b9975b', 'berry.ul@gmail.com', 'BERRY', 'ULTER', 'LTRBRR91R16O389X', '3934455182', 1500, '1991-11-16'),
(15, 'GROSSO', 'd014737671a9a00237e6', 'jerry@live.com', 'JERRY', 'SCOTTI', 'SCTJRR65F14O326B', '3458855691', 2800, '1965-01-14'),
(16, 'NEW', '2689367b205c16ce32ed', 'ok@boh.it', 'NONSO', 'CHISSA', 'EUREIR23Y23U234I', '3313322445', 1250, '1990-07-06');

--
-- Triggers `addsicurezza`
--
DROP TRIGGER IF EXISTS `addsicurezza_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `addsicurezza_BEFORE_INSERT` BEFORE INSERT ON `addsicurezza`
 FOR EACH ROW BEGIN
	IF(NOT NEW.NAME REGEXP '^[a-zA-Z]+([']?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT NEW.SURNAME REGEXP '^[a-zA-Z]+([' -]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT NEW.TAX_CODE REGEXP '[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$')
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT NEW.EMAIL REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9]{1}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9._%-]{0,62}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9_%-]{1}@[a-zA-Z0-9]{1}[a-zA-Z0-9._%-]{1,252}.[a-zA-Z]{2,4}$')
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT NEW.PHONE REGEXP '^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$')
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NAME = UPPER(NEW.NAME);
    SET NEW.SURNAME = UPPER(NEW.SURNAME);
    SET NEW.TAX_CODE = UPPER(NEW.TAX_CODE);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `addsicurezza_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `addsicurezza_BEFORE_UPDATE` BEFORE UPDATE ON `addsicurezza`
 FOR EACH ROW BEGIN
	IF(NOT NEW.NAME REGEXP '^[a-zA-Z]+([']?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT NEW.SURNAME REGEXP '^[a-zA-Z]+([' -]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT NEW.TAX_CODE REGEXP '[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$')
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT NEW.EMAIL REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9]{1}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9._%-]{0,62}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9_%-]{1}@[a-zA-Z0-9]{1}[a-zA-Z0-9._%-]{1,252}.[a-zA-Z]{2,4}$')
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT NEW.PHONE REGEXP '^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$')
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NAME = UPPER(NEW.NAME);
    SET NEW.SURNAME = UPPER(NEW.SURNAME);
    SET NEW.TAX_CODE = UPPER(NEW.TAX_CODE);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

CREATE TABLE IF NOT EXISTS `amministratore` (
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
) TYPE=InnoDB;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`IDAMM`, `NOME`, `COGNOME`, `USERNAME`, `PASSWORD`, `CF`, `EMAIL`, `TEL`) VALUES
('1', 'TOMMASO', 'PIROZZI', 'CANON21', 'TOMMI', 'PRZTMS92P04G309L', 'TOMPIR@LIVE,IT', '3335020696'),
('12345', 'General', 'Administrator', 'ok', 'ok', 'GNLDNT90T15E313X', 'admin@em17.it', '3391234567'),
('2', 'Giuliano', 'Vanesio', 'giuEgiu', 'giuli', 'VNSGLN93D02F839M', 'GIUVAN@HOTMAIL.IT', '3405588633'),
('3', 'Marcello', 'Quattromani', 'quatt', 'marci', 'MARQTT90T15E313X', 'marc@live.com', '3335245878'),
('4', 'Vincenzo', 'Torino', 'vintor', 'vinci', 'VINTOR90T15E313X', 'vinc@hotmail.it', '3205051423');

--
-- Triggers `amministratore`
--
DROP TRIGGER IF EXISTS `amministratore_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `amministratore_BEFORE_INSERT` BEFORE INSERT ON `amministratore`
 FOR EACH ROW BEGIN
	SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NOME = UPPER(NEW.NOME);
    SET NEW.COGNOME = UPPER(NEW.COGNOME);
    SET NEW.CF = UPPER(NEW.CF);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `amministratore_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `amministratore_BEFORE_UPDATE` BEFORE UPDATE ON `amministratore`
 FOR EACH ROW BEGIN
	SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NOME = UPPER(NEW.NOME);
    SET NEW.COGNOME = UPPER(NEW.COGNOME);
    SET NEW.CF = UPPER(NEW.CF);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `biglietto`
--

CREATE TABLE IF NOT EXISTS `biglietto` (
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
  KEY `biglietto_sicurezza_idx` (`ADDSICUREZZA`)
) TYPE=InnoDB;

--
-- Dump dei dati per la tabella `biglietto`
--


--
-- Triggers `biglietto`
--
DROP TRIGGER IF EXISTS `biglietto_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `biglietto_BEFORE_INSERT` BEFORE INSERT ON `biglietto`
 FOR EACH ROW BEGIN
	SET NEW.BARCODE = UPPER(NEW.BARCODE);
    SET NEW.NOMEPOSTO = UPPER(NEW.NOMEPOSTO);
    SET NEW.REPARTO = UPPER(NEW.REPARTO);
    SET NEW.TITOLOEVENTO = UPPER(NEW.TITOLOEVENTO);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `biglietto_AFTER_INSERT`;
DELIMITER //
CREATE TRIGGER `biglietto_AFTER_INSERT` AFTER INSERT ON `biglietto`
 FOR EACH ROW BEGIN
	SELECT COUNT(*) FROM BIGLIETTO WHERE CLIENTE= NEW.CLIENTE INTO @BIGLIETTI;
    UPDATE CLIENTE SET ACQUISTI = @BIGLIETTI WHERE IDCLIENTE = NEW.CLIENTE;
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `biglietto_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `biglietto_BEFORE_UPDATE` BEFORE UPDATE ON `biglietto`
 FOR EACH ROW BEGIN
	SET NEW.BARCODE = UPPER(NEW.BARCODE);
    SET NEW.NOMEPOSTO = UPPER(NEW.NOMEPOSTO);
    SET NEW.REPARTO = UPPER(NEW.REPARTO);
    SET NEW.TITOLOEVENTO = UPPER(NEW.TITOLOEVENTO);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
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
) TYPE=InnoDB  AUTO_INCREMENT=6 ;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`IDCLIENTE`, `USERNAME`, `PASSWORD`, `NAME`, `SURNAME`, `EMAIL`, `TAX_CODE`, `PHONE`, `BIRTH`, `ACQUISTI`) VALUES
(4, 'PROVA123', 'yyy', 'TOMMASO', 'PIROZZI', 'TOM@XXX.ITF', 'PRZTMS92P04G309L', '0810000000', '1992-06-21', 2),
(5, 'KEFMEKM', 'MEMKFK', 'GIULIANO', 'VANESIO', 'GIU@GG.IT', 'GRNVNS93D02F839M', '0810000000', '1993-04-17', 0);

--
-- Triggers `cliente`
--
DROP TRIGGER IF EXISTS `cliente_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `cliente_BEFORE_INSERT` BEFORE INSERT ON `cliente`
 FOR EACH ROW BEGIN
	IF(NOT NEW.NAME REGEXP '^[a-zA-Z]+([']?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT NEW.SURNAME REGEXP '^[a-zA-Z]+([' -]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT NEW.TAX_CODE REGEXP '[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$')
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT NEW.EMAIL REGEXP'^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9]{1}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9._%-]{0,62}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9_%-]{1}@[a-zA-Z0-9]{1}[a-zA-Z0-9._%-]{1,252}.[a-zA-Z]{2,4}$')
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT NEW.PHONE REGEXP '^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$')
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    IF(NOT NEW.USERNAME REGEXP'^(?!.*?[ '.-]{2})[A-Za-z0-9 '.-]{1,30}$')
	THEN
		SIGNAL SQLSTATE '45005'
		SET MESSAGE_TEXT = 'Error : Invalid username format ';
	END IF;
	SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NAME = UPPER(NEW.NAME);
    SET NEW.SURNAME = UPPER(NEW.SURNAME);
    SET NEW.TAX_CODE = UPPER(NEW.TAX_CODE);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `cliente_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `cliente_BEFORE_UPDATE` BEFORE UPDATE ON `cliente`
 FOR EACH ROW BEGIN
    IF(NOT NEW.NAME REGEXP '^[a-zA-Z]+([']?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error : Invalid name format ';
	END IF;

	IF(NOT NEW.SURNAME REGEXP '^[a-zA-Z]+([' -]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z ]+)*$')
	THEN
		SIGNAL SQLSTATE '45001'
		SET MESSAGE_TEXT = 'Error : Invalid surname format ';
	END IF;

	IF(NOT NEW.TAX_CODE REGEXP '[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$')
	THEN
		SIGNAL SQLSTATE '45002'
		SET MESSAGE_TEXT = 'Error : Invalid tax code format ';
	END IF;

	IF(NOT NEW.EMAIL REGEXP'^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9]{1}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9._%-]{0,62}[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9_%-]{1}@[a-zA-Z0-9]{1}[a-zA-Z0-9._%-]{1,252}.[a-zA-Z]{2,4}$')
	THEN
		SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Error : Invalid email format ';
	END IF;

	IF(NOT NEW.PHONE REGEXP '^([+]{1}[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$')
	THEN
		SIGNAL SQLSTATE '45004'
		SET MESSAGE_TEXT = 'Error : Invalid phone format ';
	END IF;
    IF(NOT NEW.USERNAME REGEXP'^(?!.*?[ '.-]{2})[A-Za-z0-9 '.-]{1,30}$')
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
	SET NEW.USERNAME = UPPER(NEW.USERNAME);
    SET NEW.EMAIL = LOWER(NEW.EMAIL);
    SET NEW.NAME = UPPER(NEW.NAME);
    SET NEW.SURNAME = UPPER(NEW.SURNAME);
    SET NEW.TAX_CODE = UPPER(NEW.TAX_CODE);
    SET NEW.PASSWORD = SHA2(NEW.PASSWORD, 256);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `evento`
--

CREATE TABLE IF NOT EXISTS `evento` (
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
) TYPE=InnoDB  AUTO_INCREMENT=33 ;

--
-- Dump dei dati per la tabella `evento`
--

INSERT INTO `evento` (`IDEVENTO`, `TITLE`, `DESCRIPTION`, `EVENT_TYPE`, `KIND_TYPE`, `DATE`, `ZIP_CODE`, `PLACE_NAME`) VALUES
(1, 'DA PAURA', 'BELLO E BUONO', 'CINEMA', 'HORROR', '2017-12-05', '80019', 'StadioQualiano'),
(2, 'Harry Potter', 'Film fantasy adatto a tutti', 'CINEMA', 'OTHER', '2018-08-09', NULL, 'UCICINEMAS,NAPOLI'),
(3, 'Pokemon', 'Film per bambini', 'CINEMA', 'OTHER', '2018-07-11', NULL, 'MED Maxicinema'),
(4, 'Vasco in Tour', 'Vasco Rossi in tour per l''Italia', 'CONCERT', 'OTHER', '2018-07-12', NULL, 'Stadio San Paolo Napoli'),
(5, 'PROVA', 'SUPER EVENTO', 'CINEMA', 'COMEDY', '2018-06-18', '80019', 'STADIOQUALIANO'),
(6, 'VASCO IN TOUR', 'Vasco Rossi in tour per l''Italia', 'CONCERT', 'OTHER', '2018-08-20', NULL, 'Stadio San Siro Milano'),
(7, 'INTER-LAZIO', 'PARTITA DI CAMPIONATO', 'SPORT', 'FOOTBALL', '2018-11-20', NULL, 'STADIO SAN SIRO MILANO'),
(8, 'Legnano-Monza', 'Partita di volley', 'SPORT', 'VOLLEYBALL', '2018-10-11', NULL, 'PALABORSANI Castellenza VA'),
(9, 'PROVA2', 'SUPER EVENTO', 'SPORT', 'FOOTBALL', '2018-06-18', '80019', 'StadioQualiano'),
(10, 'Vasco in Tour', 'Vasco Rossi in tour per l''Italia', 'CONCERT', 'OTHER', '2018-09-15', NULL, 'Stadio Olimpico Roma'),
(11, 'A CASA 1', 'OK', 'CINEMA', 'COMEDY', '2018-07-11', NULL, 'asd'),
(14, 'SMALL', '\naf', 'CINEMA', 'COMEDY', '2018-07-06', NULL, 'aef'),
(23, 'Napoli-Juve', 'test', 'SPORT', 'FOOTBALL', '2019-03-06', NULL, 'test'),
(24, 'Harry Potter 3', 'test', 'CINEMA', 'OTHER', '2020-06-07', NULL, 'test'),
(27, 'ZAINO IN SPALLA', 'IN GIRO PER L''ITALIA CON ZAINO IN SPALLA', 'SPORT', 'OTHER', '2018-07-27', NULL, 'DA CATANIA A MILANO'),
(28, 'PARTITA DEL CUORE', 'PARTITA DI BENEFICENZA', 'SPORT', 'FOOTBALL', '2018-08-06', NULL, 'STADIO SAN PAOLO'),
(29, 'BELLA LÌ', 'DIVERTENTE', 'THEATER', 'OTHER', '2018-07-31', '80124', 'TEATRO NUOVO');

--
-- Triggers `evento`
--
DROP TRIGGER IF EXISTS `evento_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `evento_BEFORE_INSERT` BEFORE INSERT ON `evento`
 FOR EACH ROW BEGIN
	IF(NOT NEW.DESCRIPTION REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9 
,.;'"/_#?!-]+$')
	THEN
		SIGNAL SQLSTATE '45007'
		SET MESSAGE_TEXT = 'Error : Invalid description format ';
	END IF;

	IF(NOT NEW.ZIP_CODE REGEXP '^[0-9]{3}[0-9xX]{2}$')
	THEN
		SIGNAL SQLSTATE '45008'
		SET MESSAGE_TEXT = 'Error : Invalid zip code format ';
	END IF;

	IF(NOT NEW.PLACE_NAME REGEXP '^(([a-zA-Z]{1}[°]?)|([0-9]+[°]?))(([ ',."/-]{1}(([ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z]{1}[°]?)|([0-9]+[°]?)))*["']?[,./-]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z 0-9]+)*[.]?$')
	THEN
		SIGNAL SQLSTATE '45009'
		SET MESSAGE_TEXT = 'Error : Invalid place name format ';
	END IF;
	IF(NOT NEW.TITLE REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9 ,.;'"/_#?!-]+$')
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
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'COMEDY' AND NEW.KIND_TYPE != 'MUSICAL' AND NEW.KIND_TYPE != 'CABARET' AND NEW.EVENT_TYPE = 'THEATER')
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
    SET NEW.TITLE = UPPER(NEW.TITLE);
    SET NEW.DESCRIPTION = UPPER(NEW.DESCRIPTION);
    SET NEW.EVENT_TYPE = UPPER(NEW.EVENT_TYPE);
    SET NEW.KIND_TYPE = UPPER(NEW.KIND_TYPE);
    SET NEW.PLACE_NAME = UPPER(NEW.PLACE_NAME);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `evento_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `evento_BEFORE_UPDATE` BEFORE UPDATE ON `evento`
 FOR EACH ROW BEGIN
	
	IF(NOT NEW.DESCRIPTION REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9 
,.;'"/_#?!-]+$')
	THEN
		SIGNAL SQLSTATE '45007'
		SET MESSAGE_TEXT = 'Error : Invalid description format ';
	END IF;

	IF(NOT NEW.ZIP_CODE REGEXP '^[0-9]{3}[0-9xX]{2}$')
	THEN
		SIGNAL SQLSTATE '45008'
		SET MESSAGE_TEXT = 'Error : Invalid zip code format ';
	END IF;

	IF(NOT NEW.PLACE_NAME REGEXP '^(([a-zA-Z]{1}[°]?)|([0-9]+[°]?))(([ ',."/-]{1}(([ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z]{1}[°]?)|([0-9]+[°]?)))*["']?[,./-]?[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z 0-9]+)*[.]?$')
	THEN
		SIGNAL SQLSTATE '45009'
		SET MESSAGE_TEXT = 'Error : Invalid place name format ';
	END IF;
	IF(NOT NEW.TITLE REGEXP '^[ÀÁÈÉÌÍÒÓÙÚàáèéìíòóùúa-zA-Z0-9 ,.;'"/_#?!-]+$')
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
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'COMEDY' AND NEW.KIND_TYPE != 'MUSICAL' AND NEW.KIND_TYPE != 'CABARET' AND NEW.EVENT_TYPE = 'THEATER')
    THEN
		SIGNAL SQLSTATE '45013'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Theater ';
	END IF;
    IF(NEW.KIND_TYPE != 'OTHER' AND NEW.KIND_TYPE != 'COMEDY' AND NEW.KIND_TYPE != 'DRAMATIC' AND NEW.KIND_TYPE != 'HORROR' AND NEW.EVENT_TYPE = 'CINEMA')
    THEN
		SIGNAL SQLSTATE '45014'
		SET MESSAGE_TEXT = 'Error : The kind inserted is not of the type Cinema ';
	END IF;
    SET NEW.TITLE = UPPER(NEW.TITLE);
    SET NEW.DESCRIPTION = UPPER(NEW.DESCRIPTION);
    SET NEW.EVENT_TYPE = UPPER(NEW.EVENT_TYPE);
    SET NEW.KIND_TYPE = UPPER(NEW.KIND_TYPE);
    SET NEW.PLACE_NAME = UPPER(NEW.PLACE_NAME);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `gestione_cliente`
--

CREATE TABLE IF NOT EXISTS `gestione_cliente` (
  `CLIENTE` int(11) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(20) DEFAULT NULL,
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `gestione_cliente_clientefk_idx` (`CLIENTE`)
) TYPE=InnoDB;

--
-- Dump dei dati per la tabella `gestione_cliente`
--


--
-- Triggers `gestione_cliente`
--
DROP TRIGGER IF EXISTS `gestione_cliente_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `gestione_cliente_BEFORE_INSERT` BEFORE INSERT ON `gestione_cliente`
 FOR EACH ROW BEGIN
	SET NEW.OPERATION = UPPER(NEW.OPERATION);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `gestione_cliente_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `gestione_cliente_BEFORE_UPDATE` BEFORE UPDATE ON `gestione_cliente`
 FOR EACH ROW BEGIN
	SET NEW.OPERATION = UPPER(NEW.OPERATION);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `gestione_evento`
--

CREATE TABLE IF NOT EXISTS `gestione_evento` (
  `EVENTO` int(11) DEFAULT NULL,
  `AMMINISTRATORE` varchar(20) DEFAULT NULL,
  `OPERATION` varchar(15) DEFAULT NULL,
  KEY `AMMINISTRATORE` (`AMMINISTRATORE`),
  KEY `gestione_evento_eventofk_idx` (`EVENTO`)
) TYPE=InnoDB;

--
-- Dump dei dati per la tabella `gestione_evento`
--


--
-- Triggers `gestione_evento`
--
DROP TRIGGER IF EXISTS `gestione_evento_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `gestione_evento_BEFORE_INSERT` BEFORE INSERT ON `gestione_evento`
 FOR EACH ROW BEGIN
	SET NEW.OPERATION = UPPER(NEW.OPERATION);
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `gestione_evento_BEFORE_UPDATE`;
DELIMITER //
CREATE TRIGGER `gestione_evento_BEFORE_UPDATE` BEFORE UPDATE ON `gestione_evento`
 FOR EACH ROW BEGIN
	SET NEW.OPERATION = UPPER(NEW.OPERATION);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struttura della tabella `gestione_turno`
--

CREATE TABLE IF NOT EXISTS `gestione_turno` (
  `EVENTO` int(11) DEFAULT NULL,
  `ADDSICUREZZA` int(11) DEFAULT NULL,
  `START` time NOT NULL,
  `END` time NOT NULL,
  `TURN_NUMBER` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`TURN_NUMBER`),
  KEY `gestione_turno_sicurezzafk_idx` (`ADDSICUREZZA`),
  KEY `gestione_turno_eventofk_idx` (`EVENTO`)
) TYPE=InnoDB  AUTO_INCREMENT=29 ;

--
-- Dump dei dati per la tabella `gestione_turno`
--

INSERT INTO `gestione_turno` (`EVENTO`, `ADDSICUREZZA`, `START`, `END`, `TURN_NUMBER`) VALUES
(1, 2, '00:00:00', '00:00:00', 6),
(5, 1, '17:00:00', '18:00:00', 11),
(5, 1, '16:00:00', '01:00:00', 15),
(5, 1, '01:00:00', '02:00:00', 22),
(8, 1, '01:00:00', '02:00:00', 24),
(9, 10, '01:00:00', '02:00:00', 25),
(6, 3, '17:00:00', '00:00:00', 26),
(1, 3, '16:00:00', '00:00:00', 27),
(6, 1, '01:00:00', '02:00:00', 28);

--
-- Triggers `gestione_turno`
--
DROP TRIGGER IF EXISTS `gestione_turno_BEFORE_INSERT`;
DELIMITER //
CREATE TRIGGER `gestione_turno_BEFORE_INSERT` BEFORE INSERT ON `gestione_turno`
 FOR EACH ROW BEGIN
	DECLARE DATE_TURN DATE;
	DECLARE CHECK_TURN INTEGER;

	IF(NEW.END < NEW.START) THEN
		IF((24 - (TIME_TO_SEC(NEW.START)/3600)) + (TIME_TO_SEC(NEW.END)/3600) > 12) THEN
			SIGNAL SQLSTATE '45016'
			SET MESSAGE_TEXT = 'Error : It isn't possible to work for more than 12 hours';
		END IF;
	ELSEIF(NEW.END > NEW.START) THEN
		IF(TIME_TO_SEC(TIMEDIFF(NEW.END, NEW.START))/3600 > 12) THEN
			SIGNAL SQLSTATE '45016'
			SET MESSAGE_TEXT = 'Error : It isn't possible to work for more than 12 hours';
		END IF;
	ELSE
		SIGNAL SQLSTATE '45017'
		SET MESSAGE_TEXT = 'Error : The start time can't be the same as the end time';
    END IF;
    SELECT EVENTO.DATE FROM EVENTO WHERE EVENTO.IDEVENTO = NEW.EVENTO INTO DATE_TURN; -- prendo la data del turno che sto inserendo
    SELECT COUNT(*) FROM EVENTO WHERE EVENTO.DATE = DATE_TURN AND NEW.ADDSICUREZZA IN (SELECT ADDSICUREZZA FROM GESTIONE_TURNO WHERE GESTIONE_TURNO.EVENTO = EVENTO.IDEVENTO) INTO CHECK_TURN; -- controllo se esistono già turni di quell'addetto per quella data
    IF(CHECK_TURN > 0) THEN
		SIGNAL SQLSTATE '45018'
		SET MESSAGE_TEXT = 'Error : Thise security officer already has a turn this day';
    END IF;
END
//
DELIMITER ;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `biglietto`
--
ALTER TABLE `biglietto`
  ADD CONSTRAINT `biglietto_clientefk` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`IDCLIENTE`),
  ADD CONSTRAINT `biglietto_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`IDEVENTO`),
  ADD CONSTRAINT `biglietto_sicurezza` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`IDSICUREZZA`);

--
-- Limiti per la tabella `gestione_cliente`
--
ALTER TABLE `gestione_cliente`
  ADD CONSTRAINT `gestione_cliente_clientefk` FOREIGN KEY (`CLIENTE`) REFERENCES `cliente` (`IDCLIENTE`),
  ADD CONSTRAINT `gestione_cliente_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`IDAMM`);

--
-- Limiti per la tabella `gestione_evento`
--
ALTER TABLE `gestione_evento`
  ADD CONSTRAINT `gestione_evento_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`IDEVENTO`),
  ADD CONSTRAINT `gestione_evento_ibfk_2` FOREIGN KEY (`AMMINISTRATORE`) REFERENCES `amministratore` (`IDAMM`);

--
-- Limiti per la tabella `gestione_turno`
--
ALTER TABLE `gestione_turno`
  ADD CONSTRAINT `gestione_turno_eventofk` FOREIGN KEY (`EVENTO`) REFERENCES `evento` (`IDEVENTO`),
  ADD CONSTRAINT `gestione_turno_sicurezzafk` FOREIGN KEY (`ADDSICUREZZA`) REFERENCES `addsicurezza` (`IDSICUREZZA`);
