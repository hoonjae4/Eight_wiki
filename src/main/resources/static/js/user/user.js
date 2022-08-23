$("#name").blur(function(){
    var name =  $("#name").val();
    if(name == "" || name.length < 2){
        $("#successName").text("이름은 2자 이상 10자 미만으로 설정하셔야 합니다! :)");
        $("#successName").css("color", "red");
        $("#nameCheck").val("false");
    } else{
        //이름 중복 검사 할곳.
        $("#nameCheck").val("true");
    }
});
$("#username").blur(function(){
    var username =  $("#username").val();
    if(username == "" || username.length < 5 || username.length > 9){
        $("#successUsername").text("아이디는 5자 이상 10자 미만으로 설정하셔야 합니다! :)");
        $("#successUsername").css("color", "red");
        $("#usernameCheck").val("false");
    } else{
    //아이디 중복,유효성 검사 할거임.
        $("#usernameCheck").val("true");
    }
});
$("#password").blur(function(){
    var password =  $("#password").val();
    if(password == "" || password.length < 5){
        $("#successPassword").text("비밀번호는 5자 이상으로 설정하셔야 합니다! :(");
        $("#successPassword").css("color", "red");
        $("#passwordCheck").val("false");
    } else{
        $("#passwordCheck").val("true");
        //패스워드 유효성 검사 할것.
        if($("#password").val() == $("#password2").val()){
            $("#successPassword2").text("비밀번호가 일치합니다 :)");
            $("#successPassword2").css("color", "green");
            $("#password2Check").val("true");
        } else{
            $("#successPassword2").text("비밀번호가 일치하지 않습니다! :(");
            $("#successPassword2").css("color", "red");
            $("#password2Check").val("false");
        }
    }

});
$("#password2").blur(function(){
    if($("#password").val() == $("#password2").val()){
        $("#successPassword2").text("비밀번호가 일치합니다 :)");
        $("#successPassword2").css("color", "green");
        $("#password2Check").val("true");
    } else{
        $("#successPassword2").text("비밀번호가 일치하지 않습니다! :(");
        $("#successPassword2").css("color", "red");
        $("#password2Check").val("false");
    }
});
$("#email").blur(function(){
    var email =  $("#email").val();
    if(email == "" || email.length < 5){
        $("#successEmail").text("이메일은 5자 이상으로 설정하셔야 합니다! :)");
        $("#successEmail").css("color", "red");
        $("#emailCheck").val("false");
    } else{
        //이메일 중복,유효성 검사 할거임.
        $("#emailCheck").val("true");
    }
});

$("#birthYear").blur(function(){
    var birthYear =  $("#birthYear").val() * 1;
    if(isNaN(birthYear) || birthYear > 2022 || birthYear < 1900){
        $("#birthYearCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    } else{
        $("#birthYearCheck").val("true");
    }
    if($("#birthDayCheck").val() == "true" && $("#birthYearCheck").val() == "true" && $("#birthMonthCheck").val() == "true"){
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)")
        $("#successBirth").css("color","green");
    }
    else{
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
});
$("#birthMonth").blur(function(){
    var birthMonth =  $("#birthMonth").val() * 1;
    if(isNaN(birthMonth) || birthMonth > 12 || birthMonth < 1){
        $("#birthMonthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    } else{
        $("#birthMonthCheck").val("true");
    }
    if($("#birthDayCheck").val() == "true" && $("#birthYearCheck").val() == "true" && $("#birthMonthCheck").val() == "true"){
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)")
        $("#successBirth").css("color","green");
    }
    else{
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
});
$("#birthDay").blur(function(){
    var birthDay =  $("#birthDay").val() * 1;
    var birthMonth = $("#birthMonth").val() * 1;
    if(isNaN(birthDay)|| isNaN(birthMonth)){
        $("#birthDayCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(");
        $("#successBirth").css("color","red");
    }
    else if(birthMonth != 2 && (birthDay > 31 || birthDay < 1)){
        $("#birthDayCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(");
        $("#successBirth").css("color","red");
    } else if(birthMonth == 2 && (birthDay > 29 || birthDay < 1)){
        $("#birthDayCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(");
        $("#successBirth").css("color","red");
    } else{
        $("#birthDayCheck").val("true");
    }
    if($("#birthDayCheck").val() == "true" && $("#birthYearCheck").val() == "true" && $("#birthMonthCheck").val() == "true"){
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)");
        $("#successBirth").css("color","green");
    }
    else{
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
});
$("#gender").blur(function(){
    var gender = $("#gender").val();
    if(gender == "FEMAIL" || gender =="MAIL"){
        $("#genderCheck").val("true");
        $("#successGender").text("성별 선택이 완료되었습니다 :)");
        $("#successGender").css("color","green");
    }
    else{
     $("#successGender").text("성별을 선택해 주세요 :(");
     $("#successGender").css("color","red");
     $("#genderCheck").val("false");
    }
})
