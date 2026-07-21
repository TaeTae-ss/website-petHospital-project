package com.spring.website.pethp.mapper;

import com.spring.website.common.dto.NoticeRequestDTO;
import com.spring.website.pethp.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> noticeList();
    List<NoticeDTO> selectNoticeList(NoticeRequestDTO noticeRequestDTO);
    int selectNoticeCount(NoticeRequestDTO noticeRequestDTO);
    int noticeInsert(NoticeDTO noticeDTO);
    int readcntUpdate(@Param("noticeNumber")  int noticeNumber);
    int noticeUpdate(NoticeDTO noticeDTO);
    Optional<NoticeDTO> noticeDetail(@Param("noticeNumber") int noticeNumber);
    int noticeDelete(@Param("noticeNumber") int noticeNumber);
    int passwordConfirm(NoticeDTO noticeDTO);
}
