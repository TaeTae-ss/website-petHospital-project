package com.spring.website.admin.pethp.controller;

import com.spring.website.pethp.dto.RegisterDTO;
import com.spring.website.pethp.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminPetController {
    private final RegisterService registerService;

    @GetMapping("/register")
    public String registerForm() {
        return "client/register";
    }

    @PostMapping("/register")
    public String registerInsert(@ModelAttribute RegisterDTO registerDTO) {
        int result = registerService.registerInsert(registerDTO);

        if (result == 1) {
            return "redirect:/";
        }

        return "client/register";
    }
}
