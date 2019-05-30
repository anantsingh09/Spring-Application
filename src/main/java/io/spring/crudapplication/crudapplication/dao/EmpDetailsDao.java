package io.spring.crudapplication.crudapplication.dao;

import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface EmpDetailsDao {
	
	public void save(EmpDetailsDto empDetailsDto);

	public List<EmpDetailsDto> getAll();

	public void deleteEmpDetails();

}
