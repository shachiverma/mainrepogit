package bankingsystem.userservice.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountId;
    private String customerId;
    private String accountSystemId;
    private String bank;

    private Accounts accounts;

}
