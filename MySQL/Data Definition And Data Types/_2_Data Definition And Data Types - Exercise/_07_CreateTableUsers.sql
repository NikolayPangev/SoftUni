CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIMESTAMP,
    is_deleted BOOLEAN
);

INSERT INTO users (username, password, profile_picture, last_login_time, is_deleted)
VALUES 
('user1', 'password1', NULL, '2024-01-11 12:30:00', false),
('user2', 'password2', NULL, '2024-01-11 13:45:00', false),
('user3', 'password3', NULL, '2024-01-11 14:20:00', true),
('user4', 'password4', NULL, '2024-01-11 15:10:00', false),
('user5', 'password5', NULL, '2024-01-11 16:00:00', true);