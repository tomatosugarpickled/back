package com.app.candm.mapper;

import com.app.candm.domain.FundingRegistVO;
import com.app.candm.dto.funding.FundingRegistDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FundingRegistMapper {
    // 펀딩 추가
    public void insert(FundingRegistDTO fundingDTO);

    // 팀별 펀딩 목록 조회
    public List<FundingRegistDTO> selectAllByTeamId(Long teamId);

    // 상세 조회
    public Optional<FundingRegistDTO> selectById(Long id);

    // 상태 변경
    public void updateStatus(@Param("id") Long id, @Param("fundingStatus") String fundingStatus);
}