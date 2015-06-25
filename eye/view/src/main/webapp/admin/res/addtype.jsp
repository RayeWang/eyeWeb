<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加分类</title>
</head>
<body>
	<div class="easyui-panel" title="添加分类" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
				<table cellpadding="5">
					<tr>
						<td>分类名称:</td>
						<td style="width: 500px;"><input class="easyui-textbox"
							missingMessage="必须输入名称" type="text" id="addtype_name"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>分类网址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" type="text" id="addtype_url"></input></td>
					</tr>
				</table>
				<div style="text-align: left; padding: 5px 0px 5px 70px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitAddTypeForm()">添加</a>
				</div>
				 <script type="text/javascript">
            function submitAddTypeForm(){
            	 $.ajax({ url:'type/add.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  name:$("#addtype_name").val(),
	            		  param1:$("#addtype_url").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	  success: function(data){
							if(data==true){
								 $.messager.alert('添加分类','添加分类成功');
								 $('#tabs').tabs('close',"新增分类");
								 $('#tabs').tabs('getTab','分类管理').panel('refresh');
							}else{
								$.messager.alert('添加分类','添加分类失败');
							}
		              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>