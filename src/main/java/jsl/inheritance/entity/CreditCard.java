package jsl.inheritance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "credit_card")
@PrimaryKeyJoinColumn(name = "credit_card_id")
public class CreditCard extends BankDetails{
    @NotNull
    @Column(name = "cc_number", nullable = false, unique = true)
    private String cardNumber;

    @NotNull
    @Column(name = "exp_year", nullable = false, length = 4)
    private String expirationYear;

    @NotNull
    @Column(name = "exp_month", nullable = false, length = 3)
    private String expirationMonth;

    public CreditCard() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(expirationYear, that.expirationYear) && Objects.equals(expirationMonth, that.expirationMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, expirationYear, expirationMonth);
    }
}
