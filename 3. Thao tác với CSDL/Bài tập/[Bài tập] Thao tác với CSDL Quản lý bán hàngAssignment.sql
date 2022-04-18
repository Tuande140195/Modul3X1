use quanlybanhang;
truncate table orrder;
update customer set cName = 'Minh Quan', cAge =' 10' where cID=1;
update customer set cName = 'Ngoc Oanh', cAge =' 20' where cID=2;
-- insert into customer 
-- values(3, 'Ngoc Ha', 50);
;
insert into orrder
values(1,1,3/21/2006,2.0),
	(2,2,3/23/2006,3.0),
	(3,1,3/16/2006,3.0);
    
insert into product
values(1,'May Giat',3),
      (2,'Tu lanh',5),
      (3,'Dieu hoa',7),
      (4,'Quat',1),
      (5,'Bep dien',2);
      
insert into oderdetail
values(1,1,'3'),
      (1,3,'7'), 
      (1,4,'2'), 
      (2,1,'1'), 
      (3,1,'8'), 
      (2,5,'4'), 
      (2,3,'3');