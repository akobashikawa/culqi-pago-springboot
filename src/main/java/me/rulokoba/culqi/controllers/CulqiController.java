package me.rulokoba.culqi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.rulokoba.culqi.models.CulqiChargeData;
import me.rulokoba.culqi.services.RestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CulqiController {
	
	private final RestService restService;
	
	@Value("${culqi.sk}")
	private String CULQI_SK;
	
	public CulqiController(RestService restService) {
		this.restService = restService;
	}
	
	@GetMapping("/")
	public String home() {
		return "Culqi Pagos - Spring Boot";
	}
	
	@PostMapping("/charge")
	public ResponseEntity<String> charge(@RequestBody CulqiChargeData data) {
		data.getMetadata().put("extra", "metadata desde el server");
		return this.restService.createPost("https://api.culqi.com/v2/charges", CULQI_SK, data);
	}
	
	@PostMapping("/webhook")
	public ResponseEntity<String> charge(@RequestBody String data) {
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}

}
