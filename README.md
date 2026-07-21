# Pet Hospital Project

반려동물 병원 웹사이트 프로젝트입니다.


| 설명          | 매핑 정보            | HTTP Method · 메서드명        | View 또는 처리 결과                                              |
| ----------- | ---------------- | ------------------------- | ---------------------------------------------------------- |
| 회원가입 화면 이동  | `/register`      | GET · `registerForm()`    | `client/register.html`                                     |
| 회원가입 처리     | `/register`      | POST · `registerInsert()` | 성공: `redirect:/`<br>실패: `client/register.html`             |
| 로그인 화면 이동   | `/login`         | GET · `loginForm()`       | `client/login.html`                                        |
| 로그인 처리      | `/login`         | POST · `login()`          | 성공: `redirect:/`<br>실패: `client/login.html`                |
| 로그아웃 처리     | `/logout`        | GET · `logout()`          | 세션 삭제 후 `redirect:/`                                       |
| 마이페이지 화면 이동 | `/mypage`        | GET · `mypage()`          | 로그인 상태: `client/mypage.html`<br>비로그인 상태: `redirect:/login` |
| 회원정보 수정 처리  | `/mypage/update` | POST · `mypageUpdate()`   | 성공: `redirect:/mypage`<br>실패: `client/mypage.html`         |
