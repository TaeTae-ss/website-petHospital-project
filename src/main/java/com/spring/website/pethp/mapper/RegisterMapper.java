package com.spring.website.pethp.mapper;

import com.spring.website.pethp.dto.RegisterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterMapper {

    int registerInsert(RegisterDTO registerDTO);

    int registerIdCheck(
            @Param("registerId") String registerId
    );

    int registerEmailCheck(
            @Param("registerEmail") String registerEmail
    );

    RegisterDTO registerLogin(RegisterDTO registerDTO);

    int registerPasswordCheck(
            @Param("registerNo") int registerNo,
            @Param("currentPassword") String currentPassword
    );

    int registerUpdate(RegisterDTO registerDTO);

    RegisterDTO registerDetail(
            @Param("registerNo") int registerNo
    );
}