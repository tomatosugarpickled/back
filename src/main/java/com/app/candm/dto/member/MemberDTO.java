package com.app.candm.dto.member;

import com.app.candm.common.enumeration.Provider;
import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.MemberVO;
import com.app.candm.domain.OauthVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberEmail;
    @JsonIgnore
    private String memberPassword;
    private String memberName;
    private String memberPhoneNumber;
    private Status memberStatus;
    private String createdDatetime;
    private String updatedDatetime;
    private Provider provider;
    private boolean remember;

    public MemberVO toMemberVO(){
        return MemberVO.builder()
                .id(id)
                .memberEmail(memberEmail)
                .memberPassword(memberPassword)
                .memberName(memberName)
                .memberPhoneNumber(memberPhoneNumber)
                .memberStatus(memberStatus)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }

    public OauthVO toOauthVO() {
        return OauthVO.builder().id(id).provider(provider).build();
    }
}
