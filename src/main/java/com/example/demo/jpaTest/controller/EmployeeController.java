package com.example.demo.jpaTest.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpaTest.service.EmployeeService;
import com.example.demo.jpaTest.vo.EmployeeVo;

@RestController 
@RequestMapping("/employeeTest")
public class EmployeeController {
	// 기본형 
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	@Autowired 
	EmployeeService employeeService; 
	// 모든 회원 조회  produces = { MediaType.APPLICATION_JSON_VALUE } 
	@GetMapping("/searchAll") 
	public ResponseEntity<List<EmployeeVo>> getAllmembers() { 
		List<EmployeeVo> employee = employeeService.findAll(); 
		return new ResponseEntity<List<EmployeeVo>>(employee, HttpStatus.OK); 
	}
	// OBD부서의 퇴직하지 않은 팀장님 조회하기
	@GetMapping("/searchObdLeader")
	public ResponseEntity<EmployeeVo> getObdLeader() { 
		List<EmployeeVo> employee = employeeService.findAll();
		EmployeeVo employeeObdLeader = new EmployeeVo();
		for(int i = 0; i < employee.size(); i++) {
			if(employee.get(i).getEmpRank().equals("팀장") && employee.get(i).getDep().getDepCode().equals("OBD") && employee.get(i).getResignationDate().equals("")) {
				employeeObdLeader = employee.get(i);
			}
		}
		return new ResponseEntity<EmployeeVo>(employeeObdLeader, HttpStatus.OK); 
	}
	// 회원번호로 한명의 회원 조회 
	@GetMapping(value = "/searchOne/{empNo}", produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<EmployeeVo> getMember(@PathVariable("empNo") Long empNo) { 
		Optional<EmployeeVo>employee = employeeService.findById(empNo); 
		return new ResponseEntity<EmployeeVo>(employee.get(), HttpStatus.OK); 
	} 
	// 회원번호로 회원 삭제 
	@DeleteMapping(value = "/delete/{empNo}", produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<Void> deleteMember(@PathVariable("empNo") Long empNo) { 
		employeeService.deleteById(empNo); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	} 
	// 회원번호로 회원 수정(empNo로 회원을 찾아 Member 객체의 id, name로 수정함) 
	@PutMapping(value = "/modify/{empNo}", produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public ResponseEntity<EmployeeVo> updateMember(@PathVariable("mbrNo") Long empNo, EmployeeVo employee) { 
		employeeService.updateById(empNo, employee); 
		return new ResponseEntity<EmployeeVo>(employee, HttpStatus.OK); 
	} 
	// 회원 입력 
	@PostMapping ("/add")
	public ResponseEntity<EmployeeVo> save(EmployeeVo employee) { 
		return new ResponseEntity<EmployeeVo>(employeeService.save(employee), HttpStatus.OK); 
	}
	// 회원 입력 
	@RequestMapping(value="/saveEmployee", method = RequestMethod.GET) 
	public ResponseEntity<EmployeeVo> save(HttpServletRequest req, EmployeeVo employee){ 
		return new ResponseEntity<EmployeeVo>(employeeService.save(employee), HttpStatus.OK); 
	}
}
