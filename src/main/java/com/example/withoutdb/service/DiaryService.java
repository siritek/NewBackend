package com.example.withoutdb.service;

import com.example.withoutdb.model.Diary;

import java.sql.SQLException;
import java.util.List;

public interface DiaryService {


    public void saveDiary(Diary diary);

    public List<Diary> getAlldiaries() ;
}
