CREATE DATABASE counsellor CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'counsellor'@'%' IDENTIFIED BY PASSWORD 'counsellor';
GRANT ALL ON counsellor.* TO 'counsellor'@'%';
GRANT ALL ON counsellor TO 'counsellor'@'%';
GRANT CREATE ON counsellor TO 'counsellor'@'%';
FLUSH PRIVILEGES;