package bankingsystem.accountmanagement.repositories;

import bankingsystem.accountmanagement.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts,String> {


}
