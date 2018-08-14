package com.practice.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.practice.rest.webservices.restfulwebservices.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2,message="Name should be atleast 2 character long")
	@ApiModelProperty(name="Name should have atleast 2 characters")
	private String name;
	@Past
	@ApiModelProperty(name="Date of birth should be in the past")
	private Date birthDate;
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public User(int id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public User() {
	}
	
	
}
