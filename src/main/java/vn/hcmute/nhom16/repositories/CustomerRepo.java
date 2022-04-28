package vn.hcmute.nhom16.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vn.hcmute.nhom16.entities.Customer;

import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:13 AM
 * Filename : CustomerRepo
 */
public interface CustomerRepo extends MongoRepository<Customer,String> {

    @Query(value = "{'email': ?0}")
    Optional<Customer> getCustomerByEmail(String email);
}
