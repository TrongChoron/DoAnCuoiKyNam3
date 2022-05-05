package vn.hcmute.nhom16.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vn.hcmute.nhom16.entities.User;

import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:13 AM
 * Filename : CustomerRepo
 */
public interface UserRepo extends MongoRepository<User,String> {
    @Query(value = "{$or: [{'email' : { $regex: ?0, $options: 'i' } }, {'name' : { $regex: ?0, $options: 'i' } }] }"
            , sort = "{'enable' : -1, 'email' : 1}")
    Page<User> getUserPaging(String search, Pageable pageable);

    Optional<User> findByEmail(String email);
    @Query(value = "{'email': ?0}")
    Optional<User> getUserByEmail(String email);
}
