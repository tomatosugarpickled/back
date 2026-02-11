package com.app.candm.dto;

import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.MessageVO;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class MessageDTO {
    private Long id;
    private String senderId;
    private String receiverId;
    private Status messageStatus;
    private String notificationDatetime;
    private String messageContent;
    private String messageRoomId;

    // DTO → VO 변환 (화면 데이터를 DB 저장용으로 변환)
    public MessageVO toVO() {
        return MessageVO.builder()
                .id(id)
                .senderId(senderId)
                .receiverId(receiverId)
                .messageStatus(messageStatus)
                .notificationDatetime(notificationDatetime)
                .messageContent(messageContent)
                .messageRoomId(messageRoomId)
                .build();
    }
}
