package com.app.candm.service.mypage;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.MemberActivityFileVO;
import com.app.candm.domain.MemberActivityVO;
import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberVO;
import com.app.candm.dto.FileDTO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.*;
import com.app.candm.repository.mypage.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MyPageService {
    private final MemberCareerDAO memberCareerDAO;
    private final MemberEducationDAO memberEducationDAO;
    private final MemberActivityDAO memberActivityDAO;
    private final FileDAO fileDAO;
    private final MemberActivityFileDAO memberActivityFileDAO;

//    경력 등록
    public void regist(MemberCareerDTO memberCareerDTO){
        memberCareerDAO.save(memberCareerDTO.toMemberCareerVO());
    }
//    경력 목록
    public MemberWithCareerDTO getCareerByMemberId(Long id){
        MemberWithCareerDTO memberWithCareerDTO = new MemberWithCareerDTO();
        List<MemberCareerDTO> careers = memberCareerDAO.findCareerByMemberId(id);

        memberWithCareerDTO.setCareers(careers);
        memberWithCareerDTO.setMemberId(id);
        return memberWithCareerDTO;
    }

//    경력삭제
    public void delete(Long id){
        memberCareerDAO.delete(id);
    }

    public MemberCareerDTO toDTO(MemberCareerVO memberCareerVO){
        MemberCareerDTO memberCareerDTO = new MemberCareerDTO();
        memberCareerDTO.setId(memberCareerVO.getId());
        memberCareerDTO.setMemberId(memberCareerVO.getMemberId());
        memberCareerDTO.setAffiliationTitle(memberCareerVO.getAffiliationTitle());
        memberCareerDTO.setMemberEmploymentType(memberCareerVO.getMemberEmploymentType());
        memberCareerDTO.setStartDate(memberCareerVO.getStartDate());
        memberCareerDTO.setEndDate(memberCareerVO.getEndDate());
        memberCareerDTO.setMemberRole(memberCareerVO.getMemberRole());
        memberCareerDTO.setMemberSkill(memberCareerVO.getMemberSkill());
        memberCareerDTO.setIntroDetailed(memberCareerVO.getIntroDetailed());
        memberCareerDTO.setCreatedDatetime(memberCareerVO.getCreatedDatetime());
        memberCareerDTO.setUpdatedDatetime(memberCareerVO.getUpdatedDatetime());
        return memberCareerDTO;
    }

//    ==================================================학력=============================================================

//   학력 등록
    public void regist(MemberEducationDTO memberEducationDTO){
        memberEducationDAO.save(memberEducationDTO.toMemberEducationVO());
    }

//   학력 목록
    public MemberWithEducationDTO getEducationByMemberId(Long id){
        MemberWithEducationDTO memberWithEducationDTO = new MemberWithEducationDTO();
        List<MemberEducationDTO> educations = memberEducationDAO.findEducationByMemberId(id);

        memberWithEducationDTO.setEducations(educations);
        memberWithEducationDTO.setMemberId(id);
        return memberWithEducationDTO;
    }

//    학력 삭제
    public void deleteEducation(Long id){
        memberEducationDAO.delete(id);
    }

//    ================================================활동===============================================================

//    활동 등록(이미지 포함)
    public void regist(MemberActivityDTO memberActivityDTO, ArrayList<MultipartFile> multipartFiles){
        log.info("input : {},,,,,,,,,,,,,,", memberActivityDTO);
        String rootPath = "C:/file/";
        String todayPath = getTodayPath();
        String path = rootPath + todayPath;

        FileDTO fileDTO = new FileDTO();
        MemberActivityFileDTO memberActivityFileDTO = new MemberActivityFileDTO();

        memberActivityDAO.save(memberActivityDTO);
        Long generatedActivityId = memberActivityDTO.getId();

        if (generatedActivityId == null) {
            throw new IllegalStateException(
                    "tbl_member_activity 저장 후 생성된 id를 받지 못했습니다. " +
                            "MyBatis activityInsert의 useGeneratedKeys/keyProperty/keyColumn 설정을 확인하세요."
            );
        }

        multipartFiles.forEach(multipartFile -> {
            if(multipartFile.getOriginalFilename().isEmpty()){
                return;
            }
            UUID uuid = UUID.randomUUID();
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(String.valueOf(multipartFile.getSize()));
            fileDTO.setFileOriginalName(multipartFile.getOriginalFilename());
            fileDTO.setFileName(uuid.toString() + "_" + multipartFile.getOriginalFilename());
            fileDTO.setFileContentType(multipartFile.getContentType().contains("image") ? FileContentType.IMAGE : FileContentType.OTHER);
            fileDAO.save(fileDTO);

            memberActivityFileDTO.setId(fileDTO.getId());
            memberActivityFileDTO.setMemberId(memberActivityDTO.getMemberId());
            memberActivityFileDTO.setMemberActivityId(generatedActivityId);

            MemberActivityFileVO memberActivityFileVO = memberActivityFileDTO.toMemberActivityFileVO();
            memberActivityFileDAO.save(memberActivityFileVO);


            File directory = new File(rootPath + "/" + fileDTO.getFilePath());
            if(!directory.exists()){
                directory.mkdirs();
            }
            try {
                multipartFile.transferTo(new File(path, fileDTO.getFileName()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String getTodayPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

//    활동 목록
    public List<MemberActivityDTO> getActivityByMemberId(Long id){
        List<MemberActivityDTO> activities = memberActivityDAO.findActivityByMemberId(id);

        activities.forEach(activityDTO -> {
            List<MemberActivityFileDTO> files = memberActivityFileDAO.findAllByMemberId(activityDTO.getId());
            activityDTO.setActivityFiles(files);
        });

        return activities;
    }

//    활동내역 삭제

    public void deleteActivity(Long id){
//        log.info("{들어옴1}");
//        memberActivityFileDAO.findAllByMemberId(id).forEach(memberActivityFileDTO -> {
//            File file = new File("C:/file/" + memberActivityFileDTO.getFilePath(), memberActivityFileDTO.getFileName());
//            if(file.exists()){
//                log.info("{들어옴2}");
//                file.delete();
//            }
//
//            Long fileId = memberActivityFileDTO.getId();
//            memberActivityFileDAO.deleteByActivityId(fileId);
//            fileDAO.delete(fileId);
//        });
//        memberActivityDAO.delete(id);
        List<MemberActivityFileDTO> files = memberActivityFileDAO.findAllByMemberId(id);
        files.forEach(memberActivityFileDTO -> {
            File file = new File("C:/file/" + memberActivityFileDTO.getFilePath(), memberActivityFileDTO.getFileName());
                if(file.exists()){
                    file.delete();
                    }
        });
        memberActivityFileDAO.deleteByActivityId(id);

        files.forEach(fileDTO -> fileDAO.delete(fileDTO.getId()));

        memberActivityDAO.delete(id);
    }

}
