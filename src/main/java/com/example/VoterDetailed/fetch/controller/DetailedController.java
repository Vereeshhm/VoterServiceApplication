package com.example.VoterDetailed.fetch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;
import com.example.VoterDetailed.fetch.Response.VoterResponse;
import com.example.VoterDetailed.fetch.Response.Voterdetailedresponse;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class DetailedController {

	
	@Autowired
	VoterDetailedService  detailedService;
	
	
	@PostMapping("api/voterid/detailedsearch")
	public ResponseEntity<Voterdetailedresponse>fetchAll(@RequestBody Voterrequest dto) throws JsonProcessingException
	{
		Voterdetailedresponse response=detailedService.getfetchAll(dto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("api/voterid/fetch")
	public ResponseEntity<VoterResponse>fetchdetails(@RequestBody Voterdto dto) throws JsonProcessingException
	{
		VoterResponse response=detailedService.getfetchdetails(dto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
