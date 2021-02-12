CREATE USER 'db_access_user'@'%' IDENTIFIED BY '1234';
DROP DATABASE db_access_app;
CREATE DATABASE db_access_app;
GRANT ALL ON db_access_app.* TO 'db_access_user'@'%';
USE db_access_app;

DROP TABLE curso;
CREATE TABLE curso (
	cursoId bigint unsigned PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255)
);

DROP TABLE instructor;
CREATE TABLE instructor (
	instructorid bigint unsigned PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255)
);

DROP TABLE periodo;
CREATE TABLE periodo (
	cursoid bigint unsigned,
    instructorid bigint unsigned,
    periodoid VARCHAR(2),
	year VARCHAR(4),
    inicio date,
    fin date,
    primary key (cursoid, instructorid, periodoid, year),
    foreign key (cursoid) references curso(cursoid),
    foreign key (instructorid) references instructor(instructorid)
);

# --- Q1 ---
INSERT INTO periodo VALUES (1, 1, 'Q1', '2020','2020-01-01','2020-03-30');
INSERT INTO periodo VALUES (2, 3, 'Q1', '2020','2020-01-01','2020-03-30');
INSERT INTO periodo VALUES (3, 4, 'Q1', '2020','2020-01-01','2020-03-30');
INSERT INTO periodo VALUES (4, 2, 'Q1', '2020','2020-01-01','2020-03-30');
# --- Q2 ---
INSERT INTO periodo VALUES (1, 3, 'Q2', '2020','2020-04-01','2020-06-30');
INSERT INTO periodo VALUES (2, 4, 'Q2', '2020','2020-04-01','2020-06-30');
INSERT INTO periodo VALUES (3, 1, 'Q2', '2020','2020-04-01','2020-06-30');
INSERT INTO periodo VALUES (4, 2, 'Q2', '2020','2020-04-01','2020-06-30');
# --- Q3 ---
INSERT INTO periodo VALUES (1, 1, 'Q3', '2020','2020-07-01','2020-09-30');
INSERT INTO periodo VALUES (2, 2, 'Q3', '2020','2020-07-01','2020-09-30');
INSERT INTO periodo VALUES (3, 3, 'Q3', '2020','2020-07-01','2020-09-30');
INSERT INTO periodo VALUES (4, 4, 'Q3', '2020','2020-07-01','2020-09-30');
# --- Q4 ----
INSERT INTO periodo VALUES (1, 4, 'Q4', '2020','2020-10-01','2020-12-31');
INSERT INTO periodo VALUES (2, 3, 'Q4', '2020','2020-10-01','2020-12-31');
INSERT INTO periodo VALUES (3, 2, 'Q4', '2020','2020-10-01','2020-12-31');
INSERT INTO periodo VALUES (4, 1, 'Q4', '2020','2020-10-01','2020-12-31');
INSERT INTO periodo VALUES (3, 4, 'Q4', '2022','2020-10-01','2020-12-31');

select * from periodo
select * from curso
select * from instructor