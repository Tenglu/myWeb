package com.example.myWeb.service;

import java.util.List;
import java.util.Map;

import com.example.myWeb.model.Cars;
import com.example.myWeb.model.UserInfo;

public interface RentCarService {

	public List<Cars> getAvailableCarsInfo(int userId, String location,String startDate,String endDate);

	public Map<String,String> getReservationInfo(int userId,int id);

	public List<UserInfo> getAllUsersInfo();
	
}
