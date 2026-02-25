package com.app.candm.mapper;

import com.app.candm.domain.MemberActivityVO;
import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.MemberActivityDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.dto.mypage.MemberEducationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MyPageMapper {
//    ===================================================경령===========================================================
//    추가
    public void careerInsert(MemberCareerVO memberCareerVO);

//    목록
    public List<MemberCareerDTO> selectCareerByMemberId(@Param("memberId") Long id);

//    수정
    public void update(MemberCareerDTO memberCareerDTO);

//    삭제
    public void deleteCareer(Long id);

//    ===================================================학력===========================================================

//    추가
    public void educationInsert(MemberEducationVO memberEducationVO);

//    목록
    public List<MemberEducationDTO> selectEducationByMemberId(@Param("memberId") Long id);

//    삭제
    public void deleteEducation(Long id);

//    ====================================================활동내역==================================================

//    추가
    public void activityInsert(MemberActivityDTO memberActivityDTO);

//    목록
    public List<MemberActivityDTO> selectActivityByMemberId(@Param("memberId") Long idd);

}
