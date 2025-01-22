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


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ContactRepository contactRepository;


    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Set<Contact> contacts = userDto.getContact().stream()
                .map(contactDto -> {
                    Contact contact = modelMapper.map(contactDto, Contact.class);
                    contact.setUser(user);
                    return contact;
                })
                .collect(Collectors.toSet());
        user.setContact(null);
        user.setContact(contacts);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
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

    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userRepository.saveAndFlush(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }
}
