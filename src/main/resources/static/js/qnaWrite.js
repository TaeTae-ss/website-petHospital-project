const insertForm = document.querySelector("#insertForm");

insertForm.addEventListener("submit", function (event){
    event.preventDefault();

    if (!chkData("#qnaCategory", "문의 유형")) return;
    if(!chkData("#qnaName", "작성자명을")) return;
    if(!chkData("#qnaTitle", "제목을")) return;
    if(!chkData("#qnaContent", "내용을")) return;
    if(!chkData("#qnaPasswd", "비밀번호를")) return;

    insertForm.submit();
});