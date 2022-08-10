package com.example.hr;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hr.boundary.FireEmployeeResponse;
import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.HireEmployeeResponse;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.JobStyle;
import com.example.hr.service.HrService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = HrMicroserviceApplication.class)
@AutoConfigureMockMvc
class HrMicroserviceApplicationTests {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	// Test Doubles
	@MockBean
	private HrService hrService;
	
	
	@Test
	@DisplayName("successfuly hiring an employee")
	void hireEmployee_isOk() throws Throwable {
		//1. Test Fixture
		Employee jack = new Employee.Builder("11111111110")
									.departments(Department.HR,Department.FINANCE)
				                    .birthYear(1956)
				                    .fullname("jack", "bauer")
				                    .jobStyle(JobStyle.PART_TIME)
				                    .photo("")
				                    .salary(100_000)
				                    .iban("TR282238840087568690127692")
				                    .build();
		var request = new HireEmployeeRequest();
		request.setKimlikNo(jack.getKimlikNo().getValue());
		request.setBirthYear(jack.getBirthYear().getValue());
		request.setCurrency(jack.getSalary().getCurrency());
		request.setIban(jack.getIban().getValue());
		request.setSalary(jack.getSalary().getValue());
		request.setJobStyle(jack.getJobStyle());
		request.setDepartments(jack.getDepartments());
		request.setFirstName(jack.getFullname().getFirst());
		request.setLastName(jack.getFullname().getLast());
		request.setPhoto(jack.getPhoto().getBase64EncodedValues());
		Mockito.when(hrService.hireEmployee(request)).thenReturn(new HireEmployeeResponse("success"));
		//2. Call exercise method
		mvc.perform(post("/employees").content(mapper.writeValueAsString(request))
				               .contentType(MediaType.APPLICATION_JSON))
		//3. verification
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("status", is("success")));
		//4. Tear-down
	}
	
	@Test
	@DisplayName("firing an employee fails")
	void fireEmployee_fails() throws Throwable {
		//1. Test Fixture
		Employee jack = new Employee.Builder("11111111110")
				.departments(Department.HR,Department.FINANCE)
                .birthYear(1956)
                .fullname("jack", "bauer")
                .jobStyle(JobStyle.PART_TIME)
                .photo("")
                .salary(100_000)
                .iban("TR282238840087568690127692")
                .build();
		Mockito.when(hrService.fireEmployee(jack.getKimlikNo().getValue()))
				      .thenReturn(new FireEmployeeResponse("failed: cannot find employee to fire!"));
		//2. Call exercise method
		mvc.perform(delete("/employees/".concat(jack.getKimlikNo().getValue()))
				.accept(MediaType.APPLICATION_JSON))
		//3. verification
				.andExpect(status().isOk())
				.andExpect(jsonPath("status", is("failed: cannot find employee to fire!")));
		//4. Tear-down
	}

	@Test
	@DisplayName("successfuly firing an employee")
	void fireEmployee_isOk() throws Throwable {
		//1. Test Fixture
		Employee jack = new Employee.Builder("11111111110")
				.departments(Department.HR,Department.FINANCE)
				.birthYear(1956)
				.fullname("jack", "bauer")
				.jobStyle(JobStyle.PART_TIME)
				.photo("")
				.salary(100_000)
				.iban("TR282238840087568690127692")
				.build();
		Mockito.when(hrService.fireEmployee(jack.getKimlikNo().getValue()))
		       .thenReturn(new FireEmployeeResponse("success"));
		//2. Call exercise method
		mvc.perform(delete("/employees/".concat(jack.getKimlikNo().getValue()))
				.accept(MediaType.APPLICATION_JSON))
		//3. verification
		.andExpect(status().isOk())
		.andExpect(jsonPath("status", is("success")));
		//4. Tear-down
	}
	
}
