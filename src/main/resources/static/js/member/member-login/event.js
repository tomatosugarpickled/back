const loginForm = document.getElementsByClassName("login-form");
const loginButton = document.getElementsByClassName("login-button");

loginButton.addEventListener("click", (e) => {
    if (login === "false"){
        alert("아이디와 비밀번호를 확인해주세요.")
        return;
    }
        loginForm.submit();
})
