package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.dto.message.MessageRoomDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MessageRoomTests {
    @Autowired
    private MessageRoomMapper messageRoomMapper;

    @Test
    public void testInsertMessageRoom() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSenderId(1L);
        messageDTO.setReceiverId(2L);

        messageRoomMapper.insert(messageDTO);
    }

    @Test
    public void testSelectByCreatedMemberIdAndInvitedMemberId() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSenderId(1L);
        messageDTO.setReceiverId(2L);
        Long id = messageRoomMapper.selectByCreatedMemberIdAndInvitedMemberId(messageDTO);
        log.info("id:{}", id);
    }

    @Test
    public void testSelectAllListByMemberId() {
        log.info("{}", messageRoomMapper.selectAllListByMemberId(2L));
    }
}
