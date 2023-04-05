package bankingsystem.userservice.userservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "micro_customers")
public class Customer {

    @Id
    @Column(name= "ID")
    private String customerId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name ="EMAIL")
    private String email;

    @Column(name= "DOB")
    private String dob;

    @Transient
    private List<Account> bank = new ArrayList<>();
}
