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
public class Address {
    @NotNull(message = "provide your street address")
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull(message = "zip code of your area. It must be at most 5 figures")
    @Column(name = "zip", nullable = false, length = 5)
    private String zip;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    public Address() {}
}
