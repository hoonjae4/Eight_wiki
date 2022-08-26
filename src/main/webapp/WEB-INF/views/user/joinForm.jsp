<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layouts/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section>
    <div class="container py-5 h-100 main-content">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-xl-8">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">REGISTER</h3>
                        <!-- FORM -->
                        <form class="px-md-2" id="joinForm">
                            <div class="column">
                                <div class="form-outline mb-4">
                                    <input type="text" id="nickName" class="form-control" placeholder="닉네임" />
                                    <span id="successNickName">닉네임을 입력해 주세요.</span>
                                    <input type="hidden" id="nickNameCheck" value="false"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="username" class="form-control" placeholder="아이디"/>
                                    <span id="successUsername">아이디를 입력해 주세요.</span>
                                    <input type="hidden" id="usernameCheck" value="false"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password" class="form-control" placeholder="비밀번호"/>
                                    <span id="successPassword">비밀번호를 입력해 주세요.</span>
                                    <input type="hidden" id="passwordCheck" value="false"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="password2" class="form-control" placeholder="비밀번호확인"/>
                                    <span id="successPassword2">비밀번호 확인.</span>
                                    <input type="hidden" id="password2Check" value="false"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="email" class="form-control" placeholder="이메일"/>
                                    <span id="successEmail">이메일을 입력해 주세요.</span>
                                    <input type="hidden" id="emailCheck" value="false"/>
                                </div>
                            </div>

                            <label>생년월일</label>
                            <div class="row">
                                <div class="form-outline col-4">
                                    <select class="form-control" id="birthYear">
                                        <option value="0" disabled  selected>년</option>
                                        <c:forEach var="i" begin="1900" end="2022">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-outline col-4">
                                    <select class="form-control" id="birthMonth">
                                        <option value="0" disabled selected>월</option>
                                        <c:forEach var="i" begin="1" end="12">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-outline col-4">
                                    <input type="text" class="form-control" id="birthDay" placeholder="일">
                                </div>
                                <input type="hidden" value="false" id="birthCheck">
                                <span class="col" id="successBirth">생년월일을 입력해주세요.</span>
                            </div>
                            <br/>
                            <h5>성별</h5>
                            <div class = "row">
                                <div class="col-md-6 mb-4">
                                    <select class="form-control" id="gender">
                                        <option value="1" disabled selected>Gender</option>
                                        <option value="FEMAIL">FEMAIL</option>
                                        <option value="MAIL">MAIL</option>
                                    </select>
                                    <span id="successGender">성별을 선택해주세요.</span>
                                    <input type="hidden" id="genderCheck" value="false"/>
                                </div>
                            </div>
                            <div class="form-outline mb-3">
                                <label for="introduce">자기소개</label>
                                <textarea class="form-control" rows="4" id="introduce"></textarea>
                            </div>
                            <div class="justify-content-center row">
                                <button type="button" id="join" class="btn btn-success mb-1">Register</button>
                            </div>
                            <div class="justify-content-center row">
                                <span id="successJoin"></span>
                            </div>
                            <div class="justify-content-center row">
                                <span id="validation"></span>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="/js/user/user.js"></script>
<%@ include file="../layouts/footer.jsp"%>