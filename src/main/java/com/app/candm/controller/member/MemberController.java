package com.app.candm.controller.member;

import com.app.candm.dto.member.MemberDTO;
import com.app.candm.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/member/**")
@RequiredArgsConstructor
@Slf4j
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
    public String goToLoginForm()
    {
        return "member/login";
    }

//    로그인 검사
    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO){
        session.setAttribute("member",memberService.login(memberDTO));
        log.info(session.toString());
        return new RedirectView("/mypage");
    }

//    카카오 추가정보 입력으로 읻오
    @GetMapping("kakao-join")
    public String GotoKakaoJoinForm(){
        return "/member/kakao-join";
    }

    @PostMapping("kakao-join")
    public RedirectView kakaoJoin(MemberDTO memberDTO){
        memberService.kakaoJoin(memberDTO);
        return new RedirectView("/mypage");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(){
        log.info("{들어옴}");
        log.info(session.toString());
        session.invalidate();
        return new RedirectView("/member/login");
    }

}
