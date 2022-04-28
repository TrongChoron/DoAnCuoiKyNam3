package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:09 AM
 * Filename : Customer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String email;
    private String password;
}
