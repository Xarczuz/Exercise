package Euler1_50;

public class Timer {
private long a;

public Timer() {
	this.a = System.currentTimeMillis();
}
public void time() {
	System.out.println((System.currentTimeMillis()-a) + "ms");
}

}
