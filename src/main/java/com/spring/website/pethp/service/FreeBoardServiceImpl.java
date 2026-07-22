package com.spring.website.pethp.service;

import com.spring.website.pethp.dto.FreeBoardDTO;
import com.spring.website.pethp.mapper.FreeBoardMapper; // 패키지 경로에 맞게 확인 필요
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService {

    private final FreeBoardMapper freeBoardMapper;

    @Override
    public List<FreeBoardDTO> selectFrBoardList() {
        return freeBoardMapper.selectFrBoardList();
    }

    @Override
    public FreeBoardDTO selectDetail(Long regNum) {
        return freeBoardMapper.selectDetail(regNum);
    }
    @Override
    public  int insertBoard(FreeBoardDTO freeBoardDTO){
        return freeBoardMapper.insertBoard(freeBoardDTO);
    }
    @Override
    public void deleteBoard(Long regNum){
        freeBoardMapper.deleteBoard(regNum);
    }

    @Override
    public void updateBoard(FreeBoardDTO dto){
        // 1. 수정하기 전에 DB에서 원본 정보를 먼저 조회합니다.
        FreeBoardDTO existing = freeBoardMapper.selectDetail(dto.getRegNum());

        // 2. 화면에서 넘어온 비밀번호(dto.getPwd())가 비어있으면,
        //    조회해온 기존 비밀번호(existing.getPwd())를 넣어줍니다.
        if (dto.getPPwd() == null || dto.getPPwd().trim().isEmpty()) {
            dto.setPPwd(existing.getPPwd());
        }
        // 3. 이제 비밀번호가 채워진(혹은 기존 값이 유지된) DTO로 업데이트를 실행합니다.
        freeBoardMapper.updateBoard(dto);
    }
    @Override
    public void increaseViewCnt(Long regNum) {
        freeBoardMapper.increaseViewCnt(regNum);
    }
}