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
import com.example.VoterDetailed.fetch.Logentities.ApiLog;
import com.example.VoterDetailed.fetch.Logentities.ApiLog1;
import com.example.VoterDetailed.fetch.Repository.ApiLogRepository;
import com.example.VoterDetailed.fetch.Repository.ApiLogRepository1;
import com.example.VoterDetailed.fetch.Service.VoterDetailedService;
import com.example.VoterDetailed.fetch.Utils.PropertiesConfig;
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

		ApiLog apiLog = new ApiLog();
		String response1 = null;
		try {
			String APIURL = config.getVoterApiURl();

			String requestUrl = request.getRequestURI().toString();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
			String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"getAdditionalData\": \""
					+ dto.getGetAdditionalData() + "\"}";

			Gson gson = new Gson();

			String requestBodyJson = gson.toJson(dto);
			HttpEntity<String> request1 = new HttpEntity(requestBodyJson, headers);

			System.out.println("Requestbody  " + requestBody);

			apiLog.setUrl(requestUrl);
			apiLog.setRequestBody(requestBodyJson);

			response1 = restTemplate.postForObject(APIURL, request1, String.class);
			apiLog.setResponseBody(response1);
			apiLog.setStatusCode(HttpStatus.OK.value());
			return response1;
		} catch (HttpClientErrorException.TooManyRequests e) {
			// Handling Too Many Requests Exception specifically
			apiLog.setStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());

			response1 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response1);
			apiLog.setResponseBodyAsJson("API rate limit exceeded");
		} catch (HttpClientErrorException.Unauthorized e) {
			// Handling Unauthorized Exception specifically
			apiLog.setStatusCode(HttpStatus.UNAUTHORIZED.value());

			response1 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response1);
			apiLog.setResponseBodyAsJson("No API key found in request");

		}

		catch (HttpClientErrorException e) {
			apiLog.setStatusCode(e.getStatusCode().value());

			response1 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response1);
			apiLog.setResponseBody(response1);
		}

		catch (Exception e) {
			apiLog.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

			response1 = e.getMessage();
			apiLog.setResponseBody(response1);
		}

		finally {
			apiLogRepository.save(apiLog);
		}
		return response1;

	}

	@Override
	public String getfetchdetails(Voterdto dto, HttpServletRequest request, HttpServletResponse response) {

		String response2 = null;
		ApiLog1 apiLog1 = new ApiLog1();
		try {
			String APIURL = config.getSearchApiURl();

			String requestUrl = request.getRequestURI().toString();

			int statusCode = response.getStatus();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", apiKey); // Include API key directly without "Bearer" prefix
			String requestBody = "{\"epicNumber\": \"" + dto.getEpicNumber() + "\", \"name\": \"" + dto.getName()
					+ "\"}";

			Gson gson = new Gson();

			String requestBodyJson = gson.toJson(dto);

			HttpEntity<String> request2 = new HttpEntity<>(requestBodyJson, headers);

			System.out.println("Requestbody  " + requestBody);

			apiLog1.setUrl(requestUrl);
			apiLog1.setRequestBody(requestBodyJson);

			response2 = restTemplate.postForObject(APIURL, request2, String.class);
			apiLog1.setResponseBody(response2);
			apiLog1.setStatusCode(HttpStatus.OK.value());
			return response2;
		} catch (HttpClientErrorException.TooManyRequests e) {
			// Handling Too Many Requests Exception specifically
			apiLog1.setStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());

			response2 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response2);
			apiLog1.setResponseBodyAsJson("API rate limit exceeded");
		} catch (HttpClientErrorException.Unauthorized e) {
			// Handling Unauthorized Exception specifically
			apiLog1.setStatusCode(HttpStatus.UNAUTHORIZED.value());

			response2 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response2);
			apiLog1.setResponseBodyAsJson("No API key found in request");

		}

		catch (HttpClientErrorException e) {
			apiLog1.setStatusCode(e.getStatusCode().value());

			response2 = e.getResponseBodyAsString();
			System.out.println("ResponseBody " + response2);
			apiLog1.setResponseBody(response2);
		}

		catch (Exception e) {
			apiLog1.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

			response2 = e.getMessage();
			apiLog1.setResponseBody(response2);
		}

		finally {
			apiLogRepository1.save(apiLog1);
		}
		return response2;

	}

}
