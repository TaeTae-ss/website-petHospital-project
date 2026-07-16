package com.spring.website.pethp.mapper;

import com.spring.website.pethp.dto.QnADTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class PetMapperTests {
    @Autowired
    private  QnAMapper qnamapper;

    @Test
    public void qnaListTest(){
        qnamapper.qnaList().forEach(qnaDTO->log.info(qnaDTO.toString()));
    }
    @Test
    public void qnaInsertTest(){
        QnADTO qnaDTO = new QnADTO();
        qnaDTO.setQnaCategory("기타문의");
        qnaDTO.setQnaName("이남준");
        qnaDTO.setQnaTitle("진료시간");
        qnaDTO.setQnaContent("야간진료가능?");
        qnaDTO.setQnaPassword("1234");

        int count = qnamapper.qnaInsert(qnaDTO);
        log.info("입력된 행의 수:{}", count);

    }
}

