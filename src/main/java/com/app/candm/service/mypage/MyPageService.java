package com.app.candm.service.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.dto.mypage.MemberEducationDTO;
import com.app.candm.dto.mypage.MemberWithCareerDTO;
import com.app.candm.repository.mypage.MemberCareerDAO;
import com.app.candm.repository.mypage.MemberEducationDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MyPageService {
    private final MemberCareerDAO memberCareerDAO;
    private final MemberEducationDAO memberEducationDAO;

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
    public void regist(MemberEducationDTO memberEducationDTO){
        memberEducationDAO.save(memberEducationDTO.toMemberEducationVO());
    }

}
