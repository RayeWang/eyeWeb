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
<style type="text/css">
	blockquote {
	<c:if test="!${isblack}">
	
	  background: #f7f8fa ;
	</c:if>
	  padding: 3px 3px 3px 3px;
	  width:98%;
	  border: 1px solid #dbdbea;
	  border-radius: 6px;
	  margin: 0;
	  <c:if test="${isblack}">
	
	background:#000000;
	color:#ffffff;
	</c:if>
}
<c:if test="${isblack}">
	.article-entry pre, .comment pre {
  margin: 15px auto;
  font: 12px/20px 'courier new';
  border: 1px solid #ddd;
  border-left-width: 4px;
  background: #000000; 
  padding: 10px 15px;
}
html{
background: #000000;
}
.prettyprint {
  padding: 8px;
  background-color: #000000;
  border: 1px solid #e1e1e8;
  white-space: pre;
  white-space: pre-wrap;
  word-break: break-all;
  word-wrap: break-word;
}
p {
  float: left;
  padding: 0px;
  margin: 0 0 5px 0;
  font-size: 14px;
  line-height: 150%;
  color: #fff;
  clear: both;
  display: block;
  width: 100%;
}
</c:if>
body{
	max-width: 97%;
	margin:0px;
	padding: 2px;
	<c:if test="${isblack}">
	
	background:#000000;
	color:#ffffff;
	</c:if>
}
img{ 
max-width:99%;height:auto;
margin: 0px;padding: 0px; 
} 
</style>
<script type="text/javascript">
	window.onresize()=function(){
		document.getElementByTagName(img).style.width = document.documentElement.clientWidth  + 'px';
		document.getElementByTagName(img).style.margin = "0px";
	}
	
</script>
</head>
<body >
${alert.content }
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255526976'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1255526976%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
</body>
</html>