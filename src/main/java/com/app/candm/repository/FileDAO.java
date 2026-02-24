package com.app.candm.repository;

import com.app.candm.domain.FileVO;
import com.app.candm.dto.FileDTO;
import com.app.candm.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    //    추가
    public void save(FileDTO fileDTO) {
        fileMapper.insert(fileDTO);
    }

    //    삭제
    public void delete(Long id){
        fileMapper.delete(id);
    }

    //    조회
    public Optional<FileVO> findById(Long id){
        return fileMapper.selectById(id);
    }
}
















