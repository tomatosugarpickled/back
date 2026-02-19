package com.app.candm.mapper;

import com.app.candm.dto.mypage.MemberCareerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    public void careerInsert(MemberCareerDTO memberCareerDTO);

}
