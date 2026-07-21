function chkData(selector, message) {
    const element = document.querySelector(selector);
    const value = element.value.trim();


    if (value === "" || value === "0") {
        alert(`${message} 입력 요망`);
        element.value = "";
        element.focus();
        return false;
    }
    return true;
}

const formSubmit = (selector, method, action) => {
    // 1단계: HTML에서 전송할 폼 태그 찾기
    const form = document.getElementById(selector);

    // 2단계: 폼의 전송 방식 설정 (GET or POST)
    form.method = method;

    // 3단계: 폼의 목적지(URL) 설정
    form.action = action;

    // 4단계: 실제로 서버에 전송 시작
    form.submit();
}
const formReset = (selector)=>{
    const form = document.getElementById(selector);
    form.reset();

}

const locationProcess = (url)=>{
    location.href = url;
}


function dataCheck(itemSelector,outSelector,msg){
    const item = document.querySelector(itemSelector);
    const out = document.querySelector(outSelector);
    const value = item.value.trim();

    if (value===""){
        out.textContent = `${msg}입력`;
        item.value ="" ;
        item.focus();
        return false;
    }
    return true;
}

