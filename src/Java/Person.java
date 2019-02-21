package Java;

public class Person {
	private String name;
	private int age;
	private float income;
	
	/** The phone nr. */
	private String phoneNr;
	 
	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param age the age
	 * @param income the income
	 * @param phoneNr the phone nr
	 */
	public Person(String name, int age, float income, String phoneNr) {
		super();
		this.name = name;
		this.age = age;
		this.income = income;
		this.setPhoneNr(phoneNr);
	}

	public static void rubrik() {
		System.out.printf("%1s %16s","|","Name");
		System.out.printf("%22s","| Age");
		System.out.printf("%13s","| Income ");
		System.out.printf("%27s %12s","| Phone Nr ","|");
		System.out.print("\n|*******************************************************************************************|");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the income
	 */
	public float getIncome() {
		return income;
	}


	/**
	 * @param income the income to set
	 */
	public void setIncome(float income) {
		this.income = income;
	}

	
	/**
	 * Prints the person.
	 */
	public void print() {
		System.out.printf("\n|Person: Name: %-20s Age: %3d Income: %15.2f$ Phone Nr: %-12s|",name,age,income,phoneNr);
		
	}

	/**
	 * Gets the phone nr.
	 *
	 * @return the phone nr
	 */
	public String getPhoneNr() {
		return phoneNr;
	}

	/**
	 * Sets the phone nr.
	 *
	 * @param phoneNr the new phone nr
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}



}
