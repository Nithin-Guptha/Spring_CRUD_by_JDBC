package com.inv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inv.entity.EmpEntity;
import com.inv.repository.EmpDao;
import com.inv.requestEntity.EmpRequest;

@Service
public class EmpService {
	@Autowired
	private EmpDao empDao;

	public String insertData(EmpRequest empRequest) {
		EmpEntity ee=new EmpEntity();
		ee.setId(empRequest.getId());
		ee.setEname(empRequest.getEname());
		ee.setSal(empRequest.getSal());
		ee.setRole(empRequest.getRole());
		return empDao.insertData(ee);
	}

	public String updateData(EmpRequest empRequest) {
		EmpEntity ee=new EmpEntity();
		ee.setId(empRequest.getId());
		ee.setEname(empRequest.getEname());
		ee.setSal(empRequest.getSal());
		ee.setRole(empRequest.getRole());
		return empDao.updateData(ee);
	}

	public String deleteData(int id) {
		
		return empDao.deleteData(id);
	}

	public List<EmpEntity> getAllData() {
		return empDao.getAllData();
	}

	public List<EmpEntity> getAllDataById(int id) {
	
		return empDao.getAllDataById(id);
	}

}
