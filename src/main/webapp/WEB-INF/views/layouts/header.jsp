<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>EightWiki</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
    <style>
        html, body{
            margin: 0; padding: 0;
            height: 100%;
            background-color: #8fc4b7;
        }
        .wrapper{
            display: flex;
            flex-direction: column;
            height: 100%;
        }
    </style>
</head>

<body>
<header style="background-color: #e3f2fd;" class="justify-content-center row">
<nav class="container navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="/">EightWiki</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal" var="principal"></sec:authentication>
        </sec:authorize>
        <c:choose>
            <c:when test =  "${empty principal}">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/login">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/auth/join">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/test">Test</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/test">Test</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
</header>
<!--Main Navigation-->
