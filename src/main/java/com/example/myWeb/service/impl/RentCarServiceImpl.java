package com.example.myWeb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.myWeb.model.Cars;
import com.example.myWeb.service.RentCarService;

@Service
public class RentCarServiceImpl implements RentCarService {
	static String startDate;
	static String endDate;
	static String location;
	
	@Override
	public List<Cars> getAllCarsInfo(String location,String startDate,String endDate) {
		this.startDate=startDate;
		this.endDate=endDate;
		this.location=location;
		List<Cars> cars=new ArrayList<Cars>();
		cars.add(new Cars(1,"Toyota Camry",2));
		cars.add(new Cars(2,"BMW 650",2));
		return cars;
	}

	@Override
	public Map<String,String> getReservationInfo(int id) {
		Map reservationInfo=new HashMap();
		List<Cars> cars=new ArrayList<Cars>();
		cars.add(new Cars(1,"Toyota Camry",2));
		cars.add(new Cars(2,"BMW 650",2));
		
		reservationInfo.put("Model Name", cars.get(id).getCarModelName());
		reservationInfo.put("Location", location);
		reservationInfo.put("Start Date", startDate);
		reservationInfo.put("End Date", endDate);
		return reservationInfo;
	}


}
