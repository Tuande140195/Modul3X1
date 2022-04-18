-- Hiển thị số lượng sinh viên ở từng nơi
-- Tính điểm trung bình các môn học của mỗi học viên
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
use quanlysinhvien;
select Address, count(1) as 'so luong sinh vien'
from student
group by Address;

select S.StudentId, S.studentName,avg(mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
group by S.StudentId, S.studentName;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);