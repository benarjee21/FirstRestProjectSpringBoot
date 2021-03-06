package com.example.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
//import org.springframework.hateoas.server.mvc.BasicLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.webservices.user.beans.User;
import com.example.webservices.user.exception.UserNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id){
		 User user=service.findOne(id);
		if(user==null) {
		throw new UserNotFoundException("id-"+id);
		}
//		EntityModel<User> resource= new EntityModel<User>(user);
//		BasicLinkBuilder toLink=linkTo(methodOn(this.getClass()).retriveAllUsers());
//		resource.add(toLink.linkToCurrentMapping().withRel("All Users"));
//		return resource;
		return user;
	}
	
//	@PostMapping("/users")
//	public void createUser(@RequestBody User user) {
//		User savedUser= service.save(user);
//	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser= service.save(user);
	//CREATED STAUS: 201 should be return
	//URI location 
	URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User savedUser= service.delete(id);
		
		if(savedUser == null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
//		User savedUser= service.delete(id);
//	//CREATED STAUS: 201 should be return
//	//URI location 
//	URI location=ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(savedUser.getId()).toUri();
//		
//		return ResponseEntity.created(location).build();
//	}
	
}
