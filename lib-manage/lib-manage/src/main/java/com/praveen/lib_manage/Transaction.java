package com.praveen.lib_manage;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long bookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String status;
}
