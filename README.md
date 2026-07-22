# Pet Hospital Project - 우태식, 문혜원, 홍의진, 김태현

# 1. 프로젝트 소개 및 선정 이유
이 프로젝트는 반려동물 보호자들이 쉽고 편리하게 동물병원 정보를 확인하고 다양한 진료 서비스를 이용할 수 있도록 제작한 웹사이트입니다.

병원 소개, 질의응답, 진료시간, 공지사항 등 필요한 정보를 한곳에서 제공하여 보호자들의 편의성을 높이고, 반려동물의 건강관리에 도움이 되는 웹 서비스를 구현하는 것을 목표로 하였습니다.

###  주요 기능

- 로그인 및 회원가입 기능
- 공지사항 확인
- 자유 게시판 및 의견 공유
- 고객 문의 페이지

---

# 2. 사용 기술
- HTML
- JavaScript
- Springboot
- Bootstrap
- Git
- GitHub
- IntelliJ

---

# 3. 팀원 역할

| 이름 | 담당 영역 |
|------|-----------|
| 우태식 | 공지사항 페이지 CRUD |
| 문혜원 | Q&A 페이지 CRUD |
| 홍의진 | 자유게시판 페이지 CRUD |
| 김태현 | 로그인 및 회원가입 페이지 CRUD |

---

# 4. 매핑 정보
| 설명 | 매핑 정보 | HTTP메서드·메서드명 | VIEW 처리 결과 |
|------|----------|--------------------|------------------|
| 공지게시판 목록 | /pethp/notice/list | GET·noticeList() | client/pethp/notice/list |
| 공지게시판 글 등록 화면 | /pethp/notice/write | GET·noticeWrite() | client/pethp/notice/write |
| 공지게시판 글 등록 처리 | /pethp/notice/write | POST·noticeInsert() | redirect:/pethp/notice/list |
| 공지게시판 상세 조회 | /pethp/notice/detail/{noticeNumber} | GET·noticeDetail() | client/pethp/notice/detail |
| 공지게시판 수정 화면 | /pethp/notice/ue/{noticeNumber} | GET·updateForm() | client/pethp/notice/update |
| 공지게시판 수정 처리 | /pethp/notice/{noticeNumber}/update  | POST·noticeUpdate() | redirect:/pethp/notice/{noticeNumber} |
| 공지 게시판 삭제 처리 | /pethp/notice/{noticeNumber}/delete | POST·noticeDelete() | redirect:/pethp/notice/list |
| 자유 게시글 목록 페이지 조회 | /pethp/list | GET·boardList() | client/pethp/list |
| 자유 게시글 작성 폼(화면) 이동 | /pethp/write | GET·writeForm() | client/pethp/write | 
| 자유 게시글 DB 등록 처리 | /pethp/write | POST·boardInsert() | redirect:/pethp/list |
| 자유 게시글 상세 조회 | /pethp/detail/{regNum} | GET·detail() | client/pethp/detail |
| 자유 게시글 수정 폼 | /pethp/update/{regNum} | GET·modifyForm() | client/pethp/update |
| 기존 게시글 DB 수정 처리 | /pethp/update/{regNum} | POST·modifyBoard() | redirect:/pethp/detail/{regNum} |
| 자유 기존 게시글 DB 수정 처리 | /pethp/delete/{regNum} | POST·deleteBoard() | redirect:/pethp/list |
| Q&A목록 조회 | /pethp/qna	 | GET·qnaList() | client.pethp/qna |
| Q&A글쓰기 화면 | /pethp/qna-write | GET·qnaWriteForm() | client/pethp/qnaWrite |
| Q&A 글 등록 처리 | /pethp/qna-write | POST·qnaInsertForm() | redirect:/pethp/qna |
| Q&A 상세조회 | /pethp/qna/{qnaNumber} | GET·qnaDetail() | client/pethp/qnaDetail |
| Q&A 삭제처리 | /pethp/qna/delete | POST·qnaDelete() | redirect:/pethp/qna |
| 회원가입 화면 이동  | /register | GET·registerForm()    | client/register.html |
| 회원가입 처리     | /register | POST·registerInsert() | 성공: redirect:/<br>실패: client/register.html |
| 로그인 화면 이동   | /login | GET·loginForm() | client/login.html |
| 로그인 처리      | /login | POST·login() | 성공: redirect:/<br>실패: client/login.html |
| 로그아웃 처리     | /logout | GET·logout() | redirect:/ |
| 마이페이지 화면 이동 | /mypage | GET·mypage() | 로그인 상태: client/mypage.html<br>비로그인 상태:redirect:/login |
| 회원정보 수정 처리  | /mypage/update | POST·mypageUpdate() | 성공:redirect:/mypage<br>실패:client/mypage.html |

---

# 5. 이미지

---
