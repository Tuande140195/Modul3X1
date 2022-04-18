SELECT
    *
FROM
    student
WHERE
    StudentName like 'h%';
    
    
    SELECT *FROM `class` WHERE MONTH(StartDate)  = 12  ;
 
 
 SELECT*FROM subject WHERE Credit BETWEEN 3 and 5;
 
UPDATE student SET ClassID ='2' WHERE StudentName like 'hung';

SELECT s.StudentName, u.SubName, m.Mark
FROM subject u inner join mark m
on u.SubId = m.SubId
inner JOIN student s 
on s.StudentId = m.StudentId 
ORDER by m.Mark DESC, s.StudentId ASC;