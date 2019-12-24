package com.example.myWeb.service;

import java.util.List;
import java.util.Map;

import com.example.myWeb.model.Cars;

public interface RentCarService {

	public List<Cars> getAllCarsInfo(String location,String startDate,String endDate);

	public Map<String,String> getReservationInfo(int id);

	
}
