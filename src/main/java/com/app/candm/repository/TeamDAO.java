package com.app.candm.repository;

import com.app.candm.domain.TeamVO;
import com.app.candm.dto.TeamDTO;
import com.app.candm.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TeamDAO {
    private final TeamMapper teamMapper;
//    팀 추가
    public void save(TeamDTO teamDTO) {teamMapper.insert(teamDTO);}
//    전체 목록 조회
    public List<TeamVO> selectAll(Long Id) {return teamMapper.selectAll();}

    // 팀명으로 조회
    public Optional<TeamVO> findByTitle(String teamTitle) {
        return teamMapper.selectByTitle(teamTitle);
    }
    // 팀URL로 조회
    public Optional<TeamVO> findByUrl(String teamUrl) {
        return teamMapper.selectByUrl(teamUrl);
    }



}
