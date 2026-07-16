function chkData(selector, message) {
    const element = document.querySelector(selector);
    const value = element.value.trim();

    if(value === "" || value === "0") {
        alert(`${message} 입력해 주세요.`);
        element.value = "";
        element.focus();
        return false;
    }
    return true;
}