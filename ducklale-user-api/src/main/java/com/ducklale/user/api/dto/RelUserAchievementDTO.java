package com.ducklale.user.api.dto;

import java.io.Serializable;
import java.util.Date;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class RelUserAchievementDTO implements Serializable{
	private static final long serialVersionUID = 5491636014996012599L;
	//
	private Integer achievementId;
	//
	private Long userId;
	//
	private Date achievementDate;
	//
	private Long id;


	public RelUserAchievementDTO(){
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

	public void setAchievementDate(Date achievementDate) {
		this.achievementDate = achievementDate;
	}

	public Date getAchievementDate() {
		return this.achievementDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}




	@Override
	public String toString() {
		return  "RelUserAchievement ["
				+ "AchievementId = " + getAchievementId() + ","
				+ "UserId = " + getUserId() + ","
				+ "AchievementDate = " + getAchievementDate() + ","
				+ "Id = " + getId() + ","
				+"]";
	}

}


