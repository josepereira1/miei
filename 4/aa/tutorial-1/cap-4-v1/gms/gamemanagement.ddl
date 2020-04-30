CREATE TABLE `User` (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Email varchar(255), Password varchar(255), PRIMARY KEY (ID));
CREATE TABLE Game (ID int(10) NOT NULL AUTO_INCREMENT, PlatformID int(10) NOT NULL, UserID int(10) NOT NULL, Name varchar(255), Year int(10) NOT NULL, Price float NOT NULL, Description varchar(255), GameID int(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Platform (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Year int(10) NOT NULL, Description varchar(255), Manufacture varchar(255), GameID int(10) NOT NULL, PRIMARY KEY (ID));
ALTER TABLE Game ADD CONSTRAINT tem FOREIGN KEY (UserID) REFERENCES `User` (ID);
ALTER TABLE Platform ADD CONSTRAINT tem2 FOREIGN KEY (GameID) REFERENCES Game (ID);
