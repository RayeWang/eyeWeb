<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类来源</title>
</head>
<body>
<script type="text/javascript">
	function formatLinkEdit(value,row,index){
		return '<input type="button" value="编辑" onclick="linkEdit('+row.id+')"></input>';
	} 
	
	function linkEdit(id){
		addTab('编辑分类来源','reslink/toedit.do?id='+id);
	}
	
	function deleteLink(){
		var selected = $('#linkdg').datagrid('getChecked');

		var ids = "";
		for(var i = 0;i < selected.length;i++){
			ids += selected[i].id+",";
		}
		ids = ids.substring(0, ids.length-1);
		$.ajax({ url: "reslink/deletebyids.do",
	  	  type: 'POST',
	  	  datattpe:"text",
	  	  data:{
	  		  id:ids,
	  		  ${_csrf.parameterName}:'${_csrf.token}'
	  	  },
	  	   success: function(data){
				if(data==true){
					 $.messager.alert('删除分类来源','删除成功');
					 var tab = $('#tabs').tabs('getSelected');  // get selected panel
	             	 tab.panel('refresh');
				}else{
					$.messager.alert('删除分类来源','删除失败');
				}
	    }});
	}
</script>
<table id="linkdg" title="分类来源" class="easyui-datagrid" style="width:100%;height:97%"
            url='reslink/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#linktoolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="name" width="20">名称</th>
                <th field="url" editor="text" width="60">网址</th>
                <th field="edit" editor="type:text"  formatter="formatLinkEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
     
    <div id="linktoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('新增分类来源','reslink/toadd.do?${_csrf.parameterName}=${_csrf.token}&')">新增分类来源</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteLink()">删除分类来源</a>
    </div>
</body>
</html>