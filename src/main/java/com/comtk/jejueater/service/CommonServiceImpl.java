package com.comtk.jejueater.service;

import com.comtk.jejueater.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public ArrayList<HashMap> getData() {
        return commonMapper.getData();
    }
}
