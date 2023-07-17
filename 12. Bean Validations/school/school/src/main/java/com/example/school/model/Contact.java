package com.example.school.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {

    @NotBlank(message = "Message Must not be Blank")
    @Size(min=5,message = "Message must be At least 5 chars Long")
    private String message;


    @NotBlank(message = "Name Must Not be Blank")
    @Size(min=3,message = "Name must be At least 3 chars Long")
    private String name;

    @NotBlank(message = "Mobile Number must not be Blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number Must be 10 Digits")
    private String mobileNum;

    @NotBlank(message = "EMail must not be Blank")
    @Email(message = "Please provide Valid Email")
    private String email;

    @NotBlank(message = "Subject Must not be Blank")
    @Size(min=5,message = "Subject must be At least 5 chars Long")
    private  String subject;




}
