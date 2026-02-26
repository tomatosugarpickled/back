package com.app.candm.domain;


import lombok.*;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Builder
public class MemberFileVO {
    private Long id;
    private Long memberId;
}
