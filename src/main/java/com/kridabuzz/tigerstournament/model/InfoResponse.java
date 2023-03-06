package com.kridabuzz.tigerstournament.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoResponse {

    private Long registerId;

    private  String name;

    private String emailId;

    private String password;

    private String address;

    private int age;

    private String status;
}
