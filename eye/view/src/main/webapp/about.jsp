<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>程序员之眼</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http equiv="Content-Language" content="zh-CN">
<meta name="description" content="程序员之眼,程序员各种资讯,最新IT文章,网络安全文章,程序员笑话">
<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="css/wall.css" rel="stylesheet" />
<link href="css/loading.css" rel="stylesheet" />
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/page.js"></script>
<style type="text/css">
	body {
	margin: 0px;
	padding: 0px;
	min-width: 1124px;
}
	.head{
		height: 60px;
		width: 100%;
		box-shadow: #e5e5e5 0px 1px 4px;
		z-index: 1;
		position: fixed; 
		top: 0px;
		min-width: 1124px;
		background: #ffffff;
	}
	#headcontent{
		width: 90%;
		height: 100%;
		min-width: 1124px;
		margin: 0 auto;
	}
	#headcontent span{
		font-size: 14px;
  		padding: 4px 0 6px 14px;
  		margin: 15px 10px 0 16px;
  		border-left: solid 1px #d9d9d9;
  		color: #363636;
  		font-family: "微软雅黑";
  		float: left;
	}
	#headcontent ul{
	
  		margin: 9px 10px 0 10px;
  		float: left;
  		
	}
</style>


</head>

<body>

	<div class="head" style="min-width: 1124px;">
		<div id="headcontent">
			<a href='<c:out value="alert.do"></c:out>'><img src="img/logo.png"  style="margin: 2 20;float: left;" /></a>
			<span >程序员眼中的世界</span>
			<form  method="post" style="margin-top: 14px;max-width: 284px;float: left;" action='<c:out value="alert.do"></c:out>' role="search">
		
			    <input type="text" style="float: left;width: 220px;" class="form-control" name="key" value="${key }" placeholder="输入关键字搜索">
			  	<button type="submit" class="btn btn-default" style="float: left;margin-left: 5px;">搜索</button>
		
			  
			</form>
			<ul class="nav nav-pills">
				<c:forEach items="${types}" var="type">
					<li role="presentation" <c:if test="${type.id==typeid }">class="active"</c:if> > <a href="<c:if test="${type.param1==null||type.param1 == '' }">alert.do?typeid=${type.id }</c:if><c:if test="${type.param1 != null }">${type.param1 }</c:if>" ><b>${type.name }</b></a></li>
				</c:forEach>
			</ul>
			
		</div>
	</div>
	
		<div style="min-width: 1124px;width:80%;margin:0 auto;height:80%; border: 0px solid #fff;-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);background-color: #ffffff;margin-top: 80px;text-align: center;padding: 5px;">
			<h3>关于程序员之眼</h3>
			<b>本站是我在空闲时间做的一个网站，因为时间少，加上差不多一年没碰web了，所以写得是有点烂，以后会慢慢完善好<br/>本站的内容都是从转载至网上的，每次查看都会显示文章原网址和原网站，目前的目标是做一个Android端的APP<br/>由于服务器在国外，所以访问可能会慢一点<br/>
			站长邮箱 <a href="mailto:admin@1024eye.com" >admin@1024eye.com</a><br/>by Ray Wang</b>
		</div>

</body>
</html>