<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Style-Type" content="text/javascript" />
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="./css/common.css" rel="stylesheet">
  <!--[if lt IE 9]>
  	<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div class="wrapper">
		<header>
			<h1>メモリスト</h1>
			<a href="./add.jsp">メモ追加</a>
			<form action="SelectMemoServlet" method="POST">
					<p>
						メモタイトル<input type="text" name="title" >
						<input type="submit" value="検索">
					</p>
			</form>
			<p>${ mes }</p>
		</header>
		<div class="container">
			<div class="side col-xs-2">
				<p>pone</p>
			</div>
			<div class="main col-xs-10">
				<table>
					<tr>
						<th>ID</th>
						<th>タイトル</th>
						<th>カテゴリ</th>
						<th>メモ内容</th>
						<th>日付</th>
					</tr>
					<c:forEach var="m" items="${ list }">
					<tr>
						<td>${ m.id }</td>
						<td>${ m.title }</td>
						<td>${ m.category }</td>
						<td>${ m.memo }</td>
						<td>${ m.posttime }</td>
						<td>
							<form action="./update.jsp" method="POST">
								<input type="hidden" name="id" value="${ m.id }">
								<input type="hidden" name="title" value="${ m.title }">
								<input type="hidden" name="category" value="${ m.category }">
								<input type="hidden" name="memo" value="${ m.memo }">
								<input type="hidden" name="posttime" value="${ m.posttime }">
								<input type="submit" value="更新">
							</form>
						</td>
						<td>
							<form action="DeleteMemoServlet" method="POST">
								<input type="hidden" name="id" value=${ m.id }>
								<input type="submit" value="削除">
							</form>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- <script src="js/common.js"></script> -->
</body>
</html>