package com.spring.website.pethp.service;

import com.spring.website.pethp.dto.QnADTO;
import com.spring.website.pethp.mapper.QnAMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final QnAMapper qnaMapper;

    @Override
    public List<QnADTO> qnaList() {
        return qnaMapper.qnaList();
    }

    @Override
    public int qnaInsert(QnADTO qnaDTO){
        return qnaMapper.qnaInsert(qnaDTO);
    }

    @Override
    public QnADTO qnaDetail(int qnaNumber){
        qnaMapper.readCntUpdate(qnaNumber);

        return qnaMapper.qnaDetail(qnaNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }
    @Override
    public QnADTO qnaUpdateForm(int qnaNumber){
        return qnaMapper.qnaDetail(qnaNumber)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

}
