package jsl.inheritance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "bank_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "owner", nullable = false)
    private String owner;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserInfo userInfo;

}
