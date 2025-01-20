package com.example.demo.dto;



import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String username;
    private String password;
    private String email;
    //    private Set<Contact> contact;
}



