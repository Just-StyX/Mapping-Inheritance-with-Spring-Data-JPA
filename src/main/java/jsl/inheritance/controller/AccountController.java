package jsl.inheritance.controller;

import jsl.inheritance.entity.BankAccount;
import jsl.inheritance.entity.CreditCard;
import jsl.inheritance.entity.UserInfo;
import jsl.inheritance.repository.AccountService;
import jsl.inheritance.values.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<ResponseMessage> saveUser(@RequestBody UserDto userDto) {
        var address = new Address(userDto.getStreet(), userDto.getZip(), userDto.getCity());
        var email  = new Email(userDto.getEmail());
        accountService.saveUser(new UserInfo(userDto.getName(), userDto.getUsername(), email, address));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("user info saved"));
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<ResponseMessage> updateAccount(@RequestBody AccountDto accountDto, @PathVariable String id,
                                                         @RequestParam() String type) {
        var user = accountService.findUser(id);
        if (type.equals("card")) {
            var details = new CreditCard(accountDto.getCardNumber(), accountDto.getExpirationYear(), accountDto.getExpirationMonth());
            details.setOwner(user.getName());
            user.addBankDetails(details);
            accountService.saveCreditCard(details);
        } else {
            var details = new BankAccount(accountDto.getAccountType(), accountDto.getBankName(), accountDto.getSwift());
            details.setOwner(user.getName());
            user.addBankDetails(details);
            accountService.saveBankAccount(details);
        }
        var account = type.equals("card") ? "Credit Card details" : "Bank account details";
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(account + " updated"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUser(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findUser(id));
    }
}
