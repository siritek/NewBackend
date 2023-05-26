package com.example.withoutdb.service;

import com.example.withoutdb.model.Policyinformation;

import java.util.List;


public interface PolicyinformationService {
    public void savePolicyinformation(Policyinformation policyinformation);

    public List<Policyinformation> getAllpolicyinformations();



}
