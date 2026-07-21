# Pet Hospital Project -

# 1. 프로젝트 소개 및 선정 이유
이 프로젝트는 반려동물 보호자들이 쉽고 편리하게 동물병원 정보를 확인하고 다양한 진료 서비스를 이용할 수 있도록 제작한 웹사이트입니다.

병원 소개, 질의응답, 진료시간, 공지사항 등 필요한 정보를 한곳에서 제공하여 보호자들의 편의성을 높이고, 반려동물의 건강관리에 도움이 되는 웹 서비스를 구현하는 것을 목표로 하였습니다.

또한 HTML, JavaScript, Stringboot, Bootstrap를 활용한 웹 개발 능력을 향상시키고, Git과 GitHub를 이용한 협업 경험을 쌓기 위해 진행한 프로젝트입니다.

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

# 3. 팀원 역할

---

# 4. 매핑 정보
| 설명 | 매핑 정보 | HTTP메서드/메서드명 | VIEW 처리 결과 |
|------|----------|--------------------|------------------|
| 공지게시판 목록 | /pethp/notice/list | GET/noticeList | client/pethp/notice/list |
| 공지게시판 글 등록 화면 | /pethp/notice/write | GET/noticeWrite | client/pethp/notice/write |
| 공지게시판 글 등록 처리 | /pethp/notice/write | POST/noticeInsert | redirect:/pethp/notice/list |
| 공지게시판 상세 조회 | /pethp/notice/detail/{noticeNumber} | GET/noticeDetail | client/pethp/notice/detail |
