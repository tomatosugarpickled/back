package com.app.candm.service.follow;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.follow.FollowDTO;
import com.app.candm.dto.follow.FollowWithPagingDTO;
import com.app.candm.repository.follow.FollowDAO;
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
public class FollowService {
    private final FollowDAO followDAO;

    public FollowWithPagingDTO list(Long id, int page){
        FollowWithPagingDTO followWithPagingDTO = new FollowWithPagingDTO();
        Criteria criteria = new Criteria(page, followDAO.findTotal(id));

        List<FollowDTO> follows = followDAO.findAllByFollowerId(id, criteria);

        criteria.setHasMore(follows.size() > criteria.getRowCount());
        followWithPagingDTO.setCriteria(criteria);

        follows.forEach(followDTO -> {
            followDTO.setCreatedDatetime(DateUtils.toRelativeTime(followDTO.getCreatedDatetime()));
        });


        followWithPagingDTO.setFollowerTotal(followDAO.findTotal(id));
        followWithPagingDTO.setFollows(follows);

        return followWithPagingDTO;
    }

}
