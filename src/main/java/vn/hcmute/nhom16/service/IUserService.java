package vn.hcmute.nhom16.service;

import org.springframework.data.domain.Page;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.Role;
import vn.hcmute.nhom16.entities.User;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:08 AM
 * Filename : CustomerService
 */
public interface IUserService {
    Page<User> getUserPaging(String search, int page, int size, String sort, String column);

    List<User> getUsers();

    User getUserByEmail(String email);

    User addNewUser(UserDto userDto);

    User createAdmin(UserDto dto);

    User getUserByEmailAndPassword(UserDto userDto);

    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);

    User updateUser(String id, UserDto userDto);

}
