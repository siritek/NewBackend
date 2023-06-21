package com.example.withoutdb.service;

import java.sql.SQLException;
import java.util.List;

import com.example.withoutdb.model.SearchNoteModel;

public interface SearchNoteService {

    public void saveSearchNote(SearchNoteModel searchNoteModel);

    public List<SearchNoteModel> getAllsearchnotes();
}
