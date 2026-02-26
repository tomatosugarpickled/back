package com.app.candm.dto.post;

import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.PostVO;
import lombok.*;

@Getter
@Setter @ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postViewCount;
    private Status postStatus;
    private Long memberId;
    private String memberName;
    private String createdDatetime;
    private String updatedDatetime;

    public PostVO toPostVO(){
        return PostVO.builder()
                .id(id)
                .postTitle(postTitle)
                .postContent(postContent)
                .postViewCount(postViewCount)
                .memberId(memberId)
                .postStatus(postStatus)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
}
