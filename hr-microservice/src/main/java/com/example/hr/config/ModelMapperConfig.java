package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;

@Configuration
public class ModelMapperConfig {

	
	private static final Converter<HireEmployeeRequest,Employee> HireEmployeeRequest_TO_Employee_CONVERTER = context -> {
		var request = context.getSource();
		return new Employee.Builder(request.getKimlikNo())
	               .fullname(request.getFirstName(), request.getLastName())
	               .jobStyle(request.getJobStyle())
	               .iban(request.getIban())
	               .birthYear(request.getBirthYear())
	               .salary(request.getSalary(), request.getCurrency())
	               .departments(request.getDepartments().toArray(new Department[0]))
	               .photo(request.getPhoto())
	               .build(); // valid!
	};
	
	private static final Converter<EmployeeDocument,Employee> EmployeeDocument_TO_Employee_CONVERTER = context -> {
		var employeeDocument = context.getSource();
		return new Employee.Builder(employeeDocument.getKimlikNo())
				.fullname(employeeDocument.getFirstName(), employeeDocument.getLastName())
				.jobStyle(employeeDocument.getJobStyle())
				.iban(employeeDocument.getIban())
				.birthYear(employeeDocument.getBirthYear())
				.salary(employeeDocument.getSalary(), employeeDocument.getCurrency())
				.departments(employeeDocument.getDepartments().toArray(new Department[0]))
				.photo(employeeDocument.getPhoto())
				.build(); // valid!
	};

	private static final Converter<Employee,EmployeeDocument> Employee_TO_EmployeeDocument_CONVERTER = context -> {
		var employee = context.getSource();
		var employeeDocument = new EmployeeDocument();
		var fullname = employee.getFullname();
		employeeDocument.setKimlikNo(employee.getKimlikNo().getValue());
		employeeDocument.setFirstName(fullname.getFirst());
		employeeDocument.setLastName(fullname.getLast());
		employeeDocument.setIban(employee.getIban().getValue());
		employeeDocument.setSalary(employee.getSalary().getValue());
		employeeDocument.setCurrency(employee.getSalary().getCurrency());
		employeeDocument.setDepartments(employee.getDepartments());
		employeeDocument.setJobStyle(employee.getJobStyle());
		employeeDocument.setPhoto(new String(employee.getPhoto().getBase64EncodedValues()));
		return employeeDocument;
	};
	
	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(HireEmployeeRequest_TO_Employee_CONVERTER, HireEmployeeRequest.class, Employee.class);
		mapper.addConverter(EmployeeDocument_TO_Employee_CONVERTER, EmployeeDocument.class, Employee.class);
		mapper.addConverter(Employee_TO_EmployeeDocument_CONVERTER, Employee.class, EmployeeDocument.class);
		return mapper;
	}
}
