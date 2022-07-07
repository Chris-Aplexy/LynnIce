package com.lynicecreamapp.lyn_user_service.service;

import com.lynicecreamapp.lyn_user_service.model.Address;
import com.lynicecreamapp.lyn_user_service.model.Phone;
import com.lynicecreamapp.lyn_user_service.model.User;
import com.lynicecreamapp.lyn_user_service.repository.AddressRepository;
import com.lynicecreamapp.lyn_user_service.repository.PhoneRepository;
import com.lynicecreamapp.lyn_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PhoneRepository phoneRepository;

    public User registerUser(User user){

        User user1 = userRepository.findByUserName(user.getUserName());
        Phone phone = phoneRepository.findByLocalNumber(user.getPhone().getLocalNumber());

        Address address1 = addressRepository.findByCity(user.getBillingAddress().getCity());
        Address address2 = addressRepository.findByCity(user.getShippingAddress().getCity());

        if(address1 == null || address1.equals(user.getBillingAddress())) addressRepository.save(user.getBillingAddress()); //mapping only unique billing addresses in the database
        else user.setBillingAddress(address1);
        if(address2 == null || address1.equals(user.getShippingAddress())) addressRepository.save(user.getShippingAddress());  //mapping only unique shipping addresses in the database
        else user.setShippingAddress(address2);

        if(phone == null)  phoneRepository.save(user.getPhone()); //mapping a unique contact in the database table for phone
        else user.setPhone(phone);

        if(user1 == null) userRepository.save(user); //mapping users with unique usernames only

        return user;
    }

    public User ViewUser( long id){
        return userRepository.findById(id).get();
    }

    public List<User> viewAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(long id,User user){
        User oldUser = userRepository.findById(id).get();

        if(!(user.getUserName()==null)) oldUser.setUserName(user.getUserName());
        if(!(user.getPassword()==null)) oldUser.setPassword(user.getPassword());
        if(!(user.getFirstName()==null)) oldUser.setFirstName(user.getFirstName());
        if(!(user.getLastName()==null)) oldUser.setLastName(user.getLastName());
        if(!(user.getEmail()==null)) oldUser.setEmail(user.getEmail());
        if(!(user.getDateOfBirth()==null)) oldUser.setDateOfBirth(user.getDateOfBirth());
        if(!(user.getPhone()==null)) oldUser.setPhone(user.getPhone());
        if(!(user.getGender()==null))oldUser.setGender(user.getGender());
        if(!(user.getNinNumber()==null)) oldUser.setNinNumber(user.getNinNumber());
        if(!(user.getBillingAddress()==null)) oldUser.setBillingAddress(user.getBillingAddress());
        if(!(user.getShippingAddress()==null)) oldUser.setShippingAddress(user.getShippingAddress());

        return userRepository.save(oldUser);
    }

    public String deleteUserById(long id){
        userRepository.deleteById(id);
        return "user " +id +" deleted Successfully";
    }

    public  String deleteMultipleById(List<Long> idsSelected){
        userRepository.deleteAllById(idsSelected);
        return "Users " +idsSelected +" deleted successfully";
    }

}
