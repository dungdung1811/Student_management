<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/13/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student_management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center danger">Danh sách Student</h1>
            <table class="table">
                <thead>
                <tr>
                    <th>Mã Sinh Viên</th>
                    <th>Họ Và Tên</th>
                    <th>Ngay sinh</th>
                    <th>lop</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.birthday}</td>
                        <td>${student.className}</td>
                        <td>
                            <a href="/studentservlet?action=edit&id=${student.id}" class="btn btn-primary"> Edit</a>
                            <a href="/studentservlet?action=delete&id=${student.id}"  class="btn btn-danger"> Delete</a>
<%--                                                            <a  class="btn btn-danger"> Xem</a>--%>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <a href="/studentservlet?action=add"class="btn btn-success">Them moi sv </a>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>
