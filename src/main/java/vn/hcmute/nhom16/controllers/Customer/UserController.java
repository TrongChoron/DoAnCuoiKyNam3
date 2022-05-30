package vn.hcmute.nhom16.controllers.Customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.service.IUserService;

import java.net.URI;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:04 AM
 * Filename : Customer
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
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

    @GetMapping("/email")
    public ResponseEntity<User> getCustomerByEmail(@RequestBody String email) {

        return new ResponseEntity<>(IUserService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(IUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> insertUser(@RequestBody UserDto userDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(IUserService.addNewUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/login").toUriString());
        return ResponseEntity.created(uri).body(IUserService.getUserByEmailAndPassword(userDto));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        IUserService.addRoleToUser(form.getUserEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(IUserService.updateUser(id, userDto), HttpStatus.OK);
    }

}

@Data
class RoleToUserForm {
    private String userEmail;
    private String roleName;
}
