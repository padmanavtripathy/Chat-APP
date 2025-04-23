package com.user_service.service;


import com.user_service.entity.ContactDetails;
import com.user_service.entity.User;
import com.user_service.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        try{
            userRepository.save(user);
            return "User created Successfully";
        }catch (Exception e){
            return e.toString();
        }
    }

    @Override
    public String updateUser(User user) {
        return "";
    }

    @Override
    public String deleteUser(String userId) {
        return "";
    }

    @Override
    public String addContact(ContactDetails contactDetails, String customerId) {
        Optional<User> userOpt = userRepository.findById(customerId);
        Optional<User> contactOpt = userRepository.findById(contactDetails.getContactID());

        if (userOpt.isEmpty() || userOpt.get().getMobileNumber().isBlank()) {
            return "Please enter a valid User";
        }

        if (contactOpt.isEmpty()) {
            return "Entered customer is not Registered";
        }

        User user = userOpt.get();
        List<ContactDetails> existingContacts = Optional.ofNullable(user.getContactDetails()).orElse(new ArrayList<>());

        boolean alreadyExists = existingContacts.stream()
                .anyMatch(c -> c.getContactID().equals(contactDetails.getContactID()));

        if (alreadyExists) {
            return "Contact is Already Present in the Contact List";
        }

        existingContacts.add(contactDetails);

        // Create updated user with new contact list
        User updatedUser = new User();
        BeanUtils.copyProperties(user, updatedUser);
        updatedUser.setContactDetails(existingContacts);

        System.out.println("User details saved in DB: " + updatedUser);
        userRepository.save(updatedUser);

        return "Contact Added Successfully";
    }

    @Override
    public Object getCustomer(String customerId) {
        try {
            return userRepository.findById(customerId);
        } catch (Exception e) {
            return "User not found for the given url";
        }

    }
}
