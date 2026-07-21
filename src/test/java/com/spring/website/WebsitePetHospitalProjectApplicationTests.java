package com.spring.website;

import com.spring.website.pethp.mapper.FreeBoardMapper;
import com.spring.website.pethp.service.FreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.spring.website.pethp.dto.FreeBoardDTO;
import java.util.List;
@Slf4j

@SpringBootTest
class WebsitePetHospitalProjectApplicationTests {
	@Autowired
	private FreeBoardService freeBoardService;

	@Test
	void 게시판_리스트_조회_테스트() {
		List<FreeBoardDTO> list = freeBoardService.selectFrBoardList();
		System.out.println("조회된 데이터 개수: " + list.size());
	}
	@Test
	public void bdInsertTest(){
		FreeBoardDTO bdDTo = new FreeBoardDTO();
		bdDTo.setPName("애옹이");
		bdDTo.setPGuardian("일호");
		bdDTo.setTitle("애옹이가 아파요");
		bdDTo.setPContent("애옹이");
		bdDTo.setPPwd("1234");
		int cnt = freeBoardService.insertBoard(bdDTo);
		log.info("입력 행 수 : {}" , cnt);
	}
	@Test
	public void deleteTest() {
		long bdN = 21;

		freeBoardService.deleteBoard(bdN);

		log.info("삭제 완료 테스트 실행됨");
	}


}
