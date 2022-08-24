package com.schoolfeespayment.payment.bank.payment;

import com.schoolfeespayment.POJO.Parent;
import com.schoolfeespayment.payment.bank.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path ="/api")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;



    @PostMapping(path ="/payment")
    public String payment(@RequestParam ("account_id")String account_id,
                          @RequestParam("reg_number") String reg_number,
                          @RequestParam("reference") String reference,
                          @RequestParam("school_account") String school_account,
                          @RequestParam("amount")  String amount,
                          HttpSession session,
                          RedirectAttributes redirectAttributes ) {

        String errorMessage;
        String successMessage;
        //TODO:CHECK FOR EMPTY VALUES:
        if(account_id.isEmpty()){
            errorMessage =" user account number cannot be empty";
            redirectAttributes.addFlashAttribute ("error", errorMessage);
            return "redirect:/api/payment";
        }

        //TODO:CONVERT VARIABLES:
        int accountID = Integer.parseInt (account_id);
        double paymentAmount = Double.parseDouble (amount);

        //TODO:CHECK FOR 0 (ZERO) VALUES:
        if(paymentAmount ==0){
            errorMessage =" payment amount cannot be zero";
            redirectAttributes.addFlashAttribute ("error", errorMessage);
            return "redirect:/api/payment";

        }
//
//        //TODO:GET LOGGED USER
//       User user = (User) session.getAttribute("user");
//
//
//        // TODO: GET CURRENT BALANCE
//
//         double currentBalance = accountRepository.getAccountBalance(user.getUser_id (), accountID);
////        double currentBalance = 10000;
////
//        // TODO: CHECK IF PAYMENT AMOUNT IS MOR THAN CURRENT BALANCE
//
//        if(currentBalance < paymentAmount) {
//            errorMessage =" You have insufficient funds";
//            redirectAttributes.addFlashAttribute ("error", errorMessage);
//            return "redirect:/api/payment";
//
//        }
//
//        //TODO: SET NEW BALANCE FOR ACCOUNT PAYING FOR
//        double newBalance = currentBalance - paymentAmount;
//
////        //TODO: UPDATE ACCOUNT PAYING FROM
//        accountRepository.changeAccountBalanceById(newBalance, accountID);
////
        //TODO: MAKE PAYMENT
        String reasonCode = "payment processed suceessful";
        LocalDateTime currentDateTime = LocalDateTime.now ();
        // String reference = null;
        paymentRepository.makePayment(accountID,reg_number,school_account, paymentAmount,reference, "success", reasonCode, currentDateTime);

        successMessage =" payment was successful";
        redirectAttributes.addFlashAttribute ("error", successMessage);
        return "redirect:/api/payment";


    }

    @GetMapping("/payment_history")
    public ModelAndView getPaymentHistory(HttpSession session){
        // Set View:
        ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

        // Get Logged In User:\
        Parent user = (Parent) session.getAttribute("user");

        // Get Payment History / Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getParent_id ());

        getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

        return getPaymentHistoryPage;

    }

//    @PostMapping("/withdraw")
//    public String withdraw(@RequestParam("withdraw_amount") String withdrawalAmount,
//                           @RequestParam("account_id") String accountID,
//                           HttpSession session,
//                           RedirectAttributes redirectAttributes){
//
//        String errorMessage;
//        String successMessage;
//
//        if(withdrawalAmount.isEmpty () ){
//            errorMessage="withdrawal amount cannot be empty";
//            redirectAttributes.addFlashAttribute ("error", errorMessage);
//            return "redirect:/app/dashboard";
//        }
//
//        double withdrawal_amount = Double.parseDouble (withdrawalAmount);
//        int account_id = Integer.parseInt (accountID);
//
//        if(withdrawal_amount ==0){
//            errorMessage="withdrawal amount cannot be zero";
//            redirectAttributes.addFlashAttribute ("error", errorMessage);
//            return "redirect:/app/dashboard";
//        }
//
//        //TODO:GET LOGGED USER
//        User user = (User) session.getAttribute("user");
//
//
//        // TODO: GET CURRENT BALANCE
//
//        double currentBalance = accountRepository.getAccountBalance(user.getUser_id (), account_id);
//
//        double newBalance = currentBalance - withdrawal_amount;
//
//        accountRepository.changeAccountBalanceById(newBalance, account_id);
//
//        successMessage ="withdrawal successful";
//        redirectAttributes.addFlashAttribute ("success", successMessage);
//        return "redirect/app/dashboard";
//
//    }
}
