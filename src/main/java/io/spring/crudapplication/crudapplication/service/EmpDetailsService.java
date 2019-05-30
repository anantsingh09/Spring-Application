package io.spring.crudapplication.crudapplication.service;

import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;
import io.spring.crudapplication.crudapplication.dto.EmpTransactionDeatilsDto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmpDetailsService {

	public EmpTransactionDeatilsDto getEmpDetails();

	public void saveEmpDetails(EmpDetailsDto empDetailsDto);

	public void deleteEmpDetails();
	
}
