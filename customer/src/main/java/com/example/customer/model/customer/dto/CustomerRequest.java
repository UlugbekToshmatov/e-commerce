package com.example.customer.model.customer.dto;

import com.example.customer.model.customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
    @NotNull(message = "Firstname is required")
    String firstname,

    @NotNull(message = "Lastname is required")
    String lastname,

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email address")
    String email,

    @NotNull(message = "Address is required")
    Address address
) {

}
