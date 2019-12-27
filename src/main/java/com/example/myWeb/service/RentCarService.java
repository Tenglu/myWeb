package com.example.myWeb.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.myWeb.model.Cars;
import com.example.myWeb.model.UserInfo;

public interface RentCarService {

	public List<Cars> getAvailableCarsInfo(int userId, String location,String startDate,String endDate);

	public Map<String,String> getReservationInfo(int userId,int id);

	public List<UserInfo> getAllUsersInfo();
	
	public Map<String,String> confirmBooking(int userId);
	
	public Optional<UserInfo> getBookingInfo(int userId);
	
	public Map<String,String> cancelBooking(int userId);
	
	public List<Cars> getStockInfo();
}
