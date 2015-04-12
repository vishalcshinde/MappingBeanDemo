package com.vishal;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class PropertyVo {
	String name;
	String value;
	
	public PropertyVo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PropertyVo [name=" + name + ", value=" + value + "]";
	}

	public PropertyVo(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	@ApiModelProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
