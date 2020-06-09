package com.example.webservices.filteringDemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	
	@GetMapping("/filter")
	public DemoUser filterController() {
		return new DemoUser(1,"vikky1","vzm");
	}
	
	@GetMapping("/filter-list")
	public List<DemoUser> filterListController() {
		return Arrays.asList(new DemoUser(1,"vikky1","vzm"),new DemoUser(2,"vikky2","vzm"));
	}
	
}
