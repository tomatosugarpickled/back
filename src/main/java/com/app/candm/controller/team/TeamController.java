package com.app.candm.controller.team;

import com.app.candm.dto.TeamDTO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.service.team.TeamRegistrationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
@Slf4j
public class TeamController {

    private final TeamRegistrationService teamRegistrationService;


    // 팀 등록
    @GetMapping("/team-regist")
    public String goToRegisterForm(@RequestParam("memberId") Long memberId, Model model) {
        TeamDTO dto = new TeamDTO();
        dto.setMemberId(memberId);
        model.addAttribute("teamDTO", dto);
        log.info("teamDTO = {}.................", dto);

        return "/team/team-regist/team-regist";

    }
    @PostMapping("/team-regist")
    public String register(TeamDTO teamDTO, RedirectAttributes redirectAttributes) {
        teamRegistrationService.registerTeam(teamDTO);
        redirectAttributes.addAttribute("memberId", teamDTO.getMemberId());

        return "redirect:/team/team-regist/team-regist";
    }

    // 3. 팀 목록 페이지
    @GetMapping("/team-list")
    public String showTeamList(@RequestParam(value = "memberId", required = false) Long memberId, HttpSession session, Model model) {
        if (memberId == null) {
            MemberDTO member = (MemberDTO) session.getAttribute("member");
            if (member != null) memberId = member.getId();
        }
        List<TeamDTO> teams = memberId != null ? teamRegistrationService.getListByMember(memberId) : List.of();
        model.addAttribute("teams", teams);
        model.addAttribute("memberId", memberId);
        return "/team/team-list/team-list";
    }


    // ////////////////////////////////////////////////////////////////////////
    // 팀명 중복 검사
//    @GetMapping(value = "/team-regist/check-title")
//    @ResponseBody
//    public boolean checkTitle(@RequestParam String teamTitle) {
//        return teamRegistrationService.checkTeamTitle(teamTitle);
//    }


    // 팀 URL 중복 검사
//    @GetMapping(value = "/team-regist/check-url")
//    @ResponseBody
//    public boolean checkUrl(@RequestParam String teamUrl) {
//        return teamRegistrationService.checkTeamUrl(teamUrl);
//    }
}