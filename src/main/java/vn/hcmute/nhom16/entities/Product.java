package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Wed, 5/4/2022
 * Time     : 9:38 PM
 * Filename : Products
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {                                                              
    @Id
    private String id;
    private String name;
    private String pic;
    private String description;
    private double price;
    // Status = False -> Ngừng kinh doanh, = True -> Còn hàng
    private boolean status;
    TypeProduct typeProduct;
}
