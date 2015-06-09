<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>样式管理</title>
</head>
<body>
<script type="text/javascript">
	var index = 0;
	function deleteItem(id){
		if(id>0){
			$("#editcssdel").append('<input type="hidden" name="editcss_del" value="'+id+'" />');
		}
		$("[cid1="+id+"]").remove();
	
	}
	
	function addLine(){
		index--;
		$("#eidtcssTBody").append('<tr cid1="'+index+'"><td>代码:</td><td ><span class="textbox" style="width: 498px; height: 20px;"><input type="text" class="textbox-text validatebox-text" autocomplete="off" placeholder="" style="margin-left: 0px; margin-right: 0px; padding-top: 3px; padding-bottom: 3px; width: 490px;" name="edit_css" cid="'+index+'"></span>'+
		'<td><a href="javascript:void(0)" iconcls="icon-remove" class="easyui-linkbutton l-btn l-btn-small" onclick="deleteItem('+index+')" group="" id=""><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text l-btn-empty">&nbsp;</span><span class="l-btn-icon icon-remove">&nbsp;</span></span></a></td></tr>');
	
	}
</script>
	<div class="easyui-panel" title="样式管理" style="width: 100%">
		<div style="padding: 10px 60px 20px 60px; margin: 20px auto;">
			<form>
			<input type="hidden" id="editcss_id" value="${link.id }" />
				<table cellpadding="5">
					<tr>
						<td>分类来源:</td>
						<td style="width: 500px;">${link.name }</td>
						<td></td>
					</tr>
					<tbody id="eidtcssTBody">
					<c:forEach items="${csss }" var="css">
						<tr cid1="${css.id }">
							<td>代码:</td>
							<td >
								<input style="width: 500px;" name="edit_css" cid="${css.id }" value='${css.csslink }'
								data-options="required:true" class="easyui-textbox"
								missingMessage="必须输入内容"/>
							</td>
							<td><a href="javascript:void(0)" iconCls="icon-remove" class="easyui-linkbutton" onclick="deleteItem(${css.id})"></a></td>
						</tr>
					</c:forEach>
					</tbody>
					
				</table>
				<div id="editcssdel"></div>
				<div style="text-align: left; padding: 5px 0px 5px 70px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="addLine()">添加</a>
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitEditCssForm()">保存</a>
				</div>
				<script type="text/javascript">
					function submitEditCssForm(){
						//先获取数据
						var vitems = $("[name=edit_css]");
						var iitems = $("[cid]");
						var ids1="",values1="";
						vitems.each(function(i, o){
							values1 += $(o).val()+"<;>";
						});
						iitems.each(function(i,o){
							ids1 += $(o).attr("cid")+"<;>";
						});
						//获取删除了的
						var dels = $("[name=editcss_del]");
						var delIds = "";
						
						dels.each(function(i,o){
							delIds += $(o).val()+"<;>";
						});
						
						 $.ajax({ url:'cssadmin/update.do',
			            	  type: 'POST',
			            	  datattpe:"text",
			            	  data:{
			            		  linkid:$("#editcss_id").val(),
			            		  ids:ids1,
			            		  values:values1,
			            		  del:delIds,
			            		  ${_csrf.parameterName}:'${_csrf.token}'
			            	  },
			            	  success: function(data){
									if(data==true){
										 $.messager.alert('编辑样式','保存成功');
										 $('#tabs').tabs('close',"编辑样式");
									}else{
										$.messager.alert('编辑样式','保存失败');
									}
				              }});
					}
				</script>
			</form>
		</div>
	</div>
</body>
</html>