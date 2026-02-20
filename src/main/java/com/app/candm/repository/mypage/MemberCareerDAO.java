package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberCareerDAO {

    private final MyPageMapper myPageMapper;

//    경력 등록
    public void save(MemberCareerDTO memberCareerDTO){
        myPageMapper.careerInsert(memberCareerDTO);
    }

//    경력 조회
    public Optional<MemberCareerDTO> findByMemberId(Long id){
        return myPageMapper.selectById(id);
    }
}
