-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cebopetsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cebopetsdb` ;

-- -----------------------------------------------------
-- Schema cebopetsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cebopetsdb` DEFAULT CHARACTER SET utf8 ;
USE `cebopetsdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(450) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `relationship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `relationship` ;

CREATE TABLE IF NOT EXISTS `relationship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('SINGLE', 'DATING', 'MARRIED', 'COMPLICATED') NULL,
  `enabled` TINYINT NULL,
  `create_date` DATE NOT NULL,
  `marriage_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `breed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `breed` ;

CREATE TABLE IF NOT EXISTS `breed` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `picture_url` TEXT NULL,
  `trait` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cebopet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cebopet` ;

CREATE TABLE IF NOT EXISTS `cebopet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `hunger_level` INT NOT NULL,
  `gender` ENUM('MALE', 'FEMALE', 'NONBINARY', 'GENDERFLUID', 'OTHER') NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `relationship_id` INT NULL,
  `breed_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cebopet_relationship_idx` (`relationship_id` ASC),
  INDEX `fk_cebopet_breed1_idx` (`breed_id` ASC),
  INDEX `fk_cebopet_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_cebopet_relationship`
    FOREIGN KEY (`relationship_id`)
    REFERENCES `relationship` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cebopet_breed1`
    FOREIGN KEY (`breed_id`)
    REFERENCES `breed` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cebopet_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guild`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guild` ;

CREATE TABLE IF NOT EXISTS `guild` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `create_date` DATE NOT NULL,
  `picture_url` VARCHAR(2000) NULL,
  `creator_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_guild_user1_idx` (`creator_user_id` ASC),
  CONSTRAINT `fk_guild_user1`
    FOREIGN KEY (`creator_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `post` ;

CREATE TABLE IF NOT EXISTS `post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NOT NULL,
  `description` TEXT NULL,
  `create_date` DATE NOT NULL,
  `update_date` DATE NULL,
  `creator_user_id` INT NOT NULL,
  `guild_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_user1_idx` (`creator_user_id` ASC),
  INDEX `fk_post_guild1_idx` (`guild_id` ASC),
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`creator_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_guild1`
    FOREIGN KEY (`guild_id`)
    REFERENCES `guild` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `create_date` DATE NOT NULL,
  `post_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post1_idx` (`post_id` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_comment_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_guild`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_guild` ;

CREATE TABLE IF NOT EXISTS `user_has_guild` (
  `user_id` INT NOT NULL,
  `guild_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `guild_id`),
  INDEX `fk_user_has_guild_guild1_idx` (`guild_id` ASC),
  INDEX `fk_user_has_guild_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_guild_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_guild_guild1`
    FOREIGN KEY (`guild_id`)
    REFERENCES `guild` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `event_date_time` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `guild_id` INT NOT NULL,
  `creator_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_guild1_idx` (`guild_id` ASC),
  INDEX `fk_event_user1_idx` (`creator_user_id` ASC),
  CONSTRAINT `fk_event_guild1`
    FOREIGN KEY (`guild_id`)
    REFERENCES `guild` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`creator_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_event` ;

CREATE TABLE IF NOT EXISTS `user_has_event` (
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `event_id`),
  INDEX `fk_user_has_event_event1_idx` (`event_id` ASC),
  INDEX `fk_user_has_event_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS cebopetsuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'cebopetsuser'@'localhost' IDENTIFIED BY 'cebopetsuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'cebopetsuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `enabled`) VALUES (1, 'tpapp', 'admin', 'Toni', 'Papp', 1);
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `enabled`) VALUES (2, 'tflores', 'admin', 'Tabatha', 'Flores', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `relationship`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `relationship` (`id`, `status`, `enabled`, `create_date`, `marriage_date`) VALUES (1, 'COMPLICATED', 1, '2020-07-21', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `breed`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `breed` (`id`, `name`, `picture_url`, `trait`) VALUES (1, 'Kacheeky', NULL, 'A shy and peaceful cebopet.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cebopet`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `cebopet` (`id`, `name`, `hunger_level`, `gender`, `enabled`, `relationship_id`, `breed_id`, `user_id`) VALUES (1, 'StinkBobFartPants', 10, 'MALE', 1, 1, 1, 1);
INSERT INTO `cebopet` (`id`, `name`, `hunger_level`, `gender`, `enabled`, `relationship_id`, `breed_id`, `user_id`) VALUES (2, 'PinkKacheeky', 10, 'FEMALE', 1, 1, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `guild`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `guild` (`id`, `name`, `description`, `create_date`, `picture_url`, `creator_user_id`) VALUES (1, 'Anime Hangout', 'A hangout for anime luvers     uwu', '2020-07-21', NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `post`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `post` (`id`, `title`, `description`, `create_date`, `update_date`, `creator_user_id`, `guild_id`) VALUES (1, 'Is your cebopet looking for a relationship?', 'Hi, my StinkBob FartPants is looking to date. Please comment if interested.', '2020-07-21', NULL, 1, 1);
INSERT INTO `post` (`id`, `title`, `description`, `create_date`, `update_date`, `creator_user_id`, `guild_id`) VALUES (2, 'Anime for CeboPets', 'My ceboplet will be the stah-are', '2020-07-21', NULL, 2, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `comment` (`id`, `content`, `create_date`, `post_id`, `user_id`) VALUES (1, 'Um, what the hell? Our CeboPets are dating.', '2020-07-21', 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_guild`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `user_has_guild` (`user_id`, `guild_id`) VALUES (1, 1);
INSERT INTO `user_has_guild` (`user_id`, `guild_id`) VALUES (2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `event` (`id`, `title`, `description`, `event_date_time`, `enabled`, `guild_id`, `creator_user_id`) VALUES (1, 'Anime Roleplay', 'Everyone picks an anime character to roleplay over Zoom EXCEPT Naruto because I am Naruto.', '2020-07-21 13:00:00', 1, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_event`
-- -----------------------------------------------------
START TRANSACTION;
USE `cebopetsdb`;
INSERT INTO `user_has_event` (`user_id`, `event_id`) VALUES (1, 1);
INSERT INTO `user_has_event` (`user_id`, `event_id`) VALUES (2, 1);

COMMIT;

