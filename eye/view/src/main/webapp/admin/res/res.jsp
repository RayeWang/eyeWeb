<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>来源管理页面</title>
<link rel="stylesheet" type="text/css"
	href="../themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

</head>
<body>
<script type="text/javascript">
function deleteRes(){
	var selected = $('#dg').datagrid('getChecked');
	console.log(selected);
	console.log(selected[0].id);
	var ids = "";
	for(var i = 0;i < selected.length;i++){
		ids += selected[i].id+",";
	}
	ids = ids.substring(0, ids.length-1);
	
	$.ajax({ url: "res/deletebyids.do",
  	  type: 'POST',
  	  datattpe:"text",
  	  data:{
  		  id:ids,
  		  ${_csrf.parameterName}:'${_csrf.token}'
  	  },
  	   success: function(data){
			if(data==true){
				 $.messager.alert('删除来源','删除成功');
				 var tab = $('#tabs').tabs('getSelected');  // get selected panel
             	 tab.panel('refresh');
			}else{
				$.messager.alert('删除来源','删除失败');
			}
    }});
}
</script>
<table id="dg" title="来源管理" class="easyui-datagrid" style="width:100%;height:97%"
            url='res/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#toolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="name" width="20">名称</th>
                <th field="url" editor="text" width="60">网址</th>
                <th field="edit" editor="type:text"  formatter="formatEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
     
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('新增来源','res/toadd.do?${_csrf.parameterName}=${_csrf.token}&')">新增来源</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRes()">删除来源</a>
    </div>
   
    
</body>
</html>