package com.app.candm.repository.post;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.post.PostDTO;
import com.app.candm.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;
//    목록
    public List<PostDTO> findAll(Long id, Criteria criteria){
        return postMapper.selectAll(id, criteria) ;}
//    전체 개수
    public int findTotal(long id) {
        return postMapper.selectTotal(id);
    }
}
