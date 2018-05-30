package com.ducklale.user.api.dto;

import java.io.Serializable;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class BehaviorOrdersDTO implements Serializable{
	private static final long serialVersionUID = 4205249022939865669L;
	//
	private Integer id;
	//序号别名
	private String orderName;


	public BehaviorOrdersDTO(){
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


