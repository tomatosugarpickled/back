package com.app.candm.mapper;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.MemberActivityFileVO;
import com.app.candm.domain.MemberActivityVO;
import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.dto.FileDTO;
import com.app.candm.dto.mypage.MemberActivityDTO;
import com.app.candm.dto.mypage.MemberActivityFileDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.dto.mypage.MemberEducationDTO;
import com.app.candm.repository.mypage.MemberActivityDAO;
import com.app.candm.repository.mypage.MemberActivityFileDAO;
import com.app.candm.repository.mypage.MemberEducationDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class MyPageMapperTests {

    @Autowired
    private MyPageMapper mypageMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private MemberActivityDAO memberActivityDAO;
    @Autowired
    private MemberActivityFileDAO memberActivityFileDAO;
    @Autowired
    private MemberActivityFileMapper memberActivityFileMapper;

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

    @Test
    public void testFileInsert(){
        FileDTO fileDTO = new FileDTO();
        MemberActivityFileDTO memberActivityFileDTO = new MemberActivityFileDTO();

        fileDTO.setFilePath("C:\\gb_0900_hsh\\spring\\workspace\\candm\\src\\main\\resources\\static\\image\\profiles");
        fileDTO.setFileName("donald_trump.png");
        fileDTO.setFileOriginalName("donald_trump.png");
        fileDTO.setFileSize("150px");
        fileDTO.setFileContentType(FileContentType.IMAGE);
//        fileDTO.setMemberId(4L);
        memberActivityFileDTO.setId(2L);
        memberActivityFileDTO.setMemberId(4L);

        fileMapper.insert(fileDTO);
        memberActivityFileMapper.insert(memberActivityFileDTO.toMemberActivityFileVO());
        log.info("{}",fileDTO);
    }

    @Test
    public void testMemberActivityInsert(){
        MemberActivityDTO memberActivityDTO = new MemberActivityDTO();
        List<MemberActivityFileDTO> fileList = new ArrayList<>();

        MemberActivityFileDTO activityFile = new MemberActivityFileDTO();

        activityFile.setFilePath("C:\\gb_0900_hsh\\spring\\workspace\\candm\\src\\main\\resources\\static\\image\\profiles");
        activityFile.setFileName("donald_trump.png");
        activityFile.setFileOriginalName("donald_trump.png");
        activityFile.setFileSize("150px");
        activityFile.setFileContentType(FileContentType.IMAGE);

        fileList.add(activityFile);

        memberActivityDTO.setAwardTitle("운전면허증");
        memberActivityDTO.setActivityType("자격증");
        memberActivityDTO.setStartDate("2024-02");
        memberActivityDTO.setMemberId(4L);
        memberActivityDTO.setActivityFiles(fileList);

        mypageMapper.activityInsert(memberActivityDTO); // 🔥 실제 저장 호출
    }

    @Test
    public void testFindActivityByIdMemberId(){
        List<MemberActivityDTO> activities = mypageMapper.selectActivityByMemberId(5L);
        log.info("{},,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",activities.toString());
    }

    @Test
    public void testFindFiletAllByMemberId(){

        List<MemberActivityFileDTO> files = memberActivityFileMapper.selectAllByMemberId(5L);
        log.info("{},,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",files);
    }

    @Test
    public void getActivityByMemberId(){
        List<MemberActivityDTO> activities = memberActivityDAO.findActivityByMemberId(5L);

        activities.forEach(activityDTO -> {
            List<MemberActivityFileDTO> files = memberActivityFileDAO.findAllByMemberId(5L);
            activityDTO.setActivityFiles(files);
        });

        log.info("{},,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",activities);
    }

    @Test
    public void testSelectActivityById(){
        MemberActivityDTO activity = mypageMapper.selectActivityById(26L)
                .orElseThrow(() -> new RuntimeException("데이터 없음!"));
        log.info("조회된 결과: {}", activity.toString());
    }

    @Test
    public void testDeleteActivity(){
        MemberActivityDTO activity = mypageMapper.selectActivityById(26L).orElseThrow();
        MemberActivityFileDTO file =

        mypageMapper.deleteActivity(activity.getId());
        memberActivityFileMapper.deleteByActivityId(activity.getId());
        fileMapper.delete();
    }

}
