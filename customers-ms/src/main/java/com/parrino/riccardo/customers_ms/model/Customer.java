package com.parrino.riccardo.customers_ms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String username;
    private String name;
    // private String surname;
    // private String city;
    // private String email;
    // private String phoneNumber;
}
