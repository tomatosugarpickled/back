package com.app.candm.controller.follow;

import com.app.candm.dto.follow.FollowWithPagingDTO;
import com.app.candm.service.follow.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage/**")
@RequiredArgsConstructor
@Slf4j
public class FollowAPIController {
    private final FollowService followService;

    @GetMapping("/follow/list/{id}/{page}")
    public FollowWithPagingDTO list(@PathVariable("id") Long id, @PathVariable("page") int page){
        return followService.list(id, page);
    }

}
