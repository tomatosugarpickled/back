package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.dto.message.MessageRoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageRoomMapper {
    // 방 생성
    public void insert(MessageDTO messageDTO);

    // 방 조회
    public Long selectByCreatedMemberIdAndInvitedMemberId(
    MessageDTO messageDTO
    );

    // 내 채팅방 목록
    public List<MessageRoomDTO> selectAllListByMemberId(Long memberId);
}
