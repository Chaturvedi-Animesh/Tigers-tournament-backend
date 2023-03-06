package com.kridabuzz.tigerstournament.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InfoRequest {


    @NotBlank(message = "Name should not be blank")
    private  String name;
    @NotBlank(message = "Email Id should not be blank")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    private String emailId;
    @NotBlank(message = "Password should not be blank")
    private String password;
    @NotBlank(message = "Address should not be blank")
    @Length(min = 10, max=100)
    private String address;
    @NotNull(message = "Name should not be blank")
    private int age;
}
