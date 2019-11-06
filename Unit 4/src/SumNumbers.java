
public class SumNumbers {

	public static void main(String[] args) {
		int lol = sumNumbers("a1234bb11");
		System.out.println("The number is: " + lol);
		
		int hi = sumNumbers("aa11b33");
		System.out.println("Number: " + hi);
	}

	public static int sumNumbers(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				String num = "" + c;
				int j = i+1;
				while (j < str.length() && Character.isDigit(str.charAt(j))) {
					c = str.charAt(j);
					j++;
					num += c;
				}
				i += num.length();
				System.out.println(num);
				sum += Integer.parseInt(num);
			}
		}
		return sum;
	}
}
