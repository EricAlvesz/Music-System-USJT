-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: musicas
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `avaliamusica`
--

DROP TABLE IF EXISTS `avaliamusica`;
/*!50001 DROP VIEW IF EXISTS `avaliamusica`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `avaliamusica` AS SELECT 
 1 AS `idusuario`,
 1 AS `idMusica`,
 1 AS `descricao`,
 1 AS `Nota`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `dataInsercao` datetime NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Forró','2020-11-30 16:49:41'),(2,'MPB','2020-11-30 16:53:39'),(3,'Funk','2020-11-30 16:53:49');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generousuario`
--

DROP TABLE IF EXISTS `generousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generousuario` (
  `idGeneroUsuario` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `idGenero` int NOT NULL,
  `dataInsercao` datetime NOT NULL,
  PRIMARY KEY (`idGeneroUsuario`),
  UNIQUE KEY `uniqueEscolha` (`idUsuario`,`idGenero`),
  KEY `idUsuario_idx` (`idUsuario`),
  KEY `idGenero_idx` (`idGenero`),
  CONSTRAINT `idGenero` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='Tabela que irá guardar o genero que cada usuario gosta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generousuario`
--

LOCK TABLES `generousuario` WRITE;
/*!40000 ALTER TABLE `generousuario` DISABLE KEYS */;
INSERT INTO `generousuario` VALUES (22,4,2,'2020-12-01 09:24:37'),(36,1,3,'2020-12-01 16:09:57'),(37,1,2,'2020-12-01 16:10:07');
/*!40000 ALTER TABLE `generousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica` (
  `idMusica` int NOT NULL AUTO_INCREMENT,
  `idGenero` int NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`idMusica`),
  KEY `idGenero_idx` (`idGenero`),
  CONSTRAINT `idGeneroMusica` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
INSERT INTO `musica` VALUES (1,1,'Investe em mim'),(2,1,'Romance desapegado'),(3,1,'Recairei'),(4,1,'Na cama que eu paguei'),(5,1,'Chorona'),(6,2,'Aquarela'),(7,2,'Admirável Gado Novo'),(8,2,'Chega de Saudade'),(9,2,'País Tropical'),(10,2,'Vambora'),(11,3,'Desce Pro Play'),(12,3,'Os Boys Amam, o Ex Chora'),(13,3,'Vai Ter Que Aguentar'),(14,3,'Oh Juliana'),(15,3,'Amor Difícil');
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicaavaliacao`
--

DROP TABLE IF EXISTS `musicaavaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicaavaliacao` (
  `idmusicaavaliacao` int NOT NULL AUTO_INCREMENT,
  `nota` varchar(45) DEFAULT '0',
  `dataAvaliacao` datetime NOT NULL,
  `idUsuario` int NOT NULL,
  `idMusica` int NOT NULL,
  PRIMARY KEY (`idmusicaavaliacao`),
  UNIQUE KEY `uniqueEscolha` (`idUsuario`,`idMusica`),
  KEY `idUsuario_idx` (`idUsuario`),
  KEY `idMusica_idx` (`idMusica`),
  CONSTRAINT `idMusicaA` FOREIGN KEY (`idMusica`) REFERENCES `musica` (`idMusica`),
  CONSTRAINT `idUsuarioA` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicaavaliacao`
--

LOCK TABLES `musicaavaliacao` WRITE;
/*!40000 ALTER TABLE `musicaavaliacao` DISABLE KEYS */;
INSERT INTO `musicaavaliacao` VALUES (23,'1','2020-12-01 13:48:05',1,1),(25,'5','2020-12-01 13:48:26',4,1),(26,'4','2020-12-01 13:59:25',1,2),(27,'2','2020-12-01 13:59:32',1,5),(28,'1','2020-12-01 13:59:46',4,2),(29,'4','2020-12-01 13:59:52',4,5),(30,'5','2020-12-01 14:00:13',4,11),(31,'5','2020-12-01 14:00:16',4,9),(33,'3','2020-12-01 14:01:02',1,8),(35,'1','2020-12-01 14:01:53',2,9),(36,'5','2020-12-01 14:03:46',1,4),(37,'5','2020-12-01 14:49:32',1,14),(38,'4','2020-12-01 15:18:31',1,13),(39,'5','2020-12-01 15:23:24',1,12),(40,'5','2020-12-01 16:11:09',4,10),(42,'5','2020-12-01 16:11:31',4,8);
/*!40000 ALTER TABLE `musicaavaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `musicas`
--

DROP TABLE IF EXISTS `musicas`;
/*!50001 DROP VIEW IF EXISTS `musicas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `musicas` AS SELECT 
 1 AS `idMusica`,
 1 AS `Musica`,
 1 AS `Genero`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `topmusicas`
--

DROP TABLE IF EXISTS `topmusicas`;
/*!50001 DROP VIEW IF EXISTS `topmusicas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `topmusicas` AS SELECT 
 1 AS `idGenero`,
 1 AS `descricao`,
 1 AS `Media`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin'),(2,'teste','teste'),(3,'teste2','teste1'),(4,'abc','123'),(5,'testando123','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `avaliamusica`
--

/*!50001 DROP VIEW IF EXISTS `avaliamusica`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `avaliamusica` AS select `m`.`idUsuario` AS `idusuario`,`mu`.`idMusica` AS `idMusica`,`mu`.`descricao` AS `descricao`,ifnull(`m`.`nota`,0) AS `Nota` from (`musica` `mu` left join `musicaavaliacao` `m` on((`mu`.`idMusica` = `m`.`idMusica`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `musicas`
--

/*!50001 DROP VIEW IF EXISTS `musicas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `musicas` AS select `mus`.`idMusica` AS `idMusica`,`mus`.`descricao` AS `Musica`,`ge`.`descricao` AS `Genero` from (`musica` `mus` join `genero` `ge` on((`ge`.`idGenero` = `mus`.`idGenero`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `topmusicas`
--

/*!50001 DROP VIEW IF EXISTS `topmusicas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `topmusicas` AS select `gen`.`idGenero` AS `idGenero`,`mus`.`descricao` AS `descricao`,avg(`aval`.`nota`) AS `Media` from ((`musicaavaliacao` `aval` join `musica` `mus` on((`mus`.`idMusica` = `aval`.`idMusica`))) join `genero` `gen` on((`gen`.`idGenero` = `mus`.`idGenero`))) group by `gen`.`idGenero`,`mus`.`descricao` order by `gen`.`idGenero`,avg(`aval`.`nota`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 16:23:12
