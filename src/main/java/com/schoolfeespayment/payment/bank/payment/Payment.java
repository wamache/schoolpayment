package com.schoolfeespayment.payment.bank.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
  //  @Column(name = "id", nullable = false)
    private int payment_id;
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
