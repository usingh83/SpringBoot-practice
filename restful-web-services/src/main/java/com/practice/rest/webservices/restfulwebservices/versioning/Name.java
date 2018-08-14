package com.practice.rest.webservices.restfulwebservices.versioning;

public class Name {
String firstName;
String SecondName;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getSecondName() {
	return SecondName;
}
public void setSecondName(String secondName) {
	SecondName = secondName;
}
public Name(String firstName, String secondName) {
	super();
	this.firstName = firstName;
	SecondName = secondName;
}

}
