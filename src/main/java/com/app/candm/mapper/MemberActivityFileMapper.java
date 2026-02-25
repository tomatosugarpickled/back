package com.app.candm.mapper;

import com.app.candm.domain.MemberActivityFileVO;
import com.app.candm.dto.mypage.MemberActivityFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberActivityFileMapper {
//    추가
    public void insert(MemberActivityFileVO memberActivityFileVO);
//    목록
    public List<MemberActivityFileDTO> selectAllByMemberId(Long id);
//    삭제
    public void delete(Long id);

    public void deleteByActivityId(Long id);
}
