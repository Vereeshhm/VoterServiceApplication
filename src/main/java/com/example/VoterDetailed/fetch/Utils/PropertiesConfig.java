package com.example.VoterDetailed.fetch.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class PropertiesConfig {

	
	@Value("${Voter.ApiURl}")  
	private String VoterApiURl;

	public String getVoterApiURl() {
		return VoterApiURl;
	}

	public void setVoterApiURl(String voterApiURl) {
		VoterApiURl = voterApiURl;
	}
	
	@Value("${Search.ApiURl}")                      
	private String SearchApiURl;

	public String getSearchApiURl() {
		return SearchApiURl;
	}

	public void setSearchApiURl(String searchApiURl) {
		SearchApiURl = searchApiURl;
	}
}
