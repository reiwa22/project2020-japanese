<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

  
<!-- jQuery -->
<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>
<script src="<%=cp %>/resources/js/jquery-3.3.1.min.js"></script>
 
<style>
#left{
	color: green;
}
</style>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>みどり書店 &mdash; 本は美しい</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../resources/css/jquery-ui.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="../../resources/fonts/icomoon/style.css">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/magnific-popup.css">
    <link rel="stylesheet" href="../../resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../../resources/css/owl.theme.default.min.css">


    <link rel="stylesheet" href="../../resources/css/aos.css">

    <link rel="stylesheet" href="../../resources/css/style.css">
    
  </head>
  <body>
  
  <div class="site-wrap">
    <header class="site-navbar" role="banner">
      <div class="site-navbar-top">
      
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
            		<a id="left">本はいつも皆様とご一緒に</a>
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
              <div class="site-logo">
                <a href="/" class="js-logo-clone">みどり書店</a>
              </div>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
              <ul>
                  <c:choose>
		             <c:when test="${not empty sessionScope.u_id}">
		             	<a>${sessionScope.u_id}様ログイン中</a>
		              	<a href="/jm/logout" class="btn btn-basic btn-flat">ログアウト</a>
		             </c:when>
					<c:otherwise>
						<a class="btn btn-default btn-sm" href="/jm/jm_signUp">会員加入</a>
		              	<a href="/jm/jm_login" class="btn btn-basic btn-flat">ログイン</a>
		            </c:otherwise>
		          </c:choose>
		          <c:if test="${sessionScope.u_id != null}">
                  <li><a href="/jm/jm_userInfo"><span class="icon icon-person"></span></a></li>
                  </c:if>
                  <li><a href="/jm/jm_about"><span class="icon icon-heart-o"></span></a></li>
                  <li>
                  </li> 
                 </ul>
              </div> 
            </div>
		 </div>
        </div>
      </div> 

      <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
            <li class="has">
              <a href="/">ホーム</a>
            </li>
            <li><a href="/jm/jm_about">みどり書店の紹介</a></li>
           	<li><a href="/jm/jm_introForm">本の紹介</a></li>
            	<li><a href="/jm/jm_reviewForm">レビュー</a></li>
            <li><a href="/jm/jm_contact">お問い合わせ</a></li> 
          </ul>
        </div>
      </nav>
    </header>