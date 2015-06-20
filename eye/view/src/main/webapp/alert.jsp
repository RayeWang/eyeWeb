<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http equiv="Content-Language" content="zh-CN">
<meta name="description" content="${alert.desc1 }">
<title>${alert.title }</title>

<c:forEach items="${alert.csss }" var="css">
	${css.csslink }
</c:forEach>

</head>
<body>
${alert.content }
</body>
</html>