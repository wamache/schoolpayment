package com.schoolfeespayment.payment.bank.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    private int account_id;

    private int parent_id;

    private String account_number;

    private String account_name;

    private String account_type;

    private BigDecimal balance;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}
