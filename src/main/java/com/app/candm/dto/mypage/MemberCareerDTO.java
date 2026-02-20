package com.app.candm.dto.mypage;

import com.app.candm.domain.MemberCareerVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class MemberCareerDTO {
    private Long id;
    private String affiliationTitle;
    private String memberEmploymentType;
    private String memberRole;
    private String memberSkill;
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

    public MemberCareerVO toMemberCareerVO(){
        return MemberCareerVO.builder()
                .id(id)
                .affiliationTitle(affiliationTitle)
                .memberEmploymentType(memberEmploymentType)
                .memberRole(memberRole)
                .memberSkill(memberSkill)
                .introDetailed(introDetailed)
                .startDate(startDate)
                .endDate(endDate)
                .memberId(memberId)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
