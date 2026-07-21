package com.spring.website.pethp.mapper;

import com.spring.website.pethp.dto.QnADTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QnAMapper {
    List<QnADTO> qnaList();

    int qnaInsert(QnADTO qnaDTO);
    int readCntUpdate(@Param("qnaNumber")int qnaNumber);
    Optional<QnADTO> qnaDetail(@Param("qnaNumber") int qnaNumber);
    int qnaDelete(@Param("qnaNumber")int qnaNumber);
}
