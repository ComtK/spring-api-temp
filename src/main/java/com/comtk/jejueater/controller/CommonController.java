package com.comtk.jejueater.controller;

import com.comtk.jejueater.dto.UserDTO;
import com.comtk.jejueater.repository.UserRepository;
import com.comtk.jejueater.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController

public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private UserRepository userRepository;

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
}
