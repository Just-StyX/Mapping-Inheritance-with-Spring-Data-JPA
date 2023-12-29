package jsl.inheritance.values;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class Email {
    @NotNull
    @Column(name = "email_address", nullable = false)
    private String email;

    public String preparedEmail(String value) {
        return null;
    }

    public Email() {}
}
