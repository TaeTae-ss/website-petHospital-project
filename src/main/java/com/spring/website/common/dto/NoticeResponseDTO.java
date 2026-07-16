package com.spring.website.common.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class NoticeResponseDTO<E> {
    private final List<E> list;
    private final NoticeRequestDTO noticeRequestDTO;

    private final int startPage;
    private final int endPage;

    private final boolean previous;
    private final boolean next;

    private final int totalCount;
    private final int totalPage;

    public NoticeResponseDTO(List<E> list, NoticeRequestDTO noticeRequestDTO, int totalCount) {
        this.list = list;
        this.noticeRequestDTO = noticeRequestDTO;
        this.totalCount = totalCount;

        int navigateSize = 10;

        int tempEnd = (int) (Math.ceil(noticeRequestDTO.getPage() / (double) navigateSize)) * navigateSize;

        this.startPage = tempEnd - navigateSize + 1;

        this.totalPage = (int) Math.ceil((double) totalCount / noticeRequestDTO.getSize());

        int realEnd = (totalPage == 0) ? 1 : totalPage;
        this.endPage = Math.min(tempEnd, realEnd);

        this.previous = this.startPage > 1;
        this.next =this.endPage < totalPage;
    }
}
