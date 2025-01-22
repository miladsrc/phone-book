package com.demo.service;

import com.demo.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto createContact(ContactDto contactDto);
    ContactDto getContact(Long id);
    List<ContactDto> getAllContacts();
    ContactDto updateContact(ContactDto contactDto, Long id);
    void deleteContact(Long id);
}
