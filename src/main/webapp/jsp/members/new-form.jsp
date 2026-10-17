<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- new-form.jsp도 결국 서블릿 객체로 등록된다. 그떄 URL은 JSP파일의 경로가 된다. 요청 url : http://localhost:8080/jsp/members/new-form.jsp -->
<html>
<head>
 <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>