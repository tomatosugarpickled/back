package com.app.candm.service.team;

import com.app.candm.domain.TeamVO;
import com.app.candm.dto.TeamDTO;
import com.app.candm.repository.TeamDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamRegistrationService {
    private final TeamDAO teamDAO;

    //    팀명
    public boolean checkTeamTitle(String teamTitle){
        return teamDAO.findByTitle(teamTitle).isEmpty();
    }
    //    팀URL 중복검사
    public boolean checkTeamUrl(String teamUrl){
        return teamDAO.findByUrl(teamUrl).isEmpty();
    }

    // 실제 팀 등록
    public TeamDTO registerTeam(TeamDTO teamDTO){
        log.info("Registering team: {}", teamDTO);
        teamDAO.save(teamDTO);
        return teamDTO; // 등록된 팀 정보를 반환
    }
//    팀 등록중 예외처리
    public void registerTeamException(TeamDTO teamDTO){
        try {
            log.info("Registering team: {}", teamDTO);
            teamDAO.save(teamDTO);
        } catch (Exception e) {
            log.error("Failed to register team", e);
            throw new RuntimeException("팀 등록 중 오류 발생");
        }

    }
//    중복검사 후 등록
    public void registerTeamCheck(TeamDTO teamDTO){
        if(!checkTeamTitle(teamDTO.getTeamTitle())){
            throw new IllegalArgumentException("이미 존재하는 팀명입니다.");
        }
        if(!checkTeamUrl(teamDTO.getTeamUrl())){
            throw new IllegalArgumentException("이미 존재하는 팀 URL입니다.");
        }
        teamDAO.save(teamDTO);
    }



}
