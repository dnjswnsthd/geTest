package com.example.demo.jpaTest.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="employee")
@SequenceGenerator(name = "GENERATOR", sequenceName = "SEQ", initialValue = 100000, allocationSize = 1)
public class EmployeeVo {
	// PK 사번(10000부터 시작 추가시 1씩 증가)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR")
	@Column(name = "empNo", nullable = false, unique = true)
	private Long empNo;
	// 사원 이름
	@Column(nullable = false, length = 10)
	private String empName;
	// 사원 직급
	@Column(nullable = false, length = 10)
	private String empPosition;
	// 사원 직책
	@Column(nullable = false, length = 10)
	private String empRank;
	// 연락처
	@Column(nullable = false, length = 20)
	private String empContact;
	// 입사일
	@Column(nullable = false)
	private String dateOfEntry;
	// 퇴사일
	private String resignationDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "depCode", nullable = false)
	private DepartmentVo dep;
	
	public EmployeeVo() {}
	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPositon) {
		this.empPosition = empPositon;
	}

	public String getEmpRank() {
		return empRank;
	}

	public void setEmpRank(String empRank) {
		this.empRank = empRank;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(String resignationDate) {
		this.resignationDate = resignationDate;
	}

	public DepartmentVo getDep() {
		return dep;
	}

	public void setDep(DepartmentVo dep) {
		this.dep = dep;
	}
	
	@Builder
	public EmployeeVo(String empName, String empPosition, String empRank, String dateOfEntry, String resignationDate, String depCode) {
		this.empName = empName;
		this.empPosition = empPosition;
		this.empRank = empRank;
		this.dateOfEntry = dateOfEntry;
		this.resignationDate = resignationDate;
		this.dep = new DepartmentVo(depCode);
	}
}
