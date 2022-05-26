package vn.hcmute.nhom16.controllers.Customer;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.service.IUserService;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:04 AM
 * Filename : Customer
 */
@RestController
@RequestMapping("api/v1/user")
public class HomeController {
    private final IUserService IUserService;

    @GetMapping("/paging")
    public ResponseEntity<Page<User>> getNhanVienPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "asc") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "email") String column
    ) {
        return new ResponseEntity<>(IUserService.getUserPaging(search, page, size, sort, column), HttpStatus.OK);
    }
    public HomeController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){

        return new ResponseEntity<>(IUserService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<User> getCustomerByEmail(@RequestBody String email){

        return new ResponseEntity<>(IUserService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return IUserService.getUsers();
    }

    @PostMapping()
    public ResponseEntity<User> insertUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(IUserService.addNewUser(userDto),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDto userDto){
        return new ResponseEntity<>(IUserService.updateUser(id, userDto),HttpStatus.OK);
    }

}
