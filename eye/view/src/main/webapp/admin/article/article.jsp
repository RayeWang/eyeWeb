<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>
<script type="text/javascript">
	function formatArticleEdit(value,row,index){
		return '<input type="button" value="编辑" onclick="toArticleEdit('+row.id+')"></input>';
	}
	function toArticleEdit(id){
		addTab('编辑文章','article/toedit.do?id='+id);
	}
	
	function deleteArticle(){
		var selected = $('#articledg').datagrid('getChecked');

		var ids = "";
		for(var i = 0;i < selected.length;i++){
			ids += selected[i].id+",";
		}
		ids = ids.substring(0, ids.length-1);
		$.ajax({ url: "article/deletebyids.do",
	  	  type: 'POST',
	  	  datattpe:"text",
	  	  data:{
	  		  ids:ids,
	  		  ${_csrf.parameterName}:'${_csrf.token}'
	  	  },
	  	   success: function(data){
				if(data==true){
					 $.messager.alert('删除文章','删除成功');
					 //var tab = $('#tabs').tabs('getSelected');  // get selected panel
	             	 //tab.panel('refresh');
					 $("#articledg").datagrid('reload',{});
				}else{
					$.messager.alert('删除文章','删除失败');
				}
	    }});
	}
</script>
<table id="articledg" title="来源管理" class="easyui-datagrid" style="width:100%;height:97%"
            url='article/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#articletoolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="title" width="20">标题</th>
                <th field="url" editor="text" width="20">原网址</th>
                <th field="desc1" width="25">简介</th>
                <th field="edit" editor="type:text"  formatter="formatArticleEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
     
    <div id="articletoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('添加文章','article/toadd.do?${_csrf.parameterName}=${_csrf.token}&')">添加文章</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteArticle()">删除文章</a>
    </div>
</body>
</html>