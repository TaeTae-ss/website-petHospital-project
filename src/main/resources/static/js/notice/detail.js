let actionType = "";

const passwordFormArea = document.querySelector("#passwordFormArea");
const passwordForm = document.querySelector("#passwordForm");
const noticePasswdInput = document.querySelector("#noticePasswd");
const messageEl = document.querySelector("#message");
const noticeNumberInput = document.querySelector("#noticeNumber");

const resetPasswordMessage = () => {
    messageEl.textContent = "작성 시 입력한 비밀번호를 입력해 주세요.";
}

const hidePasswordForm = () => {
    passwordFormArea.hidden = true;
    noticePasswdInput.value = "";
    messageEl.textContent = "";
    actionType = "";
};

const showPasswordForm = () => {
    passwordFormArea.hidden = false;
    resetPasswordMessage();
    noticePasswdInput.value = "";
};

document.querySelector("#updateFormBtn").addEventListener("click", () => {
    actionType = "update";
    showPasswordForm();
});

document.querySelector("#noticeDeleteBtn").addEventListener("click", () => {
    actionType = "delete";
    showPasswordForm();
});

noticePasswdInput.addEventListener("input", () => {
    resetPasswordMessage();
});

const locationProcess = (url) => {
    location.href = url;
}

const dataForm = document.querySelector("#dataForm");

document.querySelector("#passwordBtn").addEventListener("click", () => {
   const value = passwordForm.value;

   if (value === "") {
       alert("비밀번호를 입력해주세요");
       return;
   }

   const formData = new FormData(passwordForm);

   fetch("/pethp/notice/password-confirm", {
       method: "POST",
       body: formData
   })
       .then(response => {
           if (!response.ok) {
               throw new Error("비밀번호 확인 요청에 실패했습니다.");
           }

           return response.json();
       })
       .then(result => {
           if (!result) {
               messageEl.textContent = "작성 시 입력한 비밀번호가 일치하지 않습니다.";
               noticePasswdInput.select();
               return;
           }
           messageEl.textContent = "";
           const noticeNumber = noticeNumberInput.value;

           if (actionType === "update") {
               locationProcess(`/pethp/notice/${noticeNumber}/update`);
           } else if (actionType === "delete") {
               if (confirm("정말 삭제하시겠습니까?")) {
                   dataForm.method="post";
                   dataForm.action = "/pethp/notice/delete";
                   dataForm.submit();
               }
           }
       })
       .catch(error => {
           console.error(error);
           alert("시스템 오류입니다. 관리자에게 문의하세요");
       });
});

document.querySelector("#passwordCancelBtn").addEventListener("click", () => {
    hidePasswordForm();
});