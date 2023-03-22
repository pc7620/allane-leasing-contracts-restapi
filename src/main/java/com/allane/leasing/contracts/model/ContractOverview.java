package com.allane.leasing.contracts.model;

public class ContractOverview {
    private String contractNumber;
    private String customerSummary;
    private String vehicleSummary;
    private String vin;
    private Double monthlyRate;
    private Double vehiclePrice;
    private String contractDetailsLink;
	public ContractOverview() {
		super();
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getCustomerSummary() {
		return customerSummary;
	}
	public void setCustomerSummary(String customerSummary) {
		this.customerSummary = customerSummary;
	}
	public String getVehicleSummary() {
		return vehicleSummary;
	}
	public void setVehicleSummary(String vehicleSummary) {
		this.vehicleSummary = vehicleSummary;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Double getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}
	public Double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(Double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public String getContractDetailsLink() {
		return contractDetailsLink;
	}
	public void setContractDetailsLink(String contractDetailsLink) {
		this.contractDetailsLink = contractDetailsLink;
	}

    // getters and setters
}

