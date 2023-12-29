package jsl.inheritance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jsl.inheritance.values.Address;
import jsl.inheritance.values.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    private Email email;
    private Address address;

    @OneToMany(mappedBy = "userInfo", cascade = {CascadeType.PERSIST})
    private Set<BankDetails> bankDetails = new HashSet<>();

    public UserInfo() {}

    public UserInfo(String name, String username, Email email, Address address) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public void addBankDetails(BankDetails bankDetails) {
        this.getBankDetails().add(bankDetails);
        bankDetails.setUserInfo(this);
    }
}
