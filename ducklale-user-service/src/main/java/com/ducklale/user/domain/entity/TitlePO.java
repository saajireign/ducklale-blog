package com.ducklale.user.domain.entity;

import java.io.Serializable;

//
/**
 * 
 * @author reign.gao
 * 2015年9月16日
 */
public class TitlePO implements Serializable{
	private static final long serialVersionUID = -256662139158725835L;

	//成就点数
	private Long achievementPoints;
	//等级名称
	private String title;
	//
	private Integer id;
	

	public TitlePO(){
	}
	


	public void setAchievementPoints(Long achievementPoints) {
		this.achievementPoints = achievementPoints;
	}
	
	public Long getAchievementPoints() {
		return this.achievementPoints;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}




	@Override
	public String toString() {
		return  "Title ["
			+ "AchievementPoints = " + getAchievementPoints() + ","
			+ "Title = " + getTitle() + ","
			+ "Id = " + getId() + ","
		+"]";
	}
	
}


