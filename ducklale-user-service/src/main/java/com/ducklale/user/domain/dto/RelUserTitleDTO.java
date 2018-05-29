package com.ducklale.user.domain.dto;

import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年9月16日
 */
public class RelUserTitleDTO implements Serializable{
	private static final long serialVersionUID = 8685163490670607943L;


	//
	private Integer titleId;
	//
	private Long userId;
	//
	private Long id;


	public RelUserTitleDTO(){
	}



	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getTitleId() {
		return this.titleId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}




	@Override
	public String toString() {
		return  "RelUserTitle ["
				+ "TitleId = " + getTitleId() + ","
				+ "UserId = " + getUserId() + ","
				+ "Id = " + getId() + ","
				+"]";
	}
	
}


