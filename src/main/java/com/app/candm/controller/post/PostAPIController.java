package com.app.candm.controller.post;

import com.app.candm.dto.post.PostWithPagingDTO;
import com.app.candm.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage/**")
@RequiredArgsConstructor
@Slf4j
public class PostAPIController {
    private final PostService postService;

    @GetMapping("/post/list/{id}/{page}")
    public PostWithPagingDTO list(@PathVariable("id") Long id, @PathVariable("page") int page){

        return postService.list(id, page);
    }
}
