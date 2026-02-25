package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberActivityVO;
import com.app.candm.dto.mypage.MemberActivityDTO;
import com.app.candm.mapper.MemberActivityFileMapper;
import com.app.candm.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberActivityDAO {

    private final MyPageMapper myPageMapper;


//    추가
    public void save(MemberActivityDTO memberActivityDTO){
        myPageMapper.activityInsert(memberActivityDTO);
    }

//    목록
    public List<MemberActivityDTO> findActivityByMemberId(Long id){
        return myPageMapper.selectActivityByMemberId(id);
    }

//    삭제
    public void delete(Long id){
        myPageMapper.deleteActivity(id);
    }


}
