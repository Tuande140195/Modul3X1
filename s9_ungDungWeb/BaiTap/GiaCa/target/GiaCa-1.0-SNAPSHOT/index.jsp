<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tinh Chiet Khau</title>
</head>
<body>
<h1>
    Bảng Tính chiết khấu:
</h1>
<br/>
<form action="tinhchietkhau" method="post" >
    <label>Mô tả: </label><br/>
    <input type="text" name="mota" ><br/>
    <label>Giá gốc: </label><br/>
    <input type="text" name="gia"><br/>
    <label>% chiết khấu: </label><br/>
    <input type="text" name="chietkhau">
    <input type="submit" value="Tính">
</form>
</body>
</html>