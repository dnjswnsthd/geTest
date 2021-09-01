package com.example.demo.jpaTest.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpaTest.vo.EmployeeVo;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeVo, Long>{
	public List<EmployeeVo> findByEmpNo(long empNo);
	
}
