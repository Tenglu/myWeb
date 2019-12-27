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
	    UserInfo userInfo=userList.stream().
				filter(userList -> userList.getUserId()==userId).findAny().orElseGet(() -> new UserInfo());
	    userInfo.setUserId(userId);
		userInfo.setLocation(location);
		userInfo.setStartDate(startDate);
		userInfo.setEndDate(endDate);
		userList.add(userInfo);
		return cars;
	}

	@Override
	public Map<String,String> getReservationInfo(int userId,int carId) {
		UserInfo userInfo =userList.stream().
				filter(userList -> userList.getUserId()==userId).findAny().orElse(new UserInfo());
		userInfo.setCarId(carId);
		Map reservationInfo=new HashMap();	
		reservationInfo.put("Model Name", cars.stream().filter(c ->userInfo.getCarId()==c.getId()).findAny().get().getCarModelName());
		reservationInfo.put("Location", userInfo.getLocation());
		reservationInfo.put("Start Date", userInfo.getStartDate());
		reservationInfo.put("End Date", userInfo.getEndDate());
		return reservationInfo;
	}



	@Override
	public List<UserInfo> getAllUsersInfo() {
		return userList;
	}
	
	@Override
	public Map<String,String> confirmBooking(int userId) {
	    Map<String,String> resultMap=new HashMap<String,String>();
	    Optional<UserInfo> userInfo =userList.stream().
                filter(userList -> userList.getUserId()==userId).findAny();
	    userInfo.ifPresent(info -> {
	        if(cars.stream().filter(car -> info.getCarId()==car.getId()).findAny().get().getInStockNumber()>0) {
	            resultMap.put("errorMsg",info.errorMsg());
	            resultMap.put("result",info.errorMsg().equals("")?"success":"failed");
	        }
	        else {
	            resultMap.put("errorMsg","There is no enough car in stock");
                resultMap.put("result","failed");
	        }
	    });
	    if(!userInfo.isPresent()) {
	        resultMap.put("errorMsg","The user does not exist");
	        resultMap.put("result","failed");
	    }
	    if(resultMap.get("result").equals("success")) {    
	        userInfo.get().setStatus("booked");
	        cars.stream().filter(car -> car.getId()==userInfo.get().getCarId()).findAny().get().decrease();    
	    }else {
	        userInfo.get().setStatus("failed");
	    }
	    return resultMap;
	}



    @Override
    public Optional<UserInfo> getBookingInfo(int userId) {
        return userList.stream().
                filter(userList -> userList.getUserId()==userId).findAny();
    }



    @Override
    public Map<String,String> cancelBooking(int userId) {
        Map<String,String> resultMap=new HashMap<String,String>();
        Optional<UserInfo> userInfo =userList.stream().
                filter(userList -> userList.getUserId()==userId).findAny();
        userInfo.ifPresent(info -> {
            if(info.getStatus().equals("booked")) {
                resultMap.put("errorMsg","");
                resultMap.put("result","success");
            }else {
                resultMap.put("errorMsg","The Booking is not even success");
                resultMap.put("result","failed");
            }
            
        });
        if(!userInfo.isPresent()) {
            resultMap.put("errorMsg","The user does not exist");
            resultMap.put("result","failed");
        }
        if(resultMap.get("result").equals("success")) {
            cars.stream().filter(car -> car.getId()==userInfo.get().getCarId()).findAny().get().increase(); 
            userInfo.get().setStatus("cancelled");
        }
        return resultMap;
    }



    @Override
    public List<Cars> getStockInfo() {
        return cars;
    }

	


}
