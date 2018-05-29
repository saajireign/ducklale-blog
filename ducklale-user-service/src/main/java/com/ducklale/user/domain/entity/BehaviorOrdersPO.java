package com.ducklale.user.domain.entity;

import java.io.Serializable;


//
/**
 * 
 * @author reign.gao
 * 2015年9月16日
 */
public class BehaviorOrdersPO implements Serializable{
	private static final long serialVersionUID = 4187071698966405669L;

	//
	private Integer id;
	//序号别名
	private String orderName;
	

	public BehaviorOrdersPO(){
	}
	


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getOrderName() {
		return this.orderName;
	}




	@Override
	public String toString() {
		return  "BehaviorOrders ["
			+ "Id = " + getId() + ","
			+ "OrderName = " + getOrderName() + ","
		+"]";
	}
	
}


