/* creacion de tabla casa de heroe*/
CREATE TABLE IF NOT EXISTS `heroes`.`family` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/* creacion de tabla heroe*/
CREATE TABLE IF NOT EXISTS `heroes`.`heroe` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `image` VARCHAR(100) NULL DEFAULT NULL,
  `bio` VARCHAR(1000) NULL DEFAULT NULL,
  `release1` DATE NOT NULL,
  `family_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_heroe_family_idx` (`family_id` ASC) VISIBLE,
  CONSTRAINT `fk_heroe_family`
    FOREIGN KEY (`family_id`)
    REFERENCES `heroes`.`family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;