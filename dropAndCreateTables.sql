-- DROP TABLE IF EXISTS game_reviews;
-- DROP TABLE IF EXISTS user_reviews;
DROP TABLE IF EXISTS user_games;
-- DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS developers;

CREATE TABLE developers (
id INT NOT NULL AUTO_INCREMENT,
developer_name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
profile_name VARCHAR(50) NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(40) NOT NULL,
age INT NOT NULL,
country VARCHAR(50) NOT NULL,
wallet FLOAT UNSIGNED NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE games (
id INT NOT NULL AUTO_INCREMENT,
game_name VARCHAR(75) NOT NULL,
price FLOAT NOT NULL,
copies_sold INT NOT NULL,
developer_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (developer_id) REFERENCES developers (id) ON DELETE CASCADE
);

-- CREATE TABLE reviews (
-- id INT NOT NULL AUTO_INCREMENT,
-- review_title VARCHAR(50) NOT NULL,
-- review_body VARCHAR(1000) NOT NULL,
-- review_date DATE NOT NULL,
-- PRIMARY KEY (id)
-- );

CREATE TABLE user_games (
user_id INT NOT NULL,
game_id INT NOT NULL,
PRIMARY KEY (user_id, game_id),
FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (game_id) REFERENCES games (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- CREATE TABLE user_reviews (
-- user_id INT NOT NULL,
-- review_id INT NOT NULL,
-- FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
-- FOREIGN KEY (review_id) REFERENCES reviews (id) ON DELETE CASCADE
-- );

-- CREATE TABLE game_reviews (
-- game_id INT NOT NULL,
-- review_id INT NOT NULL,
-- FOREIGN KEY (game_id) REFERENCES games (id) ON DELETE CASCADE,
-- FOREIGN KEY (review_id) REFERENCES reviews (id) ON DELETE CASCADE
-- );