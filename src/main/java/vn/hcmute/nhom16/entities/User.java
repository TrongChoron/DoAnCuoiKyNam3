package vn.hcmute.nhom16.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.hcmute.nhom16.utils.EnumRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:09 AM
 * Filename : Customer
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "user")
public class User{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String avatar;
    private Address address;
    private Collection<Role> roles = new ArrayList<>();
    public User(String firstName, String lastName, String email, String password, String avatar
            , Address address, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.address = address;
        this.roles = roles;
    }

}
