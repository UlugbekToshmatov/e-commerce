package com.example.customer.model.customer;

import com.example.customer.model.customer.dto.CustomerRequest;
import com.example.customer.model.customer.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.customer.model.customer.Mapper.toCustomer;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public String createCustomer(CustomerRequest request) {
        return customerRepository.save(toCustomer(request)).getId();
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(Mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomer(String id) {
        return customerRepository.findById(id)
                .map(Mapper::fromCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public String updateCustomer(String id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customerRepository.save(toCustomer(request, customer)).getId();
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
