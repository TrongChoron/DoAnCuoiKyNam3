package vn.hcmute.nhom16.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/5/2022
 * Time     : 12:47 PM
 * Filename : Order
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderDetail")
public class OrderDetail {
    @Id
    private String id;
    private double total;
    private Timestamp createAt;
    private List<OrderItem> orderItemList;
}
