package com.boomi.demo.addresslookup;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Arrays;


@Controller
public class AddressLookupController {

	// AUTH PARAMETERS (from application.yml)
	@Value("${example.serverBaseUrl}")
	private String SERVER_BASE_URL;

	@Value("${example.oauth2.client.grant-type}")
	private String GRANT_TYPE;

	@Value("${example.oauth2.client.clientId}")
	private String CLIENT_ID;

	@Value("${example.oauth2.client.clientSecret}")
	private String CLIENT_SECRET;

	@Value("${example.oauth2.client.accessTokenUri}")
	private String ACCESS_TOKEN_URI;

	@Value("${example.oauth2.client.scope}")
	private String SCOPE;

	@Value("${example.oauth2.client.x-api-key}")
	private String X_API_KEY;


	protected ClientCredentialsResourceDetails setOauthDetails() {
        ClientCredentialsResourceDetails credDetails = new ClientCredentialsResourceDetails();
        credDetails.setGrantType(GRANT_TYPE);
        credDetails.setClientId(CLIENT_ID);
        credDetails.setClientSecret(CLIENT_SECRET);
		credDetails.setAccessTokenUri(ACCESS_TOKEN_URI);
		List<String> SCOPES = Arrays.asList(SCOPE);
        credDetails.setScope(SCOPES);

        return credDetails;
    }

    @Bean
    protected OAuth2RestTemplate getRestTemplate() {
        return new OAuth2RestTemplate(setOauthDetails());
    }

    public String callAddressApiUsingNoAuth(String streetNumber, String streetName) {
        
		String uri = "http://api.boomiapj.com:9090" + "/ws/rest/v1/council/address/streetNo/" + streetNumber + "/streetName/" + streetName;
		RestTemplate restTemplate = new RestTemplate();
		//Result result = restTemplate.getForObject(uri, Result.class);
		String jsonString = restTemplate.getForObject(uri, String.class);
        
        return jsonString;
    }

    public String callAddressApiUsingOauth(String streetNumber, String streetName) {
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", X_API_KEY);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> response = getRestTemplate().exchange(SERVER_BASE_URL + "/ws/rest/v1/council/address/streetNo/" + streetNumber + "/streetName/" + streetName, HttpMethod.GET, entity, String.class);
        
        return response.getBody();
    }

	@GetMapping("/address")
	public String addressSearchForm(Model model) {
		model.addAttribute("address", new Address());
	
		return "address";
	}	

	@PostMapping("/address")
	public String addressSearchSubmit(Model model, @RequestParam String streetName, @RequestParam String streetNumber) {
		String jsonString = callAddressApiUsingOauth(streetNumber,streetName);
		System.out.println("RESPONSE: " + jsonString);
		model.addAttribute("result", jsonString);  	

		return "result";
	}	
}