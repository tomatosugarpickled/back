package com.app.candm.controller.member;

import com.app.candm.dto.member.MemberDTO;
import com.app.candm.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/member/**")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
//    session 서버에 저장
    private final HttpSession session;

//    회원가입 페이지 이동
    @GetMapping("join")
    public String goToJoinForm(){
        return "member/join";
    }
//    회원가입
    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }
//    이메일 체크
    @GetMapping("check-email")
    @ResponseBody
    public boolean checkEamil(String memberEmail){
        return memberService.checkEmail(memberEmail);
    }

//    로그인 화면으로 이동
    @GetMapping("login")
    public String goToLoginForm(
            @CookieValue(name = "remember",required = false) boolean remember,
            HttpServletRequest request,
            Model model)
    {
        model.addAttribute("remember", remember);
        return "member/login";
    }

//    로그인 검사
    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, Model model, HttpServletResponse response){
        session.setAttribute("member",memberService.login(memberDTO));
        Cookie rememberCookie = new Cookie("remember", String.valueOf(memberDTO.isRemember()));

        rememberCookie.setPath("/");

        if(memberDTO.isRemember()){
            rememberCookie.setMaxAge(60 * 60 * 24 * 30); // 30일 유지
        }
        else {
            rememberCookie.setMaxAge(0);
        }

        response.addCookie(rememberCookie);

        return new RedirectView("/main/main");
    }
}
