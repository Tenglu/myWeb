package com.example.myWeb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myWeb.model.Cars;
import com.example.myWeb.model.UserInfo;
import com.example.myWeb.service.RentCarService;

import io.swagger.annotations.ApiOperation;


@RestController()
public class RentCarController {
	@Autowired
	private RentCarService rentCarService;
    
	@ApiOperation(value = "Get user location and date information")
    @RequestMapping(value="/location", method = RequestMethod.GET, produces = "application/json")
    public List<Cars> rentLocation(@RequestParam int userId, @RequestParam String location, @RequestParam String startDate, @RequestParam String endDate) {
  
    	return rentCarService.getAvailableCarsInfo(userId,location,startDate,endDate);
    }
    
	@ApiOperation(value = "List all the informations")
    @RequestMapping(value="/reservation", method = RequestMethod.GET, produces = "application/json")
    public Map<String,String> reserveInfo(@RequestParam int userId,@RequestParam String carId) {
    	Map map=new HashMap();
    	map=rentCarService.getReservationInfo(userId,Integer.parseInt(carId));
		return map;
    }
	
	 @RequestMapping(value="/print", method = RequestMethod.GET, produces = "application/json")
	public List<UserInfo> printUserInfo(){
		return rentCarService.getAllUsersInfo();
	}
    

}
