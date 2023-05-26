package com.NewNotepage.NewNote.Service;

import java.util.List;
import java.sql.SQLException;
import com.NewNotepage.NewNote.Model.LossSummary;

public interface LossSummaryService {
    public void saveLossSummary(LossSummary losssummary);

    public List<LossSummary> getAlllosssummarys() ;

}
