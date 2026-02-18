package com.app.candm.dto;

import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.MemberVO;
import com.app.candm.domain.TeamVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class TeamDTO {
    private Long id;
    private String teamTitle;
    private String teamUrl;
    private String teamContactEmail;
    private Status teamStatus;
    private String teamIntro;
    private Long memberId;
    private String createdDatetime;
    private String updatedDatetime;


    public TeamVO toTeamVO(){
        return TeamVO.builder()
                .id(id)
                .teamIntro(teamIntro)
                .teamTitle(teamTitle)
                .teamContactEmail(teamContactEmail)
                .teamStatus(teamStatus)
                .memberId(memberId)
                .teamUrl(teamUrl)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
