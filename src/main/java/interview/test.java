package interview;
public class test {

	public static String getA(){
		return "a";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String test = "a";
		String test2 ="a";
		String A = test2 + "b";
		String B = "a"+"b";
		String C = test + "b";
		String D = getA() + "b";
		String compare ="ab";
		System.out.println(A==compare);
		System.out.println(B==compare);
		System.out.println(C==compare);
		System.out.println(D==compare);
	}

}
