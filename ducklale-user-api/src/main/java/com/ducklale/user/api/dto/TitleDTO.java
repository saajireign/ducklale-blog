package com.ducklale.user.api.dto;

import java.io.Serializable;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class TitleDTO implements Serializable{
	private static final long serialVersionUID = -212045070833417898L;


	//成就点数
	private Long achievementPoints;
	//等级名称
	private String title;
	//
	private Integer id;


	public TitleDTO(){
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


