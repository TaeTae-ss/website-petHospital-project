package com.spring.website.pethp.service;
import com.spring.website.pethp.dto.FreeBoardDTO;
import java.util.List;
public interface FreeBoardService {

    List<FreeBoardDTO> selectFrBoardList();
    FreeBoardDTO selectDetail(Long regNum);
    int insertBoard(FreeBoardDTO freeBoardDTO);
    void deleteBoard(Long regNum);
    void updateBoard(FreeBoardDTO dto);
    void increaseViewCnt(Long regNum);
}
