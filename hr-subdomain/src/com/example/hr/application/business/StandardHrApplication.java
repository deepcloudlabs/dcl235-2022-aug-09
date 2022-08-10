package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.domain.event.EmployeeFiredEvent;
import com.example.hr.domain.event.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;
	
	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void hireEmployee(Employee employee) {
		TcKimlikNo kimlikNo = employee.getKimlikNo();
		var kimlik = kimlikNo.getValue();
		if (employeeRepository.exists(kimlik)) 
			throw new IllegalArgumentException("Employee already exists!");
		employeeRepository.save(employee);
		eventPublisher.publish(new EmployeeHiredEvent(kimlikNo));
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo kimlik) {
		var employee = employeeRepository.findById(kimlik);
		if (employee.isEmpty()) 
			return Optional.empty();
		employeeRepository.remove(employee.get());
		eventPublisher.publish(new EmployeeFiredEvent(kimlik));
		return employee;
	}

}
