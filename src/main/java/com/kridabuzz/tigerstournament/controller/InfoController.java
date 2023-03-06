package com.kridabuzz.tigerstournament.controller;


import com.kridabuzz.tigerstournament.entity.InfoEntity;
import com.kridabuzz.tigerstournament.model.InfoRequest;
import com.kridabuzz.tigerstournament.model.InfoResponse;
import com.kridabuzz.tigerstournament.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kridabuzz")
@CrossOrigin
@Validated
public class InfoController {
    @Autowired
    InfoService infoService;

    @GetMapping("/tt/getAll")
    public List<InfoEntity> getAll(){
        return infoService.getAllList();

    }


    @GetMapping("/tt/user/{name}/{status}")
    public InfoResponse getUserByNameAndStatus(@PathVariable String name, @PathVariable  String status){

        return infoService.getByNameAndStatus(name,status);

    }

    @DeleteMapping("/tt/deleteUser/{name}")
    public InfoResponse deleteUserByName(@PathVariable String name){

        return infoService.deleteByUsername(name);

    }

    @PutMapping("/tt/updateUser")

    public InfoResponse updateUser(@RequestBody InfoRequest infoRequest){

        return infoService.updateUsername(infoRequest);

    }

    @GetMapping("/tt/login")
    public ResponseEntity<Long> loginUser(@Valid @RequestParam String email,@Valid @RequestParam  String password){

        return new ResponseEntity<>( infoService.loginUser(email,  password), HttpStatus.ACCEPTED);

    }


    @PostMapping("/tt/registerUser")
    public String createUser(@Valid @RequestBody InfoRequest infoRequest){

        return infoService.createUser(infoRequest);

    }



}
