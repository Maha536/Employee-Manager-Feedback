package com.cts.employeeService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.employeeService.entity.Delivarable;
import com.cts.employeeService.entity.User;
import com.cts.employeeService.model.DelivarableModel;
import com.cts.employeeService.model.DelivarableStatus;
import com.cts.employeeService.repository.DelivarableRepository;
import com.cts.employeeService.repository.UserRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DelivarableRepository delivarableRepository;
	
	// It saves the delivarable into table
	@Override
	public Delivarable saveDelivarable(DelivarableModel delivarableModel) {
		Delivarable data = new Delivarable();
		data.setEmployeeId(delivarableModel.getEmployeeId());
		data.setPojectName(delivarableModel.getProjectname());
		data.setRemarks(delivarableModel.getRemarks());
		data.setRated(false);
		data.setReviewed(false);
		return this.delivarableRepository.save(data); 

	}

	//It updates the rating status
	@Override
	public Delivarable updateDelivarableRatingStatus(DelivarableStatus delivarableStatus) {
		Delivarable data = new Delivarable();
		data.setId(delivarableStatus.getDelivarableId());
		data.setEmployeeId(delivarableStatus.getEmployeeId());
		data.setPojectName(delivarableStatus.getProjectname());
		data.setRemarks(delivarableStatus.getRemarks());
		data.setRated(true);
		data.setReviewed(false);
		
		return this.delivarableRepository.save(data);
	}

	//It updates the review status
	@Override
	public Delivarable updateDelivarableReviewStatus(DelivarableStatus delivarableStatus) {
		Delivarable data = new Delivarable();
		data.setId(delivarableStatus.getDelivarableId());
		data.setEmployeeId(delivarableStatus.getEmployeeId());
		data.setPojectName(delivarableStatus.getProjectname());
		data.setRemarks(delivarableStatus.getRemarks());
		data.setRated(true);
		data.setReviewed(true);
		
		return this.delivarableRepository.save(data);
	}
	
	//retrieves the list of employee ids by manager Id
	@Override
	public ResponseEntity<List<Integer>> getEmployeeIds(Integer managerId){
		
		List<Integer> data = this.userRepository.findBymanagerId(managerId).stream()
				.map((user)->{
					return user.getUserId();
				}).collect(Collectors.toList());
		return new ResponseEntity<List<Integer>>(data,HttpStatus.OK);
		
		
	}

	//Retrieves the list of delivarables by employee Id
	@Override
	public ResponseEntity<List<Delivarable>> getDelivarablesByEmployeeId(Integer employeeId) {

		List<Delivarable> list = this.delivarableRepository.findByemployeeId(employeeId);
		return new  ResponseEntity<List<Delivarable>>(list,HttpStatus.OK);
		
	}
	
	//Retrieve the user details by manager Id and employee Id
	@Override
	public ResponseEntity<User> getUserByManagerId(Integer employeeId, Integer managerId) {

		User user = this.userRepository.findByUserIdAndManagerId(employeeId, managerId);
		return  new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
