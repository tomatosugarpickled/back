package com.app.candm.controller.funding;

import com.app.candm.domain.FundingVO;
import com.app.candm.dto.funding.FundingDTO;
import com.app.candm.service.funding.FundingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/funding")
@RequiredArgsConstructor
@Slf4j
public class FundingController {

    private final FundingService fundingService;

    /* ================= 펀딩 등록 ================= */

    @GetMapping("/funding-regist-page")
    public String goToRegisterForm(@RequestParam("teamId") Long teamId, Model model) {
        FundingDTO dto = new FundingDTO();
        dto.setTeamId(teamId);
        model.addAttribute("fundingDTO", dto);
        log.info("fundingDTO = {}.................", dto);

        return "/funding/funding-regist-page";

    }

    @PostMapping("/funding-regist-page")
    public RedirectView register(FundingDTO fundingDTO, @RequestParam(value = "file", required = false) ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes) {
        log.info("fundingDTO = .............{}", fundingDTO);
        fundingService.register(fundingDTO);
        // 2. 파일이 있다면 파일 저장
        if (files != null && !files.isEmpty()) {
            fundingService.write(fundingDTO, files);
        }
        redirectAttributes.addAttribute("teamId", fundingDTO.getTeamId());
        //  funding/funding-list 로 이동
        return new RedirectView("/funding/funding-list-page");
    }

    /* ================= 펀딩 목록 ================= */

    @GetMapping("/funding-list-page")
    public String showFundingList(@RequestParam(value = "teamId", required = false) Long teamId, Model model) {
        List<FundingDTO> fundingList = teamId != null ? fundingService.getListByTeam(teamId) : List.of();
        model.addAttribute("fundingList", fundingList);
        model.addAttribute("teamId", teamId);
        return "/funding/funding-list-page";
    }
    /*====================파일============================*/
    @PostMapping("write")
    public RedirectView write(FundingDTO fundingDTO,
                              @RequestParam("file") ArrayList<MultipartFile> multipartFiles){

        fundingService.write(fundingDTO, multipartFiles);
        return new RedirectView("/post/list");
    }
}
