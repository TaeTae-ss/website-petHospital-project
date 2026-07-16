package com.spring.website.pethp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterDTO {

    private int registerNo;
    private String registerId;
    private String registerPassword;
    private String registerName;
    private String registerEmail;
    private String registerPhone;
    private String registerDate;
}