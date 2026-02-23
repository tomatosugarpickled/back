package com.app.candm.mapper;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
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


}
