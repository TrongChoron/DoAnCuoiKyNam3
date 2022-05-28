package vn.hcmute.nhom16.service.impl;

import com.stc.vietnamstringutils.VietnameseStringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.Role;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.repositories.RoleRepo;
import vn.hcmute.nhom16.service.exceptions.InvalidException;
import vn.hcmute.nhom16.service.exceptions.NotFoundException;
import vn.hcmute.nhom16.repositories.UserRepo;
import vn.hcmute.nhom16.service.IUserService;
import vn.hcmute.nhom16.utils.PageUtils;

import java.util.*;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:05 AM
 * Filename : CustomerService
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final VietnameseStringUtils vietnameseStringUtils;

    @Value("123456")
    private String defaultPassword;

    @Override
    public Page<User> getUserPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return userRepo.getUserPaging(vietnameseStringUtils.makeSearchRegex(search), pageable);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.getUserByEmail(email)
                .orElseThrow(() -> new NotFoundException(String.format("Tài khoản có Email %s không tồn tại", email)));
    }

    @Override
    public User addNewUser(UserDto userDto) {
        Boolean userExists = userRepo
                .findByEmail(userDto.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }
        String hash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));
        Role role = roleRepo.findByName("ROLE_CUSTOMER");
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(hash);
        user.getRoles().add(role);
        userRepo.save(user);

        return user;
    }

    @Override
    public User createAdmin(UserDto dto) {
        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new InvalidException("Email không được bỏ trống");
        }
        User userCoreByEmail = getUserByEmail(dto.getEmail());
        if (!ObjectUtils.isEmpty(userCoreByEmail)) {
            throw new InvalidException(String.format("Tài khoản có email %s đã tồn tại", dto.getEmail()));
        }
        User user = new User();
        user.setEmail(dto.getEmail());
        if (!ObjectUtils.isEmpty(dto.getPassword())) {
            user.setPassword(dto.getPassword());
        } else {
            user.setPassword(defaultPassword);
        }
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        userRepo.save(user);
        return user;
    }

    @Override
    public User getUserByEmailAndPassword(UserDto userDto) {
        User user = userRepo.findByEmail(userDto.getEmail())
                .orElseThrow(() ->
                        new NotFoundException(String.format("User not found with email: {}", userDto.getEmail())));
//        String hash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12));
        if (BCrypt.checkpw(userDto.getPassword(), user.getPassword())) {
            return user;
        }else {
            throw new NotFoundException(String.format("User not found with pass: {}", userDto.getPassword()));
        }

    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new NotFoundException(String.format("User not found with email: {}", email)));
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
    }

    @Override
    public User updateUser(String id, UserDto userDto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Tài khoản có id %s không tồn tại", id)));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        if (!userDto.getEmail().toLowerCase().trim().equals(user.getEmail()) &&
                getUserByEmail(userDto.getEmail().toLowerCase().trim()) == null) {
            user.setEmail(userDto.getEmail().toLowerCase().trim());
        }
        userRepo.save(user);
        return user;
    }


}
