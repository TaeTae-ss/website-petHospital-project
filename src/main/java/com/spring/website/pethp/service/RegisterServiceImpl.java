package com.spring.website.pethp.service;

import com.spring.website.pethp.dto.RegisterDTO;
import com.spring.website.pethp.mapper.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterMapper registerMapper;

    @Override
    public int registerInsert(RegisterDTO registerDTO) {
        return registerMapper.registerInsert(registerDTO);
    }

    @Override
    public int registerIdCheck(String registerId) {
        return registerMapper.registerIdCheck(registerId);
    }

    @Override
    public int registerEmailCheck(String registerEmail) {
        return registerMapper.registerEmailCheck(registerEmail);
    }

    @Override
    public RegisterDTO registerLogin(RegisterDTO registerDTO) {
        return registerMapper.registerLogin(registerDTO);
    }

    @Override
    public int registerPasswordCheck(
            int registerNo,
            String currentPassword
    ) {
        return registerMapper.registerPasswordCheck(
                registerNo,
                currentPassword
        );
    }

    @Override
    public int registerUpdate(RegisterDTO registerDTO) {
        return registerMapper.registerUpdate(registerDTO);
    }

    @Override
    public RegisterDTO registerDetail(int registerNo) {
        return registerMapper.registerDetail(registerNo);
    }
}