package com.pickrecalled.model;

import org.springframework.beans.factory.annotation.Value;

public class Person {

	@Value("李四")
	public String name;

	@Value("#{20-5}")
	public String age;

	@Value("${nick.name}")
	public String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

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
		sb.append(", nickName='").append(nickName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
