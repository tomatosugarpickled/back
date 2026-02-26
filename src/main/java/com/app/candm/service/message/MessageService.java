package com.app.candm.service.message;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.dto.message.MessageRoomDTO;
import com.app.candm.repository.message.MessageDAO;
import com.app.candm.repository.message.MessageRoomDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MessageService {
    private final MessageDAO messageDAO;
    private final MessageRoomDAO messageRoomDAO;

    // 작성
    public void write(MessageDTO messageDTO) {
        Long roomId = messageRoomDAO.findByCreatedMemberIdAndInvitedMemberId(messageDTO);
        if(roomId == null) {
            messageRoomDAO.save(messageDTO);
            roomId = messageDTO.getId();
        }
        messageDTO.setMessageRoomId(roomId);
        messageDAO.save(messageDTO);
    }

    // 조회
    public List<MessageRoomDTO> getMessageRoomList(Long memberId) {
        return messageRoomDAO.selectAllListByMemberId(memberId);
    }
}
