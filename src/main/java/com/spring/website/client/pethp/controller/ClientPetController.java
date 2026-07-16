package com.spring.website.client.pethp.controller;

import com.spring.website.pethp.dto.QnADTO;
import com.spring.website.pethp.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pethp")
@RequiredArgsConstructor
public class ClientPetController {
    private final PetService petService;

    @GetMapping("/qna")
    public String qnaList(Model model){
        List<QnADTO> list = petService.qnaList();
        model.addAttribute("qnaList", list);
        return "client/pethp/qna";
    }
    @GetMapping("/qna-write")
    public String qnaWriteForm(Model model){
        model.addAttribute("qna" ,new QnADTO());
        return "client/pethp/qnaWrite";
    }

    @PostMapping("/qna-write")
    public String qnaInsertForm(QnADTO qnaDTO){
        petService.qnaInsert(qnaDTO);
        return "redirect:/pethp/qna";
    }

    @GetMapping("/qna/{qnaNumber}")
    public String qnaDetail(@PathVariable int qnaNumber, Model model){
        QnADTO qnaDTO = petService.qnaDetail(qnaNumber);
        model.addAttribute("qna", qnaDTO);
        return "client/pethp/qnaDetail";
    }

    @GetMapping("/qna/{qnaNumber}/update")
    public String qnaUpdateForm(@PathVariable int qnaNumber, Model model){
        QnADTO qnaDTO = petService.qnaUpdateForm(qnaNumber);
        model.addAttribute("qna", qnaDTO);
        return "client/pethp/qnaUpdate";
    }

}