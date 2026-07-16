package com.spring.website.pethp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnADTO {
    private int qnaNumber; //글번호
    private String qnaCategory;//카테고리
    private String qnaName;//이름
    private String qnaTitle; //제목
    private String qnaContent; //내용
    private String qnaDate; //작성일
    private String qnaPassword;//비밀번호
    private int qnaReadcnt;//조회수

}

