package com.app.candm.dto.funding;

import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.FundingRegistVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class FundingRegistDTO {
    private Long id;
    private Long fundingTargetAmount;
    private Long fundingCurrentAmount;
    private String fundingTitle;
    private String startDate;
    private String endDate;
    private String fundingDescription;
    private String fundingContactEmail;
    private Status fundingStatus;
    private String createdDatetime;
    private Long teamId;

    // VO로 변환하는 메서드
    public FundingRegistVO toFundingVO() {
        return FundingRegistVO.builder()
                .id(id)
                .fundingTargetAmount(fundingTargetAmount)
                .fundingCurrentAmount(fundingCurrentAmount)
                .fundingTitle(fundingTitle)
                .startDate(startDate)
                .endDate(endDate)
                .fundingDescription(fundingDescription)
                .fundingContactEmail(fundingContactEmail)
                .fundingStatus(fundingStatus)
                .teamId(teamId)
                .build();
    }
}