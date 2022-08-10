package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.JobStyle;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String> {
	List<Employee> findAllByDepartmentsIn(Department department);
	List<Employee> findAllByBirthYearBetween(int fromYear,int toYear);
	@Query("{jobSytle: ?}")
	List<Employee> calismaSeklineGoreBul(JobStyle jobStyle);	
}
