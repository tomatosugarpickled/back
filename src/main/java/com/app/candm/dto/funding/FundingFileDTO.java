package com.app.candm.dto.funding;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.FileVO;
import com.app.candm.domain.FundingFileVO;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class FundingFileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
    private Long fundingId;
    private String createdDatetime;
    private String updatedDatetime;

    public FileVO toFileVO(){
        return FileVO.builder()
                .id(id)
                .filePath(filePath)
                .fileName(fileName)
                .fileOriginalName(fileOriginalName)
                .fileSize(fileSize)
                .fileContentType(fileContentType)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }

    public FundingFileVO toFundingFileVO(){
        return FundingFileVO.builder()
                .id(id)
                .fundingId(fundingId)
                .build();
    }
}












