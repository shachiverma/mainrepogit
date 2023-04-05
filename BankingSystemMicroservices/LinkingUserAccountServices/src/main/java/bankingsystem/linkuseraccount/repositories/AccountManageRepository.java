package bankingsystem.linkuseraccount.repositories;

import bankingsystem.linkuseraccount.entities.AccountManage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountManageRepository extends JpaRepository<AccountManage,String> {

    //customfindermethods

    List<AccountManage> findByCustomerId(String customerId);
}
