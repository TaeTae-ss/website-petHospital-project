package com.spring.website.pethp.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.spring.website.pethp.dto.FreeBoardDTO;
@Mapper
public interface FreeBoardMapper {
    List<FreeBoardDTO> selectFrBoardList();
    FreeBoardDTO selectDetail(Long regNum);
    int insertBoard(FreeBoardDTO freeBoardDTO);
    void deleteBoard(Long regNum);
    void updateBoard(FreeBoardDTO dto);
    void increaseViewCnt(Long regNum);
}
