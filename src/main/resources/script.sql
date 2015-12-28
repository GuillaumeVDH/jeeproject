#database creation
CREATE DATABASE IF NOT EXISTS jeeproject;

#mysql user creation
GRANT ALL ON jeeproject.* TO 'jeeproject'@'localhost' IDENTIFIED BY 'jeeproject';

CREATE TABLE IF NOT EXISTS jeeproject.shelfs(
  id INT NOT NULL,
  PRIMARY KEY (id)
);

ALTER IGNORE TABLE jeeproject.shelfs ADD COLUMN name VARCHAR(256);

CREATE TABLE IF NOT EXISTS jeeproject.articles(
  id INT NOT NULL,
  shelf INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (shelf) REFERENCES jeeproject.shelfs(id) ON DELETE CASCADE
);

ALTER IGNORE TABLE jeeproject.articles ADD COLUMN name VARCHAR(256);
