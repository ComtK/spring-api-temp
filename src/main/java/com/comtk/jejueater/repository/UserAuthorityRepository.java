package com.comtk.jejueater.repository;

import com.comtk.jejueater.dto.UserAuthorityDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthorityDTO, Long> {
    ArrayList<UserAuthorityDTO> findByUsername(String username);
}
