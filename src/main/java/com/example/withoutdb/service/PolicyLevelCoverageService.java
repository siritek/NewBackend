package com.example.withoutdb.service;

import com.example.withoutdb.model.PolicyLevelCoverage;
import java.sql.SQLException;

import java.util.List;

public interface PolicyLevelCoverageService
{
    public void savePolicyLevelCoverage(PolicyLevelCoverage policyLevelCoverage);

    public List<PolicyLevelCoverage> getAllpolicyLevelCoverages();


}
