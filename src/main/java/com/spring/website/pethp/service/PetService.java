package com.spring.website.pethp.service;


import com.spring.website.pethp.dto.QnADTO;

import java.util.List;

public interface PetService {
    List<QnADTO> qnaList();
    int qnaInsert(QnADTO qnaDTO);
    QnADTO qnaDetail(int qnaNumber);
    QnADTO qnaUpdateForm(int qnaNumber);
}
