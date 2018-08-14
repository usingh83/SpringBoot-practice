package com.practice.rest.webservices.restfulwebservices.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.rest.webservices.restfulwebservices.user.User;
@Entity
public class Post {
@Id
@GeneratedValue
private int id;
private String Description;
@ManyToOne(fetch=FetchType.LAZY)
@JsonIgnore
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "Post [id=" + id + ", Description=" + Description + ", user=" + user + "]";
}
public Post(int id, String description, User user) {
	this.id = id;
	Description = description;
	this.user = user;
}

public Post() {
	
}

}
