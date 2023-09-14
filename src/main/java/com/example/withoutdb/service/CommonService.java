package com.example.withoutdb.service;

import com.example.withoutdb.model.Common;


import java.util.List;

public interface CommonService {

    public String saveCommon(Common common);

    public List<Common> getAllcommons();
}
