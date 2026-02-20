package com.app.candm.mapper;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MyPageMapper {

    public void careerInsert(MemberCareerDTO memberCareerDTO);

//    id로 조회
    public Optional<MemberCareerDTO> selectById(Long id);

}
