package com.spring.website.pethp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeDTO {
    private int noticeNumber;
    private String noticeName;
    private String noticeTitle;
    private String noticeContent;
    private String noticeDate;
    private String noticePasswd;
    private int noticeReadcnt;
}
