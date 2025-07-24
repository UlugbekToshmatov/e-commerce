package com.example.customer.model.customer.dto;

import com.example.customer.model.customer.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
