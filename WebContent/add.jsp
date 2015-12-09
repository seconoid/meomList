<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メモ追加</title>
</head>
<body>
	<h1>追加</h1>
	<!--  用修正  -->
	<p>${ mes }${ titleErr }${ memoErr }</p>
		<form action="AddMemoServlet" method="POST">
		<p>タイトル <input type="text" name="title"></p>
		<p>カテゴリ<input type="text" name="category"></p>
		<p>メモ <input type="text" name="memo"></p>
		<input type="submit" value="追加">
	</form>
	<p><a href="SelectMemoServlet">戻る</a>
</body>
</html>