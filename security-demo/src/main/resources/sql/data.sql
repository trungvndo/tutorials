INSERT INTO users
(email, first_name, last_name, password, is_active)
VALUES
('john@gmail.com', 'John', 'Doe', '12345', 1);

INSERT INTO authorities
(email, authority)
VALUES
('john@gmail.com', 'write');
