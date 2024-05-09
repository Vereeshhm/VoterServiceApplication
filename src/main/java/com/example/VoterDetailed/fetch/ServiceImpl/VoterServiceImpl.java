package com.example.VoterDetailed.fetch.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.VoterDetailed.fetch.Entity.Voterrequest;
import com.example.VoterDetailed.fetch.Response.Voterdetailedresponse;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;
import com.example.VoterDetailed.fetch.Utils.PropertiesConfig;

@Service
public class VoterServiceImpl implements VoterDetailedService {

	private final RestTemplate restTemplate;

	private final String apiKey;

	private static final Logger logger = LoggerFactory.getLogger(VoterServiceImpl.class);

	@Autowired
	PropertiesConfig config;

	@Autowired
	public VoterServiceImpl(RestTemplate restTemplate, @Value("${api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiKey = apiKey;
	}

	@Override
	public Voterdetailedresponse getfetchAll(Voterrequest dto) {

		String APIURL = config.getVoterApiURl();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
		String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"getAdditionalData\": \""
				+ dto.getGetAdditionalData() + "\"}";

		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

		System.out.println("Requestbody  " + requestBody);
		Voterdetailedresponse response = restTemplate.postForObject(APIURL, request, Voterdetailedresponse.class);
        logger.info(response+"");;
		return response;
	}

}
