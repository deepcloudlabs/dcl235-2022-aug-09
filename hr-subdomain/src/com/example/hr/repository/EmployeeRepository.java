package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface EmployeeRepository {

	boolean exists(String kimlik);

	Employee save(Employee employee);

	Optional<Employee> findById(TcKimlikNo kimlik);

	void remove(Employee employee);

}
