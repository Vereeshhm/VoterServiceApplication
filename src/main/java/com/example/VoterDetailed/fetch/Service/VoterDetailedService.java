package com.example.VoterDetailed.fetch.Service;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;




public interface VoterDetailedService {

public	Object getfetchAll(Voterrequest dto);

public Object getfetchdetails(Voterdto dto);



}
