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
			<h1><img src="./images/logo.png"></h1>
			<div class="add-icon">
				<a href="./add.jsp" class="header-add">+</a>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="side col-xs-2">
					<h2>Categories</h2>
					<div class="categorylist">
						<a href="SelectMemoServlet">▶All</a>
					</div>
					<c:forEach var="m" items="${ categoryList }">
						<div class="categorylist">
							<form name="${ m.category }" action="SelectMemoServlet" method="POST">
								<input type="hidden" name="category" value="${ m.category }">
								<a href="#" onclick="javascript:document.${ m.category }.submit()">▶${ m.category }</a>
							</form>
						</div>
					</c:forEach>
				</div>
				<div class="main col-xs-10">

					<!-- memoList -->
					<h2 class="page-title">Memos</h2>
					<div class="row">
						<c:forEach var="m" items="${ list }">
							<div class="col-xs-12 col-sm-6 m-20">
								<div class="memo">
									<div class="memo-header">
										<div class="title">
											${ m.title }
										</div>
										<c:if test="${ m.category != null }">
											<div class="category">
												${ m.category }
											</div>
										</c:if>
										<div class="delete">
											<form action="DeleteMemoServlet" method="POST">
												<input type="hidden" name="id" value="${ m.id }">
												<input type="submit" value="削除">
											</form>
										</div>
										<div class="update">
											<form action="./update.jsp" method="POST">
												<input type="hidden" name="id" value="${ m.id }">
												<input type="hidden" name="title" value="${ m.title }">
												<input type="hidden" name="category" value="${ m.category }">
												<input type="hidden" name="memo" value="${ m.memo }">
												<input type="hidden" name="posttime" value="${ m.posttime }">
												<input type="submit" value="編集">
											</form>
										</div>
									</div>
									<div class="msg">
										${ m.memo }
									</div>
									<div class="posttime">
										${ m.posttime }
									</div>
								</div>
							</div>
						</c:forEach>
						
						<!-- add memo -->
						<div class="col-xs-12 col-sm-6 m-20">
							<div class="memo">
								<div class="add-memo">
									<a href="./add.jsp">+</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- <script src="js/common.js"></script> -->
</body>
</html>