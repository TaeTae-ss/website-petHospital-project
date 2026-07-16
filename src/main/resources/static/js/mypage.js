const mypageForm = document.querySelector("#mypageForm");

const updateModeButton =
    document.querySelector("#updateModeButton");

const cancelButton =
    document.querySelector("#cancelButton");

const updateButtonArea =
    document.querySelector("#updateButtonArea");

const passwordCheckArea =
    document.querySelector("#passwordCheckArea");

const registerPassword =
    document.querySelector("#registerPassword");

const registerPasswordConfirm =
    document.querySelector("#registerPasswordConfirm");

const registerName =
    document.querySelector("#registerName");

const registerEmail =
    document.querySelector("#registerEmail");

const registerPhone =
    document.querySelector("#registerPhone");

const currentPassword =
    document.querySelector("#currentPassword");

const passwordError =
    document.querySelector("#passwordError");

const passwordConfirmError =
    document.querySelector("#passwordConfirmError");

const nameError =
    document.querySelector("#nameError");

const emailError =
    document.querySelector("#emailError");

const phoneError =
    document.querySelector("#phoneError");

const currentPasswordError =
    document.querySelector("#currentPasswordError");

// 수정 취소 시 원래 값으로 복구하기 위한 값
const originalName = registerName.value;
const originalEmail = registerEmail.value;
const originalPhone = registerPhone.value;

// 회원가입에서 사용한 정규식과 같은 규칙
const passwordRegExp =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,10}$/;

const nameRegExp = /^[가-힣]{2,5}$/;

const emailRegExp =
    /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

const phoneRegExp = /^010-\d{4}-\d{4}$/;

// 수정 모드 활성화
updateModeButton.addEventListener("click", function () {
    registerPassword.readOnly = false;
    registerPasswordConfirm.readOnly = false;
    registerName.readOnly = false;
    registerEmail.readOnly = false;
    registerPhone.readOnly = false;

    currentPassword.disabled = false;

    passwordCheckArea.hidden = false;
    updateButtonArea.hidden = false;
    updateModeButton.hidden = true;

    registerName.focus();
});

// 수정 취소
cancelButton.addEventListener("click", function () {
    registerPassword.value = "";
    registerPasswordConfirm.value = "";

    registerName.value = originalName;
    registerEmail.value = originalEmail;
    registerPhone.value = originalPhone;
    currentPassword.value = "";

    registerPassword.readOnly = true;
    registerPasswordConfirm.readOnly = true;
    registerName.readOnly = true;
    registerEmail.readOnly = true;
    registerPhone.readOnly = true;

    currentPassword.disabled = true;

    passwordCheckArea.hidden = true;
    updateButtonArea.hidden = true;
    updateModeButton.hidden = false;

    clearErrorMessages();
});

// 수정 요청 전 정규식 검증
mypageForm.addEventListener("submit", function (event) {
    let isValid = true;

    clearErrorMessages();

    // 새 비밀번호를 입력한 경우에만 정규식 검사
    if (
        registerPassword.value !== "" &&
        !passwordRegExp.test(registerPassword.value)
    ) {
        passwordError.textContent =
            "비밀번호는 영문, 숫자, 특수문자를 포함한 6~10자로 입력하세요.";

        isValid = false;
    }

    // 비밀번호와 비밀번호 확인 비교
    if (
        registerPassword.value !==
        registerPasswordConfirm.value
    ) {
        passwordConfirmError.textContent =
            "새 비밀번호가 일치하지 않습니다.";

        isValid = false;
    }

    if (!nameRegExp.test(registerName.value)) {
        nameError.textContent =
            "이름은 한글 2~5자로 입력하세요.";

        isValid = false;
    }

    if (!emailRegExp.test(registerEmail.value)) {
        emailError.textContent =
            "올바른 이메일 형식으로 입력하세요.";

        isValid = false;
    }

    if (!phoneRegExp.test(registerPhone.value)) {
        phoneError.textContent =
            "전화번호는 010-1234-5678 형식으로 입력하세요.";

        isValid = false;
    }

    if (currentPassword.value.trim() === "") {
        currentPasswordError.textContent =
            "현재 비밀번호를 입력하세요.";

        isValid = false;
    }

    if (!isValid) {
        event.preventDefault();
    }
});

function clearErrorMessages() {
    passwordError.textContent = "";
    passwordConfirmError.textContent = "";
    nameError.textContent = "";
    emailError.textContent = "";
    phoneError.textContent = "";
    currentPasswordError.textContent = "";
}