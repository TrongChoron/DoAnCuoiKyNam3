package vn.hcmute.nhom16.service;

import vn.hcmute.nhom16.entities.TypeProduct;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 5/30/2022
 * Time     : 22:40
 * Filename : ITypeProductService
 */
public interface ITypeProductService {
    List<TypeProduct> getAllTypeProduct();

    TypeProduct getProductByName(String typeName);

    TypeProduct addNewTypeProduct(String typeName);

    TypeProduct updateTypeProduct(String id, TypeProduct typeProduct);
}
