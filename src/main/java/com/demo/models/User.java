package com.demo.models;

import com.demo.anotations.Numeric;
import com.demo.anotations.Required;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@JsonProperty("id")
	  private int id;
	  @JsonProperty("name")
	  @Required
	  private String name;
	  @JsonProperty("age")
	  @Numeric
	  private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	  
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", age=" + age +
	            '}';
	}

	}