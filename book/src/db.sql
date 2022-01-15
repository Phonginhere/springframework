CREATE DATABASE SERVJSP_exam;


USE SERVJSP_exam;


CREATE TABLE dbo.Books(
	BookId int AUTO_INCREMENT NOT NULL,
	Title varchar(50) NULL,
	Price float NULL,
	CategoryId int NULL,
  CONSTRAINT PK_Books PRIMARY KEY (BookId)
 );



CREATE TABLE dbo.Category(
	CategoryId int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	CategoryId varchar(50) NULL,
    CONSTRAINT PK_Category PRIMARY KEY (CategoryId)
);


CREATE TABLE dbo.Users(
	UserId int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Username varchar(50) NULL,
	Password char(10) NULL,
    CONSTRAINT PK_Users PRIMARY KEY (UserId)
);
