<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <a href ="HelloWorldPage.htm">Hello</a>
        
        <form action="${pageContext.request.contextPath}/unni/create" method="post">
        	ID <input name="id" /> <br>
        	RealName <input name="realname"/><br>
        	NickName <input name="nickname"/><br>
        	Password <input name="password" type="password" /><br>
        	Re-type Password <input name="password_re" type="password" /><br>
        	<input type="submit" value="Create!!" />
        </form>
    </body>
</html>