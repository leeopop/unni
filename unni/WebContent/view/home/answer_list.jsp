<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>답변하기</title>
    </head>

    <body>
        <h2>제목 </h2><p>${title}</p><br>
        <h2>질문 내용 </h2><p>${oldContent}</p><br>
        <c:forEach var="answer" items="${answers}">
        	<p>----------------------------------------</p>
        	<p>${answer.getContent() }</p>
        </c:forEach>
    </body>
</html>