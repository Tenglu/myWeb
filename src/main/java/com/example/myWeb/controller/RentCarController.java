package com.example.myWeb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myWeb.model.Cars;
import com.example.myWeb.service.RentCarService;
import com.example.myWeb.service.impl.RentCarServiceImpl;

import io.swagger.annotations.ApiOperation;


@RestController("/rentacar")
public class RentCarController {
	@Autowired
	private RentCarService rentCarService;
    
	@ApiOperation(value = "Get user location and date information")
    @RequestMapping(value="/location/{location}/{startDate}/{endDate}", method = RequestMethod.GET, produces = "application/json")
    public List<Cars> rentLocation(@PathVariable String location, @PathVariable String startDate, @PathVariable String endDate) {
    	
    	return rentCarService.getAllCarsInfo(location,startDate,endDate);
    }
    
	@ApiOperation(value = "List all the informations")
    @RequestMapping(value="/reservation/{id}", method = RequestMethod.GET, produces = "application/json")
    public Map<String,String> reserveInfo(@PathVariable String id) {
    	Map map=new HashMap();
    	map=rentCarService.getReservationInfo(Integer.parseInt(id));
		return map;

    }
    

}
