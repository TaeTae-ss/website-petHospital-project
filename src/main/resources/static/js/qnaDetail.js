const updateFormBtn = document.querySelector("#updateFormBtn");
const qnaDeleteBtn =document.querySelector("#qnaCancelBtn");
updateFormBtn.addEventListener("click", function (){
    const qnaNumber = document.querySelector("#qnaNumber").value;
    locationProcess(`/qna/${qnaNumber}/update`);
});

qnaDeleteBtn.addEventListener("click", function (){
    if(!confirm("삭제하시겠습니까?")){
        return;
    }
    formSubmit("dataForm", "post","qna/delete");
});
