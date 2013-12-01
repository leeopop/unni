<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방가</title>
</head>

<body>
	<h1>안녕 ${nickname}!!</h1>

	<c:when test="${empty questions}">
		<p>작성한 질문이 없습니다.</p>
	</c:when>
	<c:otherwise>
		<p>내가 작성한 질문들</p>
		<br>

		<c:forEach var="question" items="${questions}">
			<p>{$question.getTitle()}</p>
			<p>//TODO count replies</p>
			<br>
		</c:forEach>
	</c:otherwise>
</body>
</html>