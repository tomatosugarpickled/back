package com.app.candm.dto.mypage;

import com.app.candm.domain.MemberActivityVO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class MemberActivityDTO {
    private Long id;
    private String awardTitle;
    private String activityType;
    private String startDate;
    private String startYear;
    private String startMonth;
    private Long memberId;
    private String createdDatetime;
    private String updatedDatetime;

    private List<MemberActivityFileDTO> activityFiles = new ArrayList<>();
    private String[] fileIdsToDelete;

    public MemberActivityVO toMemberActivityVO(){
        return MemberActivityVO.builder()
                .id(id)
                .awardTitle(awardTitle)
                .activityType(activityType)
                .startDate(startDate)
                .memberId(memberId)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
