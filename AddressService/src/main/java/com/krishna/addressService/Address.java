package com.krishna.addressService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Address {

	private String addr1;
	private String city;
	private String state;
	private String zip;
	
	@ApiModelProperty(required = true, dataType = "java.lang.String", example ="95616, 95618")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@ApiModelProperty(required = true, dataType = "java.lang.String", example ="Testing Address")
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	@ApiModelProperty(required = true, dataType = "java.lang.String", example ="Hyderabad")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@ApiModelProperty(required = true, dataType = "java.lang.String", example ="Telangana")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
