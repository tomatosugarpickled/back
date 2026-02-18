package com.app.candm.controller.team;

import com.app.candm.dto.TeamDTO;
import com.app.candm.service.team.TeamRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/team/*")
@RequiredArgsConstructor
@Slf4j
public class TeamController {
    private final TeamRegistrationService teamRegistrationService;

    // 팀 등록 페이지로 이동
    @GetMapping("register")
    public String goToRegisterForm(TeamDTO teamDTO) {
        return "team/register";
    }

    // 팀 등록 실행
    @PostMapping("register")
    public RedirectView register(TeamDTO teamDTO) {
        log.info("Registering team: {}", teamDTO);

        // 서비스 내 중복검사 로직이 포함된 메서드 호출
        teamRegistrationService.registerTeamCheck(teamDTO);

        return new RedirectView("/team/team-detail"); // 팀상세 페이지로 이동
    }

    // 팀명 중복 검사
    @GetMapping("check-title")
    @ResponseBody
    public ResponseEntity<Boolean> checkTitle(@RequestParam String teamTitle) {
        // 존재하지 않으면 true (사용 가능)
        return ResponseEntity.ok(teamRegistrationService.checkTeamTitle(teamTitle));
    }

    // 팀 URL 중복 검사
    @GetMapping("check-url")
    @ResponseBody
    public ResponseEntity<Boolean> checkUrl(@RequestParam String teamUrl) {
        // 존재하지 않으면 true (사용 가능)
        return ResponseEntity.ok(teamRegistrationService.checkTeamUrl(teamUrl));
    }
}