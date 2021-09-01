package com.example.demo.jpaTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpaTest.repository.EmployeeRepository;
import com.example.demo.jpaTest.vo.EmployeeVo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeVo>findAll(){
		List<EmployeeVo> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> employees.add(e));
		return employees;
	}
	
	public Optional<EmployeeVo> findById(Long empNo){
		Optional<EmployeeVo> employee = employeeRepository.findById(empNo);
		return employee;
	}
	
	public void deleteById(Long empNo) {
		employeeRepository.deleteById(empNo);
	}
	
	public EmployeeVo save(EmployeeVo employee) {
		employeeRepository.save(employee);
		return employee;
	}
	public void updateById(Long empNo, EmployeeVo employee) {
		Optional<EmployeeVo> e = employeeRepository.findById(empNo);
		if(e.isPresent()) {
			e.get().setEmpNo(employee.getEmpNo());
			e.get().setEmpName(employee.getEmpName());
			e.get().setEmpPosition(employee.getEmpPosition());
			e.get().setEmpRank(employee.getEmpRank());
			e.get().setEmpContact(employee.getEmpContact());
			e.get().setDateOfEntry(employee.getDateOfEntry());
			e.get().setResignationDate(employee.getResignationDate());
			e.get().setDep(employee.getDep());
			employeeRepository.save(employee);
		}
	}
}
