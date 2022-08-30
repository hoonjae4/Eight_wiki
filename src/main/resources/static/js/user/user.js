$("#nickName").blur(function(){
    var nickName =  $("#nickName").val();
    var nickNameRegex = /^[a-zA-Z0-9가-힣]{2,12}$/
    if(!nickNameRegex.test(nickName)){
        $("#successNickName").text("닉네임은 2글자 이상 12글자 미만으로 설정해주세요. 특수문자 불가능. :)");
        $("#successNickName").css("color", "red");
        $("#nickNameCheck").val("false");
    } else{
        $.ajax({
            url: '/auth/nickNameCheck?checkNickname='+nickName,
            type:'post',
            cache: false,
            success:function(data){
                if(data){
                    $("#successNickName").text("사용중인 닉네임입니다 :p");
                    $("#successNickName").css("color", "red");
                    $("#nickNameCheck").val("false");
                } else{
                    $("#successNickName").text("사용 가능한 닉네임입니다 :p");
                    $("#successNickName").css("color", "green");
                    $("#nickNameCheck").val("true");
                }
            },
            fail:function(error){
                console.log(error);
            }
        });
    }
});

$("#username").blur(function() {
    var username = $("#username").val();
    var usernameRegex = /^[a-zA-Z0-9]{5,15}$/;
    if (!usernameRegex.test(username)) {
        $("#successUsername").text("ID는 영어와 숫자로 이루어진 5~15자로 설정해주세요 :(");
        $("#successUsername").css("color", "red");
        $("#usernameCheck").val("false");
    } else {
        $.ajax({
            url: '/auth/usernameCheck?checkUsername=' + username,
            type: 'post',
            cache: false,
            success: function (data) {
                if (data) {
                    $("#successUsername").text("사용중인 ID입니다 :p");
                    $("#successUsername").css("color", "red");
                    $("#usernameCheck").val("false");
                } else {
                    $("#successUsername").text("사용 가능한 ID입니다 :p");
                    $("#successUsername").css("color", "green");
                    $("#usernameCheck").val("true");
                }
            },
            fail: function (error) {
                console.log(error);
            }
        });
    }
});

$("#password").blur(function(){
    var password =  $("#password").val();
    var passwordRegex = /(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\W)(?=\S+$).{8,20}/;
    if(!passwordRegex.test(password)){
        $("#successPassword").text("비밀번호는 영문자와, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.");
        $("#successPassword").css("color", "red");
        $("#passwordCheck").val("false");
    }
    else{
        $("#passwordCheck").val("true");
        $("#successPassword").text("사용 가능한 비밀번호입니다 :)");
        $("#successPassword").css("color", "green");
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

$("#email").blur(function(){
    var email =  $("#email").val();
    if(email == "" || email.length < 5){
        $("#successEmail").text("이메일은 5자 이상으로 설정하셔야 합니다! :)");
        $("#successEmail").css("color", "red");
        $("#emailCheck").val("false");
    } else {
        $.ajax({
            url: '/auth/emailCheck?checkEmail=' + email,
            type: 'post',
            cache: false,
            success: function (data) {
                if (data) {
                    console.log(data);
                    console.log("중복있음");
                    $("#successEmail").text("사용중인 이메일입니다 :p");
                    $("#successEmail").css("color", "red");
                    $("#emailCheck").val("false");
                } else {
                    console.log(data);
                    console.log("중복없음");
                    $("#successEmail").text("사용 가능한 이메일입니다 :p");
                    $("#successEmail").css("color", "green");
                    $("#emailCheck").val("true");
                }
            },
            fail: function (error) {
                console.log(error);
            }
        });
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

$("#birthYear").blur(function(){
    var birthYear =  $("#birthYear").val();
    var birthMonth = $("#birthMonth").val();
    var birthDay = $("#birthDay").val();
    var birth = birthYear + "-" + birthMonth + "-" + birthDay;
    var birthReg = /^((19[0-9]\d{1})|(20((0[0-9])|(1[0-9])|(2[0-2]))))\-(([1-9])|(1[0-2]))\-(([1-9])|([1-2][0-9])|30|31)$/;
    if(birthMonth == "2" && birthDay * 1 > 28){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
    else if(!birthReg.test(birth)){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    } else{
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)")
        $("#successBirth").css("color","green");
        $("#birthCheck").val("true");
    }
});

$("#birthMonth").blur(function(){
    var birthYear =  $("#birthYear").val();
    var birthMonth = $("#birthMonth").val();
    var birthDay = $("#birthDay").val();
    var birth = birthYear + "-" + birthMonth + "-" + birthDay;
    var birthReg = /^((19[0-9]\d{1})|(20((0[0-9])|(1[0-9])|(2[0-2]))))\-(([1-9])|(1[0-2]))\-(([1-9])|([1-2][0-9])|30|31)$/;
    if(birthMonth == "2" && birthDay * 1 > 28){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
    else if(!birthReg.test(birth)){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    } else{
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)")
        $("#successBirth").css("color","green");
        $("#birthCheck").val("true");
    }
});

$("#birthDay").blur(function(){
    var birthYear =  $("#birthYear").val();
    var birthMonth = $("#birthMonth").val();
    var birthDay = $("#birthDay").val();
    var birth = birthYear + "-" + birthMonth + "-" + birthDay;
    var birthReg = /^((19[0-9]\d{1})|(20((0[0-9])|(1[0-9])|(2[0-2]))))\-(([1-9])|(1[0-2]))\-(([1-9])|([1-2][0-9])|30|31)$/;
    if((birthMonth*1 == 2 && birthDay * 1 > 29 && birthYear%4==0) || (birthMonth*1 == 2 && birthDay * 1 > 28 && birthYear%4!=0)){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    }
    else if(!birthReg.test(birth)){
        $("#birthCheck").val("false");
        $("#successBirth").text("생년월일이 올바르지 않습니다 :(")
        $("#successBirth").css("color","red");
    } else{
        $("#successBirth").text("생년월일이 올바르게 입력되었습니다 :)")
        $("#successBirth").css("color","green");
        $("#birthCheck").val("true");
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
});

$("#join").on("click",()=>{
    if($("#nickNameCheck").val() == "true" && $("#usernameCheck").val()=="true" && $("#passwordCheck").val() == "true" &&
        $("#password2Check").val() == "true" && $("#birthCheck").val() =="true" && $("#genderCheck").val() == "true" &&
        $("#emailCheck").val() == "true"){

        let data = {
            nickName: $("#nickName").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            birth: $("#birthYear").val() + "-" + $("#birthMonth").val() + "-" + $("#birthDay").val(),
            gender: $("#gender").val(),
            introduce: $("#introduce").val(),
            oauth: $("#oauth").val(),
        }
        $.ajax({
            type:"POST",
            url:"/auth/joinValidation",
            data : JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
           if(resp){
               //resp == true -> 유효성검사 완료, 회원가입후 메인페이지
               $.ajax({
                   type:"POST",
                   url:"/auth/joinProc",
                   data:JSON.stringify(data),
                   contentType: "application/json; charset=utf-8",
                   dataType: "json"
               }).done(function(resp){
                   alert("회원가입 ㅊㅊ");
                   location.href="/";
               }).fail(function(error){
                   console.log(JSON.stringify(error));
                   console.log("회원가입 오류");
               });
           } else{
               console.log("유효성검사 실패");
               alert("유효성 검사 실패");
               //resp == false -> 유효성검사 통과X
           }
        }).fail(function(error){
            console.log("유효성 검사 불러오기 실패");
            console.log(JSON.stringify(error));
        });
    }
    else{
        $("#successJoin").text("Form 입력이 잘못되었습니다. 확인하세요 :(");
        $("#successJoin").css("color","red");
    }
});
