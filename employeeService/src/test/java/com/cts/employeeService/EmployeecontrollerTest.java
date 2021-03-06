package com.cts.employeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.cts.employeeService.controller.EmployeeController;
import com.cts.employeeService.entity.Delivarable;


@RunWith(MockitoJUnitRunner.class)
public class EmployeecontrollerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Test
	public void getEmployeeIdsBymanagerId(){
		ResponseEntity<List<Integer>> data = this.employeeController.getEmployeeIdsBymanagerId(1);
		assertEquals(HttpStatus.SC_OK, data.getStatusCode());
	}
	
	@Test
	public void getDelivarablesByEmployeeIdTest() {
		ResponseEntity<List<Delivarable>> data = this.employeeController.getDelivarablesByEmployeeId(1);
		assertEquals(HttpStatus.SC_OK, data.getStatusCode());
	}
}
