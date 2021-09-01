package com.example.demo.jpaTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpaTest.repository.DepartmentRepository;
import com.example.demo.jpaTest.vo.DepartmentVo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentVo save(DepartmentVo dept) {
		departmentRepository.save(dept);
		return dept;
	}
}
