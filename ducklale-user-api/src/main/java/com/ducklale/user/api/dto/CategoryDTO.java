package com.ducklale.user.api.dto;

import java.io.Serializable;
import java.sql.*;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = -474561958684581355L;

	//
	private int id;
	//
	private String categoryName;
	

	public CategoryDTO(){
	}
	


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return this.categoryName;
	}




	@Override
	public String toString() {
		return  "Category ["
			+ "Id = " + getId() + ","
			+ "CategoryName = " + getCategoryName() + ","
		+"]";
	}
	
}


