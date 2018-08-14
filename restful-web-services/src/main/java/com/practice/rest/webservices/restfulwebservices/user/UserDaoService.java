package com.practice.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<User>();
	static {
		users.add(new User(1,"Uday",new Date()));
		users.add(new User(2,"Shobha",new Date()));
		users.add(new User(3,"Aditi",new Date()));
	}
	
	private int usercount=3;
	List<User> findall(){
		return users;
	}
	
	User Save(User user) {
		if(user.getId()==0){
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}
	
	User findById(int id){
		for(User user: users){
			if(user.getId()==id) {
				return user;
			}
		}
		return null;	
	}
	User deleteById(int id){
		for(User user: users){
			if(user.getId()==id) {
				users.remove(user);
				return user;
			}
		}
		return null;
			
	}
}
