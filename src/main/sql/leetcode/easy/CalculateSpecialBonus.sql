USE db;
DROP TABLE IF EXISTS Employees;

create table IF NOT EXISTS Employees
(
    employee_id INT,
    name        VARCHAR(255),
    salary      INT,
    PRIMARY KEY (employee_id)
);

INSERT INTO Employees VALUE (2, 'Meir', 3000);
INSERT INTO Employees VALUE (3, 'Michael', 3800);
INSERT INTO Employees VALUE (7, 'Addilyn', 7400);
INSERT INTO Employees VALUE (8, 'Juan', 6100);
INSERT INTO Employees VALUE (9, 'Kannon', 7700);

SELECT *
FROM Employees;

-- Using CASE condition

SELECT employee_id,
       CASE
           WHEN employee_id % 2 != 0 AND name NOT LIKE 'M%' THEN salary
           ELSE 0
           END AS bonus
FROM Employees;

-- Using IF condition

SELECT employee_id, if(employee_id % 2 = 0 OR LOWER(LEFT(name, 1)) = 'm', 0, salary) AS bonus FROM Employees;