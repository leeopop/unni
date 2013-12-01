<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>질문을 올리세요</title>
    </head>

    <body>
        
        <form action="${pageContext.request.contextPath}/unni/ask" method="post">
        	질문 제목 <input name="title" type="text"/> <br>
        	질문 내용 <textarea name="content" rows=10 cols=40></textarea><br>
        	<input type="submit" value="질문 하기" />
        </form>
    </body>
</html>