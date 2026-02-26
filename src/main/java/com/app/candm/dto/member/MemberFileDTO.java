package com.app.candm.dto.member;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.FileVO;
import com.app.candm.domain.MemberFileVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class MemberFileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
    private Long memberId;
    private String createdDatetime;
    private String updatedDatetime;

    public FileVO toFileVO(){
        return FileVO.builder()
                .id(id)
                .filePath(filePath)
                .fileName(fileName)
                .fileOriginalName(fileOriginalName)
                .fileContentType(fileContentType)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }

    public MemberFileVO toPostFileVO(){
        return MemberFileVO.builder()
                .id(id)
                .memberId(memberId)
                .build();
    }

}
