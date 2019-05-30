package io.spring.crudapplication.crudapplication.controller;

import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;
import io.spring.crudapplication.crudapplication.dto.EmpTransactionDeatilsDto;
import io.spring.crudapplication.crudapplication.service.EmpDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpDetailsController {
	
	@Autowired
	private EmpDetailsService empDetailsService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/details")
	public EmpTransactionDeatilsDto getEmpDetails() {
		return empDetailsService.getEmpDetails();
	}
	@RequestMapping(method = RequestMethod.POST, value = "/saveDetails")
	public void saveEmpDetails(@RequestBody EmpDetailsDto empDetailsDto) {
		empDetailsService.saveEmpDetails(empDetailsDto);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteDetails")
	public void deleteEmpDetails() {
		empDetailsService.deleteEmpDetails();
	}

}
