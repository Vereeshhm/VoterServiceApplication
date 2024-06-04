package com.example.VoterDetailed.fetch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;
//import com.example.VoterDetailed.fetch.Response.VoterResponse;
//import com.example.VoterDetailed.fetch.Response.Voterdetailedresponse;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DetailedController {

	@Autowired
	VoterDetailedService detailedService;

	@PostMapping("api/voterid/detailedsearch")
	public String fetchAll(@RequestBody Voterrequest dto, HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {

		return detailedService.getfetchAll(dto, request, response);
	}

	@PostMapping("api/voterid/fetch")
	public String fetchdetails(@RequestBody Voterdto dto, HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {

		return detailedService.getfetchdetails(dto, request, response);
	}
}
