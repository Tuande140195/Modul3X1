-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

use quanlysinhvien;
select subname , credit from subject
where credit = (select max(Credit) from subject)
group by SubName, Credit;


select s.subname, m.mark 
from subject s join mark m on s.SubId = m.SubId
where Mark = (select max(Mark) from mark)
group by s.SubName, m.Mark;



select s.* , avg(Mark)
from student s left join mark m on s.StudentId = m.StudentId
GROUP BY S.StudentId, S.StudentName
order by avg(Mark) desc;
