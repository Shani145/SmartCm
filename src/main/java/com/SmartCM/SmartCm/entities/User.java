package com.SmartCM.SmartCm.entities;





import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

   
   
   
    

    @Id
    private String useId;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(unique = true,nullable = false)
    private String email;

    private String password;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;
    private String phoneNumber;

    //Information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

//self ,google ,facebook ,linkedin ,github ,
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
private List<Contact> contacts = new ArrayList<Contact>();




}