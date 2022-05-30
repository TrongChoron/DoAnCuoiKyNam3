package vn.hcmute.nhom16.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hcmute.nhom16.entities.Product;
import vn.hcmute.nhom16.entities.TypeProduct;

import java.util.List;
import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/12/2022
 * Time     : 13:03
 * Filename : ProductRepo
 */
public interface ProductRepo extends MongoRepository<Product,String> {

//    @Query()
//    Page<Product> getProductPaging(String search, Pageable pageable);


    Optional<Product> findByName(String name);

    @Query(value = "{'productType': ?0}")
    List<Product> getProductByType(TypeProduct typeProduct);
}
