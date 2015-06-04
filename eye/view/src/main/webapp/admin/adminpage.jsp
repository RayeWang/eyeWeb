<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css"
	href="../themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/admain.css" />
<script type="text/javascript">
	$(function(){
		$(".menu_item").click(function(){
			addTab($(this).html(),$(this).attr("url"));
		});
	});
	
	function addTab(name,url){
		if ($('#tabs').tabs('exists',name)){
			$('#tabs').tabs('select',name);
		} else {
			 $('#tabs').tabs('add',{
	                title: name,
	                href:url,
	                closable: true,
	                tools:[{
	                    iconCls:'icon-mini-refresh',
	                    handler:function(){
	                    	var tab = $('#tabs').tabs('getSelected');  // get selected panel
	                    	tab.panel('refresh');
	                    }
	                }]
	            });
		}
	
	}
	function formatEdit(value,row,index){
		return '<input type="button" value="编辑" onclick="toedit('+row.id+')"></input>';
	}
	
	
	function toedit(id){
		alert(id);
		return;
	}
</script>

</head>
<body>

	<div style="width: 100%; height: 50px; background-color: #333"></div>
	<div class="easyui-layout" style="width: 100%;height: 90%">
		<!-- 菜单区域 -->
		<div data-options="region:'west',split:true" title="菜单"
			style="width: 200px;height: 100%">
			<div class="easyui-accordion" style="width: 100%;">
				<div title="文章管理" style="overflow: auto; padding: 10px;">
					<h2 class="menu_item" >文章管理</h2>
					<h2 class="menu_item" url="res.jsp">来源管理</h2>
					<h2 class="menu_item">分类管理</h2>
					<h2 class="menu_item">样式管理</h2>
				</div>
				<div title="系统管理" style="padding: 10px;">
					<h2 class="menu_item">登陆日志</h2>
					<h2 class="menu_item">系统用户</h2>
					<h2 class="menu_item">权限管理</h2>
				</div>

			</div>
		</div>
		<!-- 中间面板区 -->
		<div class="easyui-tabs" id="tabs" data-options="region:'center'">
	
		</div>
	</div>
</body>
</html>