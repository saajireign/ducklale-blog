package com.ducklale.user.domain.entity;

import java.io.Serializable;

//
/**
 * 
 * @author reign.gao
 * 2015年9月16日
 */
public class AchievementPO implements Serializable{
	private static final long serialVersionUID = 7911216569002072128L;

	//
	private Integer id;
	//成就名称
	private String achievementName;
	//
	private String achievementDescription;
	//成就点数
	private int achievementPoints;
	

	public AchievementPO(){
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


