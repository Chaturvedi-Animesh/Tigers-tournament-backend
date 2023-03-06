package com.kridabuzz.tigerstournament.service;

import com.kridabuzz.tigerstournament.entity.InfoEntity;
import com.kridabuzz.tigerstournament.model.InfoRequest;
import com.kridabuzz.tigerstournament.model.InfoResponse;

import java.util.List;
import java.util.Optional;

public interface InfoService {
     List<InfoEntity> getAllList();

     String createUser(InfoRequest infoRequest);

     InfoResponse getByNameAndStatus(String name,String status);

//     List<InfoResponse> getAllListResponse();

     InfoResponse deleteByUsername(String name);

     InfoResponse updateUsername( InfoRequest infoRequest);

     Long  loginUser(String name,String password);


}
