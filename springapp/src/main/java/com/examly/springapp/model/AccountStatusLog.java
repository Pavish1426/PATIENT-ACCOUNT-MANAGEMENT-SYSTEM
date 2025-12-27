package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountStatusLog {
    
    @Id
    private Long logId;
    private Long userAccountId;
    private String oldStatus;
    private String newStatus;
    private String changedDate;


}
