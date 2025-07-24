package com.example.customer.model.customer;

import com.example.core.base.HttpResponse;
import com.example.customer.model.customer.dto.CustomerRequest;
import com.example.customer.model.customer.dto.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("")
    public ResponseEntity<HttpResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
        String customerId = customerService.createCustomer(request);

        return ResponseEntity.ok(
            HttpResponse.builder()
                .statusCode(0)
                .description(HttpStatus.CREATED.name())
                .data(Map.of("customerId", customerId))
                .build()
        );
    }

    @GetMapping("")
    public ResponseEntity<HttpResponse> getAll() {
        List<CustomerResponse> customers = customerService.getAllCustomers();

        return ResponseEntity.ok(
            HttpResponse.builder()
                .statusCode(0)
                .description(HttpStatus.OK.name())
                .data(Map.of("customers", customers))
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getCustomer(@PathVariable String id) {
        CustomerResponse customer = customerService.getCustomer(id);

        return ResponseEntity.ok(
            HttpResponse.builder()
                .statusCode(0)
                .description(HttpStatus.OK.name())
                .data(Map.of("customer", customer))
                .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> updateCustomer(
        @PathVariable String id,
        @RequestBody @Valid CustomerRequest request
    ) {
        String customerId = customerService.updateCustomer(id, request);

        return ResponseEntity.ok(
            HttpResponse.builder()
                .statusCode(0)
                .description(HttpStatus.OK.name())
                .data(Map.of("customerId", customerId))
                .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);

        return ResponseEntity.accepted().body(
            HttpResponse.builder()
                .statusCode(0)
                .description(HttpStatus.ACCEPTED.name())
                .build()
        );
    }
}
