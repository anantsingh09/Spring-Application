package io.spring.crudapplication.crudapplication.dto;

import lombok.Data;

@Data
public class EmpDetailsDto {

	private String empName;

	private String empAddress;

	private String time;

	private double amount;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public EmpDetailsDto() {
		super();
	}

	public EmpDetailsDto(int id, String empName, String empAddress) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
