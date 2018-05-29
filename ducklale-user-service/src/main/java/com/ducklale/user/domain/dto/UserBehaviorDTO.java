package com.ducklale.user.domain.dto;

import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class UserBehaviorDTO implements Serializable{
	private static final long serialVersionUID = -3617946113295742994L;

	//
	private Long id;
	//用户id
	private Long userId;
	//回敬词汇
	private String sayingWords;
	//回敬序号
	private Integer sayingOrder;


	public UserBehaviorDTO(){
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

	public void setSayingWords(String sayingWords) {
		this.sayingWords = sayingWords;
	}

	public String getSayingWords() {
		return this.sayingWords;
	}

	public void setSayingOrder(Integer sayingOrder) {
		this.sayingOrder = sayingOrder;
	}

	public Integer getSayingOrder() {
		return this.sayingOrder;
	}




	@Override
	public String toString() {
		return  "UserBehavior ["
				+ "Id = " + getId() + ","
				+ "UserId = " + getUserId() + ","
				+ "SayingWords = " + getSayingWords() + ","
				+ "SayingOrder = " + getSayingOrder() + ","
				+"]";
	}

}


