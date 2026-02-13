package com.app.candm.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/**")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {

    @GetMapping("")
    public String gotoMyPage(){
        log.info("들어옴!");
        return "mypage/mypage";
    }
}
