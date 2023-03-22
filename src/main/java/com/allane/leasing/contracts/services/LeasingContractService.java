package com.allane.leasing.contracts.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allane.leasing.contracts.model.Customer;
import com.allane.leasing.contracts.model.CustomerDto;
import com.allane.leasing.contracts.model.CustomerRepository;
import com.allane.leasing.contracts.model.LeasingContract;
import com.allane.leasing.contracts.model.LeasingContractDto;
import com.allane.leasing.contracts.model.LeasingContractRepository;
import com.allane.leasing.contracts.model.Vehicle;
import com.allane.leasing.contracts.model.VehicleDto;
import com.allane.leasing.contracts.model.VehicleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeasingContractService {
    
    @Autowired
    private LeasingContractRepository leasingContractRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<LeasingContractDto> getAllLeasingContracts() {
        List<LeasingContract> leasingContracts = leasingContractRepository.findAll();
        return leasingContracts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public LeasingContractDto getLeasingContractById(String id) {
        LeasingContract leasingContract = leasingContractRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leasing contract not found with id " + id));
        return convertToDto(leasingContract);
    }
    
    public LeasingContractDto createLeasingContract(LeasingContractDto leasingContractDto) {
        Customer customer = customerRepository.findById(leasingContractDto.getCustomer().getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + leasingContractDto.getCustomer().getId()));
        Vehicle vehicle = vehicleRepository.findById(leasingContractDto.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + leasingContractDto.getVehicle().getId()));
        
        LeasingContract leasingContract = convertToEntity(leasingContractDto);
        leasingContract.setCustomer(customer);
        leasingContract.setVehicle(vehicle);
        
        leasingContract = leasingContractRepository.save(leasingContract);
        return convertToDto(leasingContract);
    }
    
    public LeasingContractDto updateLeasingContract(String id, LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = leasingContractRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leasing contract not found with id " + id));
        Customer customer = customerRepository.findById(leasingContractDto.getCustomer().getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + leasingContractDto.getCustomer().getId()));
        Vehicle vehicle = vehicleRepository.findById(leasingContractDto.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + leasingContractDto.getVehicle().getId()));
        
        leasingContract.setContractNumber(leasingContractDto.getContractNumber());
        leasingContract.setMonthlyRate(leasingContractDto.getMonthlyRate());
        leasingContract.setCustomer(customer);
        leasingContract.setVehicle(vehicle);
        
        leasingContract = leasingContractRepository.save(leasingContract);
        return convertToDto(leasingContract);
    }
    
    public void deleteLeasingContract(String id) {
        leasingContractRepository.deleteById(id);
    }
    
    private LeasingContractDto convertToDto(LeasingContract leasingContract) {
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setId(leasingContract.getId());
        leasingContractDto.setContractNumber(leasingContract.getContractNumber());
        leasingContractDto.setMonthlyRate(leasingContract.getMonthlyRate());
        CustomerDto customerdto = new CustomerDto();
        BeanUtils.copyProperties(leasingContract.getCustomer(),customerdto);
        leasingContractDto.setCustomer(customerdto);
        VehicleDto vehicledto = new VehicleDto();
        BeanUtils.copyProperties( leasingContract.getVehicle(),vehicledto);
        leasingContractDto.setVehicle(vehicledto);
        return leasingContractDto;
    }
    
    private LeasingContract convertToEntity(LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setId(leasingContractDto.getId());
        leasingContract.setContractNumber(leasingContractDto.getContractNumber());
        leasingContract.setMonthlyRate(leasingContractDto.getMonthlyRate());
        return leasingContract;
    }
}
