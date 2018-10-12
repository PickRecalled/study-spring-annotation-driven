package com.pickrecalled.bean;

import org.springframework.stereotype.Component;

@Component
public class Boss {

	private Car car;

	/**
	 * 有参构造器
	 * @param car
	 */
	// @Autowired
	public Boss(Car car) {
		this.car = car;
		System.out.println("Boss 有参构造器.....");
	}

	public Car getCar() {
		return car;
	}

	// @Autowired//这个要注销
	public void setCar(/* @Autowired */ Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Boss{");
		sb.append("car=").append(car);
		sb.append('}');
		return sb.toString();
	}
}
