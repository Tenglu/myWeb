package com.example.myWeb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myWeb.model.Cars;
import com.example.myWeb.model.UserInfo;
import com.example.myWeb.service.RentCarService;



@Service
public class RentCarServiceImpl implements RentCarService {
	static String startDate;
	static String endDate;
	static String location;
	List<Cars> cars;
	List <UserInfo> userList;
	
	public RentCarServiceImpl () {
		cars=new ArrayList<Cars>();
		cars.add(new Cars(1,"Toyota Camry",2));
		cars.add(new Cars(2,"BMW 650",2));
		
		userList=new ArrayList<UserInfo>();
	}
	
	
	
	@Override
	public List<Cars> getAvailableCarsInfo(int userId, String location,String startDate,String endDate) {
		UserInfo userInfo =userList.stream().
				filter(userList -> userList.getUserId()==userId).findAny().orElse(new UserInfo());
		userInfo.setUserId(userId);
		userInfo.setLocation(location);
		userInfo.setStartDate(startDate);
		userInfo.setEndDate(endDate);
		System.out.println(userInfo.toString());
		userList.add(userInfo);
		return cars;
	}

	@Override
	public Map<String,String> getReservationInfo(int userId,int carId) {
		UserInfo userInfo =userList.stream().
				filter(userList -> userList.getUserId()==userId).findAny().orElse(new UserInfo());
		userInfo.setCarId(carId);
		Map reservationInfo=new HashMap();
		
		reservationInfo.put("Model Name", cars.get(userInfo.getCarId()).getCarModelName());
		reservationInfo.put("Location", userInfo.getLocation());
		reservationInfo.put("Start Date", userInfo.getStartDate());
		reservationInfo.put("End Date", userInfo.getEndDate());
		return reservationInfo;
	}



	@Override
	public List<UserInfo> getAllUsersInfo() {
		return userList;
	}
	
	


}
