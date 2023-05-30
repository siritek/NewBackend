package com.example.withoutdb.service;

import com.example.withoutdb.model.LossSummary;

import java.util.List;

public interface LossSummaryService {
    public void saveLossSummary(LossSummary losssummary);

    public List<LossSummary> getAlllosssummarys() ;

}
