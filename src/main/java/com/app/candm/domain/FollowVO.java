package com.app.candm.domain;

import com.app.candm.audit.Period;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class FollowVO extends Period {
    private Long id;
    private Long followerId;
    private Long followingId;
}
