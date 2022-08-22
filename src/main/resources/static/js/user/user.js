let index = {
    init: function () {
        $("#join").on("click", () => {
            this.save();
        });
    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            introduce: $("#introduce").val(),
            birthYear: $("#birthYear").val(),
            birthMonth: $("#birthMonth").val(),
            birthDay: $("#birthDay").val(),
            gender: $("#gender").val(),
            email: $("#email").val(),
        }
        $.ajax({
            type:"POST",
            url:"/join",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            datatype:"json"
        }).done(function (resp){
            alert("회원가입 완료");
            console.log(resp);
            //location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
            console.log(JSON.stringify(error));
        });
    },
};
index.init();