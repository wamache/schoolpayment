package com.schoolfeespayment.payment.bank.payment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface PaymentRepository extends CrudRepository<Payment , Integer> {

    @Modifying
    @Query(value = "INSERT INTO payment (account_id, reg_number, school_account, amount, reference, status, reason_code, created_at)" +
    "VALUES( :account_id, :reg_number, :school_account, :amount, :reference, :status, :reason_code, :created_at ) ", nativeQuery = true)
    //()
    @Transactional
    void makePayment(@Param ("account_id")int account_id,
                     @Param ("reg_number") String reg_number,
                     @Param("school_account") String school_account,
                     @Param("amount")  double amount,
                     @Param("reference") String reference,
                     @Param("status") String status,
                     @Param("reason_code") String reason_code,
                     @Param("created_at") LocalDateTime created_at);



}
