<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질문 리스트</title>
</head>

<body>
	<table>
		<thead>
			<tr>
				<td>질문 제목</td>
				<td>작성자</td>
				<td>작성 시각</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${questions}">
			<tr>
				<td a="${pageContext.request.contextPath}/unni/answer?orig_id=${question.getUuid()}"><c:out value="${question.getTitle()}"/></td>
				<td><c:out value="${question.getWriter().getNickName()}"/></td>
				<td><c:out value="${question.getTime()}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>제목</h2>
	<p>${title}</p>
	<br>
	<h2>질문 내용</h2>
	<p>${oldContent}</p>
	<br>
	<form action="${pageContext.request.contextPath}/unni/answer"
		method="post">
		<input name="orig_id" type="hidden" value="{orig_id}" /> 답변 내용
		<textarea name="content" rows=10 cols=40></textarea>
		<br> <input type="submit" value="답변 하기" />
	</form>
</body>
</html>