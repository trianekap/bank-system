package com.example.bank_system.models.dtos;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class ReportDto {

    private Long reportId;

    private UserDto user;

    private ReportType reportType;

    private LocalDateTime reportDate;

    private String data;

    public enum ReportType {
        TRANSACTION_HISTORY, LOAN_STATUS
    }
}
