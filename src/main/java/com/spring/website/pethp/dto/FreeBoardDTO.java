package com.spring.website.pethp.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FreeBoardDTO {

    private Long regNum;      // 글번호[생성순]
    private String pName;     // 동물 이름 (p_name에서 변경)
    private String pGuardian; // 보호자 이름
    private String title;     // 제목
    private String pContent;  // 내용
    private LocalDateTime regDate; // 등록일 (reDate에서 오타 수정)
    private String pPwd;      // 비밀번호
    private int viewCnt;      // 조회수
}
