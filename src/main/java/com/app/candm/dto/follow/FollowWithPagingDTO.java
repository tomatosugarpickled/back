package com.app.candm.dto.follow;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.post.PostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FollowWithPagingDTO {
    private List<FollowDTO> follows;
    private Criteria criteria;
    private int followerTotal;
}
