package com.example.demo.model;

import lombok.Data;

@Data
public class Contact {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
}
