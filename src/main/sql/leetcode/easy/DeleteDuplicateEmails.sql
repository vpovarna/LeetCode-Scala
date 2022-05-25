USE db;
DROP TABLE IF EXISTS Person;

create table IF NOT EXISTS Person
(
    id    INT,
    email VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Person VALUES (1, 'john@example.com');
INSERT INTO Person VALUES (2, 'bob@example.com');
INSERT INTO Person VALUES (3, 'john@example.com');

SELECT * FROM Person;

SET SQL_SAFE_UPDATES = 0;

DELETE e1
from Person e1
         INNER JOIN Person e2
WHERE e1.id > e2.id
  AND e1.email = e2.email;

SELECT * FROM Person;

SET SQL_SAFE_UPDATES = 1;
