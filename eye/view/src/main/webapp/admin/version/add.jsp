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
<div class="easyui-panel" title="新增APP版本" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
				<table cellpadding="5">
					
					<tr>
						<td>APP版本号:</td>
						<td style="width: 500px;"><input class="easyui-numberbox" 
							missingMessage="必须输入版本号" type="text" id="add_app_version"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>平台：</td>
						<td>
							<select class="easyui-combobox" id="add_app_nametype" name="add_app_nametype">
								<option value="1">Android</option>
								<option value="2">IOS</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>更新描述:</td>
						<td style="width: 500px;"><input class="easyui-textbox" 
						missingMessage="必须输入新版本描述" type="text" id="add_app_des" ></input></td>
					</tr>
					<tr>
						<td>新版本下载地址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" 
						missingMessage="必须输入新版本下载地址" type="text" id="add_app_url" ></input></td>
					</tr>
				</table>
				<div style="text-align: left; padding: 5px 0px 5px 70px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitVersionForm()">保存</a>
				</div>
				 <script type="text/javascript">
            function submitVersionForm(){
            	 $.ajax({ url:'version/add.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  version:$("#add_app_version").val(),
	            		  nametype:$("[name=add_app_nametype]").val(),
	            		  des:$("#add_app_des").val(),
	            		  url:$("#add_app_url").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	  success: function(data){
							if(data==true){
								 $.messager.alert('添加版本','添加版本成功');
								 $('#tabs').tabs('close',"添加版本");
								 $('#tabs').tabs('getTab','APP版本管理').panel('refresh');
							}else{
								$.messager.alert('添加版本','添加版本失败');
							}
		              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>