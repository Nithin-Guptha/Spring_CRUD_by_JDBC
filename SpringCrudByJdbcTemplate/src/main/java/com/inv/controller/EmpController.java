package com.inv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inv.entity.EmpEntity;
import com.inv.requestEntity.EmpRequest;
import com.inv.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@PostMapping("/insertData")
	public String insertData(@RequestBody EmpRequest empRequest) {
		
		return empService.insertData(empRequest);
	}

	@PutMapping("/updateData")
	public String updateData(@RequestBody EmpRequest empRequest) {
		
		return empService.updateData(empRequest);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		return empService.deleteData(id);
	}
	
	@GetMapping("/getData")
	public List<EmpEntity> getAllData(){
		return empService.getAllData();
	}
	@GetMapping("/getData/{id}")
	public List<EmpEntity> getAllDataById(@PathVariable int id){
		return empService.getAllDataById(id);
	}
}
