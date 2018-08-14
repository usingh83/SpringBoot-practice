package com.practice.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping(name="/filtering")
	public MappingJacksonValue retreiveSomeBean() {
		SomeBean someBean= new SomeBean("Value1","Value2","Value3");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(someBean); 
		mapping.setFilters(filters);
		return mapping;
	}
}