package com.app.candm.service.mypage;

import com.app.candm.dto.mypage.MemberCareerDTO;
import com.app.candm.repository.mypage.MemberCareerDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MyPageService {
    private MemberCareerDAO memberCareerDAO;

//    화면에서 경력 등록
    public void careerRegist(MemberCareerDTO memberCareerDTO){
        memberCareerDAO.save(memberCareerDTO);
    }

}
