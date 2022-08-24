package com.schoolfeespayment.payment.bank.account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query(value = "SELECT * FROM accounts WHERE parent_id = :parent_id", nativeQuery = true)
    List<Account> getUserAccountsById(@Param ("parent_id") int parent_id);

    @Query(value = "SELECT * FROM accounts WHERE parent_id = :parent_id", nativeQuery = true)
    BigDecimal getTotalBalance(@Param ("parent_id") int parent_id);

    @Modifying
    @Query(value = "UPDATE accounts SET balance =:new_balance WHERE account_id=:account_id", nativeQuery = true)
    @Transactional
    void changeAccountBalanceById(@Param("new_balance") double new_balance, @Param ("account_id") int account_id);


    @Modifying
    @Query(value = "INSERT INTO accounts(parent_id, account_number, account_name, account_type) VALUES" +
            "(:parent_id, :account_number, :account_name, :account_type)", nativeQuery= true)

    @Transactional
    void createBankAccount(@Param ("parent_id") int parent_id,
                           @Param ("account_number") String account_number,
                           @Param ("account_name") String account_name,
                           @Param ("account_type") String account_type);

    @Query(value = "SELECT balance FROM accounts WHERE parent_id = :parent_id AND account_id=:account_id", nativeQuery = true)
    double getAccountBalance(@Param ("parent_id") int parent_id,
                             @Param ("account_id") int account_id);




    //Account findByAccountNumberEquals(String accountNumber);

}
