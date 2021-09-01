package com.example.demo.jpaTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpaTest.service.DepartmentService;
import com.example.demo.jpaTest.vo.DepartmentVo;

@RestController 
@RequestMapping("/departmentTest")
public class DepartmentController {
	// 기본형 
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DepartmentService deptService;
	
	@PostMapping("/add")
	public ResponseEntity<DepartmentVo> save(DepartmentVo dept) { 
		return new ResponseEntity<DepartmentVo>(deptService.save(dept), HttpStatus.OK); 
	}
}
