package com.topica.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	private static final float PI = 3.14f;
	private static final int MAX = 99999999;

	public static void printMenu() {
		String menu = "1./Find the closest are\n2./Exit";
		System.out.println(menu);
		System.out.println("Enter your choice");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		float min = MAX;
		float radius;
		int choice;
		float area;
		ArrayList<Circle> circleList = new ArrayList<>();
		ArrayList<Integer> listIndex = new ArrayList<>();
		BufferedReader reader = null;

		for (int i = 0; i < 100; i++) {
			Circle circle = new Circle();
			circleList.add(circle);
		}

		Collections.sort(circleList);

		for (Circle circle : circleList) {
			System.out.println(circle);
		}

		do {
			printMenu();
			reader = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.valueOf(reader.readLine());
			switch (choice) {
			case 1:
				do {
					System.out.println("Enter area: ");
					reader = new BufferedReader(new InputStreamReader(System.in));
					area = Float.valueOf(reader.readLine());
				} while (area <= 0);

				radius = (float) Math.sqrt(area / PI);

				for (int i = 0; i < circleList.size(); i++) {
					float dis = Math.abs(radius - circleList.get(i).getRadius());
					if (dis == min)
						listIndex.add(i);
					if (dis < min) {
						listIndex.clear();
						listIndex.add(i);
						min = dis;
					}
				}

				System.out.println("Index: " + listIndex + " Area: " + circleList.get(listIndex.get(0)).computeArea());
				break;

			default:
				break;
			}
		} while (choice != 2);
	}
}
