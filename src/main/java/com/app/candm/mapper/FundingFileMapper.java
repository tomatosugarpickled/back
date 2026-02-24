package com.app.candm.mapper;

import com.app.candm.domain.FundingFileVO;
import com.app.candm.dto.funding.FundingFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundingFileMapper {
//    추가
    public void insert(FundingFileVO fundingFileVO);
//    목록
    public List<FundingFileDTO> selectAllByFundingId(Long id);
//    삭제
    public void delete(Long id);
//    삭제(게시글 아이디)
    public void deleteByPostId(Long id);
}
