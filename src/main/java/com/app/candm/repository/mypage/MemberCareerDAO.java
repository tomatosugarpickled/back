package com.app.candm.repository.mypage;

import com.app.candm.domain.MemberCareerVO;
import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberCareerDAO {

    private final MyPageMapper myPageMapper;

//    경력 등록
    public void save(MemberCareerVO memberCareerVO){
        myPageMapper.careerInsert(memberCareerVO);
    }

//    목록
    public List<MemberCareerDTO> findCareerByMemberId(Long id){
        return myPageMapper.selectCareerByMemberId(id);
    }

//    삭제
    public void delete(Long id){
        myPageMapper.deleteCareer(id);
    }

}
