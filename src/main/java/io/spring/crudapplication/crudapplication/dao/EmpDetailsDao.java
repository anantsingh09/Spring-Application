package io.spring.crudapplication.crudapplication.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;


@Component
public interface EmpDetailsDao {
	
	public void save(EmpDetailsDto empDetailsDto);

	public List<EmpDetailsDto> getAll();

	public void deleteEmpDetails();

}
