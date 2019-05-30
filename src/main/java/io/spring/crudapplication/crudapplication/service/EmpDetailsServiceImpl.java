package io.spring.crudapplication.crudapplication.service;

import io.spring.crudapplication.crudapplication.dao.EmpDetailsDao;
import io.spring.crudapplication.crudapplication.dto.EmpDetailsDto;
import io.spring.crudapplication.crudapplication.dto.EmpTransactionDeatilsDto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDetailsServiceImpl implements EmpDetailsService{
	
	
	@Autowired
	private EmpDetailsDao empDetailsDao;

	@Override
	public EmpTransactionDeatilsDto getEmpDetails() {
		List<EmpDetailsDto> transactionList = empDetailsDao.getAll();
		
		List<EmpDetailsDto> recentTransactions = new ArrayList<>();

		for (int index = 0; index < transactionList.size(); index++) {
			EmpDetailsDto transaction = transactionList.get(index);
			ZonedDateTime transactionTime = ZonedDateTime.parse(transaction.getTime())
					.withZoneSameLocal(TimeZone.getTimeZone("UTC").toZoneId());

			if (transactionTime.isAfter(ZonedDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()).minusMinutes(10))) {
				recentTransactions.add(transaction);
			}
		}

		return prepareTransactionDetail(recentTransactions);
	}
	

	private EmpTransactionDeatilsDto prepareTransactionDetail(
			List<EmpDetailsDto> recentTransactions) {
		int count = recentTransactions.size();
		
		EmpTransactionDeatilsDto xy= new EmpTransactionDeatilsDto();

		double maxTransaction = recentTransactions.stream().filter(Objects::nonNull).map(EmpDetailsDto::getAmount)
				.mapToDouble(amount -> amount).max().getAsDouble();
		double minTransaction = recentTransactions.stream().filter(Objects::nonNull).map(EmpDetailsDto::getAmount)
				.mapToDouble(amount -> amount).min().getAsDouble();
		double sum = recentTransactions.stream().filter(Objects::nonNull).map(EmpDetailsDto::getAmount)
				.mapToDouble(amount -> amount).sum();
		double avg = sum / count;

		xy.setAvg(avg);
		xy.setCount(count);
		xy.setMax(maxTransaction);
		xy.setMin(minTransaction);
		xy.setSum(sum);
		
		return xy;
	}


	@Override
	public void saveEmpDetails(EmpDetailsDto empDetailsDto) {
		empDetailsDao.save(empDetailsDto);		
	}


	@Override
	public void deleteEmpDetails() {
		empDetailsDao.deleteEmpDetails();
	}

}
