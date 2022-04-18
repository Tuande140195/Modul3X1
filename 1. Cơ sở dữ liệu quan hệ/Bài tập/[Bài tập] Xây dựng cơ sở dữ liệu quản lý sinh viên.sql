create database quanlyhocsinh;
use quanlyhocsinh;
create table Hocsinh(
id int not null primary key,
name nvarchar(50) not null,
country nvarchar(50) not null
);
create table Class(
classID int not null,
className nvarchar(50) not null
);
create table teacher(
teachID int not null,
teachName nvarchar(50) not null,
teachAge int not null,
teachCountry nvarchar(50)
);