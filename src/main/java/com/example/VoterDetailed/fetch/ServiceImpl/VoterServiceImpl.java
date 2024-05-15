package com.example.VoterDetailed.fetch.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;
import com.example.VoterDetailed.fetch.Exception1.EmptyEpicnumberException;
import com.example.VoterDetailed.fetch.Exception1.EpicnumberNotfoundException;
import com.example.VoterDetailed.fetch.Exception1.InvalidEpicException;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;

import com.example.VoterDetailed.fetch.Utils.PropertiesConfig;
import com.example.VoterDetailed.fetch.exception.EmptyEpicNumberException;
import com.example.VoterDetailed.fetch.exception.EpicNumberNotFoundException;
import com.example.VoterDetailed.fetch.exception.InvalidGetAdditionalDataException;





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
	public Object getfetchAll(Voterrequest dto) {

		String APIURL = config.getVoterApiURl();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
		String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"getAdditionalData\": \""
				+ dto.getGetAdditionalData() + "\"}";

		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

		System.out.println("Requestbody  " + requestBody);

		try {
            Object response = restTemplate.postForObject(APIURL, request, Object.class);
            return response;
        } catch (HttpClientErrorException.NotFound e) {
            String errorMessage = e.getResponseBodyAsString();
            logger.error("Error Response: {}", errorMessage);
            if (errorMessage.contains("epicNumber is not found")) {
                throw new EpicNumberNotFoundException("epicNumber is not found");
            } else {
                throw e;
            }
        }
		catch (HttpClientErrorException.BadRequest e) {
		    String errorMessage = e.getResponseBodyAsString();
		    logger.error("Error Response: {}", errorMessage);
		    if (errorMessage.contains("epicNumber is not allowed to be empty string")) {
		        throw new EmptyEpicNumberException("epicNumber is not allowed to be empty string");
		    } else if (errorMessage.contains("getAdditionalData can only  be 'true' or 'false'")||dto.getGetAdditionalData().matches("[a-zA-Z]+")) {
				throw new InvalidGetAdditionalDataException("getAdditionalData can only  be 'true' or 'false'");
			} else {
				throw e;
			}
		}
		
	}

	@Override
	public Object getfetchdetails(Voterdto dto) {
		

		String APIURL = config.getSearchApiURl();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
		String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"name\": \"" + dto.getName() + "\"}";

		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

		System.out.println("Requestbody  " + requestBody);
//		Object response1 = restTemplate.postForObject(APIURL, request, Object.class);
//
//		return response1;
		try {
            Object response = restTemplate.postForObject(APIURL, request, Object.class);
            return response;
        } catch (HttpClientErrorException.BadRequest e) {
            String errorMessage = e.getResponseBodyAsString();
            logger.error("Error Response: {}", errorMessage);
            if (errorMessage.contains("\\\"epicNumber\\\" is not allowed to be empty")) {
                throw new EmptyEpicnumberException("\\\"epicNumber\\\" is not allowed to be empty");
            } else if(errorMessage.contains("epicNumber is not valid")){
            	
            	 throw new InvalidEpicException("epicNumber is not valid");
            }else {
                throw e;
            }
        }
		catch(HttpClientErrorException.NotFound e)
		{
			String errorMessage=e.getResponseBodyAsString();
			logger.error("Error Response: {}", errorMessage);
			if(errorMessage.contains("")) {
				throw new EpicnumberNotfoundException("Epic number not found");
			}else {
				throw e;
			}
		}
	
	}

}
