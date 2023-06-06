package com.example.withoutdb.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/common")
@CrossOrigin
public class ClaimGeneration {

    private AtomicInteger lastClaimNumber = new AtomicInteger(0);

    @GetMapping("/generateClaimNumber")
    public ClaimNumberResponse generateClaimNumber() {
        int claimNumber = getNextClaimNumber();
        saveNextClaimNumber(claimNumber);

        System.out.println("Generated Claim Number: " + claimNumber);

        return new ClaimNumberResponse(claimNumber);
    }

    private int getNextClaimNumber() {
        // Increment the last claim number to generate the next claim number
        return lastClaimNumber.incrementAndGet();
    }

    private void saveNextClaimNumber(int nextClaimNumber) {
        // Implement the logic to save the next claim number to the database or update the source
        // Example implementation:
        // You can store the claim number in a separate table or collection and update it accordingly
        // This example uses an atomic integer to simulate the storage
        lastClaimNumber.set(nextClaimNumber);
    }

    // Response object to hold the claim number
    private static class ClaimNumberResponse {
        private int claimNumber;

        public ClaimNumberResponse(int claimNumber) {
            this.claimNumber = claimNumber;
        }

        public int getClaimNumber() {
            return claimNumber;
        }

        public void setClaimNumber(int claimNumber) {
            this.claimNumber = claimNumber;
        }
    }
}

