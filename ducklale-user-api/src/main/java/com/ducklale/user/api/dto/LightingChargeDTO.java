package com.ducklale.user.api.dto;

import java.io.Serializable;
import java.util.Date;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class LightingChargeDTO implements Serializable{
	private static final long serialVersionUID = 5826803549293492440L;
	//
	private Long id;
	//
	private Long userId;
	//
	private int lightingPoints;
	//0表示收入，1表示支出
	private int chargingStatus;
	//
	private String action;
	//流水发生的日期
	private Date chargeDate;


	public LightingChargeDTO(){
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

	public void setLightingPoints(int lightingPoints) {
		this.lightingPoints = lightingPoints;
	}

	public int getLightingPoints() {
		return this.lightingPoints;
	}

	public void setChargingStatus(int chargingStatus) {
		this.chargingStatus = chargingStatus;
	}

	public int getChargingStatus() {
		return this.chargingStatus;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return this.action;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public Date getChargeDate() {
		return this.chargeDate;
	}




	@Override
	public String toString() {
		return  "LightingCharge ["
				+ "Id = " + getId() + ","
				+ "UserId = " + getUserId() + ","
				+ "LightingPoints = " + getLightingPoints() + ","
				+ "ChargingStatus = " + getChargingStatus() + ","
				+ "Action = " + getAction() + ","
				+ "ChargeDate = " + getChargeDate() + ","
				+"]";
	}
	
}


