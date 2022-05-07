package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 5/7/2022
 * Time     : 11:05 PM
 * Filename : OrderItem
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderItem")
public class OrderItem {
    private String id;
    private String name;
}
