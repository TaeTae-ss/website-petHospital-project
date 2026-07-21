package com.spring.website.client.pethp.controller;
import com.spring.website.pethp.dto.FreeBoardDTO;
import com.spring.website.pethp.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pethp")
@RequiredArgsConstructor
public class FreeBoardController {
    private final FreeBoardService freeBoardService;

    @GetMapping("/list")

    public String boardList(Model model){
        List<FreeBoardDTO> list = freeBoardService.selectFrBoardList();
        model.addAttribute("boardList",list);
        return "client/pethp/list";
    }

    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("board", new FreeBoardDTO());
        return "client/pethp/write";
    }
    @PostMapping("/write")
    public String boardInsert(FreeBoardDTO freeBoardDTO) {
        freeBoardService.insertBoard(freeBoardDTO);

        return "redirect:/pethp/list";
    }
    @GetMapping("/detail/{regNum}")
    public String detail(@PathVariable("regNum") Long regNum, Model model) {
         freeBoardService.increaseViewCnt(regNum);

        FreeBoardDTO detail = freeBoardService.selectDetail(regNum);
        model.addAttribute("board", detail);

        return "client/pethp/detail";
    }

    @PostMapping("/delete/{regNum}")
    public String deleteBoard(@PathVariable("regNum") Long regNum){
        freeBoardService.deleteBoard(regNum);

        // redirect 뒤에 : 가 있어야 경로 이동이 됩니다.
        return "redirect:/pethp/list";
    }

    @GetMapping("/update/{regNum}")
    public String modifyForm(@PathVariable("regNum") Long regNum, Model model) {
        FreeBoardDTO board = freeBoardService.selectDetail(regNum);
        model.addAttribute("board", board);
        return "client/pethp/update";
    }

    @PostMapping("/update")
    public String modifyBoard(FreeBoardDTO freeBoardDTO) {
        freeBoardService.updateBoard(freeBoardDTO);
        return "redirect:/pethp/detail/" + freeBoardDTO.getRegNum();
    }




}
