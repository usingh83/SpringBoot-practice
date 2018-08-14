/*
package com.practice.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserService {

	@Autowired
	private UserDaoService service;
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findall();
	}
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id){
		User user=service.findById(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(link.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user=service.deleteById(id);
		if (user==null) {
			throw new UserNotFoundException("id- "+id);
		}
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser=service.Save(user);
		URI location=ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
*/