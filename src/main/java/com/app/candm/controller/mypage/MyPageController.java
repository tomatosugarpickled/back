package com.app.candm.controller.mypage;

import com.app.candm.dto.member.MemberDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/**")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {

//    마이페이지 이동, 이동 시 로그인 정보가 없으면 로그인 페이지로 이동
    @GetMapping("")
    public String gotoMyPage(HttpSession session, Model model){
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if(memberDTO == null){
            return "redirect:/member/login";
        }
        model.addAttribute("member", memberDTO);
        model.addAttribute("isOwner", true);
        return "mypage/mypage";



    }
}
