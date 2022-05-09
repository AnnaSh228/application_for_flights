package com.example.demos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class UserDto {
    public String username;
    
    public String name;
 
    public String lastname;
    
    public String password;
    
    public String passportNumber;
   
    public String address;
   
    public String bankcardNumber;
    
    public String email;
    
    public String phoneNumber;

    
}
