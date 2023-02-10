package in.neosoft.test;

public class ReverseStringWithNumberPreservation {

	//Akashd
	
	public String reverseString(String str) {
		System.out.println("Original String : "+str);
		int numIndex = str.indexOf("5");
		String replace = str.replace("5", "");
		
		int numIndex2 = replace.indexOf("5");
		String replace2 = replace.replace("5", "");
		
		System.out.println(replace2);
		
		String rev="";
		for(int i=replace2.length()-1;i>=0;i--) {
			rev = rev+replace2.charAt(i);
		}
		System.out.println(replace2);
		StringBuffer sb = new StringBuffer(rev);
		sb.insert(numIndex, '5');
		sb.insert(numIndex2, '5');
		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseStringWithNumberPreservation rswnp = new ReverseStringWithNumberPreservation();
		String reverseString = rswnp.reverseString("AK5AS5H");
		System.out.println("Reverse String : "+reverseString);
	}
}
