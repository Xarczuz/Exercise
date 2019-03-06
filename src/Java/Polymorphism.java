package Java;

public class Polymorphism {

	static class a {

		public String toString() {
			return "Tåg ";
		}
	}
	static class b extends a {

		public String toString() {
			return "Tuff ";
		}
	}

	public static void main(String[] args) {
		a obj = new b();
		
		System.out.println(obj);
		System.out.println((b)obj);
		System.out.println((a)obj);
	}
}