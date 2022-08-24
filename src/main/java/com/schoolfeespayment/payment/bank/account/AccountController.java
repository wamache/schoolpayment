package com.schoolfeespayment.payment.bank.account;


import com.schoolfeespayment.POJO.Parent;
import com.schoolfeespayment.payment.bank.helper.GenAccountNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name") String accountName,
                                @RequestParam("account_type") String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {

        if (accountName.isEmpty ()){
            redirectAttributes.addFlashAttribute ("error" , "account name cannot be empty");
            return "redirect:/dashboard";

        }

        Parent user = (Parent) session.getAttribute ("user");


        int setAccountNumber = GenAccountNumber.generateaccountNumber ();
        String bankAccountNumber = Integer.toString (setAccountNumber);


        accountRepository.createBankAccount (user.getParent_id (),bankAccountNumber,accountName,accountType );

        redirectAttributes.addFlashAttribute ("success" , "account created successfully");

        return "redirect:/dashboard";
    }
}
