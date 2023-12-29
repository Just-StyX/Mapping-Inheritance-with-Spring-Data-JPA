package jsl.inheritance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jsl.inheritance.values.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Objects;

@Getter
@Setter
@Entity
@Immutable
@AllArgsConstructor
@Table(name = "bank_account")
@PrimaryKeyJoinColumn(name = "bank_account_id")
public class BankAccount extends BankDetails{
    @NotNull
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @NotNull
    @Column(name = "swift", nullable = false, unique = true)
    private String swift;

    public BankAccount() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountType == that.accountType && Objects.equals(bankName, that.bankName) && Objects.equals(swift, that.swift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, bankName, swift);
    }
}
