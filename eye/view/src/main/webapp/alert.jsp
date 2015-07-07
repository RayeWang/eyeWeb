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
	  background: #f7f8fa ;
	  padding: 3px 3px 3px 3px;
	  width:98%;
	  border: 1px solid #dbdbea;
	  border-radius: 6px;
	  margin: 0;
}
img{ 
max-width:100%;height:auto; 
} 
</style>
<script type="text/javascript">
	window.onresize()=function(){
		document.getElementByTagName(img).style.width = document.documentElement.clientWidth  + 'px';
	}
</script>
</head>
<body >
${alert.content }
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255526976'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1255526976%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
</body>
</html>