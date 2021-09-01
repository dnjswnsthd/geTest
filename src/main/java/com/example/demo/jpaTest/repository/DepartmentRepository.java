package com.example.demo.jpaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpaTest.vo.DepartmentVo;

public interface DepartmentRepository extends JpaRepository<DepartmentVo, String>{

}
