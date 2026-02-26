package com.app.candm.dto.follow;

import com.app.candm.domain.FollowVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class FollowDTO {
    private Long id;
    private Long followerId;
    private Long followingId;
    private String memberName;
    private String createdDatetime;
    private String updatedDatetime;

    public FollowVO toFollowVO(){
        return FollowVO.builder()
                .id(id)
                .followerId(followerId)
                .followingId(followingId)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
