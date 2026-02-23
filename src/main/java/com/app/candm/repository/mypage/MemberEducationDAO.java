package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.domain.MemberEducationVO;
import com.app.candm.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberEducationDAO {

    public final MyPageMapper myPageMapper;

//    추가
    public void save(MemberEducationVO memberEducationVO){
        myPageMapper.educationInsert(memberEducationVO);
    }
//    목록

//    삭제
}
