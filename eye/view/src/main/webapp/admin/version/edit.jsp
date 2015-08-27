<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>APP版本编辑</title>
</head>
<body>
<div class="easyui-panel" title="编辑APP版本" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
				<table cellpadding="5">
					<tr>
						<td>ID:</td>
						<td style="width: 500px;"><input class="easyui-textbox" readonly="readonly"
							 type="text" id="version_id" value="${version.id }"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>平台：</td>
						<td>
							<select class="easyui-combobox" id="app_nametype" readonly="true" name="editlink_type">
								<option <c:if test="${version.nametype == 1 }">selected="selected"</c:if>  value="1" >Android</option>
								<option <c:if test="${version.nametype == 2 }">selected="selected"</c:if> value="2"  >IOS</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>APP版本号:</td>
						<td style="width: 500px;"><input class="easyui-textbox" value="${version.version }"
							missingMessage="必须输入版本号" type="text" id="app_version"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>更新描述:</td>
						<td style="width: 500px;"><input class="easyui-textbox" value="${version.des }" 
						missingMessage="必须输入新版本描述" type="text" id="app_des" ></input></td>
					</tr>
					<tr>
						<td>新版本下载地址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" value="${version.url }" 
						missingMessage="必须输入新版本下载地址" type="text" id="app_url" ></input></td>
					</tr>
				</table>
				<div style="text-align: left; padding: 5px 0px 5px 70px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitVersionForm()">保存</a>
				</div>
				 <script type="text/javascript">
            function submitVersionForm(){
            	 $.ajax({ url:'version/update.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  id:$("#version_id").val(),
	            		  nametype:$("#app_nametype").val(),
	            		  version:$("#app_version").val(),
	            		  des:$("#app_des").val(),
	            		  url:$("#app_url").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	  success: function(data){
							if(data==true){
								 $.messager.alert('修改版本','修改版本成功');
								 $('#tabs').tabs('close',"编辑版本");
								 $('#tabs').tabs('getTab','APP版本管理').panel('refresh');
							}else{
								$.messager.alert('修改版本','修改版本失败');
							}
		              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>