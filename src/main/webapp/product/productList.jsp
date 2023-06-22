<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="product/css/style.css">

<title>전체 상품</title>
</head>
<body>
<div align="center">
    <div class="category">
        <ul>
            <li>Home</li>
            <li>상품</li>
            <li>전체상품</li>
        </ul>
    </div>
	<h3>상품 리스트</h3>
	<div class="container">
        <c:forEach var="productList" items="${productList}">
            <div class="item">
	            <img class="product_img" src="${productList.image}">
	            <span>${productList.name}</span><br><br>
	            <span class="sale_price">${productList.price}원</span>
            </div>
   		</c:forEach>
	</div>
	<div class="item_page">
		
	</div>
</div>
</body>
</html>