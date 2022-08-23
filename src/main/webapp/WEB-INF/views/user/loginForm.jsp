<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layouts/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<section class="h-100 h-custom" style="background-color: #8fc4b7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">LOGIN</h3>
                        <!-- FORM -->
                        <form class="px-md-2">
                            <div class="column">

                                <div class="form-outline mb-4">
                                    <input type="text" id="username" class="form-control" placeholder="Username" />
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="password" class="form-control" placeholder="Password"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="password2" class="form-control" placeholder="Password Validation"/>
                                </div>
                            </div>
                        </form>
                        <button class="btn btn-success">Login</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<%@ include file="../layouts/footer.jsp"%>