<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加分类来源</title>
</head>
<body>
<div class="easyui-panel" title="添加分类来源" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form   method="post">
				
				<table cellpadding="5">
					<tr>
						<td>来源名称:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入名字"
							type="text" id="addlink_name" value="${reslink.name }"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>URL:</td>
						<td><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="addlink_url" value="${reslink.url }"
							data-options="required:true,validType:'url'"></input>
							</td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><select class="easyui-combobox" id="addlink_resid" name="language">
								<c:forEach items="${ress}" var="res">
									<option
										value="${res.id }">${res.name }</option>
								</c:forEach>
						</select></td>
					</tr>
				
					<tr>
						<td>分类:</td>
						<td><select class="easyui-combobox" id="addlink_type" name="addlink_type">
								<c:forEach items="${types}" var="type">
									<option
										value="${type.id }">${type.name }</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				 <div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitLinkForm()">保存</a>
            </div>
            <script type="text/javascript">
            function submitLinkForm(){
            	 $.ajax({ url:'reslink/add.do',
	            	  type: 'POST',
	            	  datattpe:"text",
	            	  data:{
	            		  name:$("#addlink_name").val(),
	            		  url:$("#addlink_url").val(),
	            		  resid:$("#addlink_resid").val(),
	            		  typeid:$("[name=addlink_type]").val(),
	            		  ${_csrf.parameterName}:'${_csrf.token}'
	            	  },
	            	   success: function(data){
						if(data==true){
							 $.messager.alert('新增分类来源','添加分类成功');
							 $('#tabs').tabs('close',"新增分类来源");
							 $('#tabs').tabs('getTab','分类来源').panel('refresh');
						}else{
							$.messager.alert('新增分类来源','新增分类失败');
						}
	              }});
            }
            </script>
			</form>
		</div>
	</div>
</body>
</html>