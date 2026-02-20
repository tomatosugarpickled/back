package com.app.candm.mapper;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MyPageMapperTests {

    @Autowired
    private MyPageMapper mypageMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberCareerDTO memberCareerDTO = new MemberCareerDTO();

        memberCareerDTO.setAffiliationTitle("현대자동차");
        memberCareerDTO.setMemberEmploymentType("풀타임");
        memberCareerDTO.setMemberRole("보안운영팀");
        memberCareerDTO.setMemberSkill("서비스보안기술");
        memberCareerDTO.setStartDate("2026-02");
        memberCareerDTO.setEndDate("2026-04");
        memberCareerDTO.setIntroDetailed("안녕하십니까");
        memberCareerDTO.setMemberId(4L);

        log.info("{},,,,,,,,,,,,,",memberCareerDTO);
        mypageMapper.careerInsert(memberCareerDTO);
    }

    @Test
    public void testFindById(){
        Optional<MemberCareerDTO> foundCareer = mypageMapper.selectById(5L);
        log.info("{},,,,,,,,,,,,,,,,,", foundCareer.isEmpty());
    }

}
