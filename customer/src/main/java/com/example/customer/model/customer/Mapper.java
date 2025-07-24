package com.example.customer.model.customer;

import com.example.customer.model.customer.dto.CustomerRequest;
import com.example.customer.model.customer.dto.CustomerResponse;
import org.springframework.beans.BeanUtils;

public class Mapper {

    public static Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
            .firstname(request.firstname())
            .lastname(request.lastname())
            .email(request.email())
            .address(request.address())
            .build();
    }

    public static Customer toCustomer(CustomerRequest request, Customer customer) {
        BeanUtils.copyProperties(request, customer);
        return customer;
    }

    public static CustomerResponse fromCustomer(Customer customer) {
        return CustomerResponse.builder()
            .id(customer.getId())
            .firstname(customer.getFirstname())
            .lastname(customer.getLastname())
            .email(customer.getEmail())
            .address(customer.getAddress())
            .build();
    }

}
