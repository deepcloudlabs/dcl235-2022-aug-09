package com.example.hr.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.boundary.FireEmployeeResponse;
import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.HireEmployeeResponse;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Service
public class HrService {

	private HrApplication hrApplication;
	private ModelMapper modelMapper;

	// Constructor Injection
	public HrService(HrApplication hrApplication, ModelMapper modelMapper) {
		this.hrApplication = hrApplication;
		this.modelMapper = modelMapper;
	}

	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		var employee = modelMapper.map(request, Employee.class);
		hrApplication.hireEmployee(employee);
		return new HireEmployeeResponse("success");
	}

	public FireEmployeeResponse fireEmployee(String identityNo) {
		var optEmp = hrApplication.fireEmployee(TcKimlikNo.valueOf(identityNo));
		if (optEmp.isEmpty()) {
			return new FireEmployeeResponse("failed: cannot find employee to fire!");
		}
		return new FireEmployeeResponse("success");
	}

}
