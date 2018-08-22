package com.pickrecalled.model;

public class Person {

	public String name;

	public String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Person() {
	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Person{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age='").append(age).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
