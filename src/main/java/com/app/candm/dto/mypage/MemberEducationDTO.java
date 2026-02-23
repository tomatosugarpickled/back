package com.app.candm.dto.mypage;

import com.app.candm.domain.MemberEducationVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class MemberEducationDTO {
    private Long id;
    private String educationTitle;
    private String educationType;
    private String educationMajor;
    private String educationGraduation;
    private String introDetailed;
    private String startDate;
    private String startYear;
    private String startMonth;
    private String endDate;
    private String endYear;
    private String endMonth;
    private Long memberId;
    private String createdDatetime;
    private String updatedDatetime;

    public MemberEducationVO toMemberEducationVO(){
        return MemberEducationVO.builder()
                .id(id)
                .educationTitle(educationTitle)
                .educationType(educationType)
                .educationMajor(educationMajor)
                .educationGraduation(educationGraduation)
                .introDetailed(introDetailed)
                .startDate(startDate)
                .endDate(endDate)
                .memberId(memberId)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
