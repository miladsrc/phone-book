package com.demo.service;

import com.demo.dto.ContactDto;
import com.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto todoDto);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto, Long id);

    void deleteUser(Long id);
}
