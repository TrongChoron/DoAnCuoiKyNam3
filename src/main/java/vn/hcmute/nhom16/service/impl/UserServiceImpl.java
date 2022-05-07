package vn.hcmute.nhom16.service.impl;

import com.stc.vietnamstringutils.VietnameseStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.exceptions.InvalidException;
import vn.hcmute.nhom16.exceptions.NotFoundException;
import vn.hcmute.nhom16.repositories.UserRepo;
import vn.hcmute.nhom16.service.UserService;
import vn.hcmute.nhom16.utils.EnumRole;
import vn.hcmute.nhom16.utils.PageUtils;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:05 AM
 * Filename : CustomerService
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final VietnameseStringUtils vietnameseStringUtils;

    public UserServiceImpl(UserRepo userRepo, VietnameseStringUtils vietnameseStringUtils) {
        this.userRepo = userRepo;
        this.vietnameseStringUtils = vietnameseStringUtils;
    }

    @Value("123456")
    private String defaultPassword;

    @Override
    public Page<User> getUserPaging(String search, int page, int size, String sort, String collumn) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, collumn);
        return userRepo.getUserPaging(vietnameseStringUtils.makeSearchRegex(search), pageable);
    }

    @Override
    public User getUser(Principal principal) {
        return userRepo.findByEmail(principal.getName())
                .orElseThrow(() -> new NotFoundException(String.format("Tài khoản có Email %s không tồn tại", principal.getName())));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.getUserByEmail(email)
                .orElse(null);
    }

    @Override
    public User addNewUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(Collections.singletonList(EnumRole.ROLE_CUSTOMER.name()));
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
        user.setName(dto.getName());
        user.setRoles(Arrays.asList(EnumRole.ROLE_ADMIN.name(), EnumRole.ROLE_CUSTOMER.name()));
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(String id, UserDto userDto) {
        User user = userRepo.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Tài khoản có id %s không tồn tại", id)));
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        if (!userDto.getEmail().toLowerCase().trim().equals(user.getEmail()) &&
                getUserByEmail(userDto.getEmail().toLowerCase().trim()) == null) {
            user.setEmail(userDto.getEmail().toLowerCase().trim());
        }
        user.setRoles(userDto.getRoles());
        userRepo.save(user);
        return user;
    }

    @Override
    public List<String> getRoles() {
        return Arrays.stream(EnumRole.values()).map(Enum::name).collect(Collectors.toList());
    }
}
