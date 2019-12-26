package com.example.myWeb.model;

import java.util.Date;

public class UserInfo {
	private int userId;
	private int carId;
	private String location;
	private String startDate;
	private String endDate;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", carId=" + carId + ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}
