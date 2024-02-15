package com.example.withoutdb.service;

import com.example.withoutdb.model.GWCCResponse;

import java.util.List;

public interface GWCCResponseService {
    public boolean saveGWCCResponse(GWCCResponse gwccResponse);

    public List<GWCCResponse> getAllGWCCresponses() ;


}



