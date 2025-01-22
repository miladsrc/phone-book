package com.demo.service.serviceImpl;

import com.demo.dto.UserDto;
import com.demo.entity.Contact;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.ContactRepository;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {

    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        return null;
    }

//    @Override
//    @Transactional
//    public UserDto updateUser(UserDto userDto, Long id) {
//
//        User existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
//
//        modelMapper.map(userDto, existingUser);
//
//        List<Contact> newContacts = userDto.getContacts().stream()
//                .map(contactDtos -> {
//                    return modelMapper.map(contactDtos, Contact.class);
//                })
//                .collect(Collectors.toList());
//
//        userService.updateContacts(existingUser, newContacts);
//
//        userRepository.updateContact()
//        User savedUser = userRepository.save(existingUser);
//
//        return modelMapper.map(savedUser, UserDto.class);


    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }

}
