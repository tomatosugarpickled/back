package com.app.candm.mapper;

import com.app.candm.common.pagination.Criteria;
import com.app.candm.domain.PostVO;
import com.app.candm.dto.post.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void postSelectTest(){
        Criteria criteria = new Criteria(1,10);
        List<PostDTO> list = postMapper.selectAll(5L, criteria);

        log.info("{},,,,,,,,,,,,,,,,,,,,,,",list);
    }


}
