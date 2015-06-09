<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加文章</title>
</head>
<body>
	<div class="easyui-panel" title="添加文章" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
				<table cellpadding="5">
					<tr>
						<td>标题:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入名字"
							type="text" id="addarticle_title" 
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>原网址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="addarticle_url" 
							data-options="required:true,validType:'url'"></input></td>
					</tr>
					<tr>
						<td>图片地址:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="addarticle_img" value="${article.img }"></input></td>
					</tr>
					<tr>
						<td>文章时间:</td>
						<td style="width: 500px;"><input class="easyui-textbox" missingMessage="必须输入网址"
							type="text" id="addarticle_alerttime" value="${article.alerttime }"></input></td>
					</tr>
					<tr>
						<td>分类</td>
						<td><select class="easyui-combobox"  name="addarticle_type">
							
							<c:forEach items="${types }" var="type">
								<option value="${type.id }"  >${type.name }</option>
							</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>来源</td>
						<td>
							<select class="easyui-combobox"  name="addarticle_reslink">
								<c:forEach items="${links }" var="link">
								<option value="${link.id }">${link.name }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>简介:</td>
						<td ><textarea style="height: 100px;width: 500px;" class="easyui-textbox"  data-options="multiline:true"
							name="addarticle_desc1" ></textarea></td>
					</tr>
					<tr>
						<td>内容</td>
						<td>
							<textarea style="height: 300px;width: 500px;" name="addarticle_content" class="easyui-textbox"  data-options="multiline:true" ></textarea>
						</td>
					</tr>
				</table>
				<div style="text-align:left;padding:5px 0px 5px 70px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddArticleForm()">保存</a>
            </div>
			</form>
			<script type="text/javascript">
				function submitAddArticleForm(){
					$.ajax({ url: "article/add.do",
					  	  type: 'POST',
					  	  datattpe:"text",
					  	  data:{
					  		
					  		title:$("#addarticle_title").val(),
					  		url:$("#addarticle_url").val(),
					  		img:$("#addarticle_img").val(),
					  		alerttime:$("#addarticle_alerttime").val(),
					  		atypeId:$("[name=addarticle_type]").val(),
					  		resLinkId:$("[name=addarticle_reslink]").val(),
					  		desc1:$("[name=addarticle_desc1]").val(),
					  		content:$("[name=addarticle_content]").val(),
					  		${_csrf.parameterName}:'${_csrf.token}'
					  	  },
					  	   success: function(data){
								if(data==true){
									 $.messager.alert('添加文章','添加成功');
									 //var tab = $('#tabs').tabs('getSelected');  // get selected panel
					             	 //tab.panel('refresh');
									 $('#tabs').tabs('close',"添加文章");
									 $("#articledg").datagrid('reload',{});
								}else{
									$.messager.alert('添加文章','添加失败');
								}
					    }});
				}
			</script>
		</div>
	</div>
</body>
</html>