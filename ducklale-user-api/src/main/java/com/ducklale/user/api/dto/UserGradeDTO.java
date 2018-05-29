package com.ducklale.user.domain.dto;

import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class UserGradeDTO implements Serializable{
	private static final long serialVersionUID = -3160266814024886892L;


	//
	private String name;
	//
	private Long id;
	//
	private int grade;
	//
	private int lightingPoint;


	public UserGradeDTO(){
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setLightingPoint(int lightingPoint) {
		this.lightingPoint = lightingPoint;
	}

	public int getLightingPoint() {
		return this.lightingPoint;
	}




	@Override
	public String toString() {
		return  "UserGrade ["
				+ "Name = " + getName() + ","
				+ "Id = " + getId() + ","
				+ "Grade = " + getGrade() + ","
				+ "LightingPoint = " + getLightingPoint() + ","
				+"]";
	}
	
}


