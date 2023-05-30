package com.example.withoutdb.service;

import com.example.withoutdb.model.Common;


import java.util.List;

public interface CommonService {

    public void saveCommon(Common common);

    public List<Common> getAllcommons();
}
