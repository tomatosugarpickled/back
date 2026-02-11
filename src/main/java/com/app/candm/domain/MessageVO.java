package com.app.candm.domain;
import com.app.candm.audit.Period;

import com.app.candm.common.enumeration.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class MessageVO extends Period {
    private Long id;
    private String senderId;
    private String receiverId;
    private Status messageStatus;
    private String notificationDatetime;
    private String messageContent;
    private String messageRoomId;
}
