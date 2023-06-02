package com.example.withoutdb.service;

import com.example.withoutdb.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommonServiceImpl  implements  CommonService {

    public void saveCommon(Common common) {
        try {

            Fnol fnol = common.getFnolData();
            Policyinformation policyinformation = common.getPolicyInfoData();
            LossSummary lossSummary = common.getLossData();
            Exposure exposure = common.getExposureData();

           new FnolServiceImpl().saveFnol(fnol);
           new PolicyinformationServiceImpl().savePolicyinformation(policyinformation);
           new LossSummaryServiceImpl().saveLossSummary(lossSummary);
            new ExposureServiceImpl().saveExposure(exposure);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Common> getAllcommons() {
        return null;
    }

}


