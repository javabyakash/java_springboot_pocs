package in.neosoft.test;

public class ReverseTestClass {

	public static String reverseString(String str) {
		if (str.isEmpty()) {
			return str;
		} else {
			return reverseString(str.substring(1)) + str.charAt(0);
		}
	}

	public static void main(String[] args) {
		String reverseString = reverseString("AKAS5H");
		System.out.println(reverseString);
	}
}
