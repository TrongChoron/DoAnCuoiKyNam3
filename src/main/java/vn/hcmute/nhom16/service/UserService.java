package vn.hcmute.nhom16.service;

import org.springframework.data.domain.Page;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.User;

import java.security.Principal;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:08 AM
 * Filename : CustomerService
 */
public interface UserService {
Page<User> getUserPaging(String search, int page, int size, String sort, String collumn);
User getUser(Principal principal);
User getUserByEmail(String email);
User addNewUser(String name, String email, String password);
User createAdmin(UserDto dto);
User updateUser(String id, UserDto userDto);
List<String> getRoles();
}
