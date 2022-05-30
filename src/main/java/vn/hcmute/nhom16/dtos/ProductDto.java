package vn.hcmute.nhom16.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmute.nhom16.entities.TypeProduct;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/12/2022
 * Time     : 13:00
 * Filename : ProductDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String pic;
    private String description;
    private double price;
    private boolean status;
    private TypeProduct typeProduct;
}
