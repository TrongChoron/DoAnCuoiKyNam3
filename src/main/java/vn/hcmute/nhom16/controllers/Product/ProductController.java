package vn.hcmute.nhom16.controllers.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.hcmute.nhom16.dtos.ProductDto;
import vn.hcmute.nhom16.entities.Product;
import vn.hcmute.nhom16.service.IProductService;

import java.net.URI;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 5/30/2022
 * Time     : 22:37
 * Filename : ProductController
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @PostMapping("/product/save")
    public ResponseEntity<Product> insertProduct(@RequestBody ProductDto productDto){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/product/save").toUriString());
        return ResponseEntity.created(uri).body(productService.addNewProduct(productDto));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }

}
