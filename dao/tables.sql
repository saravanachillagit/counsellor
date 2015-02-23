--CREATE USER 'counsellor'@'%' IDENTIFIED BY 'counsellor';
--GRANT ALL PRIVILEGES ON * . * TO 'counsellor'@'%';
--GRANT ALL PRIVILEGES ON *.* TO 'counsellor'@'%' WITH GRANT OPTION;
--FLUSH PRIVILEGES;
--CREATE SCHEMA counsellor;
--use counsellor;

CREATE DATABASE counsellor CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'counsellor'@'%' IDENTIFIED BY PASSWORD 'counsellor';
GRANT ALL ON counsellor.* TO 'counsellor'@'%';
GRANT ALL ON counsellor TO 'counsellor'@'%';
GRANT CREATE ON counsellor TO 'counsellor'@'%';
FLUSH PRIVILEGES;

DROP TABLE USER;
CREATE TABLE USER (
ID  BIGINT PRIMARY KEY,
TYPE  VARCHAR(50) NOT NULL,
FIRSTNAME  VARCHAR(50),
LASTNAME  VARCHAR(50),
PHOTO  VARCHAR(150),
EMAILID  VARCHAR(50) NOT NULL,
PHONE  VARCHAR(20) NOT NULL,
PASSWORD  VARCHAR(50) NOT NULL,
GENDER  VARCHAR(10),
LOGINTYPE  VARCHAR(10),
STATUS  VARCHAR(50) NOT NULL,
ZIPCODE VARCHAR(25),
LMD  TIMESTAMP NOT NULL,
CD TIMESTAMP NOT NULL,
);

DROP TABLE COLLEGE;

CREATE TABLE COLLEGE (
ID  BIGINT PRIMARY KEY,
COLLEGE_NAME  VARCHAR(50),
COLLEGE_LOCATION  VARCHAR(50),
COLLEGE_TYPE  VARCHAR(50),
COLLEGE_CAMPUS_UG_ENROLLED  VARCHAR(50),
COLLEGE_CAMPUS_SIZE  NUMBER,
COLLEGE_AREA   VARCHAR(50),
COLLEGE_ACCEPTANCE   VARCHAR(50),
COLLEGE_REQUIREMENTS_SCORES   VARCHAR(50),
ACT_SCORES   VARCHAR(50),
COLLEGE_COST_INSTATE  VARCHAR(50),
COLLEGE_COST_OUT_OF STATE  VARCHAR(50),
COLLEGE_ROOM_N_BOARD  VARCHAR(50),
STATUS  VARCHAR(50) NOT NULL,
LMD  TIMESTAMP NOT NULL,
CD TIMESTAMP NOT NULL
);

DROP TABLE USER_COLLEGE;
CREATE TABLE USER_COLLEGE (
ID  BIGINT PRIMARY KEY,
USERID  BIGINT  NOT NULL,
COLLEGEID  BIGINT  NOT NULL,
LMD  TIMESTAMP NOT NULL,
CD TIMESTAMP NOT NULL,
);