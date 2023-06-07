package com.example.withoutdb.service;

import java.sql.SQLException;
import java.util.List;

import com.example.withoutdb.model.NewNoteModel;

public interface NewNoteService {




        public void saveNewNote(NewNoteModel newnote);

        public List<NewNoteModel> getAllnewnotes() ;

}
