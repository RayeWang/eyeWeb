<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-Frame-Options" content="SAMEORIGIN"> 
<title><c:if test="${res != null }">编辑来源</c:if><c:if
		test="${res == null }">新增来源</c:if></title>
</head>
<body>
 <div class="easyui-panel" title="<c:if test="${res != null }">编辑来源</c:if><c:if
		test="${res == null }">新增来源</c:if>" style="width:100%">
        <div style="padding:10px 60px 20px 60px;margin: 20px auto;">
	<form id="ff" action="res/addres.do" method="post">
		<c:if test="${res!= null }">
			<input type="hidden" name="id" value="${res.id }" />
		</c:if>
		
			<table cellpadding="5">
				<tr>
					<td>来源名称:</td>
					<td><input class="easyui-textbox" missingMessage="必须输入名字"
						type="text" id="name" name="name" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>URL:</td>
					<td><input class="easyui-textbox" missingMessage="必须输入网址"
						type="text" name="email" id="url"
						data-options="required:true,validType:'url'"></input></td>
				</tr>
				<tr>
					<td>分类:</td>
					<td><select class="easyui-combobox" id="type" name="language">
							<c:forEach items="${types}" var="type">
								<option value="${type.id }" >${type.name }</option>
							</c:forEach>
					</select></td>
				</tr>
			
			</table>
			 <div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()"><c:if test="${res == null }">添加</c:if>  <c:if test="${res != null }">保存</c:if></a>
			<script type="text/javascript">
				
				function submitForm(){
		            
		            $.ajax({ url: "res/addres.do",
		            	  type: 'POST',
		            	  datattpe:"text",
		            	  data:{
		            		  name:$("#name").val(),
		            		  url:$("#url").val(),
		            		  type:$("#type").val(),
		            		  ${_csrf.parameterName}:'${_csrf.token}'
		            	  },
		            	   success: function(data){
							if(data==0){
								 $.messager.alert('添加来源','添加成功');
								 $('#tabs').tabs('close',"新增来源");
							}else{
								$.messager.alert('添加来源','添加失败');
							}
		              }});
		        }
			</script>
        </div>
	</form>
	</div>
	</div>
</body>
</html>