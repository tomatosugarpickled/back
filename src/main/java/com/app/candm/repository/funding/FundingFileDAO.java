package com.app.candm.repository.funding;

import com.app.candm.domain.FundingFileVO;
import com.app.candm.dto.funding.FundingFileDTO;
import com.app.candm.mapper.FundingFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FundingFileDAO {
    private final FundingFileMapper fundingFileMapper;

//    추가
    public void save(FundingFileVO fundingFileVO) {
        fundingFileMapper.insert(fundingFileVO);
    }

//    목록
    public List<FundingFileDTO>  findAllByFundingId(Long id) {
        return fundingFileMapper.selectAllByFundingId(id);
    }

//    삭제
    public void delete(Long id){
        fundingFileMapper.delete(id);
    }
}













