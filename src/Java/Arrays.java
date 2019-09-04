package Java;

import java.util.ArrayList;
import java.util.Collections;

public class Arrays {

	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			myArr.add((int) Math.floor((Math.random() * 100)));
		}
		System.out.println(myArr);

		
		Collections.sort(myArr);
		System.out.println(myArr);
		ArrayList<persons> pArr = new ArrayList<>();
		pArr.add(new persons("Kalle", "23", "Sweden"));
		pArr.add(new persons("Kallen", "223", "Finland"));
		pArr.add(new persons("Kalled", "233", "USA"));
		for (persons person : pArr) {
			System.out.println(person);
		}
	}
}

class persons {
	public persons(String name, String age, String country) {

		this.name = name;
		this.age = age;
		this.country = country;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + ", country=" + country + "]";
	}

	String name;
	String age;
	String country;
}