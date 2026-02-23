package com.app.candm.domain;

import com.app.candm.audit.Period;
import com.app.candm.audit.Period;
import com.app.candm.common.enumeration.FileContentType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(of="id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class FileVO extends Period {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
}












