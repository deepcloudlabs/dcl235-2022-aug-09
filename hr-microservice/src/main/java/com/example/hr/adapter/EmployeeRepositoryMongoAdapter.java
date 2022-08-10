package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

@Service
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {

	private EmployeeDocumentRepository employeeDocumentRepository; 
	private ModelMapper modelMapper;
	

	public EmployeeRepositoryMongoAdapter(EmployeeDocumentRepository employeeDocumentRepository,
			ModelMapper modelMapper) {
		this.employeeDocumentRepository = employeeDocumentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean exists(String kimlik) {
		return employeeDocumentRepository.existsById(kimlik);
	}

	@Override
	public Employee save(Employee employee) {
		var employeeDocument = modelMapper.map(employee, EmployeeDocument.class);
		var savedEmployeeDocument = employeeDocumentRepository.save(employeeDocument);
		return modelMapper.map(savedEmployeeDocument, Employee.class);
	}

	@Override
	public Optional<Employee> findById(TcKimlikNo kimlik) {
		var optOfEmp = employeeDocumentRepository.findById(kimlik.getValue());
		if (optOfEmp.isEmpty())
			return Optional.empty();
		return Optional.of(modelMapper.map(optOfEmp.get(), Employee.class));
	}

	@Override
	public void remove(Employee employee) {
		employeeDocumentRepository.deleteById(employee.getKimlikNo().getValue());
	}

}
