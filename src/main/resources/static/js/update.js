document.getElementById('updateBtn').addEventListener('click', function() {
    // 필수 값 체크 (비밀번호는 제외했습니다)
    if (!chkData('#pName', '반려동물 이름을')) return;
    if (!chkData('#pGuardian', '보호자명을')) return;
    if (!chkData('#title', '제목을')) return;
    if (!chkData('#pContent', '내용을')) return;

    // 모든 필수 검사를 통과하면 폼 전송
    formSubmit('updateForm', 'post', '/pethp/update');
});
