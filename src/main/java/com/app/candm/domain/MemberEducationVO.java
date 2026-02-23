package com.app.candm.domain;

import com.app.candm.audit.Period;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MemberEducationVO extends Period {
    private Long id;
    private String educationTitle;
    private String educationType;
    private String educationMajor;
    private String educationGraduation;
    private String introDetailed;
    private String startDate;
    private String endDate;
    private Long memberId;

}
