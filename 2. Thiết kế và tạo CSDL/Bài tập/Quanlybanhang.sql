create database quanlybanhang;
use QuanLyBanHang;
create table Customer (
cID INT NOT NULL auto_increment primary key,
cName nvarchar(50) NOT NULL,
cAge int not null
);
create table Orrder(
oID int not null auto_increment primary key,
cID int not null,
oDate date Not null,
oTotalPrice double Not null,
foreign key ( cID) REFERENCES Customer (cID)
);
create table Product(
pID int not null auto_increment primary key,
pName nvarchar(50) not null,
pPrice double not null
);
create table OderDetail (
oID int not null ,
pID int not null ,
odQTY nvarchar(50) not null,
unique(oID,pID),
foreign key (oID) references Orrder (oID),
foreign key (pID) references Product(pID)
);

