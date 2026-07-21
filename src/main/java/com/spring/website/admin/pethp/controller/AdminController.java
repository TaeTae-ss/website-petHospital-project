package com.spring.website.admin.pethp.controller;

import com.spring.website.common.dto.NoticeRequestDTO;
import com.spring.website.common.dto.NoticeResponseDTO;
import com.spring.website.pethp.dto.NoticeDTO;
import com.spring.website.pethp.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pethp/notice")
@RequiredArgsConstructor
public class AdminController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    /*public String noticeList(Model model) {
        List<NoticeDTO> list = noticeService.noticeList();
        model.addAttribute("noticeList", list);
        return "client/pethp/notice/list";
    }*/
    public String noticeList(NoticeRequestDTO noticeRequestDTO,Model model) {
        NoticeResponseDTO<NoticeDTO> noticeResponse = noticeService.selectNoticeList(noticeRequestDTO);
        model.addAttribute("noticeResponse", noticeResponse);
        return "client/pethp/notice/list";
    }


    @GetMapping("/write")
    public String noticeWrite(Model model) {
        NoticeDTO noticeDTO = new NoticeDTO();
        model.addAttribute("notice", noticeDTO);
        return "client/pethp/notice/write";
    }

    @PostMapping("/write")
    public String noticeInsert(NoticeDTO noticeDTO) {
        noticeService.noticeInsert(noticeDTO);
        return "redirect:/pethp/notice/list";
    }

    @GetMapping("/{noticeNumber}")
    public String noticeDetail(@PathVariable int noticeNumber, Model model) {
        NoticeDTO noticeDTO = noticeService.noticeDetail(noticeNumber);
        model.addAttribute("notice", noticeDTO);
        return "client/pethp/notice/detail";
    }

    @GetMapping("/{noticeNumber}/update")
    public String updateForm(@PathVariable("noticeNumber") int noticeNumber, Model model) {
        NoticeDTO noticeDTO = noticeService.updateForm(noticeNumber);
        model.addAttribute("notice", noticeDTO);
        return "client/pethp/notice/update";
    }

    @PostMapping("/update")
    public String noticeUpdate(NoticeDTO noticeDTO) {
        System.out.println("noticeNumber = " + noticeDTO.getNoticeNumber());
        System.out.println("noticeTitle = " + noticeDTO.getNoticeTitle());
        System.out.println("noticeContent = " + noticeDTO.getNoticeContent());
        System.out.println("noticePasswd = " + noticeDTO.getNoticePasswd());

        noticeService.noticeUpdate(noticeDTO);
        return "redirect:/pethp/notice/" + noticeDTO.getNoticeNumber();
    }

    @PostMapping("/delete")
    public String noticeDelete(int noticeNumber) {
        noticeService.noticeDelete(noticeNumber);
        return "redirect:/pethp/notice/list";
    }

    @PostMapping("/password-confirm")
    @ResponseBody
    public boolean passwordConfirm(NoticeDTO noticeDTO) {
        return noticeService.passwordConfirm(noticeDTO);
    }
}
