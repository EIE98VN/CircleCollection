package com.topica.collection;

import java.util.Random;

public class Circle implements Comparable<Circle> {

	private static final float PI = 3.14f;
	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle() {
		Random random = new Random();
		int r = random.nextInt(100) + 1;
		this.radius = r;
	}

	public float computeArea() {
		return this.radius * this.radius * PI;
	}

	@Override
	public int compareTo(Circle o) {
		return this.radius - o.radius;
	}

	@Override
	public String toString() {
		return "Radius: " + this.radius;
	}

}
