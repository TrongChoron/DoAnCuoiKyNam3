package vn.hcmute.nhom16.service;

import vn.hcmute.nhom16.entities.Customer;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:08 AM
 * Filename : CustomerService
 */
public interface CustomerService {
Customer getCustomerByEmail(String email);
Customer getCustomerById(String id);
}
