package com.krishna.addressService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddressResult {
	
	private Boolean validZip;

	@ApiModelProperty(required = true, dataType = "java.lang.Boolean", example ="true")
	public Boolean getValidZip() {
		return validZip;
	}

	public void setValidZip(Boolean validZip) {
		this.validZip = validZip;
	}
	
	
}
