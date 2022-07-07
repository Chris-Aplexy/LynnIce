package com.lynicecreamapp.lyn_user_service.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @NotNull
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Email(regexp = "?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21\\\\x23-\\\\x5b\\\\x5d-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21-\\\\x5a\\\\x53-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])+)\\\\])\"",
            message = "Please enter valid email address")
    private String email;
    @Temporal(TemporalType.DATE)
    @NotNull
    @Past
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "phone_id")
    @NotNull
    @Max(12)
    private Phone phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Size(min = 14,max = 14)
    @Pattern(regexp = "^[A-Za-z0-9]",message = "NIN should only contain alphanumeric characters")
    private String ninNumber;
    @OneToOne
    @JoinColumn(name = "billing_address_address_id")
    private Address billingAddress;
    @OneToOne
    @JoinColumn(name = "shipping_address_address_id")
    private Address shippingAddress;


    public Person(String firstName, String lastName, String email,
                  Date dateOfBirth, String phone, Gender gender, String ninNumber,
                  Address billingAddress, Address shippingAddress) {
    }

}
