package com.app.candm.repository.funding;

import com.app.candm.dto.funding.FundingDTO;
import com.app.candm.mapper.FundingRegistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FundingDAO {
    private final FundingRegistMapper fundingRegistMapper;

    // 펀딩 저장
    public void save(FundingDTO fundingDTO) {
        fundingRegistMapper.insert(fundingDTO);
    }

    // 팀별 펀딩 목록 조회
    public List<FundingDTO> findAllByTeamId(Long teamId) {
        return fundingRegistMapper.selectAllByTeamId(teamId);
    }

    // 특정 펀딩 상세 조회
    public Optional<FundingDTO> findById(Long id) {
        return fundingRegistMapper.selectById(id);
    }

    // 펀딩 상태 업데이트
    public void updateStatus(Long id, String status) {
        fundingRegistMapper.updateStatus(id, status);
    }
}