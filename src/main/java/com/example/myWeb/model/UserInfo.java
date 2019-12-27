package com.example.myWeb.model;

import java.util.Date;

public class UserInfo {
	private int userId;
	private int carId;
	private String location;
	private String startDate;
	private String endDate;
	private String status;
	
	public UserInfo() {
	    status="draft";
	}
	
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
	public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String errorMsg() {
        StringBuffer errorMsg=new StringBuffer();
        if(this.getCarId()==0) {
            errorMsg.append("You should select the car. ");
        }
        if(this.getEndDate()==null||this.getStartDate()==null) {
            errorMsg.append("You should select the date. ");
        }
        if(this.getLocation()==null) {
            errorMsg.append("You should select the location. ");
        }
        if(this.getStatus()=="booked") {
            errorMsg.append("You have already booked a car");
        }
        return errorMsg.toString();
    }
    
    @Override
    public String toString() {
        return "UserInfo [userId=" + userId + ", carId=" + carId + ", location=" + location + ", startDate=" + startDate
                + ", endDate=" + endDate + ", status=" + status + "]";
    }

	
}
