package com.app.candm.service.mypage;

import com.app.candm.common.enumeration.FileContentType;
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
        String rootPath = "C:/file/";
        String todayPath = getTodayPath();
        String path = rootPath + todayPath;

        FileDTO fileDTO = new FileDTO();
        MemberActivityFileDTO memberActivityFileDTO = new MemberActivityFileDTO();

        memberActivityDAO.save(memberActivityDTO.toMemberActivityVO());
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
            memberActivityFileDAO.save(memberActivityFileDTO.toMemberActivityFileVO());
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
}
