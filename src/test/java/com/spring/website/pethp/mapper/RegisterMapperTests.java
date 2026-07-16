package com.spring.website.pethp.mapper;

import com.spring.website.pethp.dto.RegisterDTO;
import com.spring.website.pethp.mapper.RegisterMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
public class RegisterMapperTests {

    @Autowired
    private RegisterMapper registerMapper;

    @Test
    public void registerInsertTest() {

        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setRegisterId("user01");
        registerDTO.setRegisterPassword("1234");
        registerDTO.setRegisterName("홍길동");
        registerDTO.setRegisterEmail("user01@test.com");
        registerDTO.setRegisterPhone("010-1234-5678");

        int result =
                registerMapper.registerInsert(registerDTO);

        log.info("회원가입 결과: {}", result);

        assertEquals(1, result);
    }

    @Test
    public void registerIdCheckTest() {
        String registerId = "user01";

        int result =
                registerMapper.registerIdCheck(registerId);

        log.info("아이디 중복 개수: {}", result);
    }

    @Test
    public void registerEmailCheckTest() {

        String registerEmail = "unknown@naver.com";

        int result =
                registerMapper.registerEmailCheck(registerEmail);

        log.info("이메일 중복 개수: {}", result);
    }

    @Test
    void registerLoginTest() {
        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setRegisterId("peace");
        registerDTO.setRegisterPassword("12345");

        RegisterDTO loginMember =
                registerMapper.registerLogin(registerDTO);

        log.info("로그인 회원 정보: {}", loginMember);
    }
}