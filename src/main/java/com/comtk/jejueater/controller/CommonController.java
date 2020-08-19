package com.comtk.jejueater.controller;

import com.comtk.jejueater.dto.UserAuthorityDTO;
import com.comtk.jejueater.dto.UserDTO;
import com.comtk.jejueater.repository.UserAuthorityRepository;
import com.comtk.jejueater.repository.UserRepository;
import com.comtk.jejueater.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    @ResponseBody
    private Object main(){
        ArrayList<HashMap> tempList = commonService.getData();
        ArrayList<?> userList = (ArrayList<?>)userRepository.findAll();
        HashMap result = new HashMap();
        result.put("userList", userList);
        result.put("tempList", tempList);
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    private Object login(@RequestBody UserDTO userDTO) throws Exception{
        UserDTO result = userRepository.findByUsername(userDTO.getUsername());
        if(!passwordEncoder.matches(userDTO.getPassword(), result.getPassword())){
            System.out.println("no matched");
            throw new Exception();
        }
        return result;
    }

    @PostMapping("/signin")
    @ResponseBody
    private Object signin(@RequestBody UserDTO userDTO){

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserDTO result = userRepository.save(userDTO);

        UserAuthorityDTO userAuthorityDTO = new UserAuthorityDTO();
        userAuthorityDTO.setAuthority("USER");
        userAuthorityDTO.setUsername(result.getUsername());
        userAuthorityRepository.save(userAuthorityDTO);

        return userDTO;
    }

    @Secured("ROLE_USER")
    @GetMapping("/info")
    @ResponseBody
    private Object info(){
        return "info page";
    }
}
