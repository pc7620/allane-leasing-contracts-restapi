package com.allane.leasing.contracts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allane.leasing.contracts.model.VehicleDto;
import com.allane.leasing.contracts.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<VehicleDto> getVehicleById(@PathVariable String id) {
		VehicleDto vehicle = vehicleService.getVehicleById(id);
		return ResponseEntity.ok(vehicle);
	}

	@PostMapping
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
		VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
	}

	@PutMapping("/{id}")
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable String id, @RequestBody VehicleDto vehicleDto) {
		VehicleDto updatedVehicle = vehicleService.updateVehicle(id, vehicleDto);
		return ResponseEntity.ok(updatedVehicle);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable String id) {
		vehicleService.deleteVehicle(id);
		return ResponseEntity.noContent().build();
	}
}