package com.ducklale.user.domain.entity;

import java.io.Serializable;

//
/**
 * 
 * @author reign.gao
 * 2015年9月16日
 */
public class RelUserGradePO implements Serializable{
	private static final long serialVersionUID = 3868567702710717773L;

	//
	private Long id;
	//
	private Long userId;
	//
	private Integer gradeId;
	

	public RelUserGradePO(){
	}
	


	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return this.userId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	public Integer getGradeId() {
		return this.gradeId;
	}




	@Override
	public String toString() {
		return  "RelUserGrade ["
			+ "Id = " + getId() + ","
			+ "UserId = " + getUserId() + ","
			+ "GradeId = " + getGradeId() + ","
		+"]";
	}
	
}


