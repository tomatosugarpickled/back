package com.app.candm.mapper;

import com.app.candm.dto.TeamDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class TeamMapperTests {
    @Autowired
    private TeamMapper teamMapper;

    @Test
    public void teamInsertTest(){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamTitle("CM");
        teamDTO.setTeamIntro("안녕하세요 감사해요 잘있어요 다시만나요");
        teamDTO.setMemberId(1L);
        teamDTO.setTeamUrl("candm.com/teams/testteam");
        teamDTO.setTeamContactEmail("test@gmail.com");

        teamMapper.insert(teamDTO);

    }
}
