<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
$(function(){
	$("h1").click(function(){
		alert('click');
	});
});
	
</script>
</head>  
<body>  
    <h1>Common Page</h1>  
   	
    <br />  
    <a href="/spring3-security-integration/auth/login">退出登录</a>  
  
</body>  
</html>  