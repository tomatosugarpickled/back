package com.app.candm.mapper;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.domain.PostVO;
import com.app.candm.dto.post.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    목록
    public List<PostDTO> selectAll(@Param("id") Long id, @Param("criteria") Criteria cri);

//    조회
    public Optional<PostDTO> selectById(Long id);

//    개수
    public int selectTotal(Long id);
}
