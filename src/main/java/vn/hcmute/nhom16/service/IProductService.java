package vn.hcmute.nhom16.service;

import org.springframework.data.domain.Page;
import vn.hcmute.nhom16.dtos.ProductDto;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.Product;
import vn.hcmute.nhom16.entities.TypeProduct;
import vn.hcmute.nhom16.entities.User;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/12/2022
 * Time     : 12:58
 * Filename : IProductService
 */
public interface IProductService {
//    Page<Product> getProductPaging(String search, int page, int size, String sort, String column);

    List<Product> getAllProduct();

    Product getProductById(String id);

    List<Product> getProductByType(TypeProduct typeProduct);

    Product addNewProduct(ProductDto productDto);

    Product updateProduct(String id, ProductDto productDto);
}
