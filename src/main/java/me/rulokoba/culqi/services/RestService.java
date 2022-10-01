package me.rulokoba.culqi.services;

import java.util.Collections;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
	
	private final RestTemplate restTemplate;
	
	public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	public String getPostsPlainJSON(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }
	
	public ResponseEntity<String> createPost(String url, String token, Object data) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		HttpEntity<Object> entity = new HttpEntity<>(data, headers);
		return this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	}

}
