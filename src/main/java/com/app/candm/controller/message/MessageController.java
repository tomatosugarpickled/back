package com.app.candm.controller.message;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.dto.message.MessageRoomDTO;
import com.app.candm.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message/**")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;

    // 페이지 이동
    @GetMapping("")
    public String goToMessageRoom() {
        return "message/message";
    }

    // 메시지 작성
    @PostMapping("/send")
    @ResponseBody
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.write(messageDTO);
    }

    // 메세지 목록 조회
    @GetMapping("/list")
    @ResponseBody
    public List<MessageRoomDTO> getMessageList(Long memberId) {
        return messageService.getMessageRoomList(memberId);
    }
}
