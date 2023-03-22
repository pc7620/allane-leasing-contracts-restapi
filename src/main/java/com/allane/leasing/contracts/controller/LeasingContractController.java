package com.allane.leasing.contracts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allane.leasing.contracts.model.LeasingContractDto;
import com.allane.leasing.contracts.services.LeasingContractService;

@RestController
@RequestMapping("/api/leasing-contracts")
public class LeasingContractController {
    
    @Autowired
    private LeasingContractService leasingContractService;
    
    @GetMapping("/{id}")
    public LeasingContractDto getLeasingContractById(@PathVariable String id) {
        return leasingContractService.getLeasingContractById(id);
    }
    
    @GetMapping
    public List<LeasingContractDto> getAllLeasingContracts() {
        return leasingContractService.getAllLeasingContracts();
    }
    
    @PostMapping
    public ResponseEntity<LeasingContractDto> createLeasingContract(@RequestBody LeasingContractDto leasingContractDTO) {
        LeasingContractDto createdLeasingContractDTO = leasingContractService.createLeasingContract(leasingContractDTO);
        return ResponseEntity.created(URI.create("/leasing-contracts/" + createdLeasingContractDTO.getId())).body(createdLeasingContractDTO);
    }
    
    @PutMapping("/{id}")
    public LeasingContractDto updateLeasingContract(@PathVariable String id, @RequestBody LeasingContractDto leasingContractDTO) {
        return leasingContractService.updateLeasingContract(id, leasingContractDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeasingContract(@PathVariable String id) {
        leasingContractService.deleteLeasingContract(id);
        return ResponseEntity.noContent().build();
    }
}

