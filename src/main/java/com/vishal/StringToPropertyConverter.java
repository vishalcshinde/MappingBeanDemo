package com.vishal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToPropertyConverter implements Converter<String, PropertyVo> {

	public PropertyVo convert(String arg0) {
		if(StringUtils.isEmpty(arg0) || !arg0.contains("=")) {
			throw new IllegalArgumentException("argument should not be empty and should contain one equal");
		}
		return new PropertyVo(arg0.substring(0, arg0.indexOf('=')), arg0.substring(arg0.indexOf('=') + 1));
	}

}
