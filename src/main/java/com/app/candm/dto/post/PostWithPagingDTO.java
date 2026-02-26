package com.app.candm.dto.post;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.domain.PostVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostWithPagingDTO {
    private List<PostDTO> posts;
    private Criteria criteria;
    private int total;
}
