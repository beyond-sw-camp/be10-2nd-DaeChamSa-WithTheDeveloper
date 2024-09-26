package com.developer.report.command.dto;

import com.developer.report.command.entity.Report;
import com.developer.report.command.entity.ReportReasonCategory;
import com.developer.report.command.entity.ReportType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportCreateDTO {

    private String repoDescription; // 신고 상세 내용

    private ReportReasonCategory reportReasonCategory;  // 신고 사유 카테고리

    // DTO -> Entity
    public Report toEntity() {
        return Report.builder()
                .reportDescription(repoDescription)
                .build();
    }
}
