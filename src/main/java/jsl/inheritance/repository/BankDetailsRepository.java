package jsl.inheritance.repository;

import jsl.inheritance.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository<T extends BankDetails, ID> extends JpaRepository<T, ID> {
}
