package practice;

public class DebugExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		int b = 20;
		int c = 30;
		int d;
		System.out.println(a);
		System.out.println(b);
		
		int temp;
		temp = a;
		a= b;
		b= temp;
		System.out.println(a);
		System.out.println(b);
		
		d = a+b+c;
		System.out.println(d);
		
		
	}

}
