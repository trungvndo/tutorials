CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    password VARCHAR(45) NOT NULL,
    is_active INT NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
    id SERIAL NOT NULL PRIMARY KEY,
    email VARCHAR(200) NOT NULL,
    authority VARCHAR(45) NOT NULL
);