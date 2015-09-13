<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见与建议</title>
</head>
<body>
<table id="articledg" title="已经与建议" class="easyui-datagrid" style="width:100%;height:97%"
            url='commend.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#articletoolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="email" width="20">email</th>
                <th field="nickname" editor="text" width="20">昵称</th>
                <th field="commend" width="40">意见/建议</th>
               
            </tr>
        </thead>
    </table>
     
    <div id="articletoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('添加文章','article/toadd.do?${_csrf.parameterName}=${_csrf.token}&')">添加文章</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteArticle()">删除文章</a>
    </div>
</body>
</html>