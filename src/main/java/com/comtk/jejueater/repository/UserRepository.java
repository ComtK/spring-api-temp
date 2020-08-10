package com.comtk.jejueater.repository;

import com.comtk.jejueater.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Long> {
}
