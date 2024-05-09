package com.example.VoterDetailed.fetch.Service;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;
import com.example.VoterDetailed.fetch.Response.VoterResponse;
import com.example.VoterDetailed.fetch.Response.Voterdetailedresponse;


public interface VoterDetailedService {

public	Voterdetailedresponse getfetchAll(Voterrequest dto);

public VoterResponse getfetchdetails(Voterdto dto);



}
