package com.krishna.addressService;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="AddressRest Controller")
public class AddressRestController {

	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//Ribbon client and Eureka-aware RestTemplate
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping(value = "/hello", produces = "application/json")
	 @ApiOperation(value="", response=ResponseObject.class )
	   
	public ResponseObject example1(){
		ResponseObject response = new ResponseObject("hello from AddressRestController");
		
		return response;
	}
	
	@PostMapping("/address")
	 @ApiOperation(value="Address", response=AddressResult.class )
	   @ApiResponses(value={
			   				@ApiResponse(code =200, message=" Retrived successfully")
	   })
	public ResponseEntity<AddressResult> addAddress(@RequestBody Address address) throws RestClientException, URISyntaxException{
	
		ResponseEntity<ZipResponse> exchange =
				this.restTemplate.exchange(new RequestEntity<Address>(address, HttpMethod.GET,
						new URI("http://zipcodeservice/zip/" + address.getZip())),
						ZipResponse.class);
		
		AddressResult result = new AddressResult();
		result.setValidZip(exchange.getBody().getZipValid());
		
		return new ResponseEntity<AddressResult>(result, HttpStatus.OK);
	}
	
}
