package io.spring.crudapplication.crudapplication.dao;

import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

@Component
public class EmpDetailsDaoImpl implements EmpDetailsDao {

	List<EmpDetailsDto> transactionData = new CopyOnWriteArrayList<>();

	@Override
	public void save(EmpDetailsDto empDetailsDto) {

		transactionData.add(empDetailsDto);
		System.out.println("Data is saved. ");
	}

	@Override
	public List<EmpDetailsDto> getAll() {
		return transactionData;
	}

	@Override
	public void deleteEmpDetails() {
		transactionData.clear();
	}

}
