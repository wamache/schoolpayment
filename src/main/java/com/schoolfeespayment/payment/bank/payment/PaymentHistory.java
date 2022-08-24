package com.schoolfeespayment.payment.bank.payment;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "paymenthistory")
public class PaymentHistory {

    @Id
    private int payment_id;

    private Long parent_id;
    private String regNumber;
    private int account_id;
    //private String school_name;
    private String school_account;
    private  double amount;
    private String reference;
    private String status;
    private String reason_code;
    private LocalDateTime created_at;

}
