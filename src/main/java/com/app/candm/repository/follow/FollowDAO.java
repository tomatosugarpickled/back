package com.app.candm.repository.follow;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.follow.FollowDTO;
import com.app.candm.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FollowDAO {

    private final FollowMapper followMapper;
//  추가
    public void save(Long followerId, Long followingId) {
        followMapper.followInsert(followerId, followingId);
    }
//  목록
    public List<FollowDTO> findAllByFollowerId(Long id, Criteria criteria) {
        return followMapper.selectAllFollowerByMemberId(id, criteria);
    }
//  전체 개수
    public int findTotal(Long id) {
        return followMapper.selectTotal(id);
    }

}
