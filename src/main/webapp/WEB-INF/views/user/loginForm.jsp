<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layouts/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section>
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">LOGIN</h3>
                        <!-- FORM -->
                        <form class="px-md-2" action="/auth/loginProc" method="post">
                            <div class="column">

                                <div class="form-outline mb-4">
                                    <input type="text" id="username" name="username" class="form-control" placeholder="Username" />
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                                </div>
                            </div>
                            <span>
                                <c:choose>
                                <c:when test="${not empty error}">
                                    <p id="valid" class="alert alert-danger">${error}</p>
                                    <p id="valid" class="alert alert-danger">${exception}</p>
                                    <p id="valid" class="alert alert-danger">${errorType}</p>
                                </c:when>
                                </c:choose>
                            </span>
                            <button id="btn-login" class="btn btn-success">Login</button>
                            <a href="https://kauth.kakao.com/oauth/authorize?client_id=473d50e8b38292f249d4422411e9ac73&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
                                <img height="38px" src="/image/kakao.png" alt="카카오 로그인">
                            </a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="../layouts/footer.jsp"%>