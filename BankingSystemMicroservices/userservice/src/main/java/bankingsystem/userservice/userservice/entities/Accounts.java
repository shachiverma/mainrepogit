package bankingsystem.userservice.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {


    private String id;
    private String accountName;
    private String depositAmount;
    private String withdrawnAmount;
    private String currentBalance;
}
