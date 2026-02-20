package com.app.candm.service.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.repository.mypage.MemberCareerDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MyPageService {
    private final MemberCareerDAO memberCareerDAO;

//    화면에서 경력 등록
    public Optional<MemberCareerDTO> careerRegist(MemberCareerDTO memberCareerDTO){
        memberCareerDAO.save(memberCareerDTO);
        Optional<MemberCareerDTO> foundCareer = memberCareerDAO.findByMemberId(memberCareerDTO.getId());
        return foundCareer;
    }

//    public MemberCareerDTO toDTO(MemberCareerVO memberCareerVO){
//        MemberCareerDTO memberCareerDTO = new MemberCareerDTO();
//        memberCareerDTO.setId(memberCareerVO.getId());
//        memberCareerDTO.setMemberId(memberCareerVO.getMemberId());
//        memberCareerDTO.setAffiliationTitle(memberCareerVO.getAffiliationTitle());
//        memberCareerDTO.setMemberEmploymentType(memberCareerVO.getMemberEmploymentType());
//        memberCareerDTO.setStartDate(memberCareerVO.getStartDate());
//        memberCareerDTO.setEndDate(memberCareerVO.getEndDate());
//        memberCareerDTO.setMemberRole(memberCareerVO.getMemberRole());
//        memberCareerDTO.setMemberSkill(memberCareerVO.getMemberSkill());
//        memberCareerDTO.setIntroDetailed(memberCareerVO.getIntroDetailed());
//        memberCareerDTO.setCreatedDatetime(memberCareerVO.getCreatedDatetime());
//        memberCareerDTO.setUpdatedDatetime(memberCareerVO.getUpdatedDatetime());
//        return memberCareerDTO;
//    }

}
