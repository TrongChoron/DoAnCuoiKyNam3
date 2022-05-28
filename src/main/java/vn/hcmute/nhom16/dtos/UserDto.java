package vn.hcmute.nhom16.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmute.nhom16.entities.Address;
import vn.hcmute.nhom16.utils.EnumRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/5/2022
 * Time     : 1:07 PM
 * Filename : UserDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String avatar;
    private Address address;
    private Collection<EnumRole> roles = new ArrayList<>();
    private boolean locked;
    private boolean enabled;
}
