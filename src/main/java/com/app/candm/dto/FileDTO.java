package com.app.candm.dto;

import com.app.candm.common.enumeration.FileContentType;
import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class FileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
    private String createdDatetime;
    private String updatedDatetime;
}












