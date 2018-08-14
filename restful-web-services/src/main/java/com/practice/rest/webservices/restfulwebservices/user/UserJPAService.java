package com.practice.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.practice.rest.webservices.restfulwebservices.post.Post;
import com.practice.rest.webservices.restfulwebservices.post.PostRepository;

@RestController
public class UserJPAService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id){
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		Resource<User> resource=new Resource<User>(user.get());
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(link.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser=userRepository.save(user);
		URI location=ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@Valid @RequestBody Post post){
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		User user=userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location=ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id){
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		
		return user.get().getPosts();
	}
}
