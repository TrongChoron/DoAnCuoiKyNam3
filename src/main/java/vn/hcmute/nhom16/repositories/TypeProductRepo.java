package vn.hcmute.nhom16.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.hcmute.nhom16.entities.TypeProduct;

import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 5/30/2022
 * Time     : 22:37
 * Filename : TypeProductRepo
 */
public interface TypeProductRepo extends MongoRepository<TypeProduct,String> {
    Optional<TypeProduct> findByName(String name);
}
