package com.example.demo.domain.model;

public class UserData {
	
	private String userName;
	private Long availablePoint;
	private Boolean isGuest;
	
	public UserData() {
		// Default Constructor(Empty).
	}
	
	public String getUserName() {
		return this.userName;
	}
	public Long getAvailablePoint() {
		return this.availablePoint;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAvailablePoint(Long avalilablePoint) {
		this.availablePoint = avalilablePoint;
	}
	public Boolean getIsGuest() {
		return isGuest;
	}
	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}
}
