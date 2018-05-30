package com.ducklale.user.api.dto;

import java.io.Serializable;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class AchievementDTO implements Serializable{
	private static final long serialVersionUID = 7960950978614211335L;

	//
	private Integer id;
	//成就名称
	private String achievementName;
	//
	private String achievementDescription;
	//成就点数
	private int achievementPoints;

	private Integer achievementGrade;

	public Integer getAchievementGrade() {
		return achievementGrade;
	}

	public void setAchievementGrade(Integer achievementGrade) {
		this.achievementGrade = achievementGrade;
	}

	public AchievementDTO(){
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}

	public String getAchievementName() {
		return this.achievementName;
	}

	public void setAchievementDescription(String achievementDescription) {
		this.achievementDescription = achievementDescription;
	}

	public String getAchievementDescription() {
		return this.achievementDescription;
	}

	public void setAchievementPoints(int achievementPoints) {
		this.achievementPoints = achievementPoints;
	}

	public int getAchievementPoints() {
		return this.achievementPoints;
	}




	@Override
	public String toString() {
		return  "Achievement ["
				+ "Id = " + getId() + ","
				+ "AchievementName = " + getAchievementName() + ","
				+ "AchievementDescription = " + getAchievementDescription() + ","
				+ "AchievementPoints = " + getAchievementPoints() + ","
				+"]";
	}
}


