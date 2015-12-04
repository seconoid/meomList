<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf8"); %>
<html lang="ja">
<%
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String category = request.getParameter("category");
	String memo = request.getParameter("memo");
	String posttime = request.getParameter("posttime");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
	<h1>更新</h1>
	<p>${ titleErr }
	<form action="UpdateMemoServlet" method="POST">
		<p>ID: <%= id %></p>
		<p>タイトル： <input type="text" name="title" value="<%= title %>"></p>
		<p>カテゴリ： <input type="text" name="category" value="<%= category %>"></p>
		<p>内容： <input type="text" name="memo" value="<%= memo %>"></p>
		<input type="hidden" name="id" value=<%= id %>>
		<input type="submit" value="更新">
	</form>
	<p><a href="SelectMemoServlet">戻る</a></p>
</body>
</html>