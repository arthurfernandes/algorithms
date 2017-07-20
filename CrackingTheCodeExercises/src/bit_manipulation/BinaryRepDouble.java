package bit_manipulation;

/*
 * Cracking the Code 5.2
 */
public class BinaryRepDouble {
	public static void main(String[] args) {
		double d = 0.2;
		System.out.println(binaryRep32Double(d));
	}
	
	public static String binaryRep32Double(double d) {
		if (d >= 1 || d < 0) {
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		
		while(d > 0) {
			double r = d * 2;
			
			if (binary.length() > 32)
				return "ERROR";
			
			if (r >= 1) {
				binary.append(1);
				d = r - 1;
			}
			else {
				binary.append(0);
				d = r;
			}
		}
		
		return binary.toString();
	}
}
