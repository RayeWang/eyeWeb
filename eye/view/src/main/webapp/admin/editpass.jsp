<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<div class="easyui-panel" title="修改密码" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form   method="post">
				
				<table cellpadding="5">
					<tr>
						<td>旧密码:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须旧密码"
							type="password" id="editpass_old"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>新密码:</td>
						<td><input class="easyui-textbox" missingMessage="必须输入新密码"
							type="password" id="editpass_new"
							data-options="required:true"></input>
							</td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input class="easyui-textbox" missingMessage="必须输入确认密码"
							type="password" id="editpass_new1"
							data-options="required:true"></input>
							</td>
					</tr>
				
					
				</table>
				 <div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddLinkForm()">保存</a>
            </div>
            <script type="text/javascript">
            function submitAddLinkForm(){
            	if($("#editpass_new").val()!=$("#editpass_new1").val()){
            		alert('2次密码不一致');
            		return;
            	}
            	 $.ajax({ url:'user/changepass.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  old:$("#editpass_old").val(),
	            		  newPass:$("#editpass_new").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	   success: function(data){
						if(data==true){
							 $.messager.alert('修改密码','修改密码成功');
							 $('#tabs').tabs('close',"修改密码");
						}else{
							$.messager.alert('修改密码','修改密码失败');
						}
	              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>