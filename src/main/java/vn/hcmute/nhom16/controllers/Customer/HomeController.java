package vn.hcmute.nhom16.controllers.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.service.UserService;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:04 AM
 * Filename : Customer
 */
@RestController
@RequestMapping("api/v1/customer")
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getCustomerById(@PathVariable String id){
        return userService.getCustomerById(id);
    }

    @GetMapping("/email")
    public User getCustomerByEmail(String email){
        return userService.getCustomerByEmail(email);
    }
}
