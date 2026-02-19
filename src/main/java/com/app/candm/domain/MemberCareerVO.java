package com.app.candm.domain;

import com.app.candm.audit.Period;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MemberCareerVO extends Period {
    private Long id;
    private String affiliationTitle;
    private String memberEmploymentType;
    private String memberRole;
    private String memberSkill;
    private String introDetailed;
    private String startDate;
    private String endDate;
    private Long memberId;

}
