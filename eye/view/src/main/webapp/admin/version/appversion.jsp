<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>APP版本</title>
</head>
<body>
<script type="text/javascript">
	function formName(value,row,index){
		if(value==1){
			return "Android";
		}else{
			return "IOS";
		}
	}
	function formatVersionEdit(value,row,index){
		return '<input type="button" value="编辑" onclick="toEditVersion('+row.id+')"></input>';
	}
	function toEditVersion(id){
		addTab('编辑版本','version/toedit.do?id='+id);

	}
</script>
<table id="articledg" title="版本管理" class="easyui-datagrid" style="width:100%;height:97%"
            url='version/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#articletoolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="id" width="5">ID</th>
                <th field="version" width="8">版本号</th>
                <th field="nametype" width="8" formatter="formName">平台</th>
                <th field="des" editor="text" width="40">描述</th>
                <th field="url" width="40">url</th>
                <th field="edit" editor="type:text"  formatter="formatVersionEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
     <div id="articletoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('添加版本','version/add.jsp')">添加版本</a>
    </div>

</body>
</html>