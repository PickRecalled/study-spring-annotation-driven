package com.pickrecalled.bean;

public class Color {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Color{");
		sb.append("car=").append(car);
		sb.append('}');
		return sb.toString();
	}
}
