package com.app.candm.mapper;

import com.app.candm.domain.MemberVO;
import com.app.candm.domain.OauthVO;
import com.app.candm.dto.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

//    아이디검사
    public Optional<MemberDTO> selectByMemberEmail(String memberEmail);
//    회원가입
    public void insert(MemberDTO memberDTO);
//    oauth
    public void insertOauth(OauthVO oauthVO);
//    로그인
    public Optional<MemberVO> selectMemberForLogin(MemberDTO memberDTO);

}
