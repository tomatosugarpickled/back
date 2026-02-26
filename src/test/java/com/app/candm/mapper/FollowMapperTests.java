package com.app.candm.mapper;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.dto.follow.FollowDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class FollowMapperTests {

    @Autowired
    private FollowMapper followMapper;

    @Test
    public void testInsert() {
        followMapper.followInsert(3L, 5L);
    }

    @Test
    public void testSelectTest(){
        Criteria criteria = new Criteria(1,10);
        List<FollowDTO> list = followMapper.selectAllFollowerByMemberId(5L , criteria);

        log.info("{},,,,,,,,,,,,,,,,,,,,,,",list);
    }

}
