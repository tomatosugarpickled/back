package com.app.candm.service.post;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.post.PostDTO;
import com.app.candm.dto.post.PostWithPagingDTO;
import com.app.candm.repository.post.PostDAO;
import com.app.candm.util.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class PostService {
    private final PostDAO postDAO;

    public PostWithPagingDTO list(long id, int page) {
        PostWithPagingDTO postWithPagingDTO = new PostWithPagingDTO();
        Criteria criteria = new Criteria(page, postDAO.findTotal(id));

        List<PostDTO> posts = postDAO.findAll(id, criteria);


        criteria.setHasMore(posts.size() > criteria.getRowCount());
        postWithPagingDTO.setCriteria(criteria);

        posts.forEach(postDTO ->
                postDTO.setCreatedDatetime(DateUtils.toRelativeTime(postDTO.getCreatedDatetime())));


        postWithPagingDTO.setTotal(postDAO.findTotal(id));
        postWithPagingDTO.setPosts(posts);


        return postWithPagingDTO;
    }
}
