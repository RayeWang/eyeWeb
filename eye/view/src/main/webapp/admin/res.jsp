<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<table id="dg" title="来源管理" class="easyui-datagrid" style="width:100%;height:97%"
            url="res/get.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="firstname" width="50">First Name</th>
                <th field="lastname" width="50">Last Name</th>
                <th field="phone" width="50">Phone</th>
                <th field="email" width="50">Email</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增来源</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除来源</a>
    </div>
    
    
</body>
</html>