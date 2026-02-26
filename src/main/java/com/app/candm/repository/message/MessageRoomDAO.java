package com.app.candm.repository.message;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.dto.message.MessageRoomDTO;
import com.app.candm.mapper.MessageRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageRoomDAO {
    private final MessageRoomMapper messageRoomMapper;

    // 방 생성
    public void save(MessageDTO messageDTO) {
        messageRoomMapper.insert(messageDTO);
    }

    // 방 조회
    public Long findByCreatedMemberIdAndInvitedMemberId(MessageDTO messageDTO){
        return messageRoomMapper.selectByCreatedMemberIdAndInvitedMemberId(messageDTO);
    }

    //방 목록
    public List<MessageRoomDTO> selectAllListByMemberId(Long memberId) {
        return messageRoomMapper.selectAllListByMemberId(memberId);
    }
}
