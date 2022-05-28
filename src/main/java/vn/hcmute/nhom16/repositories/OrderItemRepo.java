package vn.hcmute.nhom16.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.hcmute.nhom16.entities.LineItem;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Tue, 5/24/2022
 * Time     : 12:48
 * Filename : OrderItemRepo
 */
public interface OrderItemRepo extends MongoRepository<LineItem,String> {
}
