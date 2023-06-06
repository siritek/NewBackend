package com.example.withoutdb.service;

import com.example.withoutdb.model.SearchClaim;

import java.util.List;

public interface SearchClaimService {

    public void saveSearchClaim(SearchClaim searchclaim);

    public List<SearchClaim> getAllsearchclaims() ;


}
