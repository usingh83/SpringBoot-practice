package com.practice.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	@GetMapping("/v1/person")
	public PersonV1 personv1(){
		return new PersonV1("Uday Singh");
	}
	@GetMapping("/v2/person")
	public PersonV2 personv2(){
		return new PersonV2(new Name("Uday","Singh"));
	}
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramv1(){
		return new PersonV1("Uday Singh");
	}
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramv2(){
		return new PersonV2(new Name("Uday","Singh"));
	}
	@GetMapping(value="/person/header", headers="version=1")
	public PersonV1 headerv1(){
		return new PersonV1("Uday Singh");
	}
	@GetMapping(value="/person/header", headers="version=2")
	public PersonV2 headerv2(){
		return new PersonV2(new Name("Uday","Singh"));
	}
	@GetMapping(value="/person/produces", produces="application/v1+json")
	public PersonV1 producerv1(){
		return new PersonV1("Uday Singh");
	}
	@GetMapping(value="/person/produces", produces="application/v2+json")
	public PersonV2 producerv2(){
		return new PersonV2(new Name("Uday","Singh"));
	}
}
