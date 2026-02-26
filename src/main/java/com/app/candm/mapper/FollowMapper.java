package com.app.candm.mapper;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.follow.FollowDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FollowMapper {

//    팔로우
    public void followInsert(@Param("followerId") Long followerId, @Param("followingId") Long followingId);

//    목록
    public List<FollowDTO> selectAllFollowerByMemberId(@Param("id") Long id, @Param("criteria") Criteria cri);

//    조회
    public FollowDTO selectById(Long id);

    //    개수
    public int selectTotal(Long id);
}
