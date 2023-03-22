package com.allane.leasing.contracts.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.allane.leasing.contracts.model.Vehicle;
import com.allane.leasing.contracts.model.VehicleDto;
import com.allane.leasing.contracts.model.VehicleRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        Type listType = new TypeToken<List<VehicleDto>>() {}.getType();
        return modelMapper.map(vehicles, listType);
    }

    public VehicleDto getVehicleById(String id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id: " + id));
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        vehicle.setId(null); // Ensure new entity is created instead of updating existing
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return modelMapper.map(savedVehicle, VehicleDto.class);
    }

    public VehicleDto updateVehicle(String id, VehicleDto vehicleDto) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id: " + id));
        modelMapper.map(vehicleDto, existingVehicle); // Copy fields from DTO to existing entity
        existingVehicle.setId(id); // Ensure correct entity is updated
        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        return modelMapper.map(updatedVehicle, VehicleDto.class);
    }

    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
}
