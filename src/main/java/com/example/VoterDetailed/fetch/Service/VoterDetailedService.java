package com.example.VoterDetailed.fetch.Service;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public interface VoterDetailedService {

public	String getfetchAll(Voterrequest dto,HttpServletRequest request, HttpServletResponse response);

public String getfetchdetails(Voterdto dto,HttpServletRequest request, HttpServletResponse response);



}
