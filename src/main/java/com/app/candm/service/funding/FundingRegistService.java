package com.app.candm.service.funding;

import com.app.candm.domain.FundingRegistVO;
import com.app.candm.domain.FundingRegistVO;
import com.app.candm.dto.funding.FundingRegistDTO;
import com.app.candm.dto.funding.FundingRegistDTO;
import com.app.candm.repository.funding.FundingRegistDAO;
import com.app.candm.repository.funding.FundingRegistDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class FundingRegistService {
    private final FundingRegistDAO fundingRegistDAO;

    // 펀딩 신규 등록
    public void register(FundingRegistDTO fundingRegistDTO) {
        log.info("Registering new funding: {}", fundingRegistDTO);

        // 비즈니스 로직 예시: 종료일이 시작일보다 빠른지 검증 가능
        // if(fundingDTO.getEndDate().compareTo(fundingDTO.getStartDate()) < 0) { ... }

        fundingRegistDAO.save(fundingRegistDTO);
    }

    // 특정 팀의 펀딩 목록 조회
    @Transactional(readOnly = true)
    public List<FundingRegistDTO> getListByTeam(Long teamId) {
        return fundingRegistDAO.findAllByTeamId(teamId);
    }

    // 펀딩 상세 정보 조회
    @Transactional(readOnly = true)
    public FundingRegistVO getFunding(Long id) {
        return fundingRegistDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 펀딩이 존재하지 않습니다. ID: " + id)).toFundingVO();
    }

    // 펀딩 상태 변경 (승인/거절 또는 활성/비활성)
    public void changeStatus(Long id, String status) {
        fundingRegistDAO.updateStatus(id, status);
    }
}