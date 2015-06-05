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
	<div class="easyui-panel" title="修改分类来源" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
		<input type="hidden" id="editarticle_id" value="${article.id }" />
		<input type="hidden" id="editarticle_resid" value="${article.resId }" />
			<form>
				<table cellpadding="5">
					<tr>
						<td>标题:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入名字"
							type="text" id="editarticle_name" value="${article.title }"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>原网址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="editarticle_name" value="${article.url }"
							data-options="required:true,validType:'url'"></input></td>
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
							id="editarticle_desc1" >${article.desc1 }</textarea></td>
					</tr>
					<tr>
						<td>内容</td>
						<td>
							<textarea style="height: 300px;width: 500px;" class="easyui-textbox"  data-options="multiline:true" >${article.content }</textarea>
						</td>
					</tr>
				</table>
				<div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submiteditArticleForm()">保存</a>
            </div>
			</form>
		</div>
	</div>
</body>
</html>