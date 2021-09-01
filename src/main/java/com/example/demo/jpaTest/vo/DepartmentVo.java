package com.example.demo.jpaTest.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="department")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVo {
	// PK 부서코드 
	@Id
	@Column(nullable = false)
	private String depCode;
	
	// 부서명
	@Column (nullable = true)
	private String depName;
	
	
	public DepartmentVo() {}
	
	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public DepartmentVo(String depCode) {
		this.depCode = depCode;
	}

	
	@Builder
	public DepartmentVo(String depCode, String depName) {
		this.depCode = depCode;
		this.depName = depName;
	}
}
