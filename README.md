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


-- 시퀀스 생성
CREATE SEQUENCE register_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- register 테이블 생성
CREATE TABLE register (
register_no NUMBER PRIMARY KEY,
register_id VARCHAR2(30) NOT NULL UNIQUE,
register_password VARCHAR2(100) NOT NULL,
register_name VARCHAR2(30) NOT NULL,
register_email VARCHAR2(100) NOT NULL UNIQUE,
register_phone VARCHAR2(20) NOT NULL,
register_date DATE DEFAULT SYSDATE
);

-- register 테이블 데이터 입력 예시
INSERT INTO register (
register_no,
register_id,
register_password,
register_name,
register_email,
register_phone,
register_date
)
VALUES (
register_seq.NEXTVAL,
'user01',
'1234',
'홍길동',
'user01@test.com',
'010-1234-5678',
SYSDATE
);