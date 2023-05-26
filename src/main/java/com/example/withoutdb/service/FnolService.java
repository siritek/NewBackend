package com.example.withoutdb.service;

import com.example.withoutdb.model.Fnol;

import java.sql.SQLException;
import java.util.List;

public interface FnolService {


    public void saveFnol(Fnol fnol);

    public List<Fnol> getAllfnols();
}
