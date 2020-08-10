package com.comtk.jejueater.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name="user")
public class UserDTO {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String token;
}
