package com.example.withoutdb.service;

import com.example.withoutdb.model.Synopsis;

import java.util.List;

public interface SynopsisService {
    public void saveSynopsis(Synopsis synopsis);

    public List<Synopsis> getAllsynopsis();
}
