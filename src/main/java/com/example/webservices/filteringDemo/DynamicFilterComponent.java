package com.example.webservices.filteringDemo;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class DynamicFilterComponent {
	
	public static MappingJacksonValue filterIt(MappingJacksonValue mapping) {
		
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters=new SimpleFilterProvider().addFilter("DemoUser2",filter);		
		mapping.setFilters(filters);
		
		return mapping;
	}

}
