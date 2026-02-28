package com.app.candm.controller.oauth;

import com.app.candm.dto.member.MemberDTO;
import com.app.candm.service.member.MemberService;
import com.app.candm.service.oauth.KakaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/kakao/login")
    public RedirectView kakaoLogin(String code, HttpServletResponse response, RedirectAttributes redirectAttributes){
        MemberDTO memberDTO = kakaoService.kakaoLogin(code);
        String path = null;

        if(memberDTO.getId() == null){
            redirectAttributes.addFlashAttribute("kakao", memberDTO);
            path = "/member/kakao-join";
        }else {
            session.setAttribute("member", memberDTO);
            path = "/main";
        }

        return new RedirectView(path);
    }

}
