package com.kridabuzz.tigerstournament.repository;

import com.kridabuzz.tigerstournament.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity,Long> {
    @Override
    Optional<InfoEntity> findById(Long registerId);

    Optional<InfoEntity> findByUserNameAndStatusIgnoreCase(String userName, String status);

    Optional<InfoEntity> findByUserName(String userName);

    Optional<InfoEntity> findByEmailIdAndStatusIgnoreCase(String emailId, String status);
}
