package com.kridabuzz.tigerstournament.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="info_table")
public class InfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registerId;

    private  String userName;

    private String emailId;

    private String password;

    private String address;

    private int age;

    private String status;

    public InfoEntity(String userName, String emailId, String password, String address, int age) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.address = address;
        this.age = age;
    }

}
