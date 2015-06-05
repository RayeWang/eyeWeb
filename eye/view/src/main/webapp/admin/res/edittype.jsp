<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑分类</title>
</head>
<body>
<div class="easyui-panel" title="编辑分类" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
				<table cellpadding="5">
					<tr>
						<td>分类ID:</td>
						<td style="width: 500px;"><input class="easyui-textbox" readonly="readonly"
							 type="text" id="edittype_id" value="${type.id }"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>分类名称:</td>
						<td style="width: 500px;"><input class="easyui-textbox" value="${type.name }"
							missingMessage="必须输入名称" type="text" id="edittype_name"
							data-options="required:true"></input></td>
					</tr>
				</table>
				<div style="text-align: left; padding: 5px 0px 5px 70px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitAddTypeForm()">添加</a>
				</div>
				 <script type="text/javascript">
            function submitAddTypeForm(){
            	 $.ajax({ url:'type/update.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  id:$("#edittype_id").val(),
	            		  name:$("#edittype_name").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	  success: function(data){
							if(data==true){
								 $.messager.alert('修改分类','修改分类成功');
								 $('#tabs').tabs('close',"编辑分类");
								 $('#tabs').tabs('getTab','分类管理').panel('refresh');
							}else{
								$.messager.alert('修改分类','修改分类失败');
							}
		              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>