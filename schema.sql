DROP DATABASE IF EXISTS quiz;
CREATE DATABASE quiz;
USE quiz;

DROP TABLE IF EXISTS quiz_type;
CREATE TABLE quiz_type(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    difficulty INT,
    time_limit INT,
    image VARCHAR(200),
    description VARCHAR(200)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(200),
    email VARCHAR(200) UNIQUE,
    is_admin TINYINT
);

DROP TABLE IF EXISTS submission;
CREATE TABLE submission(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    quiz_type_id INT,
    start_time timestamp,
    end_time timestamp,
    is_passed tinyint,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (quiz_type_id) REFERENCES quiz_type(id)
);

DROP TABLE IF EXISTS question;
CREATE TABLE question(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quiz_type_id INT,
    description VARCHAR(1000),
    FOREIGN KEY (quiz_type_id) REFERENCES quiz_type(id)
);

DROP TABLE IF EXISTS report;
CREATE TABLE report(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    submission_id INT,
	question_id INT,
    select_id INT,
    answer_id INT,
    FOREIGN KEY (submission_id) REFERENCES submission(id),
    FOREIGN KEY (question_id) REFERENCES question(id)
);

DROP TABLE IF EXISTS choice;
CREATE TABLE choice(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	question_id INT,
	description VARCHAR(1000),
    is_answer TINYINT,
    FOREIGN KEY (question_id) REFERENCES question(id)
);

DROP TABLE IF EXISTS feedback;
CREATE TABLE feedback(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	quiz_type_id INT,
	rating INT,
    description VARCHAR(1000),
    FOREIGN KEY (quiz_type_id) REFERENCES quiz_type(id)
);

