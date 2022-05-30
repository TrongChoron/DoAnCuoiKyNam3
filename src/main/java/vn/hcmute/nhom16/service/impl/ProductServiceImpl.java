package vn.hcmute.nhom16.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.hcmute.nhom16.dtos.ProductDto;
import vn.hcmute.nhom16.entities.Product;
import vn.hcmute.nhom16.entities.TypeProduct;
import vn.hcmute.nhom16.exceptions.NotFoundException;
import vn.hcmute.nhom16.repositories.ProductRepo;
import vn.hcmute.nhom16.repositories.TypeProductRepo;
import vn.hcmute.nhom16.service.IProductService;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 5/12/2022
 * Time     : 12:59
 * Filename : ProductServiceImpl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepo productRepo;
    private final TypeProductRepo typeProductRepo;


//    @Override
//    public Page<Product> getProductPaging(String search, int page, int size, String sort, String column) {
//        return null;
//    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepo.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Product with id %s not found",id)));
    }

    @Override
    public List<Product> getProductByType(TypeProduct typeProduct) {
        return productRepo.getProductByType(typeProduct);
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        Boolean productExists = productRepo
                .findByName(productDto.getName())
                .isPresent();
        if (productExists) {
            throw new IllegalStateException("Product already taken");
        }
        TypeProduct typeProduct =
                typeProductRepo.findByName(productDto.getTypeProduct().getName())
                        .orElseThrow(() -> new NotFoundException(String.format("Type has been exist")));
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPic(productDto.getPic());
        product.setStatus(productDto.isStatus());
        product.setTypeProduct(typeProduct);
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(String id, ProductDto productDto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Sản phẩm không tồn tại")));
        TypeProduct typeProduct =
                typeProductRepo.findByName(productDto.getTypeProduct().getName())
                        .orElseThrow(() -> new NotFoundException(String.format("Type has been exist")));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPic(productDto.getPic());
        product.setStatus(productDto.isStatus());
        product.setTypeProduct(typeProduct);
        productRepo.save(product);
        return product;
    }
}
