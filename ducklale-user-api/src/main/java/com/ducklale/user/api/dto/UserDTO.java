package com.ducklale.user.api.dto;

import java.io.Serializable;
import java.util.Date;

//

/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class UserDTO implements Serializable{
	private static final long serialVersionUID = -3677764615403085334L;

	//
	private Long id;
	//用户名
	private String userName;
	//密码
	private String password;
	//手机号
	private String mobile;
	//真实姓名
	private String realName;
	//昵称
	private String nickName;
	//生日
	private Date birthday;
	// 身份证
	private String identityNo;
	//显示在主页的成就
	private String showingAchievement;
	//自我介绍
	private String selfIntroduction;
	//移除flag
	private boolean removeFlag;
	//qq号码
	private String qqNo;
	//头像地址
	private String headIconUri;
	//
	private int achievementPoints;


	public UserDTO(){
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getIdentityNo() {
		return this.identityNo;
	}

	public void setShowingAchievement(String showingAchievement) {
		this.showingAchievement = showingAchievement;
	}

	public String getShowingAchievement() {
		return this.showingAchievement;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public String getSelfIntroduction() {
		return this.selfIntroduction;
	}

	public void setRemoveFlag(boolean removeFlag) {
		this.removeFlag = removeFlag;
	}

	public boolean getRemoveFlag() {
		return this.removeFlag;
	}

	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}

	public String getQqNo() {
		return this.qqNo;
	}

	public void setHeadIconUri(String headIconUri) {
		this.headIconUri = headIconUri;
	}

	public String getHeadIconUri() {
		return this.headIconUri;
	}

	public void setAchievementPoints(int achievementPoints) {
		this.achievementPoints = achievementPoints;
	}

	public int getAchievementPoints() {
		return this.achievementPoints;
	}




	@Override
	public String toString() {
		return  "User ["
				+ "Id = " + getId() + ","
				+ "UserName = " + getUserName() + ","
				+ "Password = " + getPassword() + ","
				+ "Mobile = " + getMobile() + ","
				+ "RealName = " + getRealName() + ","
				+ "NickName = " + getNickName() + ","
				+ "Birthday = " + getBirthday() + ","
				+ "IdentityNo = " + getIdentityNo() + ","
				+ "ShowingAchievement = " + getShowingAchievement() + ","
				+ "SelfIntroduction = " + getSelfIntroduction() + ","
				+ "RemoveFlag = " + getRemoveFlag() + ","
				+ "QqNo = " + getQqNo() + ","
				+ "HeadIconUri = " + getHeadIconUri() + ","
				+ "AchievementPoints = " + getAchievementPoints() + ","
				+"]";
	}

}


