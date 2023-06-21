package com.college.college.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.college.Entity.CollegeEntity;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@GetMapping("/{collegeId}")
	 public ResponseEntity<CollegeEntity> getCollegeDetails(@PathVariable("collegeId") Long collegeId ){

	CollegeEntity c = new CollegeEntity();
	c.setCollegeId(1l);
	c.setCollegeName("Hello");
	c.setAddress("Mumbai");
	
	
	return new ResponseEntity<CollegeEntity>(c,HttpStatus.OK);
	}

}
