package com.spring.website.pethp.mapper;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class PetMapperTests {
}
