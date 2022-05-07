package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 5/7/2022
 * Time     : 10:59 PM
 * Filename : Address
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "address")
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String district;
    private String country;
}
