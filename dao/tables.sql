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

drop TABLE USER;
create TABLE USER (
id  BIGINT PRIMARY KEY,
type  VARCHAR(50) NOT NULL,
firstName  VARCHAR(50),
lastName  VARCHAR(50),
photo  VARCHAR(150),
emailId  VARCHAR(50) NOT NULL,
phone  VARCHAR(20) NOT NULL,
password  VARCHAR(50) NOT NULL,
gender  VARCHAR(10),
loginType  VARCHAR(10),
status  VARCHAR(50) NOT NULL,
zipCode VARCHAR(25),
lmd  TIMESTAMP NOT NULL,
cd TIMESTAMP NOT NULL,
);

drop TABLE COLLEGE;
create TABLE COLLEGE (
id  BIGINT PRIMARY KEY,
name  VARCHAR(50),
address1  VARCHAR(50),
address2  VARCHAR(50),
city  VARCHAR(150),
zipCode VARCHAR(25),
status  VARCHAR(50) NOT NULL,
lmd  TIMESTAMP NOT NULL,
cd TIMESTAMP NOT NULL,
);

drop TABLE USER_COLLEGE;
create TABLE USER_COLLEGE (
id  BIGINT PRIMARY KEY,
userId  BIGINT  NOT NULL,
collegeId  BIGINT  NOT NULL,
lmd  TIMESTAMP NOT NULL,
cd TIMESTAMP NOT NULL,
);