package com.example.withoutdb.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;



import com.example.withoutdb.model.SearchClaim;

import com.example.withoutdb.service.SearchClaimServiceImpl;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090"})
@RestController
@RequestMapping("/searchclaimfirst")


public class SearchClaimController {




        private SearchClaimServiceImpl SearchClaimService = new SearchClaimServiceImpl();

        @PostMapping("/add")
        public String add(@RequestBody SearchClaim searchclaim) {
            SearchClaimService.saveSearchClaim(searchclaim);
            System.out.println("Connection reached Controller");
            return "New Search Claim info is added";
        }

        @GetMapping("/getAll")
        public List<SearchClaim> getAllsearchclaims() {
            return SearchClaimService.getAllsearchclaims();
        }
    }
