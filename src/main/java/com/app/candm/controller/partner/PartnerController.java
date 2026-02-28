package com.app.candm.controller.partner;

import com.app.candm.dto.TeamDTO;
import com.app.candm.dto.member.MemberDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
public class PartnerController {

    // 3. 팀 목록 페이지
    @GetMapping("/partner-list")
    public String showTeamList(@RequestParam(value = "memberId", required = false) Long memberId, HttpSession session, Model model) {
        if (memberId == null) {
            MemberDTO member = (MemberDTO) session.getAttribute("member");
            if (member != null) memberId = member.getId();
        }

        model.addAttribute("memberId", memberId);
        return "/team/partner-list/partner-list";
    }
}
