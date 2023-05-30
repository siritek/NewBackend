package com.example.withoutdb.service;

import com.example.withoutdb.model.Exposure;

import java.util.List;

public interface ExposureService {

    public void saveExposure(Exposure exposure);

    public List<Exposure> getAllexposures() ;
}
