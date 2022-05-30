package vn.hcmute.nhom16.controllers.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.hcmute.nhom16.dtos.UserDto;
import vn.hcmute.nhom16.entities.TypeProduct;
import vn.hcmute.nhom16.entities.User;
import vn.hcmute.nhom16.service.ITypeProductService;

import java.net.URI;
import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 5/30/2022
 * Time     : 22:49
 * Filename : TypeProductController
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TypeProductController {

    private final ITypeProductService typeProductService;

    @GetMapping("/types")
    public ResponseEntity<List<TypeProduct>> getAllType(){
        return ResponseEntity.ok().body(typeProductService.getAllTypeProduct());
    }

    @PostMapping("/type/save")
    public ResponseEntity<TypeProduct> insertType(@RequestBody String typeName){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/type/save").toUriString());
        return ResponseEntity.created(uri).body(typeProductService.addNewTypeProduct(typeName));
    }

    @PutMapping("/type/{id}")
    public ResponseEntity<TypeProduct> updateType(@PathVariable String id, @RequestBody TypeProduct typeProduct) {
        return new ResponseEntity<>(typeProductService.updateTypeProduct(id, typeProduct), HttpStatus.OK);
    }

}
