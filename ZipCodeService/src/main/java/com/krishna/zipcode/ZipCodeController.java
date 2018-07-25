package com.krishna.zipcode;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="ZipCode Controller")
public class ZipCodeController {


	
	//hardcoded list of zips to illustrate a validation lookup
		private List<String> validZips = Arrays.asList("95616", "95618");
		
		@GetMapping(value = "/example2", produces = "application/json")
		@ApiOperation(value="", response=ResponseObject.class )
		public ResponseObject example2(){
			ResponseObject response = new ResponseObject("hello from ZipCodeController");
			
			return response;
		}
		
		@GetMapping(value = "/zip/{zipcode}", produces = "application/json")
		@ApiOperation(value="Address", response=ZipResponse.class )
		   @ApiResponses(value={
				   				@ApiResponse(code =200, message=" Retrived successfully")
		   })
		public ResponseEntity<ZipResponse> validateZip(@PathVariable("zipcode") String zipCode){
			boolean result = validZips.contains(zipCode);
		
			return new ResponseEntity<ZipResponse>(new ZipResponse(result), HttpStatus.OK);
		}
	
}
