package com.app.candm.domain;

import com.app.candm.audit.Period;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MemberActivityVO extends Period {
    private Long id;
    private String awardTitle;
    private String activityType;
    private String startDate;
    private Long memberId;
}
