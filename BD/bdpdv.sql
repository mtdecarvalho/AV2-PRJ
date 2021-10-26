-- MySQL Script generated by MySQL Workbench
-- Tue Oct 26 15:00:41 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdpdv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdpdv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdpdv` DEFAULT CHARACTER SET utf8 ;
USE `bdpdv` ;

-- -----------------------------------------------------
-- Table `bdpdv`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`Endereco` (
  `CEP` VARCHAR(10) NOT NULL,
  `rua` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(25) NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`CEP`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdpdv`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`Cliente` (
  `codigo` INT NOT NULL,
  `telefone` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `CEP` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`codigo`, `CEP`),
  INDEX `fk_Cliente_Endereco1_idx` (`CEP` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Endereco1`
    FOREIGN KEY (`CEP`)
    REFERENCES `bdpdv`.`Endereco` (`CEP`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdpdv`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`Produto` (
  `codigo` INT NOT NULL,
  `unidade` INT NOT NULL,
  `qtdEstoque` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `ultimaVenda` DATE NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdpdv`.`formaDePagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`formaDePagamento` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdpdv`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`Venda` (
  `codigo` INT NOT NULL,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `formaDePagamento` INT NOT NULL,
  `precoTotal` DOUBLE NOT NULL,
  `codigoCliente` INT NULL,
  PRIMARY KEY (`codigo`, `formaDePagamento`),
  INDEX `fk_Venda_Cliente1_idx` (`codigoCliente` ASC) VISIBLE,
  INDEX `fk_Venda_formaDePagamento1_idx` (`formaDePagamento` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`codigoCliente`)
    REFERENCES `bdpdv`.`Cliente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_formaDePagamento1`
    FOREIGN KEY (`formaDePagamento`)
    REFERENCES `bdpdv`.`formaDePagamento` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdpdv`.`itemVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpdv`.`itemVenda` (
  `codigoVenda` INT NOT NULL,
  `codigoProduto` INT NOT NULL,
  `qtdVendida` INT NOT NULL,
  `preco` DOUBLE NOT NULL,
  PRIMARY KEY (`codigoVenda`, `codigoProduto`),
  INDEX `fk_itemVenda_Produto1_idx` (`codigoProduto` ASC) VISIBLE,
  CONSTRAINT `fk_itemVenda_Venda`
    FOREIGN KEY (`codigoVenda`)
    REFERENCES `bdpdv`.`Venda` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemVenda_Produto1`
    FOREIGN KEY (`codigoProduto`)
    REFERENCES `bdpdv`.`Produto` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
