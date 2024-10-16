package com.example.bank_system.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportType reportType;

    @Column(name = "report_date", updatable = false)
    private LocalDateTime reportDate;

    @Column
    private String data;

    public enum ReportType {
        TRANSACTION_HISTORY, LOAN_STATUS
    }
}
