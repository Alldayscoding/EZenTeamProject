<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="product/css/style.css?ver=1">


<title>전체 상품</title>
</head>
<body>
<div align="center">
    <div class="category">
        <ul><br>
         <li>&nbsp;&nbsp; HOME </li>
         <li> > 상품 </li>
         <li> > 전체 상품 &nbsp;&nbsp;</li>
        </ul>
    </div>
	<div class="productlist_top"><br><strong>상품 리스트</strong></div><br><br><br>
	<div class="container">
        <c:forEach var="product" items="${productList}">
            <div class="item">
	            <a href="main?command=product_view&num=${product.code}"><img class="product_img" src="${product.image}"></a>
	            <a href="main?command=product_view&num=${product.code}"><span>${product.name}</span></a><br><br>
	            <span class="sale_price"><fmt:formatNumber value="${product.price}" type="currency"/></span>
            </div>
   		</c:forEach>
	</div>
	<div class="item_page">
	
	</div>
</div>
</body>
</html>
