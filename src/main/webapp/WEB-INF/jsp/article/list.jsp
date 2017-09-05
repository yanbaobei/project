<%@page import="java.util.List"%>
<%@page import="com.zhidisoft.blog.admin.entity.Article"%>
<%@page import="com.zhidisoft.blog.admin.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	test

	<form action="test/save1" method="post">
		<input type="text" name="username" />
		<button type="submit">单个参数提交</button>
	</form>


	<form action="test/save2" method="post">
		<input name="username" type="text" /> <input name="age" type="number" />
		<input name="no" type="text" />
		<button type="submit">vo对象参数提交</button>
	</form>

	<form action="test/upload" method="post" enctype="multipart/form-data">
		<input name="file" type="file" />
		<button type="submit">vo对象参数提交</button>
	</form>
	
	<br/>
	
	${list.list }
	
	<%
		PageVo pageVo = (PageVo)request.getAttribute("list");
		List<Article> articleList = (List<Article>)pageVo.getList();
		for(Article article : articleList){
			out.print("title"+ article.getTitle());
		}
	%>
</body>
</html>