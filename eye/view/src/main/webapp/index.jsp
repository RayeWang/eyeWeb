<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>程序员之眼，我就是你的眼</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/wall.css" rel="stylesheet" />
<link href="css/loading.css" rel="stylesheet" />
<script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function loadClick(id,title,resname,url,url1) {
		$('#myModal').modal('toggle');
		$("#myModalLabel").html(title+"&nbsp;&nbsp;来自：<a href='"+url1+"' target='_blank'>"+resname+"</a>"+
			"&nbsp;&nbsp;<a href='"+url+"' target='_blank'>查看原文</a>");
		
		var fra = $("#iframe1");
		if (fra.attr('src') == 'getalert.do?id='+id) {
			return;
		}
		fra.attr("src", 'getalert.do?id='+id);
		fra.hide();
		$("#loading").show();

		console.log('begin');

		var oFrm = document.getElementById('iframe1');
		oFrm.onload = oFrm.onreadystatechange = function() {
			if (this.readyState && this.readyState != 'complete') {
				return;
			} else {
				showFinish();
			}
		}
	}

	function showFinish() {
		$("#iframe1").show();
		$("#loading").hide();
	}
</script>
</head>

<body>

	<div class="wf-main" id="wf-main">
		<c:forEach items="${alerts }" var="alert">
			<div class="wall-item">
				<a href="#" onclick="loadClick('${alert.id}','${alert.title }','${alert.param1 }','${alert.url }','${alert.param2 }')">
					<h4>${alert.title }</h4>
				</a>
				<p>${alert.desc1 }</p>
			</div>
		</c:forEach>

	</div>
	
	<script type="text/javascript" src="js/wall.js" ></script>

	<!-- Modal -->
	<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body" style="height: 75%;">
					<div class="spinner" id="loading">
						<div class="bounce1"></div>
						<div class="bounce2"></div>
						<div class="bounce3"></div>
					</div>
					<iframe name="test" id="iframe1" style="border: 0" width="100%"
						height="100%"></iframe>
				</div>

			</div>
		</div>
	</div>
</body>
</html>