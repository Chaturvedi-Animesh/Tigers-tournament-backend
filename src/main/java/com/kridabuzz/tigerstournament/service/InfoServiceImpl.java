package com.kridabuzz.tigerstournament.service;

import com.kridabuzz.tigerstournament.constant.Constants;
import com.kridabuzz.tigerstournament.entity.InfoEntity;
import com.kridabuzz.tigerstournament.exception.InvalidPassword;
import com.kridabuzz.tigerstournament.exception.UserAlreadyExist;
import com.kridabuzz.tigerstournament.exception.UserNotExist;
import com.kridabuzz.tigerstournament.model.InfoRequest;
import com.kridabuzz.tigerstournament.model.InfoResponse;
import com.kridabuzz.tigerstournament.repository.InfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InfoServiceImpl implements InfoService{


    @Autowired
    InfoRepository infoRepository;

    @Override
    public List<InfoEntity> getAllList() {
      return infoRepository.findAll();
    }

    @Override
    public String createUser(InfoRequest infoRequest) {
       Optional<InfoEntity> optionalInfoEntity= infoRepository.findByEmailIdAndStatusIgnoreCase(infoRequest.getEmailId(), Constants.Active);
        if(!optionalInfoEntity.isEmpty()){
            throw new UserAlreadyExist("User already exists with given email Id"+ infoRequest.getEmailId());
        }
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(infoRequest.getPassword());
        InfoEntity infoEntity=new InfoEntity(infoRequest.getName(),infoRequest.getEmailId(),encodedPassword,infoRequest.getAddress(),infoRequest.getAge());
        infoEntity.setStatus(Constants.Active);
        infoRepository.save(infoEntity);
//        InfoResponse infoResponse = new InfoResponse(infoEntity.getRegisterId(),infoEntity.getUserName(),infoEntity.getEmailId(),infoEntity.getPassword(),infoEntity.getAddress(),infoEntity.getAge(),infoEntity.getStatus());
        return "You have registered successfully";
    }

    @Override
    public InfoResponse getByNameAndStatus(String name, String status) {
       Optional<InfoEntity> infoEntity= infoRepository.findByUserNameAndStatusIgnoreCase(name,Constants.Active);
       if(infoEntity.isPresent()){
           InfoResponse infoResponse = new InfoResponse(infoEntity.get().getRegisterId(),infoEntity.get().getUserName(),infoEntity.get().getEmailId(),infoEntity.get().getPassword(),infoEntity.get().getAddress(),infoEntity.get().getAge(),infoEntity.get().getStatus());
           return infoResponse;
       }
        return null;
    }

    @Override
    public InfoResponse deleteByUsername(String name) {
        Optional<InfoEntity> infoEntity= infoRepository.findByUserNameAndStatusIgnoreCase(name,Constants.Active);
        if(infoEntity.isPresent()){
            infoEntity.get().setStatus(Constants.Inactive);
            InfoResponse infoResponse= new InfoResponse(infoEntity.get().getRegisterId(),infoEntity.get().getUserName(),infoEntity.get().getEmailId(),infoEntity.get().getPassword(),infoEntity.get().getAddress(),infoEntity.get().getAge(),infoEntity.get().getStatus());
            infoRepository.save(infoEntity.get());
            return infoResponse;
        }
        return null;
    }

    @Override
    public InfoResponse updateUsername(InfoRequest infoRequest) {
        Optional<InfoEntity> infoEntity= infoRepository.findByUserName(infoRequest.getName());
        if(infoEntity.isPresent()){
            BeanUtils.copyProperties(infoRequest,infoEntity);
            BeanUtils.copyProperties(infoEntity,infoRequest);
        }
        return null;
    }

    @Override
    public Long loginUser(String emailId, String password) {
        Optional<InfoEntity> infoEntity=infoRepository.findByEmailIdAndStatusIgnoreCase(emailId,"ACTIVE");
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        if(infoEntity.isEmpty()){
            throw new UserNotExist("User does not exist with email Id");
        }
        else if(!infoEntity.isEmpty()&&(bCryptPasswordEncoder.matches(password,infoEntity.get().getPassword()))){
            return infoEntity.get().getRegisterId();

}       else{
            throw new InvalidPassword("Wrong password");
        }



    }
//
//    @Override
//    public List<InfoResponse> getAllListResponse() {
//       List<InfoEntity> infoEntity= infoRepository.findAll();
//       List<InfoResponse>infoResponses= new ArrayList<>();
//        for (InfoEntity infoResponse:infoEntity) {
//            infoResponse.setUserName(infoEntity.getClass().);
//
//        }
//    }
}
