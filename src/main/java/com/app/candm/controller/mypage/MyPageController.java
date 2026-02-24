package com.app.candm.controller.mypage;

import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.*;
import com.app.candm.service.mypage.MyPageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/**")
@Slf4j
public class MyPageController {

    private final MyPageService myPageService;

    //    마이페이지 이동, 이동 시 로그인 정보가 없으면 로그인 페이지로 이동
    @GetMapping("")
    public String gotoMyPage(HttpSession session, Model model){
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        if(memberDTO == null){
            return "redirect:/member/login";
        }
        model.addAttribute("member", memberDTO);
        model.addAttribute("isOwner", true);
        return "/mypage/mypage";
    }

//===================================================경력====================================================================
    @PostMapping("career/regist")
    @ResponseBody
    public void careerRegist(@RequestBody  MemberCareerDTO memberCareerDTO){

        String startDate = memberCareerDTO.getStartYear() + "-" + memberCareerDTO.getStartMonth();
        String endDate = memberCareerDTO.getEndYear() + "-" + memberCareerDTO.getEndMonth();

        memberCareerDTO.setStartDate(startDate);
        memberCareerDTO.setEndDate(endDate);

        log.info("memberCareerDTO : {}",memberCareerDTO.getMemberId());
        myPageService.regist(memberCareerDTO);
    }

    @GetMapping("career/{memberId}")
    @ResponseBody
    public MemberWithCareerDTO careerList(@PathVariable Long memberId){
        return myPageService.getCareerByMemberId(memberId);
    }

    @DeleteMapping("{id}")
    public void deleteCareer(@PathVariable Long id){
        myPageService.delete(id);
    }
//=================================================학력=================================================================
    @PostMapping("education/regist")
    @ResponseBody
    public void educationRegist(@RequestBody MemberEducationDTO memberEducationDTO){

        String startDate = memberEducationDTO.getStartYear() + "-" + memberEducationDTO.getStartMonth();
        String endDate = memberEducationDTO.getEndYear() + "-" + memberEducationDTO.getEndMonth();

        memberEducationDTO.setStartDate(startDate);
        memberEducationDTO.setEndDate(endDate);

        log.info("memberEducationDTO : {}",memberEducationDTO);
        myPageService.regist(memberEducationDTO);
    }

    @GetMapping("education/{memberId}")
    @ResponseBody
    public MemberWithEducationDTO educationList(@PathVariable Long memberId){
        return myPageService.getEducationByMemberId(memberId);
    }

    @DeleteMapping("education/{id}")
    public void deleteEducation(@PathVariable Long id){
        myPageService.deleteEducation(id);
    }

//    ================================================활동====================================================
    @PostMapping("activity/regist")
    @ResponseBody
    public void activityRegist(MemberActivityDTO memberActivityDTO, @RequestParam(value = "file", required = false) ArrayList<MultipartFile> multipartFiles){
        String startDate = memberActivityDTO.getStartYear() + "-" + memberActivityDTO.getStartMonth();
        String endDate = memberActivityDTO.getEndYear() + "-" + memberActivityDTO.getEndMonth();

        memberActivityDTO.setStartDate(startDate);
        memberActivityDTO.setEndDate(endDate);

        log.info("memberEducationDTO : {}",memberActivityDTO);
        log.info("multipartFiles : {}",multipartFiles != null ? multipartFiles.size() : 0);

        myPageService.regist(memberActivityDTO, multipartFiles);
    }
}
