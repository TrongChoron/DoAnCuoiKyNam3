package vn.hcmute.nhom16.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import vn.hcmute.nhom16.entities.Customer;
import vn.hcmute.nhom16.exceptions.NotFoundException;
import vn.hcmute.nhom16.repositories.CustomerRepo;
import vn.hcmute.nhom16.service.CustomerService;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Sat, 4/23/2022
 * Time     : 9:05 AM
 * Filename : CustomerService
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepo.getCustomerByEmail(email)
                .orElseThrow(() -> new NotFoundException(String.format("Nhân viên có email %s không tồn tại", email)));
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Nhân viên có id %s không tồn tại", id)));
    }
}
