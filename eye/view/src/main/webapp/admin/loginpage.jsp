<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登陆</title>
<link href="../css/bootstrap.css" rel="stylesheet" />

</head>
<body>


	<div style="min-width: 300px; width: 30%; margin: 100px auto;"
		class="panel panel-success">
		<div class="panel-heading">登陆系统</div>
		<div class="panel-body">
			<form
				action='<c:out value="login.ad"></c:out>'
				method="post">

				<p>
					<input placeholder="用户名" name="username" class="form-control"
						type="text" />
				</p>

				<p>
					<input class="form-control" placeholder="密码" name="password"
						type="password" />
				</p>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="submit"
					class="btn btn-info" value="登陆" style="width: 100%" />

			</form>
		</div>
	</div>
</body>
</html>
