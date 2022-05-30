package vn.hcmute.nhom16.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.hcmute.nhom16.entities.TypeProduct;
import vn.hcmute.nhom16.exceptions.NotFoundException;
import vn.hcmute.nhom16.repositories.TypeProductRepo;
import vn.hcmute.nhom16.service.ITypeProductService;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 5/30/2022
 * Time     : 22:42
 * Filename : TypeProductService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TypeProductService implements ITypeProductService {

    private final TypeProductRepo typeProductRepo;

    @Override
    public List<TypeProduct> getAllTypeProduct() {
        return typeProductRepo.findAll();
    }

    @Override
    public TypeProduct getProductByName(String typeName) {
        return typeProductRepo.findByName(typeName)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy loại sản phẩm mang tên %s",typeName)));
    }

    @Override
    public TypeProduct addNewTypeProduct(String typeName) {
        Boolean typeExist = typeProductRepo
                .findByName(typeName)
                .isPresent();
        if (typeExist) {
            throw new IllegalStateException("Type already taken");
        }
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setName(typeName);
        typeProductRepo.save(typeProduct);
        return typeProduct;
    }

    @Override
    public TypeProduct updateTypeProduct(String id, TypeProduct typeProduct) {
        TypeProduct typeProductExist = typeProductRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy loại sản phẩm mang tên %s",typeProduct.getName())));
        typeProduct.setName(typeProduct.getName());
        typeProductRepo.save(typeProduct);
        return typeProduct;
    }
}
