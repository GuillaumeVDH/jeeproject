#database creation
CREATE DATABASE IF NOT EXISTS jeeproject;

#mysql user creation
GRANT ALL ON jeeproject.* TO 'jeeproject'@'localhost' IDENTIFIED BY 'jeeproject';

CREATE TABLE IF NOT EXISTS jeeproject.shelfs(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(256),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS jeeproject.articles(
  id INT NOT NULL AUTO_INCREMENT,
  shelf INT NOT NULL,
  prix FLOAT(7,2) NOT NULL,
  picturelink VARCHAR(256),
  brand VARCHAR(256),
  name VARCHAR(256),
  PRIMARY KEY (id),
  FOREIGN KEY (shelf) REFERENCES jeeproject.shelfs(id) ON DELETE CASCADE
);

INSERT INTO `jeeproject`.`shelfs` (`id`, `name`) VALUES ('', 'fruits');
INSERT INTO `jeeproject`.`shelfs` (`id`, `name`) VALUES ('', 'légumes');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`, `prix`, `picturelink`, `brand`) VALUES ('', '2', 'Pommes de terre', '10', 'http://www.cnipt-pommesdeterre.com/wp-content/uploads/2013/09/agata.png', 'Bonduelle');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`, `prix`, `picturelink`, `brand`) VALUES ('', '2', 'Petits pois', '3', 'http://www.fruitsdelaterre.com/1122-1473-large/petit-pois-frais-le-kg-espagne.jpg', 'Bonduelle');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`, `prix`, `picturelink`, `brand`) VALUES ('', '1', 'Tomates', '1', 'https://inspirationsante.files.wordpress.com/2013/03/tomate1.jpg', 'Bonduelle');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`, `prix`, `picturelink`, `brand`) VALUES ('', '1', 'Bananes', '2', 'http://www.jdbn.fr/wp-content/uploads/2014/11/arton80.jpg', 'Bonduelle');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`, `prix`, `picturelink`, `brand`) VALUES ('', '1', 'Pommes', '5', 'https://www.santelog.com/uploaded3/images/Actus%2011/POMME%20VISUEL.jpg', 'Bonduelle');

