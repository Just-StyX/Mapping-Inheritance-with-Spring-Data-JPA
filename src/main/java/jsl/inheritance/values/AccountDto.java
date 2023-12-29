package jsl.inheritance.values;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private String cardNumber;
    private String expirationYear;
    private String expirationMonth;
    private AccountType accountType;
    private String bankName;
    private String swift;
}
