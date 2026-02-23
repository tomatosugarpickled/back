package com.app.candm.mapper;

import com.app.candm.domain.FileVO;
import com.app.candm.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface FileMapper {
//    추가
    public void insert(FileDTO fileDTO);
//    삭제
    public void delete(Long id);
//    조회
    public Optional<FileVO> selectById(Long id);
}
