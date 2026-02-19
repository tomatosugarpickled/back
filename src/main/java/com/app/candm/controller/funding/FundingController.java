package com.app.candm.controller.funding;

import com.app.candm.domain.FundingVO;
import com.app.candm.dto.funding.FundingDTO;
import com.app.candm.repository.funding.FundingDAO;
import com.app.candm.service.funding.FundingService;
import com.app.candm.service.team.TeamRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/funding/*")
@RequiredArgsConstructor
@Slf4j
public class FundingController {
    private final TeamRegistrationService teamRegistrationService;
    private final FundingService fundingService;
    private final FundingDAO fundingDAO;
    private Object fundingRegistVO;

    // 펀딩 등록 폼 이동 (특정 팀이 펀딩을 생성하므로 teamId를 받음)
    @GetMapping("funding-regist")
    public String goToRegisterForm(@RequestParam("teamId") Long teamId, Model model) {
        FundingDTO fundingDTO = new FundingDTO();
        fundingDTO.setTeamId(teamId);
        model.addAttribute("fundingRegistDTO", fundingDTO);
        return "funding/funding-regist"; // templates/funding/funding-regist.html
    }

    // 펀딩 등록 처리
    @PostMapping("funding-regist")
    public RedirectView register(FundingDTO fundingDTO) {
        log.info("Funding registration request: {}", fundingDTO);
        fundingService.register(fundingDTO);

        // 등록 후 해당 팀의 펀딩 목록 페이지로 이동
        return new RedirectView("/funding/funding-list?teamId=" + fundingDTO.getTeamId());
    }

    // 팀별 펀딩 목록 조회
    @GetMapping("list")
    public void showTeamFundingList(@RequestParam("teamId") Long teamId, Model model) {
        List<FundingDTO> fundingList = fundingService.getListByTeam(teamId);
        model.addAttribute("fundings", fundingList);
        model.addAttribute("teamId", teamId);
    }

    // 펀딩 목록 페이지
    @GetMapping("funding-list")
    public void showFundingList(@RequestParam("id") Long id, Model model) {
        FundingVO fundingVO = fundingService.getFunding(id);
        model.addAttribute("funding", fundingVO);
    }
}
