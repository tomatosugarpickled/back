package com.app.candm.domain;

import com.app.candm.audit.Period;
import com.app.candm.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class PostVO extends Period {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postViewCount;
    private Status postStatus;
    private Long memberId;
}
