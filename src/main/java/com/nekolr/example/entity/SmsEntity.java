package com.nekolr.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nekolr
 */
@Data
public class SmsEntity implements Serializable {
    private String sendMobile;
    private String receiveMobile;
    private String body;
}
