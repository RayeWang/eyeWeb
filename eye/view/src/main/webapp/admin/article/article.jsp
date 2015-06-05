<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>
<table id="articledg" title="来源管理" class="easyui-datagrid" style="width:100%;height:97%"
            url='alert.do?${_csrf.parameterName}=${_csrf.token}&" />'
            toolbar="#articletoolbar" pagination="true" striped="true"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="checked" checkbox="true"></th>
            	<th field="id" width="5">ID</th>
                <th field="name" width="20">标题</th>
                <th field="url" editor="text" width="20">原网址</th>
                <th field="desc" width="25">简介</th>
                <th field="edit" editor="type:text"  formatter="formatEdit" width="10">编辑</th>
            </tr>
        </thead>
    </table>
     
    <div id="articletoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTab('新增来源','res/toadd.do?${_csrf.parameterName}=${_csrf.token}&')">新增来源</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRes()">删除来源</a>
    </div>
</body>
</html>