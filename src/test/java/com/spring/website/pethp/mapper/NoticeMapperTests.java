package com.spring.website.pethp.mapper;

import com.spring.website.common.dto.NoticeRequestDTO;
import com.spring.website.pethp.dto.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Optional;

@MybatisTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class NoticeMapperTests {

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    public void noticeListTest() {
        noticeMapper.noticeList().forEach(notice -> log.info(notice.toString()));
    }

    @Test
    public void selectNoticeListTest() {
        NoticeRequestDTO noticeRequestDTO = new NoticeRequestDTO();
/*
        noticeRequestDTO.setSearchType("title");
        noticeRequestDTO.setKeyword("진료");
 */
        noticeRequestDTO.setPage(1);
        noticeRequestDTO.setSize(10);

        noticeMapper.selectNoticeList(noticeRequestDTO).forEach(noticeDTO -> log.info(noticeDTO.toString()));
    }

    @Test
    public void noticeInsertTest() {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeTitle("제헌절 진료 안내");
        noticeDTO.setNoticeContent("7월17일 제헌절은 정상 운영하며 일요일은 정기휴일입니다.");
        noticeDTO.setNoticePasswd("1234");

        int result = noticeMapper.noticeInsert(noticeDTO);
        log.info("등록 결과: {} (1: 등록 완료, 0: 등록 실패", result);
        log.info("게시글 번호: {}", noticeDTO.getNoticeNumber());
    }

    @Test
    public void readcntUpdateTest() {
        int noticeNumber = 1;
        int count = noticeMapper.readcntUpdate(noticeNumber);
        log.info("수정된 행의 수: {}", count);
    }

    @Test
    public void noticeDetailTest() {
        int noticeNumber = 1;
        noticeMapper.noticeDetail(noticeNumber);
        Optional<NoticeDTO> optionalNotice = noticeMapper.noticeDetail(noticeNumber);
        log.info("데이터 존재 여부: {}", optionalNotice.isPresent());
        optionalNotice.ifPresent(noticeDTO -> log.info("데이터 조회: {}", noticeDTO));
    }

    @Test
    public void noticeUpdateTest() {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeNumber(1);
        noticeDTO.setNoticeTitle("진료 안내");
        noticeDTO.setNoticeContent("test");
        int result = noticeMapper.noticeUpdate(noticeDTO);

        log.info("게시판 수정된 행의 수: {}", result);
    }

    @Test
    public void noticeDeleteTest() {
        int noticeNumber = 1;
        int result = noticeMapper.noticeDelete(noticeNumber);
        log.info("삭제된 행의 수: {}", result);
    }

    @Test
    public void passwordConfirmTest() {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeNumber(1);
        noticeDTO.setNoticePasswd("4321");

        boolean result = noticeMapper.passwordConfirm(noticeDTO) == 1;
        log.info("비밀번호 일치 여부: {}", result ? "일치" : "불일치");
    }
}
