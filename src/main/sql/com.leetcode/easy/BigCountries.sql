USE db;DROP TABLE IF EXISTS World;
CREATE TABLE IF NOT EXISTS World (name VARCHAR(255), continent VARCHAR(255), area BIGINT, population BIGINT, gdp BIGINT, PRIMARY KEY (name));
INSERT INTO World values ("Afghanistan", "Asia", 652230, 25500100, 20343000000);
INSERT INTO World values ("Albania", "Europe", 28748, 2831741, 12960000000);
INSERT INTO World values ("Algeria", "Africa", 2381741, 37100000, 188681000000);
INSERT INTO World values ("Andorra", "Europe", 468, 78115, 3712000000);
INSERT INTO World values ("Angola", "Africa", 1246700, 20609294, 100990000000);
SELECT * FROM World;

# Solution
select name, area, population from World where area >= 3000000 OR population >= 25000000;

