console.log("register.js 실행됨");
const registerForm = document.querySelector("#registerForm");

const registerId = document.querySelector("#registerId");
const registerPassword = document.querySelector("#registerPassword");
const registerPasswordConfirm = document.querySelector(
    "#registerPasswordConfirm",
);
const registerName = document.querySelector("#registerName");
const registerEmail = document.querySelector("#registerEmail");
const registerPhone = document.querySelector("#registerPhone");

const idError = document.querySelector("#idError");
const passwordError = document.querySelector("#passwordError");
const passwordConfirmError = document.querySelector(
    "#passwordConfirmError",
);
const nameError = document.querySelector("#nameError");
const emailError = document.querySelector("#emailError");
const phoneError = document.querySelector("#phoneError");

// 아이디: 영문자로 시작하는 영문·숫자 5~8자
const idRegExp = /^[A-Za-z][A-Za-z0-9]{4,7}$/;

// 비밀번호: 영문, 숫자, 특수문자를 각각 하나 이상 포함한 6~10자
const passwordRegExp =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,10}$/;

// 이름: 한글 2~5자
const nameRegExp = /^[가-힣]{2,5}$/;

// 이메일 형식
const emailRegExp =
    /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

// 전화번호: 010-숫자 4자리-숫자 4자리
const phoneRegExp = /^010-\d{4}-\d{4}$/;

registerForm.addEventListener("submit", function (event) {
    let isValid = true;

    // 이전 오류 메시지 초기화
    idError.textContent = "";
    passwordError.textContent = "";
    passwordConfirmError.textContent = "";
    nameError.textContent = "";
    emailError.textContent = "";
    phoneError.textContent = "";

    // 아이디 검사
    if (!idRegExp.test(registerId.value)) {
        idError.textContent =
            "아이디는 영문자로 시작하는 5~8자의 영문·숫자로 입력하세요.";

        isValid = false;
    }

    // 비밀번호 검사
    if (!passwordRegExp.test(registerPassword.value)) {
        passwordError.textContent =
            "비밀번호는 영문, 숫자, 특수문자를 포함한 6~10자로 입력하세요.";

        isValid = false;
    }

    // 비밀번호 확인
    if (registerPassword.value !== registerPasswordConfirm.value) {
        passwordConfirmError.textContent =
            "비밀번호가 일치하지 않습니다.";

        isValid = false;
    }

    // 이름 검사
    if (!nameRegExp.test(registerName.value)) {
        nameError.textContent =
            "이름은 한글 2~5자로 입력하세요.";

        isValid = false;
    }

    // 이메일 검사
    if (!emailRegExp.test(registerEmail.value)) {
        emailError.textContent =
            "올바른 이메일 형식으로 입력하세요.";

        isValid = false;
    }

    // 전화번호 검사
    if (!phoneRegExp.test(registerPhone.value)) {
        phoneError.textContent =
            "전화번호는 010-1234-5678 형식으로 입력하세요.";

        isValid = false;
    }

    // 하나라도 형식이 맞지 않으면 서버로 제출하지 않음
    if (!isValid) {
        event.preventDefault();
    }
});