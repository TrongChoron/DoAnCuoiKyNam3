package vn.hcmute.nhom16.controllers.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmute.nhom16.entities.Customer;
import vn.hcmute.nhom16.service.CustomerService;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:04 AM
 * Filename : Customer
 */
@RestController
@RequestMapping("api/vi/customer")
public class HomeController {
    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/email")
    public Customer getCustomerByEmail(String email){
        return customerService.getCustomerByEmail(email);
    }
}
