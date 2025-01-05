CREATE DATABASE IF NOT EXISTS chatdb;

# create user table;
CREATE TABLE user (
    name VARCHAR(255) PRIMARY KEY,
    address VARCHAR(255)
);

# create friend table;
CREATE TABLE friend (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user1 VARCHAR(255) NOT NULL,
    user2 VARCHAR(255) NOT NULL
);
