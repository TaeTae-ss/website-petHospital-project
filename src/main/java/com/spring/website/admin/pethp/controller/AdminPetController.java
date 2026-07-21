package com.spring.website.admin.pethp.controller;

import com.spring.website.pethp.dto.RegisterDTO;
import com.spring.website.pethp.service.RegisterService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminPetController {
    private final RegisterService registerService;

    @GetMapping("/")
    public String main() {
        return "client/main";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "client/register";
    }

    @PostMapping("/register")
    public String registerInsert(
            @ModelAttribute RegisterDTO registerDTO,
            Model model
    ) {
        int idCount =
                registerService.registerIdCheck(
                        registerDTO.getRegisterId()
                );

        if (idCount > 0) {
            model.addAttribute(
                    "errorMessage",
                    "이미 사용 중인 아이디입니다."
            );

            return "client/register";
        }

        int emailCount =
                registerService.registerEmailCheck(
                        registerDTO.getRegisterEmail()
                );

        if (emailCount > 0) {
            model.addAttribute(
                    "errorMessage",
                    "이미 사용 중인 이메일입니다."
            );

            return "client/register";
        }

        int result =
                registerService.registerInsert(registerDTO);

        if (result == 1) {
            return "redirect:/";
        }

        model.addAttribute(
                "errorMessage",
                "회원가입에 실패했습니다."
        );

        return "client/register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "client/login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute RegisterDTO registerDTO,
            HttpSession session,
            Model model
    ) {
        RegisterDTO loginMember =
                registerService.registerLogin(registerDTO);

        if (loginMember == null) {
            model.addAttribute(
                    "errorMessage",
                    "아이디 또는 비밀번호가 일치하지 않습니다."
            );

            return "client/login";
        }

        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session) {
        RegisterDTO loginMember =
                (RegisterDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/login";
        }

        return "client/mypage";
    }

    @PostMapping("/mypage/update")
    public String mypageUpdate(
            @ModelAttribute RegisterDTO registerDTO,
            @RequestParam String currentPassword,
            HttpSession session,
            Model model
    ) {
        RegisterDTO loginMember =
                (RegisterDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/login";
        }

        int passwordCount =
                registerService.registerPasswordCheck(
                        loginMember.getRegisterNo(),
                        currentPassword
                );

        if (passwordCount == 0) {
            model.addAttribute(
                    "errorMessage",
                    "현재 비밀번호가 일치하지 않습니다."
            );

            return "client/mypage";
        }

        // 이메일이 변경된 경우에만 중복 검사
        if (!loginMember.getRegisterEmail()
                .equals(registerDTO.getRegisterEmail())) {

            int emailCount =
                    registerService.registerEmailCheck(
                            registerDTO.getRegisterEmail()
                    );

            if (emailCount > 0) {
                model.addAttribute(
                        "errorMessage",
                        "이미 사용 중인 이메일입니다."
                );

                return "client/mypage";
            }
        }

        registerDTO.setRegisterNo(
                loginMember.getRegisterNo()
        );

        int result =
                registerService.registerUpdate(registerDTO);

        if (result == 0) {
            model.addAttribute(
                    "errorMessage",
                    "회원정보 수정에 실패했습니다."
            );

            return "client/mypage";
        }

        RegisterDTO updatedMember =
                registerService.registerDetail(
                        loginMember.getRegisterNo()
                );

        session.setAttribute(
                "loginMember",
                updatedMember
        );

        return "redirect:/mypage";
    }
}
