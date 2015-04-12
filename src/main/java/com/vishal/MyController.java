package com.vishal;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
@Api(value="/hello", description="Operations on Businesses")
@RestController
@RequestMapping(value = "/hello", method={RequestMethod.GET})
public class MyController {
	
	@RequestMapping(value = "/{properties}", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Converts String to list of proerties", 
		response=PropertyVo.class, 
		responseContainer="List",
		notes = "some notes")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successful retrieval of user detail", response = PropertyVo.class),
		    @ApiResponse(code = 404, message = "User with given username does not exist"),
		    @ApiResponse(code = 500, message = "Internal server error"),
		    @ApiResponse(code = 500, message = "Resource was not found", response = ExceptionInfo.class)}
		)
	public PropertyVo sayHello(@PathVariable List<PropertyVo> properties) {
		if(properties.get(0).getName().equals("name")) {
			throw new ResourceNotFoundException(new ExceptionInfo(1, "Resource was not found"));
		}
		return properties.get(0);
	}
	
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionInfo handleException(Exception ex, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		if(ex instanceof ResourceNotFoundException) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return ((ResourceNotFoundException) ex).info; 
		}
		return new ExceptionInfo(1, ex.getMessage());
	}
}
