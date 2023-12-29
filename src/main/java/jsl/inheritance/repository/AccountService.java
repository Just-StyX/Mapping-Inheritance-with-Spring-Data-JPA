package jsl.inheritance.repository;

import jsl.inheritance.entity.BankAccount;
import jsl.inheritance.entity.CreditCard;
import jsl.inheritance.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final BankAccountRepository bankAccountRepository;
    private final CreditCardRepository creditCardRepository;
    private final UserInfoRepository userInfoRepository;

    public AccountService(BankAccountRepository bankAccountRepository, CreditCardRepository creditCardRepository,
                          UserInfoRepository userInfoRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.creditCardRepository = creditCardRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public void saveUser(UserInfo userInfo) { userInfoRepository.save(userInfo); }
    public UserInfo findUser(String id) { return userInfoRepository.findById(id).orElseThrow(); }
    public void saveCreditCard(CreditCard creditCard) { creditCardRepository.save(creditCard); }
    public void saveBankAccount(BankAccount bankAccount) { bankAccountRepository.save(bankAccount); }
}
