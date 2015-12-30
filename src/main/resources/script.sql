#database creation
CREATE DATABASE IF NOT EXISTS jeeproject;

#mysql user creation
GRANT ALL ON jeeproject.* TO 'jeeproject'@'localhost' IDENTIFIED BY 'jeeproject';

CREATE TABLE IF NOT EXISTS jeeproject.shelfs(
  id INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

ALTER IGNORE TABLE jeeproject.shelfs ADD COLUMN name VARCHAR(256);

CREATE TABLE IF NOT EXISTS jeeproject.articles(
  id INT NOT NULL AUTO_INCREMENT,
  shelf INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (shelf) REFERENCES jeeproject.shelfs(id) ON DELETE CASCADE
);

ALTER IGNORE TABLE jeeproject.articles ADD COLUMN name VARCHAR(256);

INSERT INTO `jeeproject`.`shelfs` (`id`, `name`) VALUES ('', 'surgelés'), ('', 'fruits et légumes');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`) VALUES ('', '1', 'steak'), ('', '1', 'petits poids');
INSERT INTO `jeeproject`.`articles` (`id`, `shelf`, `name`) VALUES (NULL, '2', 'tomates'), (NULL, '2', NULL);

