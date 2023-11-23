DROP SCHEMA IF EXISTS recrutatech;

DROP USER IF EXISTS 'user'@'localhost';

CREATE SCHEMA recrutatech;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass123';

GRANT SELECT, INSERT, DELETE, UPDATE ON recrutatech.* TO 'user'@'localhost';

USE recrutatech;

CREATE TABLE usr_usuario (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    user_email VARCHAR(255),
    user_password VARCHAR(255),
    user_role VARCHAR(255),
    user_status BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- CREATE TABLE job (
--     job_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     job_title VARCHAR(255),
--     job_level VARCHAR(255),
--     job_description TEXT,
--     job_status VARCHAR(255),
--     conhecimento_id BIGINT,
--     FOREIGN KEY (conhecimento_id) REFERENCES conhecimento(id)
-- );

-- CREATE TABLE conhecimento (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     content TEXT
-- );
INSERT INTO usr_usuario (user_name, user_email, user_password, user_role, user_status, created_at, updated_at)
VALUES
    ('Usuario1', 'usuario1@example.com', 'senha1', 'USER', true, NOW(), NOW()),
    ('Usuario2', 'usuario2@example.com', 'senha2', 'USER', true, NOW(), NOW()),
    ('Usuario3', 'usuario3@example.com', 'senha3', 'ADMIN', true, NOW(), NOW()),
    ('Usuario4', 'usuario4@example.com', 'senha4', 'USER', false, NOW(), NOW());