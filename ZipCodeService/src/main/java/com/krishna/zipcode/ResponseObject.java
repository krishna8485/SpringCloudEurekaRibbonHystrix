package com.krishna.zipcode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResponseObject {

	private String msg;
	
	public ResponseObject() {}
	
	public ResponseObject(String msg) {
		super();
		this.msg = msg;
	}

	@ApiModelProperty(required = true, dataType = "java.lang.Boolean", example ="message text")
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
