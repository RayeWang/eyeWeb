<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改文章</title>
</head>
<body>
	<div class="easyui-panel" title="文章管理" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
		<input type="hidden" id="editarticle_id" value="${article.id }" />
		<input type="hidden" id="editarticle_resid" value="${article.resId }" />
		<input type="hidden" id="editarticle_hot" value="${article.hot }" />
			<form>
				<table cellpadding="5">
					<tr>
						<td>标题:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入名字"
							type="text" id="editarticle_title" value="${article.title }"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>原网址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="editarticle_url" value="${article.url }"
							data-options="required:true,validType:'url'"></input></td>
					</tr>
					<tr>
						<td>图片地址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="editarticle_img" value="${article.img }"></input></td>
					</tr>
					<tr>
						<td>分类</td>
						<td><select class="easyui-combobox"  name="editarticle_type">
							<c:forEach items="${types }" var="type">
								<option value="${type.id }" <c:if test="${article.atypeId==type.id }">selected="selected"</c:if> >${type.name }</option>
							</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>来源</td>
						<td>
							<select class="easyui-combobox" disabled="disabled" name="editarticle_reslink">
								<c:forEach items="${links }" var="link">
								<option value="${link.id }" <c:if test="${article.resLinkId==link.id }">selected="selected"</c:if> >${link.name }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>简介:</td>
						<td ><textarea style="height: 100px;width: 500px;" class="easyui-textbox"  data-options="multiline:true"
							name="editarticle_desc1" >${article.desc1 }</textarea></td>
					</tr>
					<tr>
						<td>内容</td>
						<td>
							<textarea style="height: 300px;width: 500px;" name="editarticle_content" class="easyui-textbox"  data-options="multiline:true" >${article.content }</textarea>
						</td>
					</tr>
				</table>
				<div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submiteditArticleForm()">保存</a>
            </div>
			</form>
			<script type="text/javascript">
				function submiteditArticleForm(){
					$.ajax({ url: "article/updata.do",
					  	  type: 'POST',
					  	  datattpe:"text",
					  	  data:{
					  		id:$("#editarticle_id").val(),
					  		resId:$("#editarticle_resid").val(),
					  		hot:$("#editarticle_hot").val(),
					  		title:$("#editarticle_title").val(),
					  		url:$("#editarticle_url").val(),
					  		atypeId:$("[name=editarticle_type]").val(),
					  		resLinkId:$("[name=editarticle_reslink]").val(),
					  		desc1:$("[name=editarticle_desc1]").val(),
					  		content:$("[name=editarticle_content]").val(),
					  		img:$("#editarticle_img").val(),
					  		${_csrf.parameterName}:'${_csrf.token}'
					  	  },
					  	   success: function(data){
								if(data==true){
									 $.messager.alert('修改文章','修改成功');
									 $('#tabs').tabs('close',"编辑文章");
									 $("#articledg").datagrid('reload',{});
								}else{
									$.messager.alert('删除文章','删除失败');
								}
					    }});
				}
			</script>
		</div>
	</div>
</body>
</html>