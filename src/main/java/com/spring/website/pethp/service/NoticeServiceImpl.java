package com.spring.website.pethp.service;

import com.spring.website.common.dto.NoticeRequestDTO;
import com.spring.website.common.dto.NoticeResponseDTO;
import com.spring.website.pethp.dto.NoticeDTO;
import com.spring.website.pethp.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Override
    public List<NoticeDTO> noticeList() {
        return noticeMapper.noticeList();
    }

    @Override
    public NoticeResponseDTO<NoticeDTO> selectNoticeList(NoticeRequestDTO noticeRequestDTO) {
        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(noticeRequestDTO);
        int totalCount = noticeMapper.selectNoticeCount(noticeRequestDTO);
        return new NoticeResponseDTO<>(noticeList, noticeRequestDTO, totalCount);
    }

    @Override
    public int noticeInsert(NoticeDTO noticeDTO) {
        return noticeMapper.noticeInsert(noticeDTO);
    }

    @Override
    public NoticeDTO noticeDetail(int noticeNumber) {
        noticeMapper.readcntUpdate(noticeNumber);

        return noticeMapper.noticeDetail(noticeNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    @Override
    public NoticeDTO updateForm(int noticeNumber) {
        return noticeMapper.noticeDetail(noticeNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

    }

    @Override
    public int noticeUpdate(NoticeDTO noticeDTO) {
        int result = noticeMapper.noticeUpdate(noticeDTO);
        if (result == 0) {
            throw new IllegalArgumentException("게시글 수정에 실패했습니다.");
        }
        return result;
    }

    @Override
    public int noticeDelete(int noticeNumber) {
        return noticeMapper.noticeDelete(noticeNumber);
    }

    @Override
    public boolean passwordConfirm(NoticeDTO noticeDTO) {
        return noticeMapper.passwordConfirm(noticeDTO) == 1;
    }
}
