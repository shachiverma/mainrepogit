package bankingsystem.linkuseraccount.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bankdetails")
public class AccountManage {

    @Id
    private String accountId;
    private String customerId;
    private String accountSystemId;
    private String bank;
}
