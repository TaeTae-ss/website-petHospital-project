const updateBtn = document.querySelector("#updateBtn");
const deleteBtn = document.querySelector("#deleteBtn");

updateBtn.addEventListener("click", function() {
    const regNum = this.getAttribute("data-regNum");
    locationProcess(`/pethp/update/${regNum}`); // 순서를 앞으로 당김
});


deleteBtn.addEventListener("click", function() {
    if (!confirm("지우시겠습니까?")) {
        return;
    }
    const regNum = this.getAttribute("data-regNum"); // 속성에서 값을 읽음
    formSubmit('deleteForm', 'post', `/pethp/delete/${regNum}`);
});