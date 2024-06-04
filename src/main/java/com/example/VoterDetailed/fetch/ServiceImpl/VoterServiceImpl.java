package com.example.VoterDetailed.fetch.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.VoterDetailed.fetch.Entity.Voterdto;
import com.example.VoterDetailed.fetch.Entity.Voterrequest;
import com.example.VoterDetailed.fetch.Exception1.EmptyEpicnumberException;
import com.example.VoterDetailed.fetch.Exception1.EpicnumberNotfoundException;
import com.example.VoterDetailed.fetch.Exception1.InvalidEpicException;
import com.example.VoterDetailed.fetch.Logentities.ApiLog;
import com.example.VoterDetailed.fetch.Logentities.ApiLog1;
import com.example.VoterDetailed.fetch.Repository.ApiLogRepository;
import com.example.VoterDetailed.fetch.Repository.ApiLogRepository1;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;
import com.example.VoterDetailed.fetch.Utils.PropertiesConfig;
import com.example.VoterDetailed.fetch.exception.EmptyEpicNumberException;
import com.example.VoterDetailed.fetch.exception.EpicNumberNotFoundException;
import com.example.VoterDetailed.fetch.exception.InvalidGetAdditionalDataException;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class VoterServiceImpl implements VoterDetailedService {

	private final RestTemplate restTemplate;

	private final String apiKey;

	@Autowired
	ApiLogRepository apiLogRepository;

	@Autowired
	ApiLogRepository1 apiLogRepository1;

	private static final Logger logger = LoggerFactory.getLogger(VoterServiceImpl.class);

	@Autowired
	PropertiesConfig config;

	@Autowired
	public VoterServiceImpl(RestTemplate restTemplate, @Value("${api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiKey = apiKey;
	}

	@Override
	public String getfetchAll(Voterrequest dto, HttpServletRequest request, HttpServletResponse response) {

		String APIURL = config.getVoterApiURl();

		String requestUrl = request.getRequestURI().toString();

		int statusCode = response.getStatus();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
		String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"getAdditionalData\": \""
				+ dto.getGetAdditionalData() + "\"}";

		Gson gson = new Gson();

		String requestBodyJson = gson.toJson(dto);
		HttpEntity<String> request1 = new HttpEntity(requestBodyJson, headers);

		System.out.println("Requestbody  " + requestBody);

		ApiLog apiLog = new ApiLog();
		apiLog.setUrl(requestUrl);
		apiLog.setRequestBody(requestBodyJson);

		try {
			String response1 = restTemplate.postForObject(APIURL, request1, String.class);
			apiLog.setResponseBody(response1);
			apiLog.setStatusCode(HttpStatus.OK.value());
			return response1;
		} catch (HttpClientErrorException.NotFound e) {
			String errorMessage = e.getResponseBodyAsString();

			apiLog.setResponseBody(errorMessage);
			apiLog.setStatusCode(e.getStatusCode().value());
			logger.error("Error Response: {}", errorMessage);
			if (errorMessage.contains("epicNumber is not found")) {
				throw new EpicNumberNotFoundException("epicNumber is not found");
			} else {
				throw e;
			}
		} catch (HttpClientErrorException.BadRequest e) {
			String errorMessage = e.getResponseBodyAsString();
			apiLog.setResponseBody(errorMessage);
			apiLog.setStatusCode(e.getStatusCode().value());
			logger.error("Error Response: {}", errorMessage);
			if (errorMessage.contains("epicNumber is not allowed to be empty string")) {
				throw new EmptyEpicNumberException("epicNumber is not allowed to be empty string");
			} else if (errorMessage.contains("getAdditionalData can only  be 'true' or 'false'")
					|| dto.getGetAdditionalData().matches("[a-zA-Z]+")) {
				throw new InvalidGetAdditionalDataException("getAdditionalData can only  be 'true' or 'false'");

			} else {

				throw e;
			}
		} finally {
			apiLogRepository.save(apiLog);
		}

	}

	@Override
	public String getfetchdetails(Voterdto dto, HttpServletRequest request, HttpServletResponse response) {

		String APIURL = config.getSearchApiURl();

		String requestUrl = request.getRequestURI().toString();

		int statusCode = response.getStatus();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
		String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"name\": \"" + dto.getName() + "\"}";

		Gson gson = new Gson();

		String requestBodyJson = gson.toJson(dto);

		HttpEntity<String> request2 = new HttpEntity<>(requestBodyJson, headers);

		System.out.println("Requestbody  " + requestBody);

		ApiLog1 apiLog1 = new ApiLog1();
		apiLog1.setUrl(requestUrl);
		apiLog1.setRequestBody(requestBodyJson);

		try {
			String response2 = restTemplate.postForObject(APIURL, request2, String.class);
			apiLog1.setResponseBody(response2);
			apiLog1.setStatusCode(HttpStatus.OK.value());
			return response2;
		} catch (HttpClientErrorException.BadRequest e) {
			String errorMessage = e.getResponseBodyAsString();
			apiLog1.setResponseBody(errorMessage);
			apiLog1.setStatusCode(e.getStatusCode().value());
			logger.error("Error Response: {}", errorMessage);
			if (errorMessage.contains("\\\"epicNumber\\\" is not allowed to be empty")) {
				throw new EmptyEpicnumberException("\\\"epicNumber\\\" is not allowed to be empty");
			} else if (errorMessage.contains("epicNumber is not valid")) {

				throw new InvalidEpicException("epicNumber is not valid");
			} else {
				throw e;
			}
		} catch (HttpClientErrorException.NotFound e) {
			String errorMessage = e.getResponseBodyAsString();
			apiLog1.setResponseBody(errorMessage);
			apiLog1.setStatusCode(e.getStatusCode().value());
			logger.error("Error Response: {}", errorMessage);
			if (errorMessage.contains("")) {
				throw new EpicnumberNotfoundException("Epic number not found");
			} else {
				throw e;
			}
		} finally {
			apiLogRepository1.save(apiLog1);
		}

	}

}
