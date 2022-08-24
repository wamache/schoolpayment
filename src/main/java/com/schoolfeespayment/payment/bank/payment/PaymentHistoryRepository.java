package com.schoolfeespayment.payment.bank.payment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Integer> {

    @Query(value = "SELECT * FROM paymenthistory WHERE parent_id = :parent_id", nativeQuery = true)
    List<PaymentHistory> getPaymentRecordsById(@Param("parent_id")int parent_id);
}
