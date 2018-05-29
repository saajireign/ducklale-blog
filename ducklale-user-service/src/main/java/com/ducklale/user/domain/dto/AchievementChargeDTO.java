package com.ducklale.user.domain.dto;

import com.ducklale.domain.converter.impl.BeanCopyConverter;
import com.ducklale.user.domain.entity.AchievementChargePO;

import java.io.Serializable;
import java.util.Date;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class AchievementChargeDTO implements Serializable{
	private static final long serialVersionUID = -1290306098711189742L;

	//成就ID
	private Integer achievementId;
	//用户ID
	private Long userId;
	//0表示收入，1表示支出
	private int chargeStatus;
	//获得/失去的成就点数
	private int chargePoints;
	//
	private Long id;
	//流水的日期
	private Date chargeDate;


	public AchievementChargeDTO(){
	}



	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public Integer getAchievementId() {
		return this.achievementId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setChargeStatus(int chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public int getChargeStatus() {
		return this.chargeStatus;
	}

	public void setChargePoints(int chargePoints) {
		this.chargePoints = chargePoints;
	}

	public int getChargePoints() {
		return this.chargePoints;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public Date getChargeDate() {
		return this.chargeDate;
	}




	@Override
	public String toString() {
		return  "AchievementCharge ["
				+ "AchievementId = " + getAchievementId() + ","
				+ "UserId = " + getUserId() + ","
				+ "ChargeStatus = " + getChargeStatus() + ","
				+ "ChargePoints = " + getChargePoints() + ","
				+ "Id = " + getId() + ","
				+ "ChargeDate = " + getChargeDate() + ","
				+"]";
	}

}


