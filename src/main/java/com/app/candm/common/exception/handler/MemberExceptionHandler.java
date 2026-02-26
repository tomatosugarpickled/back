package com.app.candm.common.exception.handler;

import com.app.candm.common.exception.FileNotFoundException;
import com.app.candm.common.exception.LoginFailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages = "com.app.candm.controller.member")
public class MemberExceptionHandler {
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView loginFail(LoginFailException loginFailException, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("login","fail");
        return new RedirectView("/member/login");
    }

    @ExceptionHandler(FileNotFoundException.class)
    protected RedirectView fileNotFound(FileNotFoundException fileNotFoundException, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("fileNotFound","fail");
        return new RedirectView("/mypage/mypage");
    }
}
