package com.example.myWeb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myWeb.model.Cars;
import com.example.myWeb.model.UserInfo;
import com.example.myWeb.service.RentCarService;
import com.google.common.base.Optional;

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
		return rentCarService.getReservationInfo(userId,Integer.parseInt(carId));
    }
	
	@RequestMapping(value="/confirmation", method = RequestMethod.GET, produces = "application/json")
    public Map<String,String> confirmBooking(@RequestParam int userId) {
         return rentCarService.confirmBooking(userId);
    }
	
	@RequestMapping(value="/getBookingInfo", method = RequestMethod.GET, produces = "application/json")
    public UserInfo printUserInfo(@RequestParam int userId){
	    
        return rentCarService.getBookingInfo(userId).get();
    }
	
	 @RequestMapping(value="/getAllUsersInfo", method = RequestMethod.GET, produces = "application/json")
	public List<UserInfo> getAllUsersInfo(){
		return rentCarService.getAllUsersInfo();
	}
    
	 @RequestMapping(value="/cancelBooking", method = RequestMethod.GET, produces = "application/json")
	    public Map<String,String> cancelBooking(@RequestParam int userId){
	        return rentCarService.cancelBooking(userId);
	    }
	 
	 
	 @RequestMapping(value="/getStockInfo", method = RequestMethod.GET, produces = "application/json")
     public List<Cars> getStockInfo(){
         return rentCarService.getStockInfo();
     }
  

}
