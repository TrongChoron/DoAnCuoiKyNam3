package vn.hcmute.nhom16.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.email.EmailValidator;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.service.IUserService;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Fri, 5/27/2022
 * Time     : 18:29
 * Filename : RegisterController
 */
@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegisterController {
    private final IUserService userService;
    private final EmailValidator emailValidator;

    @PostMapping()
    public User register(@RequestBody UserDto userDto) {
        boolean isValidEmail = emailValidator.test(userDto.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is invalid");
        }
        return userService.addNewUser(userDto);
    }

}
