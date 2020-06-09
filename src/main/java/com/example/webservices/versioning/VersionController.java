package com.example.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
	
	@GetMapping("/carbean-v1")
	public CarBean carBean1() {
		return new CarBean("Mercedes Benz");
	}
	
	@GetMapping("/carbean-v2")
	public CarBean2 carBean2() {
		return new CarBean2(new Name("Mercedes2","Benz2"));
	}
	
	@GetMapping(value="/carbean-v1/param",params="version=1")
	public CarBean paramCarBean1() {
		return new CarBean("Mercedes Benz");
	}
	
	@GetMapping(value="/carbean-v2/param",params="version=2")
	public CarBean2 paramCarBean2() {
		return new CarBean2(new Name("Mercedes2","Benz2"));
	}
	
	@GetMapping(value="/carbean-v1/header",headers="X-API-VERSION=1")
	public CarBean headerCarBean1() {
		return new CarBean("Mercedes Benz");
	}
	
	@GetMapping(value="/carbean-v2/header",headers="X-API-VERSION=2")
	public CarBean2 headerCarBean2() {
		return new CarBean2(new Name("Mercedes2","Benz2"));
	}
	
	@GetMapping(value="/carbean-v1/produces",produces="application/vnd.company.app-v1+json")
	public CarBean producesCarBean1() {
		return new CarBean("Mercedes Benz");
	}
	
	@GetMapping(value="/carbean-v2/produces",produces="application/vnd.company.app-v2+json")
	public CarBean2 producesCarBean2() {
		return new CarBean2(new Name("Mercedes2","Benz2"));
	}

}
