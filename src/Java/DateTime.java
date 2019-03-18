package Java;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class workTime {
	String name;
	LocalDateTime in;
	LocalDateTime out;
	public workTime(String name, LocalDateTime in, LocalDateTime out) {
		this.name = name;
		this.in = in;
		this.out = out;
	}
}
public class DateTime {

	public static void main(String[] args) throws InterruptedException {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm");
		ArrayList<workTime> array = new ArrayList<>();
		array.add(new workTime("kalle anka",
				LocalDateTime.parse("2019-03-18 09:00", formatter),
				LocalDateTime.now()));
		array.add(new workTime("pelle hal",
				LocalDateTime.parse("2019-03-18 09:30", formatter),
				LocalDateTime.now()));

		array.add(new workTime("Gabriel s",
				LocalDateTime.parse("2019-03-18 10:45", formatter),
				LocalDateTime.now()));

		array.add(new workTime("Perham",
				LocalDateTime.parse("2019-03-18 08:10", formatter),
				LocalDateTime.now()));

		array.add(new workTime("nalle",
				LocalDateTime.parse("2019-03-17 09:00", formatter),
				LocalDateTime.now()));

		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i).name);
			long diff = array.get(i).out.atZone(ZoneId.systemDefault()).toInstant()
					.toEpochMilli()
					- array.get(i).in.atZone(ZoneId.systemDefault()).toInstant()
					.toEpochMilli();
			String today = LocalDateTime.now().format(formatter);
			System.out.println(array.get(i).in.format(formatter));
			System.out.println(Duration.ofMillis(diff).toHours() + "h:"
					+ Duration.ofMillis(diff)
					.minusHours(Duration.ofMillis(diff).toHours())
					.toMinutes()
					+ "m");
			System.out.println(today+"\n");
			
		}
	}

	public static void forLoop() {
		int i = 0;
		while (i < 100) {
			// System.out.println(new Date());
			// Thread.sleep(500);
			SimpleDateFormat ft = new SimpleDateFormat("E M MMM yyyy HH:mm:ss");
			System.out.println(ft.format(new Date()));
			i++;
		}

	}
	public static void loopName() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String val = "";
		int counter = 0;
		while (val != "9" && counter < 10) {

			System.out.print("Skriv ett namn:");
			val = in.nextLine();
			SimpleDateFormat ft = new SimpleDateFormat("E M MMM yyyy HH:mm:ss");
			System.out.println(ft.format(new Date()));
			counter++;
			if (val == "9") {
				System.exit(0);
			}
		}
	}
}
