package com.app.candm.repository.funding;

import com.app.candm.dto.funding.FundingRegistDTO;
import com.app.candm.mapper.FundingRegistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FundingRegistDAO {
    private final FundingRegistMapper fundingRegistMapper;

    // 펀딩 저장
    public void save(FundingRegistDTO fundingRegistDTO) {
        fundingRegistMapper.insert(fundingRegistDTO);
    }

    // 팀별 펀딩 목록 조회
    public List<FundingRegistDTO> findAllByTeamId(Long teamId) {
        return fundingRegistMapper.selectAllByTeamId(teamId);
    }

    // 특정 펀딩 상세 조회
    public Optional<FundingRegistDTO> findById(Long id) {
        return fundingRegistMapper.selectById(id);
    }

    // 펀딩 상태 업데이트
    public void updateStatus(Long id, String status) {
        fundingRegistMapper.updateStatus(id, status);
    }
}