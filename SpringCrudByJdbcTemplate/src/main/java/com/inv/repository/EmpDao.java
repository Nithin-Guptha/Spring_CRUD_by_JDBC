package com.inv.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inv.entity.EmpEntity;

@Repository
public class EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
   String result="";
	public String insertData(EmpEntity ee) {
		String sql="insert into emp values(?,?,?,?)";
		int i=jdbcTemplate.update(sql,ee.getId(),ee.getEname(),ee.getRole(),ee.getSal());
		if(i>0) {
			result="inserted";
		}else {
			result="not inserted";
		}
		return result;
	}
	public String updateData(EmpEntity ee) {
		String sql="update emp set ename=?,role=?,sal=? where id=?";
		int i=jdbcTemplate.update(sql,ee.getEname(),ee.getRole(),ee.getSal(),ee.getId());
		if(i>0) {
			result="updated";
		}else {
			result="not updated";
		}
		return result;
	}
	public String deleteData(int id) {
		String sql="delete from emp where id=?";
		int i=jdbcTemplate.update(sql,id);
		if(i>0) {
			result="deleted";
		}else {
			result="not deleted";
		}
		return result;
	}
	public List<EmpEntity> getAllData() {
		String sql="select * from emp";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmpEntity.class));
	}
	
	public List<EmpEntity> getAllDataById(int id) {
	    String sql = "select * from emp where id = ?";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmpEntity.class), id);
	}
}
