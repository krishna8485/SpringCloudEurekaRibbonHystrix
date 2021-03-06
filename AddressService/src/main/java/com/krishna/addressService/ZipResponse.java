package com.krishna.addressService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ZipResponse {

	private boolean zipValid;

	public ZipResponse(){
	}
	
	public ZipResponse(boolean valid){
		this.zipValid = valid;
	}
	
	@ApiModelProperty(required = true, dataType = "java.lang.Boolean", example ="true or false")
	public boolean getZipValid() {
		return zipValid;
	}

	public void setZipValid(boolean zipValid) {
		this.zipValid = zipValid;
	}
	
	
}
