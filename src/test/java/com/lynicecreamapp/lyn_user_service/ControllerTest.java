package com.lynicecreamapp.lyn_user_service;

import com.lynicecreamapp.lyn_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {
    @Autowired
    UserRepository userRepository;

    /*public void addingUser(){
        Phone phone = new Phone(6,"256",2883892,"jwjhjw");
        Address address1 = new Address("william","kla","","","")
        User user = new User("mwesigwa","christopher","mcaplexya@gmail.com","2001-08-06",phone,"MALE","CNJ39849393345",ADDRESS1,ADDRESS2,"chris","aplexy")
    }*/
}
