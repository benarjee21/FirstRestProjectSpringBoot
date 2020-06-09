package com.example.webservices.filteringDemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilterController {
	
	@GetMapping("/filterDy")
	public MappingJacksonValue dyFilterController() {
		DemoUser2 demoUser2 = new DemoUser2(1,"Bennu","vskp");
		MappingJacksonValue mapping = new MappingJacksonValue(demoUser2);
		DynamicFilterComponent.filterIt(mapping);
		return mapping;
	}
	
	@GetMapping("/filterDy-list")
	public MappingJacksonValue dyFilterControllerList() {
		List<DemoUser2> list= Arrays.asList(new DemoUser2(1,"bennu1","vskp"),new DemoUser2(1,"bennu1","vskp"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		DynamicFilterComponent.filterIt(mapping);
		return mapping;
	}
 
}
