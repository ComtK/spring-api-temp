package com.comtk.jejueater.controller;

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

    @GetMapping("/")
    @ResponseBody
    private Object main(){
        ArrayList<HashMap> tempList = commonService.getData();
        return tempList;
    }
}
