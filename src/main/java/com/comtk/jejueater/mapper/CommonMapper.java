package com.comtk.jejueater.mapper;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public interface CommonMapper {
    ArrayList<HashMap> getData();
}
