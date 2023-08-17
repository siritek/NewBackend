package com.example.withoutdb.service;

import com.example.withoutdb.model.Injuries;
import java.util.List;
import java.sql.*;

public interface InjuriesService
{
    public void saveInjuries(Injuries injuries);

    public List<Injuries> getAllInjuries();
}
