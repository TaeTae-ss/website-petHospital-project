package com.spring.website.pethp.service;

import com.spring.website.common.dto.NoticeRequestDTO;
import com.spring.website.common.dto.NoticeResponseDTO;
import com.spring.website.pethp.dto.NoticeDTO;


import java.util.List;

public interface NoticeService {
    List<NoticeDTO> noticeList();
    NoticeResponseDTO<NoticeDTO> selectNoticeList(NoticeRequestDTO noticeRequestDTO);
    int noticeInsert(NoticeDTO noticeDTO);
    int noticeUpdate(NoticeDTO noticeDTO);
    int noticeDelete(int noticeNumber);
    NoticeDTO noticeDetail(int noticeNumber);
    NoticeDTO updateForm(int noticeNumber);
    boolean passwordConfirm(NoticeDTO noticeDTO);
}
