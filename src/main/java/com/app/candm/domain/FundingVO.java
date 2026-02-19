package com.app.candm.domain;

import com.app.candm.audit.Period;
import com.app.candm.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class FundingVO extends Period {
    private Long id;
    private Long fundingTargetAmount;
    private Long fundingCurrentAmount;
    private String fundingTitle;
    private String startDate;
    private String endDate;
    private String fundingDescription;
    private String fundingContactEmail;
    private Status fundingStatus;
    private Long teamId; // FK: tbl_team
}