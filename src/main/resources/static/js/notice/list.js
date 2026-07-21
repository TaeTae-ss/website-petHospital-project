const searchForm = document.querySelector("#searchForm");
const keywordInput = document.querySelector("#keyword");
const searchTypeSelect = document.querySelector("#searchType");

// 문자열.replace(찾을값, 바꿀값) $&는 찾는 문자열 자체를 의미한다.
const escapeRegExp = function (value) {
    return value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
}

// 검색어와 일치하는 문자열을 강조한다.
const highlightKeyword = function (element, keyword) {
    const escapedKeyword = escapeRegExp(keyword);
    const regex = new RegExp(escapedKeyword, "gi");

    element.innerHTML = element.innerHTML.replace(
        regex,
        function(matchedText) {
            return `<span class="notice-required">${matchedText}</span>`;
        }
    );
};

const highlightSearchResult = function () {
    const keyword = keywordInput.value.trim();
    const searchType = searchTypeSelect.value;
    if (keyword === "") {
        return;
    }

    let selector = "";
    switch (searchType) {
        case "title":
            selector = ".list tr td a.detail";
            break;
        case "content":
            return;
        default:
            return;
    }
    const elements = document.querySelectorAll(selector);
    elements.forEach((element) => {
        highlightKeyword(element, keyword);
    });
};

searchForm.addEventListener("submit", function (event) {
    if (!chkData("#keyword", "검색어를")) {
        event.preventDefault();
    }
    document.querySelector("#page").value = 1;
});

highlightSearchResult();

document.querySelectorAll(".page-item a").forEach(function (link) {
    link.addEventListener("click", function (event) {
        event.preventDefault();
        document.querySelector("#page").value = this.dataset.page;
        searchForm.submit();
    });
});