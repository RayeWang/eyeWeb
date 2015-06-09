<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-groupview.js"></script>
</head>
<body>
<script type="text/javascript">
	function cssGroupFormatter(value,rows){
		return value+"("+rows.length +")";
	}
	
	function formatCssToEdit(value,row,index){
		return '<input type="button" value="编辑" onclick="cssEdit('+row.id+')"></input>';
	}
	
	function cssEdit(id){
		addTab('编辑样式','cssadmin/toedit.do?id='+id);
	}
</script>

<table id="cssdg" title="分类来源" class="easyui-datagrid" style="width:100%;height:97%"
            url='cssadmin/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#linktoolbar" pagination="true" striped="true"
            class="easyui-datagrid"
            rownumbers="true" fitColumns="true" loadMsg="加载中..."   data-options="
            	collapsible:true,
                groupField:'linkName',
                groupFormatter:function(value,rows){
                    return value+'('+rows.length +')';
                }
            ">
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="name" width="20">名称</th>
                <th field="url" editor="text" width="60">网址</th>
                <th field="edit" editor="type:text"  formatter="formatCssToEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
</body>
</html>