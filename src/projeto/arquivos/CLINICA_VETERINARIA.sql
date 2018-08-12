CREATE DATABASE CLINICA_VETERINARIA;

------------------------------------------------------------

USE CLINICA_VETERINARIA;

------------------------------------------------------------

CREATE TABLE `animal` (
  `ANI_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `ANI_NOME` varchar(50) NOT NULL,
  `ANI_ESPECIE` varchar(50) NOT NULL,
  `ANI_NASCIMENTO` varchar(10) NOT NULL,
  `ANI_SEXO` char(1) NOT NULL,
  `CPF_CLIENTE` varchar(11) NOT NULL,
  PRIMARY KEY (`ANI_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=1006 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `autenticacao` (
  `COD_AUTENTIC` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_FUNC` varchar(20) NOT NULL,
  `PASS_FUNC` varchar(20) NOT NULL,
  `FUN_CPF` varchar(11) NOT NULL,
  `PRIMEIRO_ACESSO` varchar(1) NOT NULL,
  PRIMARY KEY (`COD_AUTENTIC`)
) ENGINE=MyISAM AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `cliente` (
  `CLI_NOME` varchar(50) NOT NULL,
  `CLI_CPF` varchar(11) NOT NULL,
  `CLI_TELEFONE` varchar(11) NOT NULL,
  `CLI_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CLI_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=1013 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `consulta` (
  `CON_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `CON_DESCRICAO` varchar(100) NOT NULL,
  `NOME_ANIMAL` varchar(30) NOT NULL,
  `NOME_VETERINARIO` varchar(30) NOT NULL,
  `CON_DATA` varchar(10) NOT NULL,
  PRIMARY KEY (`CON_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `dadosconsulta` (
  `CON_CODIGO` int(11) NOT NULL,
  `EXA_CODIGO` int(11) NOT NULL,
  KEY `CON_CODIGO` (`CON_CODIGO`),
  KEY `EXA_CODIGO` (`EXA_CODIGO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `exame` (
  `EXA_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `EXA_DESCRICAO` varchar(50) NOT NULL,
  `EXA_VETERINARIO` varchar(50) NOT NULL,
  `EXA_DATA` varchar(10) NOT NULL,
  `EXA_NOME_ANIMAL` varchar(30) NOT NULL,
  PRIMARY KEY (`EXA_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `funcionario` (
  `FUN_NOME` varchar(50) NOT NULL,
  `FUN_CPF` varchar(11) NOT NULL,
  `FUN_TELEFONE` varchar(11) NOT NULL,
  `FUN_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `FUN_EMAIL` varchar(50) NOT NULL,
  `FUN_CARGO` varchar(30) NOT NULL,
  PRIMARY KEY (`FUN_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `pagamento` (
  `PAG_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `PAG_TIPO_PAGAMENTO` char(10) NOT NULL,
  `CON_CODIGO` int(11) NOT NULL,
  PRIMARY KEY (`PAG_CODIGO`),
  KEY `CON_CODIGO` (`CON_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

------------------------------------------------------------

CREATE TABLE `tratamento` (
  `TRA_DATA_INICIAL` varchar(10) NOT NULL,
  `TRA_DATA_FINAL` varchar(10) NOT NULL,
  `TRA_DESCRICAO` varchar(50) DEFAULT NULL,
  `TRA_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `TRA_NOME_ANIMAL` varchar(30) NOT NULL,
  `TRA_DIAGNOSTICO` varchar(20) NOT NULL,
  PRIMARY KEY (`TRA_CODIGO`)
) ENGINE=MyISAM AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

------------------------------------------------------------

insert into autenticacao (LOGIN_FUNC, PASS_FUNC, FUN_CPF,PRIMEIRO_ACESSO) 
values ('daiene','123','10455804494','n')

insert into funcionario (FUN_NOME,FUN_CPF,FUN_TELEFONE,FUN_EMAIL,FUN_CARGO) 
values ('daiene','10455804494','81995211262','daiene.m17','dona')
