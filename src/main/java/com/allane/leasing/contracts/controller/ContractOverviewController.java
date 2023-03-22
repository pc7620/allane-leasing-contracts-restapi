package com.allane.leasing.contracts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allane.leasing.contracts.model.ContractOverview;
import com.allane.leasing.contracts.model.LeasingContract;
import com.allane.leasing.contracts.model.LeasingContractRepository;

@RestController
@RequestMapping("/api/contract-overview")
public class ContractOverviewController {
	
	@Autowired
	private LeasingContractRepository leasingContractRepository;
	
	@GetMapping("/")
	public List<ContractOverview> getContractOverview() {
		List<LeasingContract> leasingContracts = leasingContractRepository.findAll();
		List<ContractOverview> contractOverviews = new ArrayList<>();
		for (LeasingContract lc : leasingContracts) {
			ContractOverview co = new ContractOverview();
			co.setContractNumber(lc.getContractNumber());
			co.setCustomerSummary(lc.getCustomer().getFirstName() + " " + lc.getCustomer().getLastName());
			co.setVehicleSummary(lc.getVehicle().getBrand() + " " + lc.getVehicle().getModel() + " ("
					+ lc.getVehicle().getModelYear() + ")");
			co.setVin(lc.getVehicle().getVin() != null ? lc.getVehicle().getVin() : "-");
			co.setMonthlyRate(lc.getMonthlyRate());
			co.setVehiclePrice(lc.getVehicle().getPrice());
			co.setContractDetailsLink("/contracts/" + lc.getId());
			contractOverviews.add(co);
		}
		return contractOverviews;
	}

}
