package in.neosoft.test;

public class ReverseStringWithNumberPreservation {

	
	
	public String reverseString(String str) {
		System.out.println("Original String : "+str);
		int numIndex = str.indexOf("5");
		String replace = str.replace("5", "");
		
		
		String rev="";
		for(int i=replace.length()-1;i>=0;i--) {
			rev = rev+replace.charAt(i);
		}
		System.out.println(replace);
		StringBuffer sb = new StringBuffer(rev);
		sb.insert(numIndex, '5');
		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseStringWithNumberPreservation rswnp = new ReverseStringWithNumberPreservation();
		String reverseString = rswnp.reverseString("AKAS5H");
		System.out.println("Reverse String : "+reverseString);
	}
}
