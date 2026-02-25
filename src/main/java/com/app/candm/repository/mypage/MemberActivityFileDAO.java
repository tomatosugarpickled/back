package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberActivityFileVO;
import com.app.candm.dto.mypage.MemberActivityFileDTO;
import com.app.candm.mapper.MemberActivityFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberActivityFileDAO {

    private final MemberActivityFileMapper memberActivityFileMapper;

//    추가
    public void save(MemberActivityFileVO memberActivityFileVO){
        memberActivityFileMapper.insert(memberActivityFileVO);
    }

//    목록
    public List<MemberActivityFileDTO> findAllByMemberId(Long id){
        return memberActivityFileMapper.selectAllByMemberId(id);
    }

//    삭제
    public void deleteByActivityId(Long id){
        memberActivityFileMapper.deleteByActivityId(id);
    }

}
