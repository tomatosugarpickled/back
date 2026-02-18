package com.app.candm.controller.funding;

import com.app.candm.domain.FundingRegistVO;
import com.app.candm.dto.TeamDTO;
import com.app.candm.dto.funding.FundingRegistDTO;
import com.app.candm.repository.funding.FundingRegistDAO;
import com.app.candm.service.funding.FundingRegistService;
import com.app.candm.service.team.TeamRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/funding/*")
@RequiredArgsConstructor
@Slf4j
public class FundingRegistController {
    private final TeamRegistrationService teamRegistrationService;
    private final FundingRegistService fundingRegistService;
    private final FundingRegistDAO fundingRegistDAO;
    private Object fundingRegistVO;

    // 펀딩 등록 폼 이동 (특정 팀이 펀딩을 생성하므로 teamId를 받음)
    @GetMapping("funding-regist")
    public String goToRegisterForm(@RequestParam("teamId") Long teamId, Model model) {
        FundingRegistDTO fundingRegistDTO = new FundingRegistDTO();
        fundingRegistDTO.setTeamId(teamId);
        model.addAttribute("fundingRegistDTO", fundingRegistDTO);
        return "funding/funding-regist"; // templates/funding/funding-regist.html
    }

    // 펀딩 등록 처리
    @PostMapping("funding-regist")
    public RedirectView register(FundingRegistDTO fundingRegistDTO) {
        log.info("Funding registration request: {}", fundingRegistDTO);
        fundingRegistService.register(fundingRegistDTO);

        // 등록 후 해당 팀의 펀딩 목록 페이지로 이동
        return new RedirectView("/funding/funding-list?teamId=" + fundingRegistDTO.getTeamId());
    }

    // 팀별 펀딩 목록 조회
    @GetMapping("list")
    public void showTeamFundingList(@RequestParam("teamId") Long teamId, Model model) {
        List<FundingRegistDTO> fundingList = fundingRegistService.getListByTeam(teamId);
        model.addAttribute("fundings", fundingList);
        model.addAttribute("teamId", teamId);
    }

    // 펀딩 목록 페이지
    @GetMapping("funding-list")
    public void showFundingList(@RequestParam("id") Long id, Model model) {
        FundingRegistVO fundingVO = fundingRegistService.getFunding(id);
        model.addAttribute("funding", fundingRegistVO);
    }
}
