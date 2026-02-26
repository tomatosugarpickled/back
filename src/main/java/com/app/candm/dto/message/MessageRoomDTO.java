package com.app.candm.dto.message;

import com.app.candm.domain.MessageRoomVO;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class MessageRoomDTO {
    private Long id;
    private Long createdMemberId;
    private Long invitedMemberId;
    private String memberName;
    private Long messageRoomId;
    private String messageContent;
    private String notificationDatetime;

    // DTO → VO 변환 (화면 데이터를 DB 저장용으로 변환)
    public MessageRoomVO toVO() {
        return MessageRoomVO.builder()
                .id(id)
                .createdMemberId(createdMemberId)
                .invitedMemberId(invitedMemberId)
                .build();
    }
}
