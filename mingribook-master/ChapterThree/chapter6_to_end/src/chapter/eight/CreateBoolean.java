package chapter.eight;

public class CreateBoolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean b = new Boolean("ok");
		String str = b.toString();
		System.out.println("ok:" + str);
		b = new Boolean("true");
		str = b.toString();
		System.out.println("true:" + str);
	}

}
