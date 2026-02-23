package com.app.candm.mapper;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.dto.mypage.MemberEducationDTO;
import com.app.candm.repository.mypage.MemberEducationDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
        mypageMapper.careerInsert(memberCareerDTO.toMemberCareerVO());
    }

    @Test
    public void testFindById(){
//        Optional<MemberCareerDTO> foundCareer = mypageMapper.selectById(5L);
//        log.info("{},,,,,,,,,,,,,,,,,", foundCareer.isEmpty());
        List<MemberCareerDTO> careers = mypageMapper.selectCareerByMemberId(4L);
        log.info("{},,,,,,,,,,,,,,,,,",careers);
    }

    @Test
    public void testDelete(){
        mypageMapper.deleteCareer(30L);
    }
//==========================================학력===========================================================
    @Test
    public void testEducationInsert(){
        MemberEducationDTO memberEducationDTO = new MemberEducationDTO();

        memberEducationDTO.setEducationTitle("인하대학교");
        memberEducationDTO.setEducationType("대학교");
        memberEducationDTO.setEducationMajor("전자학");
        memberEducationDTO.setEducationGraduation("휴학");
        memberEducationDTO.setIntroDetailed("잘다님");
        memberEducationDTO.setStartDate("2018-03");
        memberEducationDTO.setEndDate("2020-03");
        memberEducationDTO.setMemberId(4L);

        mypageMapper.educationInsert(memberEducationDTO.toMemberEducationVO());
    }

    @Test
    public void testFindEduById(){
        List<MemberEducationDTO> educations = mypageMapper.selectEducationByMemberId(5L);
        log.info("{},,,,,,,,,,,,,,,,,",educations);
    }

    @Test
    public void testDeleteEdu(){
        mypageMapper.deleteEducation(6L);
    }

}
