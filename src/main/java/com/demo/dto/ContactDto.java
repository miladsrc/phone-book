package com.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
