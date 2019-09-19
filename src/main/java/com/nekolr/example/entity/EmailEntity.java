package com.nekolr.example.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailEntity implements Serializable {
    private String receiveEmail;
    private String sendEmail;
    private String sendAccount;
    private transient String sendPassword;
    private String body;
}
