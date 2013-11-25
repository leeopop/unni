<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unni Login</title>
</head>

<body>
	<h1>언니~~~</h1>

	<form
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method="post">
		ID <input type="text" name="userid" /><br>
		Password<input name="password" type="password" /><br>
		<input type="submit" value="Login" />
	</form>
</body>
</html>