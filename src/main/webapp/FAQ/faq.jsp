<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

</script>
<meta charset="UTF-8">
<link rel="stylesheet" href="FAQ/css/style.css">
<title>FAQ</title>
</head>


<body>
	<div>
		<c:forEach var="subject" items="${subjects}">

		</c:forEach>

	</div>

	<div id="wapper">

		<div id="main-body">
			<!--네비게이션-->
			<nav>
				<h1>고객센터</h1>
				<br />
				<ul>
					<li><a href="">FAQ</a></li>
					<br />
					<li><a href="">공지사항</a></li>
					<br />
					<li><a href="">매장안내</a></li>
					<br />
					<li><a href="">1:1문의하기</a></li>
					<br>
					<li><h1>080-012-7878</h1></li>
					<br />
					<li style="font-size: 14px">AM 09:00 - PM 17:00 <br>(점심시간
						11:30 - 12:30) DAY OFF (토/일/공휴일 휴무)
					</li>
					<br />
					<li><input class="support" type="button" value="1:1문의하기"></li>
				</ul>
			</nav>
			<!--콘텐츠부분-->
			<section>
			<!--<p>FAQ</p>-->
				<article>
						<c:forEach var="faq" items="${FAQList}">
					<div>
						 	<ul id="subject" style="font-size:18px;font-style:bold">
								<li><strong>${faq.subject}</strong></li>
								<li>${faq.content}</li><br/>
							</ul>
					</div>
						</c:forEach>
				</article>
			</section>
			<!---->
			<aside>
				<p>aside</p>
			</aside>
		</div>
		<!--풋터-->
		<footer>footer</footer>
	</div>
</body>
</html>