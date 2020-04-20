CREATE TABLE `User` (Name varchar(255) NOT NULL, Email varchar(255), Password varchar(255), PRIMARY KEY (Name));
CREATE TABLE Game (Name varchar(255) NOT NULL, PlatformName varchar(255), UserName varchar(255), Year int(10) NOT NULL, Price float NOT NULL, Description varchar(255), PRIMARY KEY (Name));
CREATE TABLE Platform (Name varchar(255) NOT NULL, Year int(10) NOT NULL, Description varchar(255), Manufacture varchar(255), PRIMARY KEY (Name));
ALTER TABLE Game ADD CONSTRAINT tem FOREIGN KEY (UserName) REFERENCES `User` (Name);
ALTER TABLE Game ADD CONSTRAINT tem2 FOREIGN KEY (PlatformName) REFERENCES Platform (Name);
