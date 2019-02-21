package Java;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		School s = new School("EC-U");
		s.addStudent(new Student("Kalle", "Down streey 2", "034-35235",
				"kalle@edu.se"));
		s.addStudent(
				new Student("Sara", "horngatan 3", "032-35235", "sara@huh.se"));
		s.addStudent(new Student("Pelle", "Havsön 3", "034-65245",
				"pellef@wfr.se", new Car(4, 2, "v8", "volvo")));
		s.addStudent(new Student("Martin", "Stor gatan 2", "034-85235",
				"martin@24t.se", new Car(4, 7, "v3", "bmw")));

		s.addTeacher(new Teacher("Bagargatan 32", "022-15235", "lisa@tj5.se",
				"Lisa", new Car(4, 5, "v99", "tesla"), "History"));
		s.addTeacher(new Teacher("Bagargatan 1", "022-15235", "robert@tj5.se",
				"Robert", new Car(3, 1, "v1", "fiat"), "Math"));

		s.showStudents();
		s.showTeachers();

	}
}

class Contact {
	String adress, tele, mail;

	public Contact(String adress, String tele, String mail) {
		this.adress = adress;
		this.tele = tele;
		this.mail = mail;
	}

	public String getAdress() {
		return adress;
	}

	public String getMail() {
		return mail;
	}

	public String getTele() {
		return tele;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
}

class School {
	String school;
	ArrayList<Student> students;
	ArrayList<Teacher> teachers;

	public School(String school) {
		this.school = school;
		this.students = new ArrayList<>();
		this.teachers = new ArrayList<>();
	}

	public void addStudent(Student s) {
		this.students.add(s);
	}

	public void addTeacher(Teacher t) {
		this.teachers.add(t);
	}

	public String getSchool() {
		return school;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void showStudents() {
		System.out.println("School: " + this.school);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void showTeachers() {
		System.out.println("School: " + this.school);
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}

class Teacher extends Contact {
	private String name;
	private Car car;
	protected String subject;

	/**
	 * Instantiates a new teacher.
	 *
	 * @param adress
	 *            the adress
	 * @param tele
	 *            the tele
	 * @param mail
	 *            the mail
	 * @param name
	 *            the name
	 * @param car
	 *            the car
	 * @param subject
	 *            the subject
	 */
	public Teacher(String adress, String tele, String mail, String name,
			Car car, String subject) {
		super(adress, tele, mail);
		this.name = name;
		this.car = car;
		this.subject = subject;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {

		return "Teacher [name: " + name + ", subject: " + subject + ", adress: "
				+ adress + ", tele: " + tele + ", mail: " + mail + ", car: "
				+ car + "]";
	}
}

class TeachersPet extends Teacher {

	public TeachersPet(String adress, String tele, String mail, String name,
			Car car, String subject, Student s) {
		super(adress, tele, mail, name, car, subject);
		this.s = s;
	}
	Student s;
}

class Student extends Contact {
	String name;
	Car car;

	/**
	 * Instantiates a new student.
	 *
	 * @param adress
	 *            the adress
	 * @param tele
	 *            the tele
	 * @param mail
	 *            the mail
	 * @param name
	 *            the name
	 * @param car
	 *            the car
	 */
	public Student(String name, String adress, String tele, String mail,
			Car car) {
		super(adress, tele, mail);
		this.name = name;
		this.car = car;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param name
	 *            the name
	 * @param adress
	 *            the adress
	 * @param tele
	 *            the tele
	 * @param mail
	 *            the mail
	 */
	public Student(String name, String adress, String tele, String mail) {
		super(adress, tele, mail);
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		if (car != null) {
			return "Student [name: " + name + ", adress: " + adress + ", tele: "
					+ tele + ", mail: " + mail + ", car: " + car + "]";
		} else {
			return "Student [name: " + name + ", adress: " + adress + ", tele: "
					+ tele + ", mail: " + mail + "]";
		}
	}
}

class Parts {
	int wheels;
	int seats;
	String motor;

	public Parts(int wheels, int seats, String motor) {
		this.wheels = wheels;
		this.seats = seats;
		this.motor = motor;
	}
}

class Car extends Parts {
	String carName;

	public Car(int wheels, int seats, String motor, String carName) {
		super(wheels, seats, motor);
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "[carName: " + carName + ", wheels: " + wheels + ", seats: "
				+ seats + ", motor: " + motor + "]";
	}

}