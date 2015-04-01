package com.vishal;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("/hello/{name}")
	public String sayHello(@PathVariable List<PropertyVo> name) {
		return "hello " + name;
	}
}
