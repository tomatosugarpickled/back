package com.app.candm.domain;

import lombok.*;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FundingFileVO {
    private Long id;
    private Long fundingId;
}
