package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.dto.mypage.MemberEducationDTO;
import com.app.candm.dto.mypage.MemberWithEducationDTO;
import com.app.candm.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberEducationDAO {

    public final MyPageMapper myPageMapper;

//    추가
    public void save(MemberEducationVO memberEducationVO){
        myPageMapper.educationInsert(memberEducationVO);
    }

//    목록
    public List<MemberEducationDTO> findEducationByMemberId(Long id){
        return myPageMapper.selectEducationByMemberId(id);
    }

//    삭제
    public void delete(Long id){
        myPageMapper.deleteEducation(id);
    }
}
