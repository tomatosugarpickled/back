package com.app.candm.mapper;

import com.app.candm.domain.TeamVO;
import com.app.candm.dto.TeamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamMapper {
//    추가
    public void insert(TeamDTO teamDTO);
//    조회
    public List<TeamVO> selectAll();

    Optional<TeamVO> selectByUrl(String teamUrl);

    Optional<TeamVO> selectByTitle(String teamTitle);
}
