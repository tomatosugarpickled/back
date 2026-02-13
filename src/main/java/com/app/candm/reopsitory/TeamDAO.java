package com.app.candm.reopsitory;

import com.app.candm.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TeamDAO {
    private final TeamMapper teamMapper;


}
