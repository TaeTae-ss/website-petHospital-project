const qnaDeleteBtn = document.querySelector("#qnaDeleteBtn");

qnaDeleteBtn.addEventListener("click", function () {
    const password = document.querySelector("#qnaPassword").value;

    if(password.trim() === ""){
        alert("비밀번호를 입력하세요.");
        return;
    }

    if (!confirm("삭제하시겠습니까?")) {
        return;
    }


    formSubmit("dataForm", "post", "/pethp/qna/delete");
});