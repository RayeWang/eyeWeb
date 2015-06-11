<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function formatterLog(value,row,index){
		if(value==0){
			return '否';
		}else{
			return '是';
		}
	}
</script>
<table id="logdg" title="分类来源" class="easyui-datagrid" style="width:100%;height:97%"
            url='log/get.do?${_csrf.parameterName}=${_csrf.token}&" />'
             pagination="true" striped="true"
            class="easyui-datagrid"
            rownumbers="true" fitColumns="true" loadMsg="加载中..." >
        <thead>
            <tr>
            	<th field="id" width="5">ID</th>
                <th field="username" width="10">登陆名</th>
                <th field="logintime"  width="15">登陆时间</th>
                <th field="ip" width="20">登陆IP</th>
                <th field="issuccess" formatter="formatterLog" width="5">是否成功</th>
            </tr>
        </thead>
    </table>
</body>
</html>