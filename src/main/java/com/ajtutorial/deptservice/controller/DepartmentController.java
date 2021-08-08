package com.ajtutorial.deptservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajtutorial.deptservice.DeptServiceApplication;
import com.ajtutorial.deptservice.bean.Department;
import com.ajtutorial.deptservice.util.DepartmentPopulator;

@RestController
@RequestMapping(path = {"/api/v1/dept"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
	
	@Value("${read.property.from.file}")
	private String userBucketPath;
	
	private static final Logger logger = LoggerFactory.getLogger(DeptServiceApplication.class);

	@GetMapping("/")
	public List<Department> getDeptList() {
		logger.info("Inside Save Department Method" + userBucketPath);	
		return DepartmentPopulator.getDepartmentList();
	}

	@GetMapping("/{id}")
	public Department getDeptById(@PathVariable("id") Integer deptId) {
		return DepartmentPopulator.getDeptById(deptId);
	}

	@PostMapping("/")
	public List<Department> saveDepartment(@RequestBody Department dept) {
		logger.info("Inside Save Department Method" + userBucketPath);	
		return DepartmentPopulator.addDepartment(dept);
	}
	
	@PutMapping("/")
	public List<Department> updateDepartment(@RequestBody Department dept) {
		logger.info("Inside Save Department Method" + userBucketPath);	
		return DepartmentPopulator.updateDepartment(dept);
	}
	
	@DeleteMapping("/{deptId}")
	public List<Department> deleteDepartment(@PathVariable Integer deptId) {
		logger.info("Inside Delete Department Method" + userBucketPath);	
		return DepartmentPopulator.deleteDepartment(deptId);
	}
}
