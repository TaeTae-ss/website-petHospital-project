package com.spring.website.pethp.service;

import com.spring.website.pethp.dto.RegisterDTO;

public interface RegisterService {

    int registerInsert(RegisterDTO registerDTO);

    int registerIdCheck(String registerId);

    int registerEmailCheck(String registerEmail);

    RegisterDTO registerLogin(RegisterDTO registerDTO);

    int registerPasswordCheck(
            int registerNo,
            String currentPassword
    );

    int registerUpdate(RegisterDTO registerDTO);

    RegisterDTO registerDetail(int registerNo);
}