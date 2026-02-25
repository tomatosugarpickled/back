package com.app.candm.mapper;

import com.app.candm.dto.funding.FundingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FundingMapper {
    // 펀딩 추가
    public void insert(FundingDTO fundingDTO);

    // 팀별 펀딩 목록 조회
    public List<FundingDTO> selectAllByTeamId(Long teamId);

    // 상세 조회
    public Optional<FundingDTO> selectById(Long id);

    // 상태 변경
    public void updateStatus(@Param("id") Long id, @Param("fundingStatus") String fundingStatus);
}