package com.example.UserService.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTOa {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String state;
    private String country;

    private Boolean residentialAddressFlag;
    private Boolean currentAddressFlag;
    private Boolean workAddressFlag;
}