package com.user_service.service;


import com.user_service.entity.ContactDetails;
import com.user_service.entity.User;

public interface UserService {
    String createUser(User user);
    String updateUser(User user);
    String deleteUser(String userId);
    String addContact(ContactDetails contactDetails, String customerId);
    Object getCustomer(String customerId);
}
