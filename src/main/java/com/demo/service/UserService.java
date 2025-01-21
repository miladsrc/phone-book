package com.demo.service;

import com.demo.dto.UsersDto;

import java.util.List;

public interface UserService {

    UsersDto addUser(UsersDto todoDto);

    UsersDto getUser(Long id);

    List<UsersDto> getAllUsers();

    UsersDto updateUser(UsersDto userDto, Long id);

    void deleteUser(Long id);

}
