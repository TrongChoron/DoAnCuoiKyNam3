package vn.hcmute.nhom16.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.hcmute.nhom16.entities.Role;
import vn.hcmute.nhom16.entities.User;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 5/28/2022
 * Time     : 13:33
 * Filename : RoleRepo
 */
public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByName(String name);
}
