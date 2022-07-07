package com.lynicecreamapp.lyn_user_service.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends Person{
    @NotNull
    @Min(3)
    private String userName;
    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&*+=?]).{8,}$",message = "Password must contain atleast 8digits with atleast 1 character, 1 numeral and one symbol")
    private String password;

    public User(String firstName, String lastName, String email,
                Date dateOfBirth, String phone, Gender gender, String ninNumber,
                Address billingAddress, Address shippingAddress, String userName,
                String password) {
        super(firstName, lastName,
                email, dateOfBirth,
                phone, gender, ninNumber,
                billingAddress, shippingAddress);
        this.userName = userName;
        this.password = password;
    }

}
