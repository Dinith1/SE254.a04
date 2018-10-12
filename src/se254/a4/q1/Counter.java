package se254.a4.q1;
//@formatter:off
public class Counter {
	public int c;
	public static String dog = "woof";
	public static boolean mouse = true;
	private int cat = 5;
	private static double bunny = 67.0;

	public void increment() { c++; }

	public void decrement() { c--; }

	public void reset() { c = 0; }
	
	public static void a() { dog += "f"; }
	
	public void b() { mouse = !mouse; }
	
	public static void c(String s) {}
	
	private void d() { mouse = !mouse; }
	
	private static void e() {}
	
	private void f(String s) {}
	
	private static void g(String s) {}
	


}
//@formatter:on