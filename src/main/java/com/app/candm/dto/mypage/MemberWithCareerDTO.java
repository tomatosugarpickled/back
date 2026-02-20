package com.app.candm.dto.mypage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberWithCareerDTO {
    private Long memberId;
    private List<MemberCareerDTO> careers;
}
