package com.app.candm.mapper;

import com.app.candm.domain.MemberFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberFileMapper {
//    프로필사진 추가
    public void profileInsert(MemberFileVO memberFileVO);



}
