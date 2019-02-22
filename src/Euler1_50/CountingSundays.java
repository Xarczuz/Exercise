package Euler1_50;

public class CountingSundays {

	public static void main(String[] args) {
		int sundays = 0;
		int days = 0;
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 1; month < 13; month++) {
				for (int day = 1; day <= daysInAMonth(month,
						isItALeapYear(year)); day++) {

					days++;
					if (day == 1 && whatDayIsit(days).equals("sunday")) {
						sundays++;
					}
				}

			}
		}
		System.out.println("Sundays on the 1st of the month: " + sundays);
	}
	public static String whatDayIsit(int days) {
		double day = (days + 1) % 7;

		if (day == 1 % 7) {
			return "monday";
		} else if (day == 2 % 7) {
			return "tuesday";
		} else if (day == 3 % 7) {
			return "wednesday";
		} else if (day == 4 % 7) {
			return "thursday";
		} else if (day == 5 % 7) {
			return "friday";
		} else if (day == 6 % 7) {
			return "saturday";
		} else if (day == 7 % 7) {
			return "sunday";
		}
		return "error";
	}
	public static boolean isItALeapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
			return false;
		}

		if (year % 4 == 0) {
			return true;
		}
		return false;
	}
	public static int daysInAMonth(int month, boolean leapYear) {

		switch (month) {
			case 1 :
				return 31;
			case 2 :
				if (leapYear) {
					return 29;
				} else {
					return 28;
				}
			case 3 :
				return 31;
			case 4 :
				return 30;
			case 5 :
				return 31;
			case 6 :
				return 30;
			case 7 :
				return 31;
			case 8 :
				return 31;
			case 9 :
				return 30;
			case 10 :
				return 31;
			case 11 :
				return 30;
			case 12 :
				return 31;
			default :
				return 0;
		}
	}

}
